package com.zukron.newsapp.repository;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.zukron.newsapp.model.NewsResponse;
import com.zukron.newsapp.network.ApiService;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * Project name is NewsApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public class NewsDataFactory extends DataSource.Factory<Integer, NewsResponse.NewsResponseArticles> {
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;

    public NewsDataFactory(ApiService apiService, CompositeDisposable compositeDisposable) {
        this.apiService = apiService;
        this.compositeDisposable = compositeDisposable;
    }

    @NonNull
    @Override
    public DataSource<Integer, NewsResponse.NewsResponseArticles> create() {
        return new NewsDataSource(apiService, compositeDisposable);
    }
}
