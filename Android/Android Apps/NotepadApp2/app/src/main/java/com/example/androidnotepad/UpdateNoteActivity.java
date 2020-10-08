package com.example.androidnotepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.androidnotepad.RoomHelper.NotesDatabaseHelper;
import com.example.androidnotepad.RoomHelper.NotesPojo;

public class UpdateNoteActivity extends AppCompatActivity {

    EditText title_et,description_et;
    NotesPojo notesPojo;

    NotesDatabaseHelper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);
        getSupportActionBar().setTitle("Update Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        title_et = findViewById(R.id.title_et);
        description_et = findViewById(R.id.description_et);

        database_helper = new NotesDatabaseHelper(this);
        notesPojo = (NotesPojo)getIntent().getSerializableExtra("notes_table");

        setData();
    }

    private void setData(){
        title_et.setText(notesPojo.getTitle());
        description_et.setText(notesPojo.getDescription());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.update_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note_menu:
                save_note();
                break;
            case R.id.delete_menu:
                deleteNoteDialog();
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void save_note() {
        String title = title_et.getText().toString();
        String description = description_et.getText().toString();

        database_helper.updateNote(notesPojo, title, description);
    }

    private AlertDialog deleteNoteDialog(){
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Are you sure...?")
                .setMessage(notesPojo.getTitle())
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        database_helper.deleteNote(notesPojo);
                        dialog.dismiss();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
        return dialog;
    }

}