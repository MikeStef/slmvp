package com.micste.slmvp.info;

import com.micste.slmvp.netcom.model.ResponseData;

public class InfoPresenter implements InfoInteractor.OnGetInfoListener {

    private InfoInteractor interactor;
    private InfoView view;

    public InfoPresenter(InfoInteractor interactor) {
        this.interactor = interactor;
    }

    public void attach(InfoView view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

    public void getInfo(String id, String time) {
        if (view != null) {
            view.showProgressBar();
        }

        interactor.getInfo(id, time, this);
    }

    public void showBuses() {
        if (view != null) {
            view.showBuses();
        }
    }

    public void showTrains() {
        if (view != null) {
            view.showTrains();
        }
    }

    public void showSubway() {
        if (view != null) {
            view.showSubway();
        }
    }

    @Override
    public void onSuccess(ResponseData data) {
        if (view != null) {
            view.hideProgressBar();
            view.setData(data);
        }
    }

    @Override
    public void onError() {
        if (view != null) {
            view.hideProgressBar();
        }
    }
}
