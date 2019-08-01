
package com.gwynbleidd.maplearning.retro.Pojo;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class EndLocation {

    @Expose
    private Double lat;
    @Expose
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

}
