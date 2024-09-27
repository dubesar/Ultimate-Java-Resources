package com.fajarnandagusti.filmfavoritku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

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

    String image, judul, tgl, popular, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        bindMovie();
    }

    private void bindMovie() {
        image = getIntent().getStringExtra("posterPath");
        judul = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("overview");
        tgl = getIntent().getStringExtra("release_date");
        popular = getIntent().getStringExtra("popularity");

        Glide.with(getApplicationContext())
                .load(image)
                .placeholder(R.drawable.ph)
                .error(R.drawable.bg)
                .into(detPoster);
        detJudul.setText(judul);
        detTgl.setText(tgl);
        detPopular.setText(popular);
        detDesc.setText(desc);

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
