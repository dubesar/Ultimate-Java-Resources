package com.fajarnandagusti.cataloguemoviefinal.api;

import com.fajarnandagusti.cataloguemoviefinal.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public interface ApiService {
    @GET("3/discover/movie")
    Call<ResponseMovie> getAllMovies(@Query("api_key") String api_key);

    @GET("/3/search/movie")
    Call<ResponseMovie> getSearchMovie(@Query("api_key") String api_key,
                                       @Query("language") String language,
                                       @Query("query") String query,
                                       @Query("page") String page,
                                       @Query("include_adult") String include_adult);

    @GET("/3/movie/now_playing")
    Call<ResponseMovie> getNowPlayingMovie(@Query("api_key") String api_key);

    @GET("/3/movie/upcoming")
    Call<ResponseMovie> getUpComingMovie(@Query("api_key") String api_key);
}
