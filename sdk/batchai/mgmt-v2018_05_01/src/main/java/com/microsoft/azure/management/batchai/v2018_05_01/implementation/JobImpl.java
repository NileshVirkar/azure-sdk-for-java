/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batchai.v2018_05_01.implementation;

import com.microsoft.azure.management.batchai.v2018_05_01.Job;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.batchai.v2018_05_01.JobCreateParameters;
import java.util.List;
import com.microsoft.azure.management.batchai.v2018_05_01.Caffe2Settings;
import com.microsoft.azure.management.batchai.v2018_05_01.CaffeSettings;
import com.microsoft.azure.management.batchai.v2018_05_01.ChainerSettings;
import com.microsoft.azure.management.batchai.v2018_05_01.ResourceId;
import com.microsoft.azure.management.batchai.v2018_05_01.CNTKsettings;
import com.microsoft.azure.management.batchai.v2018_05_01.JobPropertiesConstraints;
import com.microsoft.azure.management.batchai.v2018_05_01.ContainerSettings;
import org.joda.time.DateTime;
import com.microsoft.azure.management.batchai.v2018_05_01.CustomMpiSettings;
import com.microsoft.azure.management.batchai.v2018_05_01.CustomToolkitSettings;
import com.microsoft.azure.management.batchai.v2018_05_01.EnvironmentVariable;
import com.microsoft.azure.management.batchai.v2018_05_01.JobPropertiesExecutionInfo;
import com.microsoft.azure.management.batchai.v2018_05_01.ExecutionState;
import com.microsoft.azure.management.batchai.v2018_05_01.HorovodSettings;
import com.microsoft.azure.management.batchai.v2018_05_01.InputDirectory;
import com.microsoft.azure.management.batchai.v2018_05_01.JobPreparation;
import com.microsoft.azure.management.batchai.v2018_05_01.MountVolumes;
import com.microsoft.azure.management.batchai.v2018_05_01.OutputDirectory;
import com.microsoft.azure.management.batchai.v2018_05_01.ProvisioningState;
import com.microsoft.azure.management.batchai.v2018_05_01.PyTorchSettings;
import com.microsoft.azure.management.batchai.v2018_05_01.JobPriority;
import com.microsoft.azure.management.batchai.v2018_05_01.EnvironmentVariableWithSecretValue;
import com.microsoft.azure.management.batchai.v2018_05_01.TensorFlowSettings;
import com.microsoft.azure.management.batchai.v2018_05_01.ToolType;
import com.microsoft.azure.management.batchai.v2018_05_01.JobBasePropertiesConstraints;
import rx.functions.Func1;

class JobImpl extends CreatableUpdatableImpl<Job, JobInner, JobImpl> implements Job, Job.Definition, Job.Update {
    private final BatchAIManager manager;
    private String resourceGroupName;
    private String workspaceName;
    private String experimentName;
    private String jobName;
    private JobCreateParameters createOrUpdateParameter;

    JobImpl(String name, BatchAIManager manager) {
        super(name, new JobInner());
        this.manager = manager;
        // Set resource name
        this.jobName = name;
        //
        this.createOrUpdateParameter = new JobCreateParameters();
    }

    JobImpl(JobInner inner, BatchAIManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.jobName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.workspaceName = IdParsingUtils.getValueFromIdByName(inner.id(), "workspaces");
        this.experimentName = IdParsingUtils.getValueFromIdByName(inner.id(), "experiments");
        this.jobName = IdParsingUtils.getValueFromIdByName(inner.id(), "jobs");
        //
        this.createOrUpdateParameter = new JobCreateParameters();
    }

    @Override
    public BatchAIManager manager() {
        return this.manager;
    }

    @Override
    public Observable<Job> createResourceAsync() {
        JobsInner client = this.manager().inner().jobs();
        return client.createAsync(this.resourceGroupName, this.workspaceName, this.experimentName, this.jobName, this.createOrUpdateParameter)
            .map(new Func1<JobInner, JobInner>() {
               @Override
               public JobInner call(JobInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<Job> updateResourceAsync() {
        JobsInner client = this.manager().inner().jobs();
        return client.createAsync(this.resourceGroupName, this.workspaceName, this.experimentName, this.jobName, this.createOrUpdateParameter)
            .map(new Func1<JobInner, JobInner>() {
               @Override
               public JobInner call(JobInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<JobInner> getInnerAsync() {
        JobsInner client = this.manager().inner().jobs();
        return client.getAsync(this.resourceGroupName, this.workspaceName, this.experimentName, this.jobName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.createOrUpdateParameter = new JobCreateParameters();
    }

    @Override
    public Caffe2Settings caffe2Settings() {
        return this.inner().caffe2Settings();
    }

    @Override
    public CaffeSettings caffeSettings() {
        return this.inner().caffeSettings();
    }

    @Override
    public ChainerSettings chainerSettings() {
        return this.inner().chainerSettings();
    }

    @Override
    public ResourceId cluster() {
        return this.inner().cluster();
    }

    @Override
    public CNTKsettings cntkSettings() {
        return this.inner().cntkSettings();
    }

    @Override
    public JobPropertiesConstraints constraints() {
        return this.inner().constraints();
    }

    @Override
    public ContainerSettings containerSettings() {
        return this.inner().containerSettings();
    }

    @Override
    public DateTime creationTime() {
        return this.inner().creationTime();
    }

    @Override
    public CustomMpiSettings customMpiSettings() {
        return this.inner().customMpiSettings();
    }

    @Override
    public CustomToolkitSettings customToolkitSettings() {
        return this.inner().customToolkitSettings();
    }

    @Override
    public List<EnvironmentVariable> environmentVariables() {
        return this.inner().environmentVariables();
    }

    @Override
    public JobPropertiesExecutionInfo executionInfo() {
        return this.inner().executionInfo();
    }

    @Override
    public ExecutionState executionState() {
        return this.inner().executionState();
    }

    @Override
    public DateTime executionStateTransitionTime() {
        return this.inner().executionStateTransitionTime();
    }

    @Override
    public HorovodSettings horovodSettings() {
        return this.inner().horovodSettings();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public List<InputDirectory> inputDirectories() {
        return this.inner().inputDirectories();
    }

    @Override
    public String jobOutputDirectoryPathSegment() {
        return this.inner().jobOutputDirectoryPathSegment();
    }

    @Override
    public JobPreparation jobPreparation() {
        return this.inner().jobPreparation();
    }

    @Override
    public MountVolumes mountVolumes() {
        return this.inner().mountVolumes();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public Integer nodeCount() {
        return this.inner().nodeCount();
    }

    @Override
    public List<OutputDirectory> outputDirectories() {
        return this.inner().outputDirectories();
    }

    @Override
    public ProvisioningState provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public DateTime provisioningStateTransitionTime() {
        return this.inner().provisioningStateTransitionTime();
    }

    @Override
    public PyTorchSettings pyTorchSettings() {
        return this.inner().pyTorchSettings();
    }

    @Override
    public JobPriority schedulingPriority() {
        return this.inner().schedulingPriority();
    }

    @Override
    public List<EnvironmentVariableWithSecretValue> secrets() {
        return this.inner().secrets();
    }

    @Override
    public String stdOutErrPathPrefix() {
        return this.inner().stdOutErrPathPrefix();
    }

    @Override
    public TensorFlowSettings tensorFlowSettings() {
        return this.inner().tensorFlowSettings();
    }

    @Override
    public ToolType toolType() {
        return this.inner().toolType();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public JobImpl withExistingExperiment(String resourceGroupName, String workspaceName, String experimentName) {
        this.resourceGroupName = resourceGroupName;
        this.workspaceName = workspaceName;
        this.experimentName = experimentName;
        return this;
    }

    @Override
    public JobImpl withCluster(ResourceId cluster) {
        this.createOrUpdateParameter.withCluster(cluster);
        return this;
    }

    @Override
    public JobImpl withNodeCount(int nodeCount) {
        this.createOrUpdateParameter.withNodeCount(nodeCount);
        return this;
    }

    @Override
    public JobImpl withStdOutErrPathPrefix(String stdOutErrPathPrefix) {
        this.createOrUpdateParameter.withStdOutErrPathPrefix(stdOutErrPathPrefix);
        return this;
    }

    @Override
    public JobImpl withCaffe2Settings(Caffe2Settings caffe2Settings) {
        this.createOrUpdateParameter.withCaffe2Settings(caffe2Settings);
        return this;
    }

    @Override
    public JobImpl withCaffeSettings(CaffeSettings caffeSettings) {
        this.createOrUpdateParameter.withCaffeSettings(caffeSettings);
        return this;
    }

    @Override
    public JobImpl withChainerSettings(ChainerSettings chainerSettings) {
        this.createOrUpdateParameter.withChainerSettings(chainerSettings);
        return this;
    }

    @Override
    public JobImpl withCntkSettings(CNTKsettings cntkSettings) {
        this.createOrUpdateParameter.withCntkSettings(cntkSettings);
        return this;
    }

    @Override
    public JobImpl withConstraints(JobBasePropertiesConstraints constraints) {
        this.createOrUpdateParameter.withConstraints(constraints);
        return this;
    }

    @Override
    public JobImpl withContainerSettings(ContainerSettings containerSettings) {
        this.createOrUpdateParameter.withContainerSettings(containerSettings);
        return this;
    }

    @Override
    public JobImpl withCustomMpiSettings(CustomMpiSettings customMpiSettings) {
        this.createOrUpdateParameter.withCustomMpiSettings(customMpiSettings);
        return this;
    }

    @Override
    public JobImpl withCustomToolkitSettings(CustomToolkitSettings customToolkitSettings) {
        this.createOrUpdateParameter.withCustomToolkitSettings(customToolkitSettings);
        return this;
    }

    @Override
    public JobImpl withEnvironmentVariables(List<EnvironmentVariable> environmentVariables) {
        this.createOrUpdateParameter.withEnvironmentVariables(environmentVariables);
        return this;
    }

    @Override
    public JobImpl withHorovodSettings(HorovodSettings horovodSettings) {
        this.createOrUpdateParameter.withHorovodSettings(horovodSettings);
        return this;
    }

    @Override
    public JobImpl withInputDirectories(List<InputDirectory> inputDirectories) {
        this.createOrUpdateParameter.withInputDirectories(inputDirectories);
        return this;
    }

    @Override
    public JobImpl withJobPreparation(JobPreparation jobPreparation) {
        this.createOrUpdateParameter.withJobPreparation(jobPreparation);
        return this;
    }

    @Override
    public JobImpl withMountVolumes(MountVolumes mountVolumes) {
        this.createOrUpdateParameter.withMountVolumes(mountVolumes);
        return this;
    }

    @Override
    public JobImpl withOutputDirectories(List<OutputDirectory> outputDirectories) {
        this.createOrUpdateParameter.withOutputDirectories(outputDirectories);
        return this;
    }

    @Override
    public JobImpl withPyTorchSettings(PyTorchSettings pyTorchSettings) {
        this.createOrUpdateParameter.withPyTorchSettings(pyTorchSettings);
        return this;
    }

    @Override
    public JobImpl withSchedulingPriority(JobPriority schedulingPriority) {
        this.createOrUpdateParameter.withSchedulingPriority(schedulingPriority);
        return this;
    }

    @Override
    public JobImpl withSecrets(List<EnvironmentVariableWithSecretValue> secrets) {
        this.createOrUpdateParameter.withSecrets(secrets);
        return this;
    }

    @Override
    public JobImpl withTensorFlowSettings(TensorFlowSettings tensorFlowSettings) {
        this.createOrUpdateParameter.withTensorFlowSettings(tensorFlowSettings);
        return this;
    }

}
