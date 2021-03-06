// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.msi;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Operation Display.null. */
@Fluent
public final class OperationDisplay {
    /*
     * Friendly name of the resource provider.
     */
    @JsonProperty(value = "provider")
    private String provider;

    /*
     * The type of operation. For example: read, write, delete.
     */
    @JsonProperty(value = "operation")
    private String operation;

    /*
     * The resource type on which the operation is performed.
     */
    @JsonProperty(value = "resource")
    private String resource;

    /*
     * A description of the operation.
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * Get the provider property: Friendly name of the resource provider.
     *
     * @return the provider value.
     */
    public String getProvider() {
        return this.provider;
    }

    /**
     * Set the provider property: Friendly name of the resource provider.
     *
     * @param provider the provider value to set.
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    /**
     * Get the operation property: The type of operation. For example: read, write, delete.
     *
     * @return the operation value.
     */
    public String getOperation() {
        return this.operation;
    }

    /**
     * Set the operation property: The type of operation. For example: read, write, delete.
     *
     * @param operation the operation value to set.
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay setOperation(String operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Get the resource property: The resource type on which the operation is performed.
     *
     * @return the resource value.
     */
    public String getResource() {
        return this.resource;
    }

    /**
     * Set the resource property: The resource type on which the operation is performed.
     *
     * @param resource the resource value to set.
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay setResource(String resource) {
        this.resource = resource;
        return this;
    }

    /**
     * Get the description property: A description of the operation.
     *
     * @return the description value.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description property: A description of the operation.
     *
     * @param description the description value to set.
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay setDescription(String description) {
        this.description = description;
        return this;
    }
}
