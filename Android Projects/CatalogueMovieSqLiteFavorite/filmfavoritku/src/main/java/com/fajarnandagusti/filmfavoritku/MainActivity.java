package com.fajarnandagusti.filmfavoritku;

import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.fajarnandagusti.filmfavoritku.adapter.MovieAdapter;

import java.util.Objects;

import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.CONTENT_URI;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    private MovieAdapter adapterFavorite;
    ListView lvMovies;
    private final int LOAD_FAV_ID = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Your Favorite Movies");

        lvMovies = findViewById(R.id.lv_movies);
        adapterFavorite = new MovieAdapter(this, null, true);
        lvMovies.setAdapter(adapterFavorite);

        getSupportLoaderManager().initLoader(LOAD_FAV_ID, null, this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().restartLoader(LOAD_FAV_ID, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, CONTENT_URI, null,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapterFavorite.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapterFavorite.swapCursor(null);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getSupportLoaderManager().destroyLoader(LOAD_FAV_ID);
    }
}
