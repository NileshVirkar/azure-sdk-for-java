// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.resources.models;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.management.AzureEnvironment;
import com.azure.management.AzureServiceClient;

/** Initializes a new instance of the PolicyClientImpl type. */
public final class PolicyClientImpl extends AzureServiceClient {
    /** The ID of the target subscription. */
    private String subscriptionId;

    /**
     * Gets The ID of the target subscription.
     *
     * @return the subscriptionId value.
     */
    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Sets The ID of the target subscription.
     *
     * @param subscriptionId the subscriptionId value.
     * @return the service client itself.
     */
    public PolicyClientImpl setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    /** server parameter. */
    private String host;

    /**
     * Gets server parameter.
     *
     * @return the host value.
     */
    public String getHost() {
        return this.host;
    }

    /**
     * Sets server parameter.
     *
     * @param host the host value.
     * @return the service client itself.
     */
    public PolicyClientImpl setHost(String host) {
        this.host = host;
        return this;
    }

    /** The HTTP pipeline to send requests through. */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     *
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /** The PolicyAssignmentsInner object to access its operations. */
    private final PolicyAssignmentsInner policyAssignments;

    /**
     * Gets the PolicyAssignmentsInner object to access its operations.
     *
     * @return the PolicyAssignmentsInner object.
     */
    public PolicyAssignmentsInner policyAssignments() {
        return this.policyAssignments;
    }

    /** The PolicySetDefinitionsInner object to access its operations. */
    private final PolicySetDefinitionsInner policySetDefinitions;

    /**
     * Gets the PolicySetDefinitionsInner object to access its operations.
     *
     * @return the PolicySetDefinitionsInner object.
     */
    public PolicySetDefinitionsInner policySetDefinitions() {
        return this.policySetDefinitions;
    }

    /** The PolicyDefinitionsInner object to access its operations. */
    private final PolicyDefinitionsInner policyDefinitions;

    /**
     * Gets the PolicyDefinitionsInner object to access its operations.
     *
     * @return the PolicyDefinitionsInner object.
     */
    public PolicyDefinitionsInner policyDefinitions() {
        return this.policyDefinitions;
    }

    /** Initializes an instance of PolicyClient client. */
    public PolicyClientImpl() {
        this(
            new HttpPipelineBuilder().policies(new UserAgentPolicy(), new RetryPolicy(), new CookiePolicy()).build(),
            AzureEnvironment.AZURE);
    }

    /**
     * Initializes an instance of PolicyClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     */
    public PolicyClientImpl(HttpPipeline httpPipeline) {
        this(httpPipeline, AzureEnvironment.AZURE);
    }

    /**
     * Initializes an instance of PolicyClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param environment The Azure environment.
     */
    public PolicyClientImpl(HttpPipeline httpPipeline, AzureEnvironment environment) {
        super(httpPipeline, environment);
        this.httpPipeline = httpPipeline;
        this.policyAssignments = new PolicyAssignmentsInner(this);
        this.policySetDefinitions = new PolicySetDefinitionsInner(this);
        this.policyDefinitions = new PolicyDefinitionsInner(this);
    }
}
