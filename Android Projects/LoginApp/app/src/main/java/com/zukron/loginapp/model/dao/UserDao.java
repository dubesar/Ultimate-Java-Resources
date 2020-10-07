package com.zukron.loginapp.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.zukron.loginapp.model.User;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

/**
 * Project name is LoginApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user WHERE username = (:username) AND password = (:password)")
    Single<User> get(String username, String password);

    @Insert
    Completable insert(User user);
}
