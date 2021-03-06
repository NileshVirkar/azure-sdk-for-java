/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.labservices.v2018_10_15;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * Represents a lab account.
 */
@JsonFlatten
@SkipParentValidation
public class LabAccountFragment extends Resource {
    /**
     * Represents if region selection is enabled.
     */
    @JsonProperty(value = "properties.enabledRegionSelection")
    private Boolean enabledRegionSelection;

    /**
     * The provisioning status of the resource.
     */
    @JsonProperty(value = "properties.provisioningState")
    private String provisioningState;

    /**
     * The unique immutable identifier of a resource (Guid).
     */
    @JsonProperty(value = "properties.uniqueIdentifier")
    private String uniqueIdentifier;

    /**
     * Get represents if region selection is enabled.
     *
     * @return the enabledRegionSelection value
     */
    public Boolean enabledRegionSelection() {
        return this.enabledRegionSelection;
    }

    /**
     * Set represents if region selection is enabled.
     *
     * @param enabledRegionSelection the enabledRegionSelection value to set
     * @return the LabAccountFragment object itself.
     */
    public LabAccountFragment withEnabledRegionSelection(Boolean enabledRegionSelection) {
        this.enabledRegionSelection = enabledRegionSelection;
        return this;
    }

    /**
     * Get the provisioning status of the resource.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioning status of the resource.
     *
     * @param provisioningState the provisioningState value to set
     * @return the LabAccountFragment object itself.
     */
    public LabAccountFragment withProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Get the unique immutable identifier of a resource (Guid).
     *
     * @return the uniqueIdentifier value
     */
    public String uniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * Set the unique immutable identifier of a resource (Guid).
     *
     * @param uniqueIdentifier the uniqueIdentifier value to set
     * @return the LabAccountFragment object itself.
     */
    public LabAccountFragment withUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
        return this;
    }

}
