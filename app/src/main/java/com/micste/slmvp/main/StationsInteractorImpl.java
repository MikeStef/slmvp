package com.micste.slmvp.main;

import com.micste.slmvp.netcom.ApiClient;


public class StationsInteractorImpl implements StationsInteractor{

    @Override
    public void getStations(String query, StationsInteractor.OnGetStationsListener listener) {

        if (query == null || query.length() == 0) {
            listener.onEmptyInput();
            return;
        }

        ApiClient.getClient().getStations(query, listener);
    }
}
