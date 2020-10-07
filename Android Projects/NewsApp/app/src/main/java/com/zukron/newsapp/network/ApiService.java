package com.zukron.newsapp.network;

import com.zukron.newsapp.model.NewsResponse;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Project name is NewsApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public interface ApiService {
    @GET("everything")
    Flowable<NewsResponse> getAllNews(
            @Query("q") String query,
            @Query("apikey") String apiKey,
            @Query("page") int page,
            @Query("pagesize") int pageSize
    );

}
