package com.example.android.tones;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends Fragment {
    private ArrayList<Audio> audio = new ArrayList<>();
    public SongFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview, container, false);
        if(audio.size()==0){
            AddData();
        }
        ListView listView = view.findViewById(R.id.list_view_songs);
        AudioAdapter audioAdapter = new AudioAdapter(getActivity(), audio);
        listView.setAdapter(audioAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String song_name = audio.get(position).getmSong_name();
                String artist = audio.get(position).getmArtist();
                String duration = audio.get(position).getmDuration();
                Intent intent = new Intent(getContext(),PlayingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",song_name);
                bundle.putString("artist",artist);
                bundle.putString("duration",duration);
                String url = audio.get(position).getAlbum_image() + "";
                bundle.putString("url",url);
                bundle.putParcelableArrayList("list",audio);
                String position_of_item = "" + position;
                bundle.putString("position",position_of_item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }
    public void AddData(){
        audio.add(new Audio("All we Know", "The Chainsmokers", "3:14", R.drawable.chainsmokers));
        audio.add(new Audio("Baba Bolta Hain Bas Ho Gaya", "Ranbir Kapoor,Papon,Supriya Pathak", "4:45", R.drawable.apple_music));
        audio.add(new Audio("Bom Diggy", "Zack Night", "3:27", R.drawable.bom_diggy_original));
        audio.add(new Audio("Chasing The Sun","The Wanted","3:18",R.drawable.wanted));
        audio.add(new Audio("Drunk On Love","The Wanted","3:23",R.drawable.wanted));
        audio.add(new Audio("Girls Like You", "Maroon 5", "4:30", R.drawable.apple_music));
        audio.add(new Audio("God's Plan", "Drake", "3:18", R.drawable.gods_plan_original));
        audio.add(new Audio("I Took a Pill In Ibiza", "Mike Posner", "3:56", R.drawable.ibiza_origina));
        audio.add(new Audio("Kar Har Maidaan Fateh", "Sukhwinder Singh,Sherya Ghoshal", "5:11", R.drawable.apple_music));
        audio.add(new Audio("Love Me Again", "John Newman", "3:54", R.drawable.love_me_again_2));
        audio.add(new Audio("Mine", "Bazzi", "2:14", R.drawable.mine_original));
        audio.add(new Audio("Something Like This", "The Chainsmokers", "4:07", R.drawable.chainsmokers));
        audio.add(new Audio("Strip That Down", "Liam Payne", "3:24", R.drawable.strip_down_original));
        audio.add(new Audio("Tareefan", "Badshah", "3:04", R.drawable.tareefan_original));
        audio.add(new Audio("Tera Yaar Hu Main", "Arijit Singh", "4:24", R.drawable.apple_music));
        audio.add(new Audio("Wolves", "Selena Gomez", "3:17", R.drawable.wolves_original));
        audio.add(new Audio("You owe Me", "The Chainsmokers", "2:14", R.drawable.chainsmokers));
    }
}
