package com.fajarnandagusti.cataloguemoviefinal.database;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import com.fajarnandagusti.cataloguemoviefinal.utils.Utility;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public class DatabaseContract {
    public static String TABLE_FAVORITE = "favorite";

    public static final class FavoriteColumn implements BaseColumns {
        public static String POSTER = "posterPath";
        public static String TITLE = "title";
        public static String RELEASE = "releaseDate";
        public static String POPULARITY = "popularity";
        public static String OVERVIEW = "overview";

        public static final Uri CONTENT_URI = new Uri.Builder()
                .scheme(Utility.SCHEME)
                .authority(Utility.AUTHORITY)
                .appendPath(TABLE_FAVORITE)
                .build();
    }

    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString( cursor.getColumnIndex(columnName) );
    }

    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt( cursor.getColumnIndex(columnName) );
    }
}
