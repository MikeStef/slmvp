package com.micste.slmvp.info;

import com.micste.slmvp.netcom.ApiClient;

public class InfoInteractorImpl implements InfoInteractor {

    @Override
    public void getInfo(String id, String time, OnGetInfoListener listener) {
        ApiClient.getClient().getInfo(id, time, listener);
    }
}
