package com.example.dictionary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("{word}")
    Call<List<WordPOJO>> getWords(@Path("word") String word);
}
