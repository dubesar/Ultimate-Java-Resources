package com.dhakanewsclub.bookfinder;

import android.util.DisplayMetrics;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.dhakanewsclub.bookfinder.model.BookList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class HomeRepository {
    final String DIBAGING_TAG="DIBAGING_TAG";

    public static HomeRepository instance;

    public static HomeRepository getInstance(){
        if (instance==null){
            instance=new HomeRepository();
        }
        return instance;
    }

    MutableLiveData<BookList> getBookList(String query){
        Log.d(DIBAGING_TAG,"getBookListRepo Query:"+query);
        final MutableLiveData<BookList> bookListMutableLiveData=new MutableLiveData<>();
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        BookApi bookApi=retrofit.create(BookApi.class);
        Call<BookList> call=bookApi.getBookList(query);
        call.enqueue(new Callback<BookList>() {
            @Override
            public void onResponse(Call<BookList> call, Response<BookList> response) {
                if (response.isSuccessful()){
                    bookListMutableLiveData.setValue(response.body());
                    Log.d(DIBAGING_TAG,"book list success: "+response.body().getItems().size());
                }
                else {
                    Log.d(DIBAGING_TAG,"failed onResponse: response: "+response.code()+"message: "+response);
                }

            }

            @Override
            public void onFailure(Call<BookList> call, Throwable t) {
                Log.d(DIBAGING_TAG,"failed in repository");
            }
        });
        return bookListMutableLiveData;
    }
}
