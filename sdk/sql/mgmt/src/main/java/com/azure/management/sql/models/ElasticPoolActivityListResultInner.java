// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.sql.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The ElasticPoolActivityListResult model. */
@Fluent
public final class ElasticPoolActivityListResultInner {
    /*
     * The list of elastic pool activities.
     */
    @JsonProperty(value = "value", required = true)
    private List<ElasticPoolActivityInner> value;

    /**
     * Get the value property: The list of elastic pool activities.
     *
     * @return the value value.
     */
    public List<ElasticPoolActivityInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of elastic pool activities.
     *
     * @param value the value value to set.
     * @return the ElasticPoolActivityListResultInner object itself.
     */
    public ElasticPoolActivityListResultInner withValue(List<ElasticPoolActivityInner> value) {
        this.value = value;
        return this;
    }
}
