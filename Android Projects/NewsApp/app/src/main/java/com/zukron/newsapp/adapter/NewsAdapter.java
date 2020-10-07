package com.zukron.newsapp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.zukron.newsapp.R;
import com.zukron.newsapp.model.NewsResponse;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.Objects;

/**
 * Project name is NewsApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
public class NewsAdapter extends PagedListAdapter<NewsResponse.NewsResponseArticles, NewsAdapter.NewsViewHolder> {
    public NewsAdapter() {
        super(new NewsDiffUtil());
    }

    private OnSelectedNewsListener onSelectedNewsListener;

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bindTo(Objects.requireNonNull(getItem(position)));
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{
        private ShapeableImageView imageView;
        private TextView tvSource, tvTitle, tvAuthorAndPublishedAt, tvDescription;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.newsItem_imageView);
            tvSource = itemView.findViewById(R.id.newsItem_tvSource);
            tvTitle = itemView.findViewById(R.id.newsItem_tvTitle);
            tvAuthorAndPublishedAt = itemView.findViewById(R.id.newsItem_tvAuthorAndPublishedAt);
            tvDescription = itemView.findViewById(R.id.newsItem_tvDescription);
        }

        public void bindTo(NewsResponse.NewsResponseArticles item) {
            Glide.with(itemView.getContext())
                    .load(item.getUrlToImage())
                    .placeholder(R.drawable.no_image)
                    .into(imageView);

            // parsing date and time string into object
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            LocalDateTime localDateTime = LocalDateTime.parse(item.getPublishedAt(), dateTimeFormatter);

            // format into date
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            String date = localDateTime.format(dateFormatter);

            // format into time
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            String time = localDateTime.format(timeFormatter);

            String authorAndPublishedAt = item.getAuthor() + ", at " + date + " " + time;
            tvSource.setText(item.getSource().getName());
            tvTitle.setText(item.getTitle());
            tvAuthorAndPublishedAt.setText(authorAndPublishedAt);
            tvDescription.setText(item.getDescription());

            itemView.setOnClickListener(view -> onSelectedNewsListener.onSelectedNews(item.getUrl()));
        }
    }

    private static class NewsDiffUtil extends DiffUtil.ItemCallback<NewsResponse.NewsResponseArticles> {
        @Override
        public boolean areItemsTheSame(@NonNull NewsResponse.NewsResponseArticles oldItem, @NonNull NewsResponse.NewsResponseArticles newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull NewsResponse.NewsResponseArticles oldItem, @NonNull NewsResponse.NewsResponseArticles newItem) {
            return oldItem == newItem;
        }
    }

    public void setOnSelectedNewsListener(OnSelectedNewsListener onSelectedNewsListener) {
        this.onSelectedNewsListener = onSelectedNewsListener;
    }
}
