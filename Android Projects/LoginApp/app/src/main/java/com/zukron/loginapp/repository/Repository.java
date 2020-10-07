package com.zukron.loginapp.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.zukron.loginapp.database.MyDatabase;
import com.zukron.loginapp.model.User;
import com.zukron.loginapp.tools.Utility;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Project name is LoginApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public class Repository {
    private static final String TAG = "Repository";
    private static Repository repository = null;
    private static MyDatabase.AppDatabase appDatabase;
    private static CompositeDisposable compositeDisposable;

    public static Repository getInstance(Context context, CompositeDisposable compositeDisposable) {
        if (repository == null) {
            Repository.appDatabase = MyDatabase.getInstance(context);
            Repository.compositeDisposable = compositeDisposable;
            Repository.repository = new Repository();
        }

        return repository;
    }

    public LiveData<Boolean> insert(User user) {
        return new LiveData<Boolean>() {
            @Override
            protected void onActive() {
                super.onActive();

                // md5 hash
                String password = user.getPassword();
                user.setPassword(Utility.md5Hashing(password));

                compositeDisposable.add(appDatabase.userDao().insert(user)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                () -> setValue(true),
                                error -> Log.e(TAG, "onActive: ", error)
                        ));
            }
        };
    }

    public LiveData<User> getUser(String username, String password) {
        return new LiveData<User>() {
            @Override
            protected void onActive() {
                super.onActive();

                // md5 hash
                String passwordHash = Utility.md5Hashing(password);

                compositeDisposable.add(appDatabase.userDao().get(username, passwordHash)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::setValue,
                                error -> setValue(null)
                        )
                );

            }
        };
    }

    public LiveData<User> getUserByHashPassword(String username, String password) {
        return new LiveData<User>() {
            @Override
            protected void onActive() {
                super.onActive();

                compositeDisposable.add(appDatabase.userDao().get(username, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                this::setValue,
                                error -> setValue(null)
                        )
                );

            }
        };
    }
}
