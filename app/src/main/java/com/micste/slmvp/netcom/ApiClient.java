package com.micste.slmvp.netcom;

import android.support.annotation.NonNull;

import com.micste.slmvp.BuildConfig;
import com.micste.slmvp.info.InfoInteractor;
import com.micste.slmvp.main.StationsInteractor;
import com.micste.slmvp.netcom.model.InfoResponse;
import com.micste.slmvp.netcom.model.StationsResponse;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String DEFAULT_TIME = "15";
    private static Retrofit retrofit = null;
    private static ApiClient apiClient = null;

    private ApiClient() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient getClient() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }

        return apiClient;
    }

    public void getStations(String query, final StationsInteractor.OnGetStationsListener listener) {
        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getStations(query).enqueue(new retrofit2.Callback<StationsResponse>() {
            @Override
            public void onResponse(Call<StationsResponse> call, retrofit2.Response<StationsResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body().getResponseData());
                }
            }

            @Override
            public void onFailure(Call<StationsResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public void getInfo(String id, String time, final InfoInteractor.OnGetInfoListener listener) {
        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getInfo(id, time).enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, retrofit2.Response<InfoResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body().getResponseData());
                }
            }

            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
                listener.onError();
            }
        });
    }
}
