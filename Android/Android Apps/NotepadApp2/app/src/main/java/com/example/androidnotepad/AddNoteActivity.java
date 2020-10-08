package com.example.androidnotepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.androidnotepad.RoomHelper.NotesDatabaseHelper;

public class AddNoteActivity extends AppCompatActivity {

    EditText title_et, description_et;
    NotesDatabaseHelper database_helper;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_activty);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add New Note");

        title_et = findViewById(R.id.title_et);
        description_et = findViewById(R.id.description_et);

        database_helper = new NotesDatabaseHelper(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note_menu:
                save_note();
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void save_note(){
        String title = title_et.getText().toString();
        String description = description_et.getText().toString();

        database_helper.addNote(title,description);
    }

}