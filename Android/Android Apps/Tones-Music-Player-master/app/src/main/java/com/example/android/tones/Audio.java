package com.example.android.tones;

import android.os.Parcel;
import android.os.Parcelable;

public class Audio implements Parcelable{

    private String mSong_name;
    private String mArtist;
    private String mDuration;
    private int album_image;

    Audio(String mSong_name, String mArtist, String mDuration, int mImage) {
        this.mSong_name = mSong_name;
        this.mArtist = mArtist;
        this.mDuration = mDuration;
        this.album_image = mImage;
    }

    private Audio(Parcel in) {
        mSong_name = in.readString();
        mArtist = in.readString();
        mDuration = in.readString();
        album_image = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSong_name);
        dest.writeString(mArtist);
        dest.writeString(mDuration);
        dest.writeInt(album_image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Audio> CREATOR = new Creator<Audio>() {
        @Override
        public Audio createFromParcel(Parcel in) {
            return new Audio(in);
        }

        @Override
        public Audio[] newArray(int size) {
            return new Audio[size];
        }
    };

    public String getmDuration() {
        return mDuration;
    }

    public int getAlbum_image() {

        return album_image;
    }

    public String getmSong_name() {
        return mSong_name;
    }

    public String getmArtist() {
        return mArtist;
    }
}
