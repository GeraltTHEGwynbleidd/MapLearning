
package com.gwynbleidd.maplearning.retro.Pojo;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Distance {

    @Expose
    private String text;
    @Expose
    private Long value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

}
