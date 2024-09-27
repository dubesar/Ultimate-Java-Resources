package com.fajarnandagusti.cataloguemoviefinal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.OVERVIEW;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.POPULARITY;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.POSTER;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.RELEASE;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.TITLE;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.TABLE_FAVORITE;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "dbmoviefav";
    private static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE_FAV = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            TABLE_FAVORITE,
            _ID,
            TITLE,
            POSTER,
            RELEASE,
            POPULARITY,
            OVERVIEW

    );

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FAV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_FAVORITE);
        onCreate(db);
    }

}
