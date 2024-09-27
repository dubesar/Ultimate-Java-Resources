package com.fajarnandagusti.cataloguemoviefinal.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import com.fajarnandagusti.cataloguemoviefinal.model.Favorite;
import com.fajarnandagusti.cataloguemoviefinal.utils.DateFormat;
import com.fajarnandagusti.cataloguemoviefinal.utils.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gustiawan on 11/17/2018.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder>{
    private Context context;
    private Cursor listFavorite;

    public FavoriteAdapter(Context context){
        this.context = context;
    }

    public void setFavoriteList(Cursor listFavorite){
        this.listFavorite = listFavorite;
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movies, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Favorite favorite = getItem(position);

        Glide.with(context)
                .load(Utility.URL+favorite.getPosterPath())
                .placeholder(R.drawable.ph)
                .error(R.drawable.bg)
                .into(holder.poster);
        holder.judul.setText(favorite.getTitle());
        holder.tanggal.setText(DateFormat.dateConverter(favorite.getReleaseDate()));
        holder.popular.setText(favorite.getPopularity());
        holder.sinopsis.setText(favorite.getOverview());

        holder.btnDetail.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra("title", favorite.getTitle());
                intent.putExtra("overview", favorite.getOverview());
                intent.putExtra("poster_path", favorite.getPosterPath());
                intent.putExtra("release_date", favorite.getReleaseDate());
                intent.putExtra("popularity", favorite.getPopularity());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"StringFormatInvalid", "ResourceType"})
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT,
                        context.getString(R.string.share, favorite.getTitle()));
                i.setType("text/plain");
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listFavorite == null) return 0;
        return listFavorite.getCount();
    }

    private Favorite getItem(int position){
        if (!listFavorite.moveToPosition(position)) {
            throw new IllegalStateException("Position invalid");
        }
        return new Favorite(listFavorite);
    }
}
