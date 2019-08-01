
package com.gwynbleidd.maplearning.retro.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Route {

    @Expose
    private List<Leg> legs;
    @Expose
    private String summary;

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
