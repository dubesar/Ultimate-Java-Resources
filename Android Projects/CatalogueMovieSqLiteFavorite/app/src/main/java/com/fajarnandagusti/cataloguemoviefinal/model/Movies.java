package com.fajarnandagusti.cataloguemoviefinal.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public class Movies implements Parcelable {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @SerializedName("popularity")
    @Expose
    private String popularity;

    public Movies( int id, String title,  String posterPath, String overview, String releaseDate, String popularity) {
        this.id = id;
        this.title = title;
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.popularity = popularity;
    }

    protected Movies(Parcel in) {

        id = in.readInt();
        title = in.readString();
        posterPath = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        popularity = in.readString();

    }

    public Movies(){

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPopularity(){
        return popularity;
    }


    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(posterPath);
        dest.writeString(overview);
        dest.writeString(releaseDate);
        dest.writeString(popularity);
    }
}
