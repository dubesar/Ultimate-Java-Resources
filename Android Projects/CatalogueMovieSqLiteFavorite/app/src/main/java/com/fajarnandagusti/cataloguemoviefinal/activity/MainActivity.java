package com.fajarnandagusti.cataloguemoviefinal.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;

import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.fajarnandagusti.cataloguemoviefinal.R;
import com.fajarnandagusti.cataloguemoviefinal.adapter.MovieAdapter;
import com.fajarnandagusti.cataloguemoviefinal.api.ApiService;
import com.fajarnandagusti.cataloguemoviefinal.api.Server;
import com.fajarnandagusti.cataloguemoviefinal.model.Movies;
import com.fajarnandagusti.cataloguemoviefinal.model.ResponseMovie;
import com.fajarnandagusti.cataloguemoviefinal.utils.Utility;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.recycler_movie)
    RecyclerView recyclerView;

    ApiService API;
    ProgressDialog loading;
    List<Movies> listMovies;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        API = Server.getAPIService();

        preload();

        if (savedInstanceState == null) {
            load();
        }else{
            listMovies = savedInstanceState.getParcelableArrayList(Utility.KEY_PARCELABLE);
            movieAdapter = new MovieAdapter(getApplicationContext(), listMovies);
            recyclerView.setAdapter(movieAdapter);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(Utility.KEY_PARCELABLE, new ArrayList<>(listMovies));
        super.onSaveInstanceState(outState);
    }

    private void preload() {
        movieAdapter = new MovieAdapter(getApplicationContext(), listMovies);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(movieAdapter);
    }

    private void load() {
        loading = ProgressDialog.show(this, null, "Loading...", true, false);

        API.getAllMovies(Utility.API_KEY).enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    listMovies = response.body().getMovies();
                    recyclerView.setAdapter(new MovieAdapter(getApplicationContext(), listMovies));

                    movieAdapter.notifyDataSetChanged(); //ini penting, kalau gak ada, data gak tampil

                }else {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setQueryHint(getResources().getString(R.string.search));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                cariFilm(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    load();
                }
                return false;
            }
        });

        return true;
    }

    private void cariFilm(String query) {
        API.getSearchMovie(Utility.API_KEY, Utility.LANGUAGE, query, Utility.page, Utility.include_adult)
                .enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                if (response.isSuccessful()){
                    listMovies = response.body().getMovies();
                    recyclerView.setAdapter(new MovieAdapter(getApplicationContext(), listMovies));
                    movieAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Toast.makeText(getApplicationContext(), getString(R.string.internet), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent setting = new Intent(getApplicationContext(), SettingActivity.class);
            startActivity(setting);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.now_playing) {
            Intent now = new Intent(getApplicationContext(), NowPlayingActivity.class);
            startActivity(now);
            Toast.makeText(getApplicationContext(), "Show Now Playing Movies", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.upcoming) {
            Intent up = new Intent(getApplicationContext(), UpcomingActivity.class);
            startActivity(up);
            Toast.makeText(getApplicationContext(), "Show Upcoming Movies", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.favorite) {
            Intent fav = new Intent(getApplicationContext(), FavoriteActivity.class);
            startActivity(fav);
            Toast.makeText(getApplicationContext(), "Show Favorite Movies", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
