package com.example.android.tones;

public class Array_Audio {
    private String mName_of_playlist;
    private int mNumber_of_Songs;
    private int mAlbum_cover;

    public int getmAlbum_cover() {
        return mAlbum_cover;
    }

    Array_Audio(String mName_of_playlist, int mNumber_of_Songs, int album_url) {
        this.mName_of_playlist = mName_of_playlist;
        this.mNumber_of_Songs = mNumber_of_Songs;
        this.mAlbum_cover = album_url;

    }

    public String getmName_of_playlist() {
        return mName_of_playlist;
    }

    public int getmNumber_of_Songs() {
        return mNumber_of_Songs;
    }
}
