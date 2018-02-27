package com.micste.slmvp.main;

import com.micste.slmvp.netcom.model.Station;

import java.util.List;

public interface StationsView {

    void showToast(int message);

    void showProgressBar();

    void hideProgressBar();

    void setData(List<Station> data);
}
