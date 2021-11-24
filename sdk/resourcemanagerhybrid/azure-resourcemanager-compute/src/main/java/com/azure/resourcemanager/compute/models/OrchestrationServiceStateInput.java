// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The input for OrchestrationServiceState. */
@Fluent
public final class OrchestrationServiceStateInput {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(OrchestrationServiceStateInput.class);

    /*
     * The name of the service.
     */
    @JsonProperty(value = "serviceName", required = true)
    private OrchestrationServiceNames serviceName;

    /*
     * The action to be performed.
     */
    @JsonProperty(value = "action", required = true)
    private OrchestrationServiceStateAction action;

    /**
     * Get the serviceName property: The name of the service.
     *
     * @return the serviceName value.
     */
    public OrchestrationServiceNames serviceName() {
        return this.serviceName;
    }

    /**
     * Set the serviceName property: The name of the service.
     *
     * @param serviceName the serviceName value to set.
     * @return the OrchestrationServiceStateInput object itself.
     */
    public OrchestrationServiceStateInput withServiceName(OrchestrationServiceNames serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    /**
     * Get the action property: The action to be performed.
     *
     * @return the action value.
     */
    public OrchestrationServiceStateAction action() {
        return this.action;
    }

    /**
     * Set the action property: The action to be performed.
     *
     * @param action the action value to set.
     * @return the OrchestrationServiceStateInput object itself.
     */
    public OrchestrationServiceStateInput withAction(OrchestrationServiceStateAction action) {
        this.action = action;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (serviceName() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property serviceName in model OrchestrationServiceStateInput"));
        }
        if (action() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property action in model OrchestrationServiceStateInput"));
        }
    }
}