package com.example.notepadapp.UI;

import android.content.Intent;
import android.os.Bundle;

import com.example.notepadapp.Adapters.NotesAdapter;
import com.example.notepadapp.AppExecutors;
import com.example.notepadapp.Database.AppDatabase;
import com.example.notepadapp.Database.Notes;
import com.example.notepadapp.MainViewModel;
import com.example.notepadapp.Models.NotesModel;
import com.example.notepadapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NotesAdapter.ListItemClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private NotesAdapter mNotesAdapter;

    private ArrayList<Notes> mNotes = new ArrayList<>();

    //DB object
    private AppDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , AddActivity.class);
                startActivity(intent);
            }
        });

        //DB initialization
        mDB = AppDatabase.getInstance(getApplicationContext());

        RecyclerView mNRecyclerView = findViewById(R.id.note_recycler_view);

        //setting the notes recycler view
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mNRecyclerView.setLayoutManager(mLayoutManager);
        mNRecyclerView.setHasFixedSize(true);
        mNotesAdapter = new NotesAdapter(mNotes,this);
        mNRecyclerView.setAdapter(mNotesAdapter);
        
        //
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            // Called when a user swipes left or right on a ViewHolder
            @Override
            public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                // call the diskIO execute method with a new Runnable and implement its run method
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        // get the position from the viewHolder parameter
                        int position = viewHolder.getAdapterPosition();
                        List<Notes> notes = mNotesAdapter.getNotes();
                        //Call deleteTask in the taskDao with the task at that position
                        mDB.notesDao().deleteNote(notes.get(position));
                    }
                });
            }
        }).attachToRecyclerView(mNRecyclerView);

        setupViewModel();
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        //send the clicked movie info to DetailsActivity using Parcelable
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("notes", mNotesAdapter.getNotes().get(clickedItemIndex));
        startActivity(intent);
    }

    private void setupViewModel() {
        // Declare a ViewModel variable and initialize it by calling ViewModelProviders.of
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // Observe the LiveData object in the ViewModel
        viewModel.getNotes().observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged( List<Notes> notes) {
                Log.d(TAG, "Updating list of notes from LiveData in ViewModel");
                mNotesAdapter.setmNotes(notes);
            }
        });
    }
}