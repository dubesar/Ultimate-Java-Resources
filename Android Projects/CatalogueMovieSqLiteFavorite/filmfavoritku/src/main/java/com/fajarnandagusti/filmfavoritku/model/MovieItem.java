package com.fajarnandagusti.filmfavoritku.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import static android.provider.BaseColumns._ID;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.OVERVIEW;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.POPULARITY;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.POSTER;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.RELEASE;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.TITLE;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.getColumnInt;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.getColumnString;

/**
 * Created by Gustiawan on 11/17/2018.
 */

public class MovieItem implements Parcelable {
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

    protected MovieItem(Parcel in) {
        id = in.readInt();
        posterPath = in.readString();
        title = in.readString();
        releaseDate = in.readString();
        popularity = in.readString();
        overview = in.readString();
    }

    public MovieItem(Cursor cursor){
        this.id = getColumnInt(cursor, _ID);
        this.posterPath = getColumnString(cursor, POSTER);
        this.title = getColumnString(cursor, TITLE);
        this.overview = getColumnString(cursor, OVERVIEW);
        this.releaseDate = getColumnString(cursor, RELEASE);
        this.popularity = getColumnString(cursor, POPULARITY);
    }

    public MovieItem() {

    }

    public static final Parcelable.Creator<MovieItem> CREATOR = new Parcelable.Creator<MovieItem>() {
        @Override
        public MovieItem createFromParcel(Parcel in) {
            return new MovieItem(in);
        }

        @Override
        public MovieItem[] newArray(int size) {
            return new MovieItem[size];
        }
    };

}
