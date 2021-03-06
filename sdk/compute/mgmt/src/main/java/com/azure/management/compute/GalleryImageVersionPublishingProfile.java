// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.compute;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The GalleryImageVersionPublishingProfile model. */
@Fluent
public final class GalleryImageVersionPublishingProfile extends GalleryArtifactPublishingProfileBase {
    /*
     * The source image from which the Image Version is going to be created.
     */
    @JsonProperty(value = "source", required = true)
    private GalleryArtifactSource source;

    /**
     * Get the source property: The source image from which the Image Version is going to be created.
     *
     * @return the source value.
     */
    public GalleryArtifactSource source() {
        return this.source;
    }

    /**
     * Set the source property: The source image from which the Image Version is going to be created.
     *
     * @param source the source value to set.
     * @return the GalleryImageVersionPublishingProfile object itself.
     */
    public GalleryImageVersionPublishingProfile withSource(GalleryArtifactSource source) {
        this.source = source;
        return this;
    }
}
