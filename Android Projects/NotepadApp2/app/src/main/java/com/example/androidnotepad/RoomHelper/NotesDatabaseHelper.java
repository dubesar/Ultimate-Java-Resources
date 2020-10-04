package com.example.androidnotepad.RoomHelper;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidnotepad.Adapter.NotesAdapter;
import com.example.androidnotepad.DashboardActivity;

import java.util.List;

public class NotesDatabaseHelper {

    Context context;
    NotesAdapter notesAdapter;

    public NotesDatabaseHelper(Context context) {
        this.context = context;

        notesAdapter = new NotesAdapter(context);
    }

    public void addNote (final String title, final String description){
        class AddNote extends AsyncTask <Void, Void, NotesPojo>{

            @Override
            protected NotesPojo doInBackground(Void... voids) {
                NotesPojo notesPojo = new NotesPojo();
                notesPojo.setTitle(title);
                notesPojo.setDescription(description);

                NotesClient.getInstance(context)
                        .getNotesDatabase()
                        .notesDAO()
                        .insert(notesPojo);
                return notesPojo;
            }

            @Override
            protected void onPostExecute(NotesPojo notesPojo) {
                super.onPostExecute(notesPojo);
                if (notesPojo != null){
                    Intent intent = new Intent(context, DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(context, "Note Saved", Toast.LENGTH_LONG).show();
                }else {
                    return;
                }
            }
        }

        AddNote addNote = new AddNote();
        addNote.execute();
    }

    public void getAllNotes(final RecyclerView recyclerView){
        class GetAllNotes extends AsyncTask<Void, Void, List<NotesPojo>>{

            @Override
            protected List<NotesPojo> doInBackground(Void... voids) {
                List<NotesPojo> notes_list = NotesClient
                        .getInstance(context)
                        .getNotesDatabase()
                        .notesDAO()
                        .getAll();
                return notes_list;
            }

            @Override
            protected void onPostExecute(List<NotesPojo> notesPojos) {
                super.onPostExecute(notesPojos);

                if (notesPojos != null && notesPojos.size() > 0){
                    notesAdapter.addNote(notesPojos);
                    recyclerView.setAdapter(notesAdapter);
                }
            }
        }

        GetAllNotes allNotes = new GetAllNotes();
        allNotes.execute();
    }

    public void updateNote(final NotesPojo notesPojo, final String title, final String description) {
        class UpdateNote extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                notesPojo.setTitle(title);
                notesPojo.setDescription(description);

                NotesClient.getInstance(context)
                        .getNotesDatabase()
                        .notesDAO()
                        .update(notesPojo);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (notesPojo != null) {
                    Intent intent = new Intent(context, DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                    Toast.makeText(context, "Note Update", Toast.LENGTH_LONG).show();
                } else {
                    return;
                }
            }
        }

        UpdateNote updateNote = new UpdateNote();
        updateNote.execute();

    }

    public void deleteNote(final NotesPojo notesPojo){
        class DeleteNote extends AsyncTask<Void, Void, Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                NotesClient.getInstance(context)
                        .getNotesDatabase()
                        .notesDAO()
                        .delete(notesPojo);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Intent intent = new Intent(context, DashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }

        DeleteNote deleteNote = new DeleteNote();
        deleteNote.execute();

    }
}
