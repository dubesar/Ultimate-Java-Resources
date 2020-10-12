package com.example.dictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    TextView textViewResults;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSupportActionBar(toolbar);
        }
        searchView = findViewById(R.id.search_view);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setIconified(false);


               // findSearch(String.valueOf(searchView.getQuery()));
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                findSearch(String.valueOf(searchView.getQuery()));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                textViewResults.setText("Click Search after you finish entering the text");
                return true;
            }
        });


        textViewResults = findViewById(R.id.text_view_result);

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.dictionaryapi.dev/api/v2/entries/en/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        apiInterface = retrofit.create(ApiInterface.class);

    }

    public void findSearch(String word){
        textViewResults.setText("Searching .....");
        Call<List<WordPOJO>> call = apiInterface.getWords(word);
        call.enqueue(new Callback<List<WordPOJO>>() {
            @Override
            public void onResponse(Call<List<WordPOJO>> call, Response<List<WordPOJO>> response) {
                if(!response.isSuccessful()) {
                    textViewResults.setText("Sorry Cant find the Word!!");
                    return;
                }

                List<WordPOJO> wordPOJOs = response.body();
                for(WordPOJO wordPOJO : wordPOJOs) {
                    String content = "" ;
                    content += "Word: "+ wordPOJO.getWord() + "\n";
                   content+= "Meaning : " + wordPOJO.getMeanings().get(0).getDefinitions().get(0).getDefinition() + "\n";
                    textViewResults.setText(content);
                }

            }

            @Override
            public void onFailure(Call<List<WordPOJO>> call, Throwable t) {
                textViewResults.setText(t.getMessage());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.actions_exit){
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}