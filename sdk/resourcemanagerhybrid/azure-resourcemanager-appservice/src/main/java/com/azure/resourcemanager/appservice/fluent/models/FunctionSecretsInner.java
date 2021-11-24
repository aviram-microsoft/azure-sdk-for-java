// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.appservice.models.ProxyOnlyResource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Function secrets. */
@Fluent
public final class FunctionSecretsInner extends ProxyOnlyResource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(FunctionSecretsInner.class);

    /*
     * FunctionSecrets resource specific properties
     */
    @JsonProperty(value = "properties")
    private FunctionSecretsProperties innerProperties;

    /**
     * Get the innerProperties property: FunctionSecrets resource specific properties.
     *
     * @return the innerProperties value.
     */
    private FunctionSecretsProperties innerProperties() {
        return this.innerProperties;
    }

    /** {@inheritDoc} */
    @Override
    public FunctionSecretsInner withKind(String kind) {
        super.withKind(kind);
        return this;
    }

    /**
     * Get the key property: Secret key.
     *
     * @return the key value.
     */
    public String key() {
        return this.innerProperties() == null ? null : this.innerProperties().key();
    }

    /**
     * Set the key property: Secret key.
     *
     * @param key the key value to set.
     * @return the FunctionSecretsInner object itself.
     */
    public FunctionSecretsInner withKey(String key) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FunctionSecretsProperties();
        }
        this.innerProperties().withKey(key);
        return this;
    }

    /**
     * Get the triggerUrl property: Trigger URL.
     *
     * @return the triggerUrl value.
     */
    public String triggerUrl() {
        return this.innerProperties() == null ? null : this.innerProperties().triggerUrl();
    }

    /**
     * Set the triggerUrl property: Trigger URL.
     *
     * @param triggerUrl the triggerUrl value to set.
     * @return the FunctionSecretsInner object itself.
     */
    public FunctionSecretsInner withTriggerUrl(String triggerUrl) {
        if (this.innerProperties() == null) {
            this.innerProperties = new FunctionSecretsProperties();
        }
        this.innerProperties().withTriggerUrl(triggerUrl);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}