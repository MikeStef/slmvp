package com.micste.slmvp.netcom.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StationsResponse {

    @SerializedName("StatusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("Message")
    @Expose
    private Object message;
    @SerializedName("ExecutionTime")
    @Expose
    private Integer executionTime;
    @SerializedName("ResponseData")
    @Expose
    private List<Station> responseData = null;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Integer getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    public List<Station> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<Station> responseData) {
        this.responseData = responseData;
    }

}