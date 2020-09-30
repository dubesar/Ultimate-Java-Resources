package com.example.githubprofilesapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<Repository> reposList;
    Context ct;
    public MyAdapter(ArrayList<Repository> list,Context context) {
        this.reposList = list;
        this.ct = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_card,parent,false);
        ViewHolder holder = new MyAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.repositoryName.setText(reposList.get(position).getName());
        String updated = reposList.get(position).getUpdatedAt();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            long time = sdf.parse(updated).getTime();
            long now = System.currentTimeMillis();
            CharSequence ago =
                    DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS);
            holder.lastUpdated.setText("Last Updated : "+ago);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String link = reposList.get(position).getHtmlUrl();
                Uri uri = Uri.parse(link);
                Intent openInBrowser = new Intent(Intent.ACTION_VIEW,uri);
                ct.startActivity(openInBrowser);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return reposList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView repositoryName,lastUpdated;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            repositoryName = itemView.findViewById(R.id.repoNameTV);
            lastUpdated = itemView.findViewById(R.id.updatedTV);
        }
    }
}
