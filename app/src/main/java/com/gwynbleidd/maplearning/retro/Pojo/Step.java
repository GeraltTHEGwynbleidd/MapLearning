
package com.gwynbleidd.maplearning.retro.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Step {

    @Expose
    private Distance distance;
    @Expose
    private Duration duration;
    @SerializedName("end_location")
    private EndLocation endLocation;
    @SerializedName("html_instructions")
    private String htmlInstructions;
    @Expose
    private Polyline polyline;
    @SerializedName("start_location")
    private StartLocation startLocation;
    @SerializedName("travel_mode")
    private String travelMode;

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public EndLocation getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(EndLocation endLocation) {
        this.endLocation = endLocation;
    }

    public String getHtmlInstructions() {
        return htmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions) {
        this.htmlInstructions = htmlInstructions;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    public StartLocation getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(StartLocation startLocation) {
        this.startLocation = startLocation;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

}
