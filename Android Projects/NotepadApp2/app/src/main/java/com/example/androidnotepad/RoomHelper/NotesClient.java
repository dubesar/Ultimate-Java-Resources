package com.example.androidnotepad.RoomHelper;

import android.content.Context;

import androidx.room.Room;

public class NotesClient {

    Context context;
    private static NotesClient instance;

    private NotesDatabase notesDatabase;

    public NotesClient(Context context){
        this.context = context;

        notesDatabase = Room.databaseBuilder(context, NotesDatabase.class, "NotepadAppDatabase").build();
    }

    public static synchronized NotesClient getInstance(Context context){
        if (instance ==null){
            instance = new NotesClient(context);
        }
        return instance;
    }

    public NotesDatabase getNotesDatabase(){
        return notesDatabase;
    }
}
