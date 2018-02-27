package com.micste.slmvp.main;

import com.micste.slmvp.netcom.model.Station;
import com.micste.slmvp.netcom.model.StationsResponse;

import java.util.List;

import retrofit2.Call;

public interface StationsInteractor {

    interface OnGetStationsListener {
        void onSuccess(List<Station> stations);

        void onError(String message);

        void onEmptyInput();
    }

    void getStations(String query, OnGetStationsListener listener);
}
