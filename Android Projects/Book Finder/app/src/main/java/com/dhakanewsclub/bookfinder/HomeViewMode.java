package com.dhakanewsclub.bookfinder;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dhakanewsclub.bookfinder.model.BookList;


import java.util.List;

class HomeViewMode extends ViewModel {
    private HomeRepository mHomeRepository;
    private MutableLiveData<BookList> mBookListMutableLiveData=new MutableLiveData<>();

    public HomeViewMode(Application application, String param) {
    }



    public void initAllPlace(String query){
        if(mHomeRepository==null){
            mHomeRepository=HomeRepository.getInstance();
        }
        mBookListMutableLiveData=mHomeRepository.getBookList(query);
    }


    public MutableLiveData<BookList> getBookListMutableLiveData() {
        return mBookListMutableLiveData;
    }
}
