package com.gwynbleidd.maplearning;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;


public class MyClusterItem implements ClusterItem {
    private final LatLng location;

    public MyClusterItem(@NonNull LatLng location) {
        this.location = location;
    }

    @Override
    public LatLng getPosition() {
        return this.location;
    }

    @Nullable
    @Override
    public String getTitle() {
        return null;
    }

    @Nullable
    @Override
    public String getSnippet() {
        return null;
    }
}
