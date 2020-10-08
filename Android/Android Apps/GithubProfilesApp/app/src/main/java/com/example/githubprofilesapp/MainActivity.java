package com.example.githubprofilesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.githubprofilesapp.APIHandler.GithubAPI;

import java.net.UnknownServiceException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String baseURL = "https://api.github.com/";
    Button loginBtn;
    EditText usernameField;
    Intent i;
    String username;
    String name,email,avatar_url, followers,following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        usernameField = findViewById(R.id.usernameTextField);

    }

    public void login(View view){
        Log.i("Login success",usernameField.getText().toString());
        username = usernameField.getText().toString();
        try {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadUserData();
    }

    public void loadUserData(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        GithubAPI myApi = retrofit.create(GithubAPI.class);
        Call<User> call = myApi.getUser(username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i("status","started onResponse");
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Invalid Username!", Toast.LENGTH_SHORT).show();
                    Log.i("error!",""+response.code());
                }else {
                    User obj = response.body();
                    Log.i("avatar url" ,""+response.body().getAvatarUrl());
                    jumpToNextActivity(obj);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i("Failure!",t.getMessage());
                Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void jumpToNextActivity(User user){
        i = new Intent(this,UserDetails.class);
        i.putExtra("UserObject",user);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(i);
        }

    }
}