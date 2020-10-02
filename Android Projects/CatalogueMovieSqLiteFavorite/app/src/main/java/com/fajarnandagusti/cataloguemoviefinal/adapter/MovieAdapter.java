package com.fajarnandagusti.cataloguemoviefinal.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fajarnandagusti.cataloguemoviefinal.R;
import com.fajarnandagusti.cataloguemoviefinal.activity.DetailMovieActivity;
import com.fajarnandagusti.cataloguemoviefinal.model.Movies;
import com.fajarnandagusti.cataloguemoviefinal.utils.DateFormat;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.URL;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    public final static String EXTRA_MOVIE = "movie";
    private Context context;
    private List<Movies> listMovies;

    public MovieAdapter(Context context, List<Movies> listMovies){
        this.context = context;
        this.listMovies = listMovies;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movies, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movies movies = listMovies.get(position);
        Glide.with(context)
                .load(URL+movies.getPosterPath())
                .placeholder(R.drawable.ph)
                .error(R.drawable.bg)
                .into(holder.poster);
        holder.judul.setText(movies.getTitle());
        holder.sinopsis.setText(movies.getOverview());
        holder.tanggal.setText(DateFormat.dateConverter(movies.getReleaseDate()));
        holder.popular.setText(movies.getPopularity());

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra("title", movies.getTitle());
                intent.putExtra("overview", movies.getOverview());
                intent.putExtra("poster_path", movies.getPosterPath());
                intent.putExtra("release_date", DateFormat.dateConverter(movies.getReleaseDate()));
                intent.putExtra("popularity", movies.getPopularity());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

       holder.btnShare.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("StringFormatInvalid")
           @Override
           public void onClick(View v) {
               Intent sendIntent = new Intent();
               sendIntent.setAction(Intent.ACTION_SEND);
               sendIntent.putExtra(Intent.EXTRA_TEXT,
                       context.getString(R.string.share, movies.getTitle()));
               sendIntent.setType("text/plain");
           }
       });

    }
    @Override
    public int getItemCount() {
        if (listMovies == null) return  0;
        return listMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_cv)
        ImageView poster;
        @BindView(R.id.movie_title)
        TextView judul;
        @BindView(R.id.movie_date)
        TextView tanggal;
        @BindView(R.id.movie_desc)
        TextView sinopsis;
        @BindView(R.id.popularity)
        TextView popular;
        @BindView(R.id.btn_detail)
        Button btnDetail;
        @BindView(R.id.btn_share)
        Button btnShare;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
