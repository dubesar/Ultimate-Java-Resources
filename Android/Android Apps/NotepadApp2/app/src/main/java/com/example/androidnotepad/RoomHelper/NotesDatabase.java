package com.example.androidnotepad.RoomHelper;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {NotesPojo.class}, version = 1)
public abstract class NotesDatabase extends RoomDatabase {
    public abstract NotesDAO notesDAO();
}
