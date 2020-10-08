package com.zukron.newsapp.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Project name is NewsApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public class RestApi {
    private static ApiService apiService = null;
    private static final String BASE_URL = "https://newsapi.org/v2/";

    public static ApiService getInstance() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();

            apiService = retrofit
                    .create(ApiService.class);
        }

        return apiService;
    }
}
