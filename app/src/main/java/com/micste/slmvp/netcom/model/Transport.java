package com.micste.slmvp.netcom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transport {

    @SerializedName("SecondaryDestinationName")
    @Expose
    private Object secondaryDestinationName;
    @SerializedName("GroupOfLine")
    @Expose
    private String groupOfLine;
    @SerializedName("TransportMode")
    @Expose
    private String transportMode;
    @SerializedName("LineNumber")
    @Expose
    private String lineNumber;
    @SerializedName("Destination")
    @Expose
    private String destination;
    @SerializedName("JourneyDirection")
    @Expose
    private Integer journeyDirection;
    @SerializedName("StopAreaName")
    @Expose
    private String stopAreaName;
    @SerializedName("StopAreaNumber")
    @Expose
    private Integer stopAreaNumber;
    @SerializedName("StopPointNumber")
    @Expose
    private Integer stopPointNumber;
    @SerializedName("StopPointDesignation")
    @Expose
    private String stopPointDesignation;
    @SerializedName("TimeTabledDateTime")
    @Expose
    private String timeTabledDateTime;
    @SerializedName("ExpectedDateTime")
    @Expose
    private String expectedDateTime;
    @SerializedName("DisplayTime")
    @Expose
    private String displayTime;
    @SerializedName("JourneyNumber")
    @Expose
    private Integer journeyNumber;

    public Object getSecondaryDestinationName() {
        return secondaryDestinationName;
    }

    public void setSecondaryDestinationName(Object secondaryDestinationName) {
        this.secondaryDestinationName = secondaryDestinationName;
    }

    public String getGroupOfLine() {
        return groupOfLine;
    }

    public void setGroupOfLine(String groupOfLine) {
        this.groupOfLine = groupOfLine;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getJourneyDirection() {
        return journeyDirection;
    }

    public void setJourneyDirection(Integer journeyDirection) {
        this.journeyDirection = journeyDirection;
    }

    public String getStopAreaName() {
        return stopAreaName;
    }

    public void setStopAreaName(String stopAreaName) {
        this.stopAreaName = stopAreaName;
    }

    public Integer getStopAreaNumber() {
        return stopAreaNumber;
    }

    public void setStopAreaNumber(Integer stopAreaNumber) {
        this.stopAreaNumber = stopAreaNumber;
    }

    public Integer getStopPointNumber() {
        return stopPointNumber;
    }

    public void setStopPointNumber(Integer stopPointNumber) {
        this.stopPointNumber = stopPointNumber;
    }

    public String getStopPointDesignation() {
        return stopPointDesignation;
    }

    public void setStopPointDesignation(String stopPointDesignation) {
        this.stopPointDesignation = stopPointDesignation;
    }

    public String getTimeTabledDateTime() {
        return timeTabledDateTime;
    }

    public void setTimeTabledDateTime(String timeTabledDateTime) {
        this.timeTabledDateTime = timeTabledDateTime;
    }

    public String getExpectedDateTime() {
        return expectedDateTime;
    }

    public void setExpectedDateTime(String expectedDateTime) {
        this.expectedDateTime = expectedDateTime;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public Integer getJourneyNumber() {
        return journeyNumber;
    }

    public void setJourneyNumber(Integer journeyNumber) {
        this.journeyNumber = journeyNumber;
    }

}
