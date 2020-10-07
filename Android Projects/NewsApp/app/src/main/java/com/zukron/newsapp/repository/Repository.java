package com.zukron.newsapp.repository;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zukron.newsapp.model.NewsResponse;
import com.zukron.newsapp.network.ApiService;
import com.zukron.newsapp.network.RestApi;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * Project name is NewsApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public class Repository {
    public static Repository getInstance() {
        if (repository == null) {
            apiService = RestApi.getInstance();
            repository = new Repository();
        }
        return repository;
    }

    private static final String TAG = "Repository";
    private static Repository repository = null;
    private static ApiService apiService;
    private int postPerPage = 10;
    private Executor executor = Executors.newFixedThreadPool(5);
    private PagedList.Config config = new PagedList.Config.Builder()
            .setPageSize(postPerPage)
            .setEnablePlaceholders(false)
            .build();

    public LiveData<PagedList<NewsResponse.NewsResponseArticles>> getAllNews(CompositeDisposable compositeDisposable) {
        NewsDataFactory newsDataFactory = new NewsDataFactory(apiService, compositeDisposable);

        return new LivePagedListBuilder(newsDataFactory, config)
                .setFetchExecutor(executor)
                .build();
    }
}
