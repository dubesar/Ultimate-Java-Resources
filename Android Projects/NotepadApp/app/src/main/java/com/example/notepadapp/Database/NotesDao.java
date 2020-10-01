package com.example.notepadapp.Database;

import com.example.notepadapp.Models.NotesModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM Notes")
    LiveData<List<Notes>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Notes note);

    @Delete
    void deleteNote(Notes note);

    @Query("UPDATE Notes SET NOTE_TITLE =:noteT ,NOTE_CONTENT=:noteC WHERE NOTE_ID =:noteId")
    void updateNote(String noteT, String noteC, int noteId);
}
