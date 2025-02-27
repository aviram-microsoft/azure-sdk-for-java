// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callautomation.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The RecognizeRequest model. */
@Fluent
public final class RecognizeRequest {
    /*
     * Determines the type of the recognition.
     */
    @JsonProperty(value = "recognizeInputType", required = true)
    private RecognizeInputTypeInternal recognizeInputType;

    /*
     * The source of the audio to be played for recognition.
     */
    @JsonProperty(value = "playPrompt")
    private PlaySourceInternal playPrompt;

    /*
     * If set recognize can barge into other existing
     * queued-up/currently-processing requests.
     */
    @JsonProperty(value = "interruptCallMediaOperation")
    private Boolean interruptCallMediaOperation;

    /*
     * Defines options for recognition.
     */
    @JsonProperty(value = "recognizeOptions", required = true)
    private RecognizeOptionsInternal recognizeOptions;

    /*
     * The value to identify context of the operation.
     */
    @JsonProperty(value = "operationContext")
    private String operationContext;

    /**
     * Get the recognizeInputType property: Determines the type of the recognition.
     *
     * @return the recognizeInputType value.
     */
    public RecognizeInputTypeInternal getRecognizeInputType() {
        return this.recognizeInputType;
    }

    /**
     * Set the recognizeInputType property: Determines the type of the recognition.
     *
     * @param recognizeInputType the recognizeInputType value to set.
     * @return the RecognizeRequest object itself.
     */
    public RecognizeRequest setRecognizeInputType(RecognizeInputTypeInternal recognizeInputType) {
        this.recognizeInputType = recognizeInputType;
        return this;
    }

    /**
     * Get the playPrompt property: The source of the audio to be played for recognition.
     *
     * @return the playPrompt value.
     */
    public PlaySourceInternal getPlayPrompt() {
        return this.playPrompt;
    }

    /**
     * Set the playPrompt property: The source of the audio to be played for recognition.
     *
     * @param playPrompt the playPrompt value to set.
     * @return the RecognizeRequest object itself.
     */
    public RecognizeRequest setPlayPrompt(PlaySourceInternal playPrompt) {
        this.playPrompt = playPrompt;
        return this;
    }

    /**
     * Get the interruptCallMediaOperation property: If set recognize can barge into other existing
     * queued-up/currently-processing requests.
     *
     * @return the interruptCallMediaOperation value.
     */
    public Boolean isInterruptCallMediaOperation() {
        return this.interruptCallMediaOperation;
    }

    /**
     * Set the interruptCallMediaOperation property: If set recognize can barge into other existing
     * queued-up/currently-processing requests.
     *
     * @param interruptCallMediaOperation the interruptCallMediaOperation value to set.
     * @return the RecognizeRequest object itself.
     */
    public RecognizeRequest setInterruptCallMediaOperation(Boolean interruptCallMediaOperation) {
        this.interruptCallMediaOperation = interruptCallMediaOperation;
        return this;
    }

    /**
     * Get the recognizeOptions property: Defines options for recognition.
     *
     * @return the recognizeOptions value.
     */
    public RecognizeOptionsInternal getRecognizeOptions() {
        return this.recognizeOptions;
    }

    /**
     * Set the recognizeOptions property: Defines options for recognition.
     *
     * @param recognizeOptions the recognizeOptions value to set.
     * @return the RecognizeRequest object itself.
     */
    public RecognizeRequest setRecognizeOptions(RecognizeOptionsInternal recognizeOptions) {
        this.recognizeOptions = recognizeOptions;
        return this;
    }

    /**
     * Get the operationContext property: The value to identify context of the operation.
     *
     * @return the operationContext value.
     */
    public String getOperationContext() {
        return this.operationContext;
    }

    /**
     * Set the operationContext property: The value to identify context of the operation.
     *
     * @param operationContext the operationContext value to set.
     * @return the RecognizeRequest object itself.
     */
    public RecognizeRequest setOperationContext(String operationContext) {
        this.operationContext = operationContext;
        return this;
    }
}
