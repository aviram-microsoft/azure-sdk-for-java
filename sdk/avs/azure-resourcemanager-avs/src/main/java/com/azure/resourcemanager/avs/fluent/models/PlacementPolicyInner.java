// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.avs.models.PlacementPolicyProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** A vSphere Distributed Resource Scheduler (DRS) placement policy. */
@Fluent
public final class PlacementPolicyInner extends ProxyResource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PlacementPolicyInner.class);

    /*
     * placement policy properties
     */
    @JsonProperty(value = "properties")
    private PlacementPolicyProperties properties;

    /**
     * Get the properties property: placement policy properties.
     *
     * @return the properties value.
     */
    public PlacementPolicyProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: placement policy properties.
     *
     * @param properties the properties value to set.
     * @return the PlacementPolicyInner object itself.
     */
    public PlacementPolicyInner withProperties(PlacementPolicyProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }
}