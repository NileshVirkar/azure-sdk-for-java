// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.network;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The ExpressRouteConnectionId model. */
@Immutable
public final class ExpressRouteConnectionId {
    /*
     * The ID of the ExpressRouteConnection.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /**
     * Get the id property: The ID of the ExpressRouteConnection.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }
}
