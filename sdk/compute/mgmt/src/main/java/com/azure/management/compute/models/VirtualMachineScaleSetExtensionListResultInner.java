// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.compute.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The VirtualMachineScaleSetExtensionListResult model. */
@Fluent
public final class VirtualMachineScaleSetExtensionListResultInner {
    /*
     * The list of VM scale set extensions.
     */
    @JsonProperty(value = "value", required = true)
    private List<VirtualMachineScaleSetExtensionInner> value;

    /*
     * The uri to fetch the next page of VM scale set extensions. Call
     * ListNext() with this to fetch the next page of VM scale set extensions.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /**
     * Get the value property: The list of VM scale set extensions.
     *
     * @return the value value.
     */
    public List<VirtualMachineScaleSetExtensionInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of VM scale set extensions.
     *
     * @param value the value value to set.
     * @return the VirtualMachineScaleSetExtensionListResultInner object itself.
     */
    public VirtualMachineScaleSetExtensionListResultInner withValue(List<VirtualMachineScaleSetExtensionInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The uri to fetch the next page of VM scale set extensions. Call ListNext() with this
     * to fetch the next page of VM scale set extensions.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The uri to fetch the next page of VM scale set extensions. Call ListNext() with this
     * to fetch the next page of VM scale set extensions.
     *
     * @param nextLink the nextLink value to set.
     * @return the VirtualMachineScaleSetExtensionListResultInner object itself.
     */
    public VirtualMachineScaleSetExtensionListResultInner withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }
}
