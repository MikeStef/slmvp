package com.micste.slmvp.netcom;


import com.micste.slmvp.BuildConfig;
import com.micste.slmvp.netcom.model.InfoResponse;
import com.micste.slmvp.netcom.model.StationsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("typeahead.json?key=" + BuildConfig.API_KEY + "&stationsonly=true")
    Call<StationsResponse> getStations(@Query("searchstring") String query);

    @GET("realtimedeparturesv4.json?key=" + BuildConfig.API_KEY2)
    Call<InfoResponse> getInfo(@Query("siteid") String id, @Query("timewindow") String time);
}
