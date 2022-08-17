package com.fajarnandagusti.cataloguemoviefinal.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import static android.provider.BaseColumns._ID;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.OVERVIEW;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.POPULARITY;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.POSTER;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.RELEASE;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.TITLE;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.getColumnInt;
import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.getColumnString;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public class Favorite implements Parcelable {
    private int id;
    private String posterPath;
    private String title;
    private String releaseDate;
    private String popularity;
    private String overview;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(posterPath);
        dest.writeString(title);
        dest.writeString(releaseDate);
        dest.writeString(popularity);
        dest.writeString(overview);
    }

    protected Favorite(Parcel in) {
        id = in.readInt();
        posterPath = in.readString();
        title = in.readString();
        releaseDate = in.readString();
        popularity = in.readString();
        overview = in.readString();
    }

    public Favorite(Cursor cursor){
        this.id = getColumnInt(cursor, _ID);
        this.posterPath = getColumnString(cursor, POSTER);
        this.title = getColumnString(cursor, TITLE);
        this.overview = getColumnString(cursor, OVERVIEW);
        this.releaseDate = getColumnString(cursor, RELEASE);
        this.popularity = getColumnString(cursor, POPULARITY);
    }

    public Favorite() {

    }

    public static final Creator<Favorite> CREATOR = new Creator<Favorite>() {
        @Override
        public Favorite createFromParcel(Parcel in) {
            return new Favorite(in);
        }

        @Override
        public Favorite[] newArray(int size) {
            return new Favorite[size];
        }
    };

}
