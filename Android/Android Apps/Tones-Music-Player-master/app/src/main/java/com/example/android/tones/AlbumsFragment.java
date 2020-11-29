package com.example.android.tones;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumsFragment extends Fragment {
    private final ArrayList<Array_Audio> details = new ArrayList<>();


    public AlbumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.grid_view, container, false);
        if(details.size()==0){
            AddData();
        }
        GridView gridView = view.findViewById(R.id.gridview);
        GridArrayAdapter adapter = new GridArrayAdapter(getActivity(),details);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),ListOfSongsinAlbumsActivity.class);
                String playlist_number = "" + position;
                String imageUrl = details.get(position).getmAlbum_cover() + "";
                String name = details.get(position).getmName_of_playlist();
                Bundle bundle = new Bundle();
                bundle.putString("position",playlist_number);
                bundle.putString("image",imageUrl);
                bundle.putString("name",name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }
    public void AddData(){
        details.add(new Array_Audio("The Chainsmokers",3,R.drawable.chainsmokers));
        details.add(new Array_Audio("The Wanted",2,R.drawable.wanted));
        details.add(new Array_Audio("Maroon 5",1,R.drawable.apple_music));
        details.add(new Array_Audio("Sanju", 2, R.drawable.apple_music));
        details.add(new Array_Audio("Sonu Titu Ki Sweety", 2,  R.drawable.bom_diggy_original));
        details.add(new Array_Audio("God's Plan", 1, R.drawable.gods_plan_original));
        details.add(new Array_Audio("I Took a Pill In Ibiza", 1,  R.drawable.ibiza_origina));
        details.add(new Array_Audio("Love Me Again", 1, R.drawable.love_me_again_2));
        details.add(new Array_Audio("Mine", 1, R.drawable.mine_original));
        details.add(new Array_Audio("Strip That Down", 1, R.drawable.strip_down_original));
        details.add(new Array_Audio("Tareefan", 1, R.drawable.tareefan_original));
        details.add(new Array_Audio("Wolves", 1,  R.drawable.wolves_original));

    }

}
