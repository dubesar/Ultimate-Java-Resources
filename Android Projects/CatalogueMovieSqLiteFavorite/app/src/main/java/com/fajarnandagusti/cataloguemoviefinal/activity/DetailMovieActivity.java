package com.fajarnandagusti.cataloguemoviefinal.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fajarnandagusti.cataloguemoviefinal.R;
import com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract;
import com.fajarnandagusti.cataloguemoviefinal.utils.Utility;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.CONTENT_URI;

public class DetailMovieActivity extends AppCompatActivity {
    @BindView(R.id.detPoster)
    ImageView detPoster;
    @BindView(R.id.detJudul)
    TextView detJudul;
    @BindView(R.id.detTgl)
    TextView detTgl;
    @BindView(R.id.detPopular)
    TextView detPopular;
    @BindView(R.id.detDesc)
    TextView detDesc;
    @BindView(R.id.fav)
    ImageView btnFav;
    @BindView(R.id.linear)
    LinearLayout linearLayout;

    String image, judul, tgl, popular, desc;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ButterKnife.bind(this);

        getParcel();
        bindMovie();
        setFavorite();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void getParcel() {
        image = getIntent().getStringExtra("poster_path");
        judul = getIntent().getStringExtra("title");
        tgl = getIntent().getStringExtra("release_date");
        popular = getIntent().getStringExtra("popularity");
        desc = getIntent().getStringExtra("overview");
    }

    private void bindMovie() {
        Glide.with(getApplicationContext())
                .load(Utility.URL+image)
                .placeholder(R.drawable.ph)
                .error(R.drawable.bg)
                .into(detPoster);

        detJudul.setText(judul);
        detTgl.setText(tgl);
        detPopular.setText(popular);
        detDesc.setText(desc);
        btnFav.setImageResource(R.drawable.ic_star_unchecked);
    }

    public void clickFav(View view){
        if (setFavorite()){
            Uri uri = Uri.parse(CONTENT_URI+"/"+id);
            getContentResolver().delete(uri, null, null);
            btnFav.setImageResource(R.drawable.ic_star_unchecked);
        }else {

            ContentValues contentValues = new ContentValues();

            contentValues.put(DatabaseContract.FavoriteColumn.POSTER, image);
            contentValues.put(DatabaseContract.FavoriteColumn.TITLE, judul);
            contentValues.put(DatabaseContract.FavoriteColumn.RELEASE, tgl);
            contentValues.put(DatabaseContract.FavoriteColumn.POPULARITY, popular);
            contentValues.put(DatabaseContract.FavoriteColumn.OVERVIEW, desc);

            getContentResolver().insert(CONTENT_URI, contentValues);
            setResult(101);

            btnFav.setImageResource(R.drawable.ic_star_checked);

            showSnackbarMessage(R.string.addto);
        }
    }

    private void showSnackbarMessage(int message) {
        Snackbar.make(linearLayout, message, Snackbar.LENGTH_SHORT).show();
    }


    private boolean setFavorite() {
        Uri uri = Uri.parse(CONTENT_URI + "");
        boolean favorite = false;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        String getTitle;

        assert cursor != null;
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getLong(0);
                getTitle = cursor.getString(1);
                if (getTitle.equals(getIntent().getStringExtra("title"))) {
                    btnFav.setImageResource(R.drawable.ic_star_checked);
                    favorite = true;
                }
            } while (cursor.moveToNext());

        }
        return favorite;
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
