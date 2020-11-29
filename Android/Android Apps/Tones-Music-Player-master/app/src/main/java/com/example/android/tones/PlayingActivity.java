package com.example.android.tones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayingActivity extends AppCompatActivity {
    private int m = 0, current_postion;
    private String url;
    private ArrayList<Audio> list_songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);
        final TextView artist = findViewById(R.id.artist_name_playing);
        final TextView songName = findViewById(R.id.song_name);
        final TextView duration = findViewById(R.id.duration);
        ImageButton back = findViewById(R.id.back_to_list);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        artist.setText(bundle.getString("artist"));
        songName.setText(bundle.getString("name"));
        duration.setText(bundle.getString("duration"));
        list_songs = bundle.getParcelableArrayList("list");
        current_postion = Integer.parseInt(bundle.getString("position"));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        final ImageView center_image = findViewById(R.id.center_image);
        final ImageView pause_play = findViewById(R.id.play_pause_btn);
        pause_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m == 1) {
                    pause_play.setImageResource(R.drawable.pause_image);
                    m = 0;
                } else if (m == 0) {
                    pause_play.setImageResource(R.drawable.play);
                    m = 1;
                }
            }
        });
        url = bundle.getString("url");
        center_image.setImageResource(Integer.parseInt(url));

        ImageView next = findViewById(R.id.btn_next);
        ImageView previous = findViewById(R.id.btn_previous);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_postion == list_songs.size() - 1) {
                    Toast.makeText(PlayingActivity.this, "Last Item in List", Toast.LENGTH_SHORT).show();
                } else {
                    current_postion += 1;
                    artist.setText(list_songs.get(current_postion).getmArtist());
                    songName.setText(list_songs.get(current_postion).getmSong_name());
                    duration.setText(list_songs.get(current_postion).getmDuration());
                    url = list_songs.get(current_postion).getAlbum_image() + "";
                    center_image.setImageResource(Integer.parseInt(url));
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_postion == 0) {
                    Toast.makeText(getApplicationContext(), "First item in List", Toast.LENGTH_SHORT).show();
                } else {
                    current_postion -= 1;
                    artist.setText(list_songs.get(current_postion).getmArtist());
                    songName.setText(list_songs.get(current_postion).getmSong_name());
                    duration.setText(list_songs.get(current_postion).getmDuration());
                    url = list_songs.get(current_postion).getAlbum_image() + "";
                    center_image.setImageResource(Integer.parseInt(url));
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
