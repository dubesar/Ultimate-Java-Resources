package com.example.androidnotepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.androidnotepad.Adapter.NotesAdapter;
import com.example.androidnotepad.RoomHelper.NotesDatabaseHelper;

public class DashboardActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    RecyclerView recycler_view;
    NotesDatabaseHelper database_helper;

    SwipeRefreshLayout swipe_refresh_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recycler_view = findViewById(R.id.recycler_view);
        swipe_refresh_layout = findViewById(R.id.swipe_refresh_layout);
        swipe_refresh_layout.setOnRefreshListener(this);

        database_helper = new NotesDatabaseHelper(this);

        setRecyclerView();
    }

    private void setRecyclerView(){
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new GridLayoutManager(this, 2));
        database_helper.getAllNotes(recycler_view);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dash_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_note:
                Intent add_note_intent = new Intent(DashboardActivity.this, AddNoteActivity.class);
                startActivity(add_note_intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        setRecyclerView();
        swipe_refresh_layout.setRefreshing(false);
    }
}