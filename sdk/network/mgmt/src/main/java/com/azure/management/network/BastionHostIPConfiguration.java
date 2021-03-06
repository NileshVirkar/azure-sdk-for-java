// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.network;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.management.SubResource;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The BastionHostIPConfiguration model. */
@JsonFlatten
@Fluent
public class BastionHostIPConfiguration extends SubResource {
    /*
     * Name of the resource that is unique within a resource group. This name
     * can be used to access the resource.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /*
     * Ip configuration type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /*
     * Reference of the subnet resource.
     */
    @JsonProperty(value = "properties.subnet")
    private SubResource subnet;

    /*
     * Reference of the PublicIP resource.
     */
    @JsonProperty(value = "properties.publicIPAddress")
    private SubResource publicIPAddress;

    /*
     * The provisioning state of the resource.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /*
     * Private IP allocation method.
     */
    @JsonProperty(value = "properties.privateIPAllocationMethod")
    private IPAllocationMethod privateIPAllocationMethod;

    /**
     * Get the name property: Name of the resource that is unique within a resource group. This name can be used to
     * access the resource.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Name of the resource that is unique within a resource group. This name can be used to
     * access the resource.
     *
     * @param name the name value to set.
     * @return the BastionHostIPConfiguration object itself.
     */
    public BastionHostIPConfiguration withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the etag property: A unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get the type property: Ip configuration type.
     *
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Get the subnet property: Reference of the subnet resource.
     *
     * @return the subnet value.
     */
    public SubResource subnet() {
        return this.subnet;
    }

    /**
     * Set the subnet property: Reference of the subnet resource.
     *
     * @param subnet the subnet value to set.
     * @return the BastionHostIPConfiguration object itself.
     */
    public BastionHostIPConfiguration withSubnet(SubResource subnet) {
        this.subnet = subnet;
        return this;
    }

    /**
     * Get the publicIPAddress property: Reference of the PublicIP resource.
     *
     * @return the publicIPAddress value.
     */
    public SubResource publicIPAddress() {
        return this.publicIPAddress;
    }

    /**
     * Set the publicIPAddress property: Reference of the PublicIP resource.
     *
     * @param publicIPAddress the publicIPAddress value to set.
     * @return the BastionHostIPConfiguration object itself.
     */
    public BastionHostIPConfiguration withPublicIPAddress(SubResource publicIPAddress) {
        this.publicIPAddress = publicIPAddress;
        return this;
    }

    /**
     * Get the provisioningState property: The provisioning state of the resource.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the privateIPAllocationMethod property: Private IP allocation method.
     *
     * @return the privateIPAllocationMethod value.
     */
    public IPAllocationMethod privateIPAllocationMethod() {
        return this.privateIPAllocationMethod;
    }

    /**
     * Set the privateIPAllocationMethod property: Private IP allocation method.
     *
     * @param privateIPAllocationMethod the privateIPAllocationMethod value to set.
     * @return the BastionHostIPConfiguration object itself.
     */
    public BastionHostIPConfiguration withPrivateIPAllocationMethod(IPAllocationMethod privateIPAllocationMethod) {
        this.privateIPAllocationMethod = privateIPAllocationMethod;
        return this;
    }
}
