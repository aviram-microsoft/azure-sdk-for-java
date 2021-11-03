// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dataprotection.models;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.dataprotection.fluent.models.ResourceGuardResourceInner;
import java.util.Map;

/** An immutable client-side representation of ResourceGuardResource. */
public interface ResourceGuardResource {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     *
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     *
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the etag property: Optional ETag.
     *
     * @return the etag value.
     */
    String etag();

    /**
     * Gets the identity property: DppIdentityDetails Input Managed Identity Details.
     *
     * @return the identity value.
     */
    DppIdentityDetails identity();

    /**
     * Gets the systemData property: Metadata pertaining to creation and last modification of the resource.
     *
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the properties property: ResourceGuardResource properties.
     *
     * @return the properties value.
     */
    ResourceGuard properties();

    /**
     * Gets the region of the resource.
     *
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     *
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the inner com.azure.resourcemanager.dataprotection.fluent.models.ResourceGuardResourceInner object.
     *
     * @return the inner object.
     */
    ResourceGuardResourceInner innerModel();

    /** The entirety of the ResourceGuardResource definition. */
    interface Definition
        extends DefinitionStages.Blank,
            DefinitionStages.WithLocation,
            DefinitionStages.WithResourceGroup,
            DefinitionStages.WithCreate {
    }
    /** The ResourceGuardResource definition stages. */
    interface DefinitionStages {
        /** The first stage of the ResourceGuardResource definition. */
        interface Blank extends WithLocation {
        }
        /** The stage of the ResourceGuardResource definition allowing to specify location. */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             *
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             *
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }
        /** The stage of the ResourceGuardResource definition allowing to specify parent resource. */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             *
             * @param resourceGroupName The name of the resource group where the backup vault is present.
             * @return the next definition stage.
             */
            WithCreate withExistingResourceGroup(String resourceGroupName);
        }
        /**
         * The stage of the ResourceGuardResource definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithTags,
                DefinitionStages.WithEtag,
                DefinitionStages.WithIdentity,
                DefinitionStages.WithProperties {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            ResourceGuardResource create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            ResourceGuardResource create(Context context);
        }
        /** The stage of the ResourceGuardResource definition allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             *
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }
        /** The stage of the ResourceGuardResource definition allowing to specify etag. */
        interface WithEtag {
            /**
             * Specifies the etag property: Optional ETag..
             *
             * @param etag Optional ETag.
             * @return the next definition stage.
             */
            WithCreate withEtag(String etag);
        }
        /** The stage of the ResourceGuardResource definition allowing to specify identity. */
        interface WithIdentity {
            /**
             * Specifies the identity property: DppIdentityDetails Input Managed Identity Details.
             *
             * @param identity DppIdentityDetails Input Managed Identity Details.
             * @return the next definition stage.
             */
            WithCreate withIdentity(DppIdentityDetails identity);
        }
        /** The stage of the ResourceGuardResource definition allowing to specify properties. */
        interface WithProperties {
            /**
             * Specifies the properties property: ResourceGuardResource properties.
             *
             * @param properties ResourceGuardResource properties.
             * @return the next definition stage.
             */
            WithCreate withProperties(ResourceGuard properties);
        }
    }
    /**
     * Begins update for the ResourceGuardResource resource.
     *
     * @return the stage of resource update.
     */
    ResourceGuardResource.Update update();

    /** The template for ResourceGuardResource update. */
    interface Update extends UpdateStages.WithTags, UpdateStages.WithIdentity {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        ResourceGuardResource apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        ResourceGuardResource apply(Context context);
    }
    /** The ResourceGuardResource update stages. */
    interface UpdateStages {
        /** The stage of the ResourceGuardResource update allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             *
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }
        /** The stage of the ResourceGuardResource update allowing to specify identity. */
        interface WithIdentity {
            /**
             * Specifies the identity property: DppIdentityDetails Input Managed Identity Details.
             *
             * @param identity DppIdentityDetails Input Managed Identity Details.
             * @return the next definition stage.
             */
            Update withIdentity(DppIdentityDetails identity);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    ResourceGuardResource refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    ResourceGuardResource refresh(Context context);
}