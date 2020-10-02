package com.dhakanewsclub.bookfinder;

import com.dhakanewsclub.bookfinder.model.BookList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface BookApi {
    @GET("books/v1/volumes")
    Call<BookList> getBookList(@Query("q") String query);
}
