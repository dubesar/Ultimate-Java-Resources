package com.example.notepadapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.notepadapp.AppExecutors;
import com.example.notepadapp.Database.AppDatabase;
import com.example.notepadapp.Database.Notes;
import com.example.notepadapp.R;

public class AddActivity extends AppCompatActivity {
    //Constant for logging
    private static final String TAG = AddActivity.class.getSimpleName();

    //DB object
    private AppDatabase mDB;

    //Views
    EditText mNTitleEditText;
    EditText mNContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //DB initialization
        mDB = AppDatabase.getInstance(getApplicationContext());

        //Views
        mNTitleEditText = findViewById(R.id.a_note_title);
        mNContentTextView = findViewById(R.id.a_note_content);
    }

    private void saveNote() {
        //get the data entered by the user
        String nTitle = mNTitleEditText.getText().toString().trim();
        String nContent = mNContentTextView.getText().toString().trim();

        final Notes note = new Notes(nTitle, nContent);

        //add the data to the DB
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDB.notesDao().insertNote(note);
                Log.d(TAG, "saveNote: note inserted ");
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            saveNote();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}