package com.example.notepadapp.Database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Notes implements Parcelable {

    @ColumnInfo(name = "NOTE_TITLE")
    String nTitle;

    @ColumnInfo(name = "NOTE_CONTENT")
    String nContent;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "NOTE_ID")
    int nId;


    public Notes(String nTitle, String nContent) {
        this.nTitle = nTitle;
        this.nContent = nContent;
    }

    protected Notes(Parcel in) {
        nTitle = in.readString();
        nContent = in.readString();
        nId = in.readInt();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nTitle);
        parcel.writeString(nContent);
        parcel.writeInt(nId);
    }
}
