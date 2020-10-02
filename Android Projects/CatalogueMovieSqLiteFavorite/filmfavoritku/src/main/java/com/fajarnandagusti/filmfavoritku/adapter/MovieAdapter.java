package com.fajarnandagusti.filmfavoritku.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fajarnandagusti.filmfavoritku.DetailActivity;
import com.fajarnandagusti.filmfavoritku.R;

import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.OVERVIEW;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.POPULARITY;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.POSTER;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.RELEASE;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.FavoriteColumn.TITLE;
import static com.fajarnandagusti.filmfavoritku.db.DatabaseContract.getColumnString;

/**
 * Created by Gustiawan on 11/17/2018.
 */

public class MovieAdapter extends CursorAdapter {
    public MovieAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_favorite, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        if(cursor != null){
            TextView tvJudul, tvTgl, tvDesc, tvPopular;
            ImageView poster;
            Button btnDetail;

            final String loadPoster = "http://image.tmdb.org/t/p/w500" + getColumnString(cursor, POSTER);

            tvJudul = view.findViewById(R.id.movie_title);
            tvDesc = view.findViewById(R.id.movie_desc);
            tvPopular = view.findViewById(R.id.popularity);
            tvTgl = view.findViewById(R.id.movie_date);
            poster = view.findViewById(R.id.img_cv);
            btnDetail = view.findViewById(R.id.btn_detail);

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DetailActivity.class);
                    i.putExtra("title", getColumnString(cursor, TITLE));
                    i.putExtra("overview",getColumnString(cursor, OVERVIEW) );
                    i.putExtra("posterPath", loadPoster);
                    i.putExtra("release_date", getColumnString(cursor, RELEASE));
                    i.putExtra("popularity", getColumnString(cursor, POPULARITY));
                    context.startActivity(i);

                }
            });

            tvDesc.setText(getColumnString(cursor, OVERVIEW));
            tvJudul.setText(getColumnString(cursor, TITLE));
            tvPopular.setText(getColumnString(cursor, POPULARITY));
            tvTgl.setText(getColumnString(cursor, RELEASE));

            Glide.with(context).load(loadPoster)
                    .placeholder(R.drawable.ph)
                    .error(R.drawable.bg)
                    .into(poster);
        }

    }
}
