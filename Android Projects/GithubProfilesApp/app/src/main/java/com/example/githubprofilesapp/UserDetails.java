package com.example.githubprofilesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.githubprofilesapp.APIHandler.GithubAPI;
import com.example.githubprofilesapp.APIHandler.RepositoryAPI;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserDetails extends AppCompatActivity {

    TextView name,username,followers,following,bio;
    ImageView avatar;
    User user;
    private final String baseURL = "https://api.github.com/";
    ArrayList<Repository> reposList;
    RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Toast.makeText(this, "Long press any repository to open in Browser.", Toast.LENGTH_LONG).show();

        name = findViewById(R.id.nameTV);
        username = findViewById(R.id.usernameTV);
        followers = findViewById(R.id.followersTV);
        following = findViewById(R.id.followingTV);
        avatar = findViewById(R.id.avatarImageView);
        rView = findViewById(R.id.recyclerView);

        user = (User) getIntent().getSerializableExtra("UserObject");

        name.setText(user.getName());
        username.setText("@"+user.getLogin());
        followers.setText(""+user.getFollowers());
        following.setText(""+user.getFollowing());

        getRepos();
        attachAvatar();

    }

    public void attachAvatar() {
        String url = user.getAvatarUrl();
        downloadImageTask task = new downloadImageTask();
        try{
            avatar.setImageBitmap(task.execute(url).get());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static class downloadImageTask extends AsyncTask<String,Void, Bitmap> {
        // Asynchronously download the display picture
        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap downloadedImg;
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream ip = connection.getInputStream();
                downloadedImg = BitmapFactory.decodeStream(ip);
                return downloadedImg;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public void getRepos(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        RepositoryAPI myApi = retrofit.create(RepositoryAPI.class);
        Call<List<Repository>> call = myApi.getRepos(user.getLogin());
        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if(response.isSuccessful()){
                    reposList = new ArrayList<>();
                    for(Repository repo : response.body()) {
                        reposList.add(repo);
                    }

                    MyAdapter adapter = new MyAdapter(reposList,UserDetails.this);
                    rView.setHasFixedSize(true);
                    rView.setAdapter(adapter);
                    rView.setLayoutManager(new LinearLayoutManager(UserDetails.this));
                }else{
                    Toast.makeText(UserDetails.this, "Failure!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Toast.makeText(UserDetails.this, "Something went Wrong! Please Try again.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}