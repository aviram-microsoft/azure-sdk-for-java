// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dataprotection.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** CheckNameAvailabilityResult CheckNameAvailability Result. */
@Fluent
public final class CheckNameAvailabilityResultInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(CheckNameAvailabilityResultInner.class);

    /*
     * Gets or sets the message.
     */
    @JsonProperty(value = "message")
    private String message;

    /*
     * Gets or sets a value indicating whether [name available].
     */
    @JsonProperty(value = "nameAvailable")
    private Boolean nameAvailable;

    /*
     * Gets or sets the reason.
     */
    @JsonProperty(value = "reason")
    private String reason;

    /**
     * Get the message property: Gets or sets the message.
     *
     * @return the message value.
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message property: Gets or sets the message.
     *
     * @param message the message value to set.
     * @return the CheckNameAvailabilityResultInner object itself.
     */
    public CheckNameAvailabilityResultInner withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the nameAvailable property: Gets or sets a value indicating whether [name available].
     *
     * @return the nameAvailable value.
     */
    public Boolean nameAvailable() {
        return this.nameAvailable;
    }

    /**
     * Set the nameAvailable property: Gets or sets a value indicating whether [name available].
     *
     * @param nameAvailable the nameAvailable value to set.
     * @return the CheckNameAvailabilityResultInner object itself.
     */
    public CheckNameAvailabilityResultInner withNameAvailable(Boolean nameAvailable) {
        this.nameAvailable = nameAvailable;
        return this;
    }

    /**
     * Get the reason property: Gets or sets the reason.
     *
     * @return the reason value.
     */
    public String reason() {
        return this.reason;
    }

    /**
     * Set the reason property: Gets or sets the reason.
     *
     * @param reason the reason value to set.
     * @return the CheckNameAvailabilityResultInner object itself.
     */
    public CheckNameAvailabilityResultInner withReason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}