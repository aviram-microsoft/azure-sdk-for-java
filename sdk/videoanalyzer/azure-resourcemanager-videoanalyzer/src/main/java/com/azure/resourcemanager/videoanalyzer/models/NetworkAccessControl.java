// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.videoanalyzer.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Network access control for video analyzer account. */
@Fluent
public final class NetworkAccessControl {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(NetworkAccessControl.class);

    /*
     * Public network access for integration group.
     */
    @JsonProperty(value = "integration")
    private GroupLevelAccessControl integration;

    /*
     * Public network access for ingestion group.
     */
    @JsonProperty(value = "ingestion")
    private GroupLevelAccessControl ingestion;

    /*
     * Public network access for consumption group.
     */
    @JsonProperty(value = "consumption")
    private GroupLevelAccessControl consumption;

    /**
     * Get the integration property: Public network access for integration group.
     *
     * @return the integration value.
     */
    public GroupLevelAccessControl integration() {
        return this.integration;
    }

    /**
     * Set the integration property: Public network access for integration group.
     *
     * @param integration the integration value to set.
     * @return the NetworkAccessControl object itself.
     */
    public NetworkAccessControl withIntegration(GroupLevelAccessControl integration) {
        this.integration = integration;
        return this;
    }

    /**
     * Get the ingestion property: Public network access for ingestion group.
     *
     * @return the ingestion value.
     */
    public GroupLevelAccessControl ingestion() {
        return this.ingestion;
    }

    /**
     * Set the ingestion property: Public network access for ingestion group.
     *
     * @param ingestion the ingestion value to set.
     * @return the NetworkAccessControl object itself.
     */
    public NetworkAccessControl withIngestion(GroupLevelAccessControl ingestion) {
        this.ingestion = ingestion;
        return this;
    }

    /**
     * Get the consumption property: Public network access for consumption group.
     *
     * @return the consumption value.
     */
    public GroupLevelAccessControl consumption() {
        return this.consumption;
    }

    /**
     * Set the consumption property: Public network access for consumption group.
     *
     * @param consumption the consumption value to set.
     * @return the NetworkAccessControl object itself.
     */
    public NetworkAccessControl withConsumption(GroupLevelAccessControl consumption) {
        this.consumption = consumption;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (integration() != null) {
            integration().validate();
        }
        if (ingestion() != null) {
            ingestion().validate();
        }
        if (consumption() != null) {
            consumption().validate();
        }
    }
}