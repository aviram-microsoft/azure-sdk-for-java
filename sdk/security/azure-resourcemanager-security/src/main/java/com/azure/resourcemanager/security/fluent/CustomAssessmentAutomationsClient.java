// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.security.fluent.models.CustomAssessmentAutomationInner;
import com.azure.resourcemanager.security.models.CustomAssessmentAutomationRequest;

/** An instance of this class provides access to all the operations defined in CustomAssessmentAutomationsClient. */
public interface CustomAssessmentAutomationsClient {
    /**
     * Gets a custom assessment automation
     *
     * <p>Gets a single custom assessment automation by name for the provided subscription and resource group.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param customAssessmentAutomationName Name of the Custom Assessment Automation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a single custom assessment automation by name for the provided subscription and resource group along with
     *     {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<CustomAssessmentAutomationInner> getByResourceGroupWithResponse(
        String resourceGroupName, String customAssessmentAutomationName, Context context);

    /**
     * Gets a custom assessment automation
     *
     * <p>Gets a single custom assessment automation by name for the provided subscription and resource group.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param customAssessmentAutomationName Name of the Custom Assessment Automation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a single custom assessment automation by name for the provided subscription and resource group.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    CustomAssessmentAutomationInner getByResourceGroup(String resourceGroupName, String customAssessmentAutomationName);

    /**
     * Creates a custom assessment automation
     *
     * <p>Creates or updates a custom assessment automation for the provided subscription. Please note that providing an
     * existing custom assessment automation will replace the existing record.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param customAssessmentAutomationName Name of the Custom Assessment Automation.
     * @param customAssessmentAutomationBody Custom Assessment Automation body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return custom Assessment Automation along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<CustomAssessmentAutomationInner> createWithResponse(
        String resourceGroupName,
        String customAssessmentAutomationName,
        CustomAssessmentAutomationRequest customAssessmentAutomationBody,
        Context context);

    /**
     * Creates a custom assessment automation
     *
     * <p>Creates or updates a custom assessment automation for the provided subscription. Please note that providing an
     * existing custom assessment automation will replace the existing record.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param customAssessmentAutomationName Name of the Custom Assessment Automation.
     * @param customAssessmentAutomationBody Custom Assessment Automation body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return custom Assessment Automation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    CustomAssessmentAutomationInner create(
        String resourceGroupName,
        String customAssessmentAutomationName,
        CustomAssessmentAutomationRequest customAssessmentAutomationBody);

    /**
     * Deletes a custom assessment automation
     *
     * <p>Deletes a custom assessment automation by name for a provided subscription.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param customAssessmentAutomationName Name of the Custom Assessment Automation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String customAssessmentAutomationName, Context context);

    /**
     * Deletes a custom assessment automation
     *
     * <p>Deletes a custom assessment automation by name for a provided subscription.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param customAssessmentAutomationName Name of the Custom Assessment Automation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String customAssessmentAutomationName);

    /**
     * List custom assessment automations in a subscription and a resource group
     *
     * <p>List custom assessment automations by provided subscription and resource group.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Custom Assessment Automations as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<CustomAssessmentAutomationInner> listByResourceGroup(String resourceGroupName);

    /**
     * List custom assessment automations in a subscription and a resource group
     *
     * <p>List custom assessment automations by provided subscription and resource group.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Custom Assessment Automations as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<CustomAssessmentAutomationInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * List custom assessment automations in a subscription
     *
     * <p>List custom assessment automations by provided subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Custom Assessment Automations as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<CustomAssessmentAutomationInner> list();

    /**
     * List custom assessment automations in a subscription
     *
     * <p>List custom assessment automations by provided subscription.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Custom Assessment Automations as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<CustomAssessmentAutomationInner> list(Context context);
}
