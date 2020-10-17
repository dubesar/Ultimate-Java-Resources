package com.example.android.tones;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class GridArrayAdapter extends ArrayAdapter<Array_Audio> {
    GridArrayAdapter(Activity context, ArrayList<Array_Audio> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.array, parent, false);
        }
        Array_Audio array_audio = getItem(position);
        assert array_audio != null;
        ImageView image = view.findViewById(R.id.album_cover);
        image.setImageResource(array_audio.getmAlbum_cover());
        TextView category_name = view.findViewById(R.id.album_song);
        category_name.setText(array_audio.getmName_of_playlist());
        TextView number_of_songs = view.findViewById(R.id.number_songs);
        String sample;
        if (array_audio.getmNumber_of_Songs() == 1) {
            sample = "Contains  only " + array_audio.getmNumber_of_Songs() + " Song";
        } else {
            sample = "Contains " + array_audio.getmNumber_of_Songs() + " Songs";

        }
        number_of_songs.setText(sample);
        return view;

    }
}
