package com.example.androidnotepad.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Update;

import com.example.androidnotepad.R;
import com.example.androidnotepad.RoomHelper.NotesPojo;
import com.example.androidnotepad.UpdateNoteActivity;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    Context context;
    List<NotesPojo> notes_list;

    public  NotesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title_tv.setText(notes_list.get(position).getTitle());
        holder.description_tv.setText(notes_list.get(position).getDescription());
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateNoteActivity.class);
                intent.putExtra("notes_table", notes_list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes_list.size();
    }

    public void addNote(List<NotesPojo> notesPojos) {
        this.notes_list = notesPojos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_tv, description_tv;
        CardView card_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title_tv = itemView.findViewById(R.id.title_tv);
            description_tv = itemView.findViewById(R.id.description_tv);
            card_view = itemView.findViewById(R.id.card_view);
        }
    }
}
