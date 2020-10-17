package com.example.android.tones;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListOfSongsinAlbumsActivity extends AppCompatActivity {
    private ArrayList<Audio> audio = new ArrayList<>();

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_list);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        TextView label = findViewById(R.id.list_name);
        label.setText(getString(R.string.album_songs));
        String url = bundle.getString("image");
        String name = bundle.getString("name");
        int position = Integer.parseInt(bundle.getString("position"));
        ImageView cover = findViewById(R.id.cover_image);
        TextView name_of_list = findViewById(R.id.name_of_list);
        FloatingActionButton floatingActionButton = findViewById(R.id.play_start);
        ListView listView = findViewById(R.id.album_list_view);
        cover.setImageResource(Integer.parseInt(url));
        name_of_list.setText(name);
        if (position == 0) {
            AddData_condition0();
        } else if (position == 1) {
            AddData_condition1();
        } else if (position == 2) {
            AddData_condition2();
        } else if (position == 3) {
            AddData_condition3();
        } else if (position == 4) {
            AddData_condition4();
        } else if (position == 5) {
            AddData_condition5();
        } else if (position == 6) {
            AddData_condition6();
        } else if (position == 7) {
            AddData_condition7();
        } else if (position == 8) {
            AddData_condition8();
        } else if (position == 9) {
            AddData_condition9();
        } else if (position == 10) {
            AddData_condition10();
        } else {
            AddDat_condition11();
        }
        AudioAdapter audioAdapter = new AudioAdapter(this, audio);
        ImageButton imageButton = findViewById(R.id.back_to_array);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        listView.setAdapter(audioAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String song_name = audio.get(position).getmSong_name();
                String artist = audio.get(position).getmArtist();
                String duration = audio.get(position).getmDuration();
                Intent intent = new Intent(ListOfSongsinAlbumsActivity.this, PlayingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", song_name);
                bundle.putString("artist", artist);
                bundle.putString("duration", duration);
                String url = audio.get(position).getAlbum_image() + "";
                bundle.putString("url", url);
                bundle.putParcelableArrayList("list", audio);
                String position_of_item = "" + position;
                bundle.putString("position", position_of_item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String song_name = audio.get(0).getmSong_name();
                String artist = audio.get(0).getmArtist();
                String duration = audio.get(0).getmDuration();
                Intent intent = new Intent(ListOfSongsinAlbumsActivity.this, PlayingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", song_name);
                bundle.putString("artist", artist);
                bundle.putString("duration", duration);
                String url = audio.get(0).getAlbum_image() + "";
                bundle.putString("url", url);
                bundle.putParcelableArrayList("list", audio);
                String position_of_item = "" + 0;
                bundle.putString("position", position_of_item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void AddDat_condition11() {
        audio.add(new Audio("Wolves", "Selena Gomez", "3:17", R.drawable.wolves_original));
    }

    private void AddData_condition10() {
        audio.add(new Audio("Tareefan", "Badshah", "3:04", R.drawable.tareefan_original));
    }

    private void AddData_condition9() {
        audio.add(new Audio("Strip That Down", "Liam Payne", "3:24", R.drawable.strip_down_original));
    }

    private void AddData_condition8() {
        audio.add(new Audio("Mine", "Bazzi", "2:14", R.drawable.mine_original));
    }

    private void AddData_condition7() {
        audio.add(new Audio("Love Me Again", "John Newman", "3:54", R.drawable.love_me_again_2));
    }

    private void AddData_condition6() {
        audio.add(new Audio("I Took a Pill In Ibiza", "Mike Posner", "3:56", R.drawable.ibiza_origina));
    }

    private void AddData_condition5() {
        audio.add(new Audio("God's Plan", "Drake", "3:18", R.drawable.gods_plan_original));
    }

    private void AddData_condition4() {
        audio.add(new Audio("Bom Diggy", "Zack Night", "3:27", R.drawable.bom_diggy_original));
        audio.add(new Audio("Tera Yaar Hu Main", "Arijit Singh", "4:24", R.drawable.apple_music));
    }

    private void AddData_condition3() {
        audio.add(new Audio("Kar Har Maidaan Fateh", "Sukhwinder Singh,Sherya Ghoshal", "5:11", R.drawable.apple_music));
        audio.add(new Audio("Baba Bolta Hain Bas Ho Gaya", "Ranbir Kapoor,Papon,Supriya Pathak", "4:45", R.drawable.apple_music));
    }

    private void AddData_condition2() {
        audio.add(new Audio("Girls Like You", "Maroon 5", "4:30", R.drawable.apple_music));
    }

    private void AddData_condition1() {
        audio.add(new Audio("Chasing The Sun", "The Wanted", "3:18", R.drawable.wanted));
        audio.add(new Audio("Drunk On Love", "The Wanted", "3:23", R.drawable.wanted));
    }

    private void AddData_condition0() {
        audio.add(new Audio("Something Like This", "The Chainsmokers", "4:07", R.drawable.chainsmokers));
        audio.add(new Audio("You owe Me", "The Chainsmokers", "2:14", R.drawable.chainsmokers));
        audio.add(new Audio("All we Know", "The Chainsmokers", "3:14", R.drawable.chainsmokers
        ));
    }

}
