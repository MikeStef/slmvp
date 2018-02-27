package com.micste.slmvp.info;

import com.micste.slmvp.netcom.model.ResponseData;

public interface InfoView {

    void showToast(int message);

    void showProgressBar();

    void hideProgressBar();

    void setData(ResponseData data);

    void showBuses();

    void showTrains();

    void showSubway();
}
