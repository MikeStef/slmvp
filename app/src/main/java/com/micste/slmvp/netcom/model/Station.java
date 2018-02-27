package com.micste.slmvp.netcom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("X")
    @Expose
    private String x;
    @SerializedName("Y")
    @Expose
    private String y;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

}
