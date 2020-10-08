package com.zukron.newsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.zukron.newsapp.R;
import com.zukron.newsapp.adapter.NewsAdapter;
import com.zukron.newsapp.adapter.OnSelectedNewsListener;
import com.zukron.newsapp.ui.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements OnSelectedNewsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view model
        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // adapter
        NewsAdapter newsAdapter = new NewsAdapter();
        newsAdapter.setOnSelectedNewsListener(this);
        RecyclerView recyclerView = findViewById(R.id.mainAct_recyclerView);
        recyclerView.setAdapter(newsAdapter);

        mainViewModel.getAllNews().observe(this, newsAdapter::submitList);
    }

    @Override
    public void onSelectedNews(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(url);
        intent.setData(uri);

        startActivity(intent);
    }
}