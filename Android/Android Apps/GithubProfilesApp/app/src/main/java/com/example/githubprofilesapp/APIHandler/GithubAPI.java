package com.example.githubprofilesapp.APIHandler;

import com.example.githubprofilesapp.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {

    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);

    @GET("{user}/repos")
    Call<List<User>> getRepos(@Path("user") String user);
}
