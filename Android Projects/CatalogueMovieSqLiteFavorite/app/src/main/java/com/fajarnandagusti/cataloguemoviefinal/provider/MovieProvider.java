package com.fajarnandagusti.cataloguemoviefinal.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract;
import com.fajarnandagusti.cataloguemoviefinal.database.FavoriteHelper;

import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.CONTENT_URI;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.AUTHORITY;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public class MovieProvider extends ContentProvider {
    private static final int MOVIE = 1;
    private static final int MOVIE_ID = 2;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY, DatabaseContract.TABLE_FAVORITE, MOVIE);

        sUriMatcher.addURI(AUTHORITY, DatabaseContract.TABLE_FAVORITE+ "/#",
                MOVIE_ID);
    }

    private FavoriteHelper favoriteHelper;


    @Override
    public boolean onCreate() {
        favoriteHelper = new FavoriteHelper(getContext());
        favoriteHelper.open();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Cursor cursor;
        switch (sUriMatcher.match(uri)){
            case MOVIE:
                cursor = favoriteHelper.queryProvider();
                break;
            case MOVIE_ID:
                cursor = favoriteHelper.queryByIdProvider(uri.getLastPathSegment());
                break;
            default:
                cursor=null;
                break;
        }

        if (cursor != null){
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }


    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long added;
        switch (sUriMatcher.match(uri)){
            case MOVIE:
                added = favoriteHelper.insertProvider(contentValues);
                break;
            default:
                added = 0 ;
                break;
        }

        if (added > 0 ){
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return Uri.parse(CONTENT_URI + "/" + added);
    }

    @Override
    public int delete(@NonNull Uri uri, String s, String[] strings) {
        int deleted;
        switch (sUriMatcher.match(uri)){
            case MOVIE_ID:
                deleted = favoriteHelper.deleteProvider(uri.getLastPathSegment());
                break;
            default:
                deleted = 0;
                break;
        }

        if (deleted > 0){
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return deleted;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues contentValues, String s, String[] strings) {
        int update;
        switch (sUriMatcher.match(uri)){
            case MOVIE_ID:
                update = favoriteHelper.updateProvider(uri.getLastPathSegment(), contentValues);
                break;
            default:
                update = 0 ;
                break;
        }

        if (update > 0){
            getContext().getContentResolver().notifyChange(uri, null);

        }
        return update;
    }
}
