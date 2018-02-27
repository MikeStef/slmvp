package com.micste.slmvp.netcom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData {

    @SerializedName("LatestUpdate")
    @Expose
    private String latestUpdate;
    @SerializedName("Metros")
    @Expose
    private List<Transport> metros = null;
    @SerializedName("Buses")
    @Expose
    private List<Transport> buses = null;
    @SerializedName("Trains")
    @Expose
    private List<Transport> trains = null;

    public String getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(String latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public List<Transport> getMetros() {
        return metros;
    }

    public void setMetros(List<Transport> metros) {
        this.metros = metros;
    }

    public List<Transport> getBuses() {
        return buses;
    }

    public void setBuses(List<Transport> buses) {
        this.buses = buses;
    }

    public List<Transport> getTrains() {
        return trains;
    }

    public void setTrains(List<Transport> trains) {
        this.trains = trains;
    }

}

