package com.zukron.newsapp.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.zukron.newsapp.model.NewsResponse;
import com.zukron.newsapp.repository.Repository;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * Project name is NewsApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public class MainViewModel extends ViewModel {
    private Repository repository = Repository.getInstance();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LiveData<PagedList<NewsResponse.NewsResponseArticles>> getAllNews() {
        return repository.getAllNews(compositeDisposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        compositeDisposable.clear();
    }
}
