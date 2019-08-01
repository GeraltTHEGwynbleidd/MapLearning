
package com.gwynbleidd.maplearning.retro.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Leg {

    @Expose
    private Bounds bounds;
    @Expose
    private String copyrights;
    @SerializedName("overview_polyline")
    private OverviewPolyline overviewPolyline;
    @Expose
    private List<Step> steps;
    @Expose
    private List<Object> warnings;
    @SerializedName("waypoint_order")
    private List<Long> waypointOrder;

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public OverviewPolyline getOverviewPolyline() {
        return overviewPolyline;
    }

    public void setOverviewPolyline(OverviewPolyline overviewPolyline) {
        this.overviewPolyline = overviewPolyline;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Object> warnings) {
        this.warnings = warnings;
    }

    public List<Long> getWaypointOrder() {
        return waypointOrder;
    }

    public void setWaypointOrder(List<Long> waypointOrder) {
        this.waypointOrder = waypointOrder;
    }

}
