/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.operationsmanagement.v2015_11_01_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.operationsmanagement.v2015_11_01_preview.implementation.ManagementAssociationInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.operationsmanagement.v2015_11_01_preview.implementation.OperationsManagementManager;

/**
 * Type representing ManagementAssociation.
 */
public interface ManagementAssociation extends HasInner<ManagementAssociationInner>, Indexable, Updatable<ManagementAssociation.Update>, HasManager<OperationsManagementManager> {
    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the location value.
     */
    String location();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the properties value.
     */
    ManagementAssociationProperties properties();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the ManagementAssociation definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithProvider, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of ManagementAssociation definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a ManagementAssociation definition.
         */
        interface Blank extends WithProvider {
        }

        /**
         * The stage of the managementassociation definition allowing to specify Provider.
         */
        interface WithProvider {
           /**
            * Specifies resourceGroupName.
            * @param resourceGroupName The name of the resource group to get. The name is case insensitive
            * @return the next definition stage
            */
            WithCreate withExistingProvider(String resourceGroupName);
        }

        /**
         * The stage of the managementassociation definition allowing to specify Location.
         */
        interface WithLocation {
            /**
             * Specifies location.
             * @param location Resource location
             * @return the next definition stage
             */
            WithCreate withLocation(String location);
        }

        /**
         * The stage of the managementassociation definition allowing to specify Properties.
         */
        interface WithProperties {
            /**
             * Specifies properties.
             * @param properties Properties for ManagementAssociation object supported by the OperationsManagement resource provider
             * @return the next definition stage
             */
            WithCreate withProperties(ManagementAssociationProperties properties);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<ManagementAssociation>, DefinitionStages.WithLocation, DefinitionStages.WithProperties {
        }
    }
    /**
     * The template for a ManagementAssociation update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<ManagementAssociation>, UpdateStages.WithLocation, UpdateStages.WithProperties {
    }

    /**
     * Grouping of ManagementAssociation update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the managementassociation update allowing to specify Location.
         */
        interface WithLocation {
            /**
             * Specifies location.
             * @param location Resource location
             * @return the next update stage
             */
            Update withLocation(String location);
        }

        /**
         * The stage of the managementassociation update allowing to specify Properties.
         */
        interface WithProperties {
            /**
             * Specifies properties.
             * @param properties Properties for ManagementAssociation object supported by the OperationsManagement resource provider
             * @return the next update stage
             */
            Update withProperties(ManagementAssociationProperties properties);
        }

    }
}
