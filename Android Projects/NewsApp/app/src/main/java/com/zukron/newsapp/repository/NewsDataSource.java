package com.zukron.newsapp.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.zukron.newsapp.model.NewsResponse;
import com.zukron.newsapp.network.ApiService;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Project name is NewsApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public class NewsDataSource extends PageKeyedDataSource<Integer, NewsResponse.NewsResponseArticles> {
    private static final String TAG = "NewsDataSource";
    private final String apiKey = "778a0c7ac8644191ae8b8ea33856613c";
    private String query = "technology";
    private int firstPage = 1;
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;

    public NewsDataSource(ApiService apiService, CompositeDisposable compositeDisposable) {
        this.apiService = apiService;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void loadInitial(
            @NonNull LoadInitialParams<Integer> params,
            @NonNull LoadInitialCallback<Integer, NewsResponse.NewsResponseArticles> callback
    ) {
        compositeDisposable.add(
                apiService.getAllNews(query, apiKey, firstPage, params.requestedLoadSize)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                newsResponse -> callback.onResult(newsResponse.getArticles(), null, firstPage + 1),
                                error -> Log.e(TAG, "loadInitial: ", error)
                        )
        );
    }

    @Override
    public void loadBefore(
            @NonNull LoadParams<Integer> params,
            @NonNull LoadCallback<Integer, NewsResponse.NewsResponseArticles> callback
    ) {
        // who care
    }

    @Override
    public void loadAfter(
            @NonNull LoadParams<Integer> params,
            @NonNull LoadCallback<Integer, NewsResponse.NewsResponseArticles> callback
    ) {
        compositeDisposable.add(
                apiService.getAllNews(query, apiKey, params.key, params.requestedLoadSize)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                newsResponse -> callback.onResult(newsResponse.getArticles(), params.key + 1),
                                error -> Log.e(TAG, "loadInitial: ", error)
                        )
        );
    }
}
