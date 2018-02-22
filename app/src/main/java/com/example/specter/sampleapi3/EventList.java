
package com.example.specter.sampleapi3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventList {


    @SerializedName("appEvents")
    @Expose
    private List<AppEvent> appEvents = null;

    public List<AppEvent> getAppEvents() {
        return appEvents;
    }

    public void setAppEvents(List<AppEvent> appEvents) {
        this.appEvents = appEvents;
    }

}
