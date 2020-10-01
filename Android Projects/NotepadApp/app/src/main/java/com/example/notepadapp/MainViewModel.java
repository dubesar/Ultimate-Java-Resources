package com.example.notepadapp;

import android.app.Application;

import android.util.Log;

import com.example.notepadapp.Database.AppDatabase;
import com.example.notepadapp.Database.Notes;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<Notes>> notes;

    public MainViewModel(Application application) {
        super(application);
        // use the getAll of the notesDao to initialize the notes variable
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the notes from the DataBase");
        notes = database.notesDao().getAll();
    }

    // a getter for the notes variable
    public LiveData<List<Notes>> getNotes() {
        return notes;
    }
}
