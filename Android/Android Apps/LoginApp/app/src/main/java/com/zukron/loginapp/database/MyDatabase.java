package com.zukron.loginapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.zukron.loginapp.model.User;
import com.zukron.loginapp.model.dao.UserDao;

/**
 * Project name is LoginApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public class MyDatabase {
    private static final String DB_NAME = "login-database";
    private static AppDatabase appDatabase = null;

    @Database(entities = {User.class}, version = 1)
    public abstract static class AppDatabase extends RoomDatabase {
        public abstract UserDao userDao();
    }

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
        }

        return appDatabase;
    }
}
