package com.example.notepadapp.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.notepadapp.Database.Notes;
import com.example.notepadapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private static final String TAG = NotesAdapter.class.getSimpleName();
    private List<Notes> mNotes;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    final private ListItemClickListener mOnClickListener;

    public NotesAdapter(List<Notes> notes, ListItemClickListener listener) {
        mNotes = notes;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notes_items, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder notesViewHolder, int i) {
        notesViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        if (mNotes == null) {
            return 0;
        }
        Log.d(TAG, "getItemCount: mNotes"+mNotes + ""+ mNotes.size());
        return mNotes.size();
    }

    public void setmNotes(List<Notes> notes) {
        mNotes = notes;
        notifyDataSetChanged();
    }

    public List<Notes> getNotes() {
        return mNotes;
    }

    class NotesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitleTextView;

        public NotesViewHolder(View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.nTitle);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            Notes notes = mNotes.get(position);

            mTitleTextView.setText(notes.getnTitle());
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}