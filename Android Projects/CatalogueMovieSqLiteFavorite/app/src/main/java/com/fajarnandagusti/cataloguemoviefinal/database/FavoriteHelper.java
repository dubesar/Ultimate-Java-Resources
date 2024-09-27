package com.fajarnandagusti.cataloguemoviefinal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.fajarnandagusti.cataloguemoviefinal.model.Favorite;

import java.util.ArrayList;

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

public class FavoriteHelper {
    private static String DATABASE_TABLE = TABLE_FAVORITE;
    private Context context;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;


    public FavoriteHelper(Context context){
        this.context = context;
    }

    public FavoriteHelper open() throws SQLException {
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        databaseHelper.close();
    }

    public ArrayList<Favorite> getAllData(){
        ArrayList<Favorite> arrayList = new ArrayList<>();
        Cursor cursor = database.query(DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                _ID +" ASC",
                null);
        cursor.moveToFirst();
        Favorite favorite;

        if (cursor.getCount()>0) {
            do{
                favorite = new Favorite();
                favorite.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                favorite.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                favorite.setPosterPath(cursor.getString(cursor.getColumnIndexOrThrow(POSTER)));
                favorite.setOverview(cursor.getString(cursor.getColumnIndexOrThrow(OVERVIEW)));
                favorite.setReleaseDate(cursor.getString(cursor.getColumnIndexOrThrow(RELEASE)));
                favorite.setPopularity(cursor.getString(cursor.getColumnIndexOrThrow(POPULARITY)));

                arrayList.add(favorite);
                cursor.moveToNext();

            }while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insert(Favorite favorite){
        ContentValues initialValues = new ContentValues();
        initialValues.put(POSTER, favorite.getPosterPath());
        initialValues.put(TITLE, favorite.getTitle());
        initialValues.put(OVERVIEW, favorite.getOverview());
        initialValues.put(RELEASE, favorite.getReleaseDate());
        initialValues.put(POPULARITY, favorite.getPopularity());
        return database.insert(DATABASE_TABLE, null, initialValues);
    }

    public int update(Favorite favorite){
        ContentValues args = new ContentValues();
        args.put(POSTER, favorite.getPosterPath());
        args.put(TITLE, favorite.getTitle());
        args.put(OVERVIEW, favorite.getOverview());
        args.put(RELEASE, favorite.getReleaseDate());
        args.put(POPULARITY, favorite.getPopularity());
        return database.update(DATABASE_TABLE, args, _ID + "= '"+ favorite.getId() + "'", null);
    }

    public int delete(int id){
        return database.delete(DATABASE_TABLE, _ID + " = '" +id+ "'", null);
    }



    public Cursor queryProvider(){
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                _ID + " DESC"
        );
    }

    public Cursor queryByIdProvider(String id){
        return database.query(DATABASE_TABLE
                ,null
                , _ID + " = ?"
                ,new String[]{id}
                ,null
                ,null
                ,null
                ,null);
    }

    public long insertProvider (ContentValues values){
        return  database.insert(DATABASE_TABLE, null, values);
    }

    public int updateProvider (String id, ContentValues values){
        return database.update(DATABASE_TABLE, values, _ID +" = ?", new String[]{id});
    }

    public int deleteProvider (String id){
        return database.delete(DATABASE_TABLE, _ID + " = ?", new String[]{id});
    }
}
