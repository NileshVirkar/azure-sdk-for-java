// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.formrecognizer;

import com.azure.ai.formrecognizer.models.CustomFormModel;
import com.azure.ai.formrecognizer.models.OperationResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.time.Duration;

import static com.azure.ai.formrecognizer.TestUtils.INVALID_MODEL_ID;
import static com.azure.ai.formrecognizer.TestUtils.INVALID_MODEL_ID_ERROR;
import static com.azure.ai.formrecognizer.TestUtils.NULL_SOURCE_URL_ERROR;
import static com.azure.ai.formrecognizer.TestUtils.getExpectedAccountProperties;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormTrainingAsyncClientTest extends FormTrainingClientTestBase {

    private FormTrainingAsyncClient client;

    @BeforeAll
    static void beforeAll() {
        StepVerifier.setDefaultTimeout(Duration.ofSeconds(30));
    }

    @AfterAll
    static void afterAll() {
        StepVerifier.resetDefaultTimeout();
    }

    @Override
    protected void beforeTest() {
        FormRecognizerAsyncClient formRecognizerAsyncClient = clientSetup(httpPipeline ->
            new FormRecognizerClientBuilder()
                .endpoint(getEndpoint())
                .pipeline(httpPipeline)
                .buildAsyncClient());
        client = formRecognizerAsyncClient.getFormTrainingAsyncClient();
    }

    /**
     * Verifies that an exception is thrown for null model Id parameter.
     */
    @Test
    void getCustomModelNullModelId() {
        StepVerifier.create(client.getCustomModel(null)).verifyError();
    }

    /**
     * Verifies that an exception is thrown for invalid model Id.
     */
    @Test
    void getCustomModelInvalidModelId() {
        getCustomModelInvalidModelIdRunner(invalidModelId -> StepVerifier.create(client.getCustomModel(invalidModelId))
            .expectErrorMatches(throwable -> throwable instanceof IllegalArgumentException
                && throwable.getMessage().equals(INVALID_MODEL_ID_ERROR)).verify());
    }

    /**
     * Verifies custom model info returned with response for a valid model Id.
     */
    @Test
    void getCustomModelWithResponse() {
        beginTrainingUnlabeledRunner((trainingDataSASUrl, useLabelFile) -> {
            SyncPoller<OperationResult, CustomFormModel> syncPoller = client.beginTraining(trainingDataSASUrl,
                useLabelFile).getSyncPoller();
            syncPoller.waitForCompletion();
            CustomFormModel trainedModel = syncPoller.getFinalResult();

            StepVerifier.create(client.getCustomModelWithResponse(trainedModel.getModelId(),
                Context.NONE)).assertNext(customFormModelResponse -> {
                    assertEquals(customFormModelResponse.getStatusCode(), HttpResponseStatus.OK.code());
                    validateCustomModelData(syncPoller.getFinalResult(), false);
                });
        });
    }

    /**
     * Verifies unlabeled custom model info returned with response for a valid model Id.
     */
    @Test
    void getCustomModelUnlabeled() {
        beginTrainingUnlabeledRunner((trainingDataSASUrl, useLabelFile) -> {
            SyncPoller<OperationResult, CustomFormModel> syncPoller =
                client.beginTraining(trainingDataSASUrl, useLabelFile).getSyncPoller();
            syncPoller.waitForCompletion();
            CustomFormModel trainedUnlabeledModel = syncPoller.getFinalResult();
            StepVerifier.create(client.getCustomModel(trainedUnlabeledModel.getModelId()))
                .assertNext(customFormModel -> validateCustomModelData(syncPoller.getFinalResult(),
                    false));
        });
    }

    /**
     * Verifies labeled custom model info returned with response for a valid model Id.
     */
    @Test
    void getCustomModelLabeled() {
        beginTrainingLabeledRunner((trainingDataSASUrl, useLabelFile) -> {
            SyncPoller<OperationResult, CustomFormModel> syncPoller =
                client.beginTraining(trainingDataSASUrl, useLabelFile).getSyncPoller();
            syncPoller.waitForCompletion();
            CustomFormModel trainedLabeledModel = syncPoller.getFinalResult();
            StepVerifier.create(client.getCustomModel(trainedLabeledModel.getModelId()))
                .assertNext(customFormModel -> validateCustomModelData(syncPoller.getFinalResult(),
                    true));
        });
    }

    /**
     * Verifies account properties returned for a subscription account.
     */
    @Test
    void validGetAccountProperties() {
        StepVerifier.create(client.getAccountProperties())
            .assertNext(accountProperties -> validateAccountProperties(getExpectedAccountProperties(),
                accountProperties))
            .verifyComplete();
    }

    /**
     * Verifies account properties returned with an Http Response for a subscription account.
     */
    @Test
    void validGetAccountPropertiesWithResponse() {
        StepVerifier.create(client.getAccountProperties())
            .assertNext(accountProperties ->
                validateAccountProperties(getExpectedAccountProperties(), accountProperties))
            .verifyComplete();
    }

    /**
     * Verifies that an exception is thrown for invalid status model Id.
     */
    @Test
    void deleteModelInvalidModelId() {
        StepVerifier.create(client.deleteModel(INVALID_MODEL_ID))
            .expectErrorMatches(throwable -> throwable instanceof IllegalArgumentException
                && throwable.getMessage().equals(INVALID_MODEL_ID_ERROR))
            .verify();
    }

    @Test
    void deleteModelValidModelIdWithResponse() {
        beginTrainingLabeledRunner((storageSASUrl, useLabelFile) -> {
            SyncPoller<OperationResult, CustomFormModel> syncPoller =
                client.beginTraining(storageSASUrl, useLabelFile).getSyncPoller();
            syncPoller.waitForCompletion();
            CustomFormModel createdModel = syncPoller.getFinalResult();

            StepVerifier.create(client.deleteModelWithResponse(createdModel.getModelId()))
                .assertNext(response ->
                    assertEquals(response.getStatusCode(), HttpResponseStatus.NO_CONTENT.code()))
                .verifyComplete();

            StepVerifier.create(client.getCustomModelWithResponse(createdModel.getModelId()))
                .verifyErrorSatisfies(throwable ->
                    throwable.getMessage().contains(HttpResponseStatus.NOT_FOUND.toString()));
        });
    }

    /**
     * Test for listing all models information.
     */
    @Test
    void getModelInfos() {
        StepVerifier.create(client.getModelInfos())
            .thenConsumeWhile(customFormModelInfo ->
                customFormModelInfo.getModelId() != null && customFormModelInfo.getCreatedOn() != null
                    && customFormModelInfo.getLastUpdatedOn() != null && customFormModelInfo.getStatus() != null)
            .verifyComplete();
    }

    /**
     * Test for listing all models information with {@link Context}.
     */
    @Test
    void getModelInfosWithContext() {
        StepVerifier.create(client.getModelInfos(Context.NONE))
            .thenConsumeWhile(modelInfo ->
                modelInfo.getModelId() != null && modelInfo.getCreatedOn() != null
                    && modelInfo.getLastUpdatedOn() != null && modelInfo.getStatus() != null)
            .verifyComplete();
    }

    /**
     * Verifies that an exception is thrown for null source url input.
     */
    @Test
    void beginTrainingNullInput() {
        NullPointerException thrown = assertThrows(
            NullPointerException.class,
            () -> client.beginTraining(null, false).getSyncPoller().getFinalResult());

        assertTrue(thrown.getMessage().equals(NULL_SOURCE_URL_ERROR));
    }

    /**
     * Verifies the result of the training operation for a valid labeled model Id and training set Url.
     */
    @Test
    void beginTrainingLabeledResult() {
        beginTrainingLabeledRunner((storageSASUrl, useLabelFile) -> {
            SyncPoller<OperationResult, CustomFormModel> syncPoller =
                client.beginTraining(storageSASUrl, useLabelFile).getSyncPoller();
            syncPoller.waitForCompletion();
            validateCustomModelData(syncPoller.getFinalResult(), true);
        });
    }

    /**
     * Verifies the result of the training operation for a valid unlabeled model Id and training set Url.
     */
    @Test
    void beginTrainingUnlabeledResult() {
        beginTrainingUnlabeledRunner((storageSASUrl, useLabelFile) -> {
            SyncPoller<OperationResult, CustomFormModel> syncPoller =
                client.beginTraining(storageSASUrl, useLabelFile).getSyncPoller();
            syncPoller.waitForCompletion();
            validateCustomModelData(syncPoller.getFinalResult(), false);
        });
    }
}
