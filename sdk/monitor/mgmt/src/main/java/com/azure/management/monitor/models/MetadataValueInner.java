// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.monitor.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The MetadataValue model. */
@Fluent
public final class MetadataValueInner {
    /*
     * the name of the metadata.
     */
    @JsonProperty(value = "name")
    private LocalizableStringInner name;

    /*
     * the value of the metadata.
     */
    @JsonProperty(value = "value")
    private String value;

    /**
     * Get the name property: the name of the metadata.
     *
     * @return the name value.
     */
    public LocalizableStringInner name() {
        return this.name;
    }

    /**
     * Set the name property: the name of the metadata.
     *
     * @param name the name value to set.
     * @return the MetadataValueInner object itself.
     */
    public MetadataValueInner withName(LocalizableStringInner name) {
        this.name = name;
        return this;
    }

    /**
     * Get the value property: the value of the metadata.
     *
     * @return the value value.
     */
    public String value() {
        return this.value;
    }

    /**
     * Set the value property: the value of the metadata.
     *
     * @param value the value value to set.
     * @return the MetadataValueInner object itself.
     */
    public MetadataValueInner withValue(String value) {
        this.value = value;
        return this;
    }
}
