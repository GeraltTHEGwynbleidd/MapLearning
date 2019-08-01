
package com.gwynbleidd.maplearning.retro.Pojo;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class OverviewPolyline {

    @Expose
    private String points;

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

}
