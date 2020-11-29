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

public class PlaylistFragment extends Fragment {
    private final ArrayList<Array_Audio> details = new ArrayList<>();

    public PlaylistFragment() {
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
                Intent intent = new Intent(getContext(),ListOfSongsInPlaylistActivity.class);
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
        details.add(new Array_Audio("Recently Added",17,R.drawable.chainsmokers));
        details.add(new Array_Audio("Most Played",6,R.drawable.gods_plan_original));
        details.add(new Array_Audio("Recently Played",7,R.drawable.wolves_original));
    }

}
