package com.fajarnandagusti.cataloguemoviefinal.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
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
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NowPlayingActivity extends AppCompatActivity {
    @BindView(R.id.recycler_movie)
    RecyclerView recyclerView;

    ApiService API;
    ProgressDialog loading;
    List<Movies> listMovies;
    private MovieAdapter movieAdapter;

    public final String KEY_PARCELABLE ="key_parcelable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

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

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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

        API.getNowPlayingMovie(Utility.API_KEY).enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    listMovies = response.body().getMovies();
                    recyclerView.setAdapter(new MovieAdapter(getApplicationContext(), listMovies));
                    movieAdapter.notifyDataSetChanged();

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
