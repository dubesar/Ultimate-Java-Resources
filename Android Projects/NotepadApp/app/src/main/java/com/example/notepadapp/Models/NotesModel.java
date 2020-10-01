package com.example.notepadapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class NotesModel implements Parcelable {

    private static final String TAG = NotesModel.class.getSimpleName();

    private int id;
    private String mTitle;
    private String mContent;

    public NotesModel(int id, String mTitle, String mContent) {
        this.id = id;
        this.mTitle = mTitle;
        this.mContent = mContent;
    }

    public static final Parcelable.Creator<NotesModel> CREATOR = new Parcelable.Creator<NotesModel>() {
        @Override
        public NotesModel createFromParcel(Parcel in) {
            return new NotesModel(in);
        }

        @Override
        public NotesModel[] newArray(int size) {
            return new NotesModel[0];
        }
    };

    public NotesModel(Parcel in) {
        mTitle = in.readString();
        mContent = in.readString();
        id = in.readInt();
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mContent);
        parcel.writeInt(id);
    }
}
