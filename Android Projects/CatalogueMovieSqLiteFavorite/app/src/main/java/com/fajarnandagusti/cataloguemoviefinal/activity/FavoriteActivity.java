package com.fajarnandagusti.cataloguemoviefinal.activity;

import android.database.Cursor;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.fajarnandagusti.cataloguemoviefinal.R;
import com.fajarnandagusti.cataloguemoviefinal.adapter.FavoriteAdapter;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.CONTENT_URI;

public class FavoriteActivity extends AppCompatActivity {
    @BindView(R.id.recycler_movie)
    RecyclerView recyclerView;

    @BindView(R.id.Favorite)
    CoordinatorLayout favoriteLayout;

    private FavoriteAdapter favoriteAdapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        favoriteAdapter = new FavoriteAdapter(this);
        favoriteAdapter.setFavoriteList(cursor);
        recyclerView.setAdapter(favoriteAdapter);

        new LoadFavoriteMovie().execute();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private class LoadFavoriteMovie extends AsyncTask<Void, Void, Cursor> {
        @Override
        protected Cursor doInBackground(Void... voids) {
            return getContentResolver().query(CONTENT_URI, null, null, null, null);
        }

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected void onPostExecute(Cursor favorite){
            super.onPostExecute(favorite);

            cursor = favorite;
            favoriteAdapter.setFavoriteList(cursor);
            favoriteAdapter.notifyDataSetChanged();

            if (cursor.getCount() == 0){
                showSnackbarMessage(R.string.Empty);
            }
        }
    }

    private void showSnackbarMessage(int message) {
        Snackbar.make(favoriteLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
