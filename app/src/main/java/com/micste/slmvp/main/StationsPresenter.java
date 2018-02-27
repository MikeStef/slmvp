package com.micste.slmvp.main;

import com.micste.slmvp.R;
import com.micste.slmvp.netcom.model.Station;

import java.util.List;


public class StationsPresenter implements StationsInteractor.OnGetStationsListener {

    private StationsInteractor interactor;
    private StationsView view;

    public StationsPresenter(StationsInteractor interactor) {
        this.interactor = interactor;
    }

    public void attach(StationsView view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

    public void getStations(String input) {

        if (view != null) {
            view.showProgressBar();
        }

        interactor.getStations(input, this);
    }

    //OnGetStationsListener

    @Override
    public void onSuccess(List<Station> stations) {
        if (view != null) {
            view.hideProgressBar();
            view.setData(stations);
        }
    }

    @Override
    public void onError(String message) {
        if (view != null) {
            view.hideProgressBar();
        }
    }

    @Override
    public void onEmptyInput() {
        if (view != null) {
            view.hideProgressBar();
            view.showToast(R.string.error_textfield_empty);
        }
    }
}
