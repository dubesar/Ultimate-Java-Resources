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

/**
 * This NotesAdapter creates and binds ViewHolders, that hold the title of a note,
 * to a RecyclerView to efficiently display data.
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private static final String TAG = NotesAdapter.class.getSimpleName();
    // List that holds notes data
    private List<Notes> mNotes;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    // Member variable to handle item clicks
    final private ListItemClickListener mOnClickListener;

    //Constructor for the NotesAdapter
    public NotesAdapter(ListItemClickListener listener) {
        mOnClickListener = listener;
    }

    //Called when ViewHolders are created to fill a RecyclerView
    // return A new NotesViewHolder that holds the view for each note
    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notes_items, viewGroup, false);
        return new NotesViewHolder(view);
    }

    // Called by the RecyclerView to display data at a specified position in the Cursor
    @Override
    public void onBindViewHolder(NotesViewHolder notesViewHolder, int i) {
        notesViewHolder.bind(i);
    }

    // Returns the number of items to display
    @Override
    public int getItemCount() {
        if (mNotes == null) {
            return 0;
        }
        Log.d(TAG, "getItemCount: mNotes" + mNotes + "" + mNotes.size());
        return mNotes.size();
    }

    //When data changes, this method updates the list of notes
    // and notifies the adapter to use the new values on it
    public void setmNotes(List<Notes> notes) {
        mNotes = notes;
        notifyDataSetChanged();
    }

    public List<Notes> getNotes() {
        return mNotes;
    }

    // Inner class for creating ViewHolders
    class NotesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //views
        TextView mTitleTextView;

        public NotesViewHolder(View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.nTitle);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            Notes notes = mNotes.get(position);

            //Set values
            mTitleTextView.setText(notes.getnTitle());
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}