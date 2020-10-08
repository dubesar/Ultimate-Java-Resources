package com.zukron.loginapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.zukron.loginapp.model.User;
import com.zukron.loginapp.repository.Repository;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * Project name is LoginApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public class MainViewModel extends AndroidViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    private static final String TAG = "MainViewModel";
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Repository repository = Repository.getInstance(getApplication(), compositeDisposable);

    public LiveData<Boolean> insert(User user) {
        return repository.insert(user);
    }

    public LiveData<User> get(String username, String password) {
        return repository.getUser(username, password);
    }

    public LiveData<User> getByHashPassword(String username, String password) {
        return repository.getUserByHashPassword(username, password);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        compositeDisposable.clear();
    }
}
