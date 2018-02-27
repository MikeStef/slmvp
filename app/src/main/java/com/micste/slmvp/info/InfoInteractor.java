package com.micste.slmvp.info;

import com.micste.slmvp.netcom.model.ResponseData;
import com.micste.slmvp.netcom.model.Transport;

import java.util.List;

public interface InfoInteractor {

    interface OnGetInfoListener {

        void onSuccess(ResponseData data);

        void onError();

    }

    void getInfo(String id, String time, OnGetInfoListener listener);
}
