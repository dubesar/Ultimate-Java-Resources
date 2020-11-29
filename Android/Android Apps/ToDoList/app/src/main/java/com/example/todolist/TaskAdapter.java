package com.example.todolist;

import android.content.Context;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Adapter to bind data to the RecyclerView.
 * Unchecked Tasks are bound first, followed by the checked Tasks.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    // Data set for the RecyclerView
    private HashMap<String, LinkedList<Task>> mDataSet;
    private LinkedList<Task> mUncheckedTasks;
    private LinkedList<Task> mCheckedTasks;

    // FloatingActionButton
    private FloatingActionButton newTaskBtn;

    // Contextual action mode and its state
    private ActionMode mActionMode;
    private boolean mMultiSelect;

    // List of the selected ViewHolders
    private List<TaskViewHolder> mSelectedViewHolders = new ArrayList<>();

    // Room database
    private TasksDatabase mDatabase;

    /**
     * ViewHolder to hold each individual item in the RecyclerView.
     * Implements TextWatcher and multiple Listeners for the CheckBox and EditText child views.
     */
    public class TaskViewHolder extends RecyclerView.ViewHolder implements TextWatcher, CompoundButton.OnCheckedChangeListener, View.OnClickListener, View.OnLongClickListener, TextView.OnEditorActionListener {

        // Item view
        private LinearLayout itemView;

        // Item's child views
        private EditText itemEditText;
        private CheckBox itemCheckBox;

        // Callbacks for the contextual action mode
        private ActionMode.Callback actionModeCallbacks = new ActionMode.Callback() {

            // Called after startSupportActionMode()
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the contextual mode, and update its Title
                mode.getMenuInflater().inflate(R.menu.contextual_action_mode, menu);
                mode.setTitle(mSelectedViewHolders.size() + " task(s) selected");

                // Disable all means of modifying or creating Tasks
                disableModification();

                // Inflated successfully
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            // Called when the User taps on an action mode item
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                // Variable to return value
                boolean registered = false;

                // Check if the delete icon was tapped
                if (item.getItemId() == R.id.remove_task) {

                    // List of the selected items
                    final List<Task> selectedItems = new ArrayList<>();

                    // Grab each item from its ViewHolder in selectedViewHolders
                    for (TaskViewHolder holder : mSelectedViewHolders) {

                        // ViewHolder's position
                        int pos = holder.getAdapterPosition();

                        Task current;

                        if (pos < mUncheckedTasks.size()) {

                            // If ViewHolder holds an unchecked Task
                            current = mUncheckedTasks.get(pos);
                        } else {

                            // If ViewHolder holds a checked Task
                            current = mCheckedTasks.get(pos - mUncheckedTasks.size());
                        }

                        /*

                        Remember that both the unchecked Tasks' and checked Tasks' Lists work together like a Stack
                        The unchecked Tasks are placed over the checked Tasks for a decent user experience

                         */

                        // Add the retrieved Task to the selected items List
                        selectedItems.add(current);
                    }

                    // Update the data set
                    for (Task current : selectedItems) {
                        if (mUncheckedTasks.contains(current)) {
                            mUncheckedTasks.remove(current);
                        } else {
                            mCheckedTasks.remove(current);
                        }
                    }

                    // Update the data set in the Adapter
                    notifyDataSetChanged();

                    // TODO: Display Undo.
                    // TODO: Update the database only if deletion is confirmed. Otherwise, revert the changes.

                    // Update removal changes to the database on a worker thread
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {

                            // Passing the selected items List to the delete query
                            mDatabase.getTaskDao().deleteTasks(selectedItems.toArray(new Task[0]));
                        }
                    });

                    // Close the contextual action mode
                    mode.finish();

                    // Click registered
                    registered = true;
                }

                // Whether click was registered or not
                return registered;
            }

            // Called after mode.finish() or when the User hits the back button
            @Override
            public void onDestroyActionMode(ActionMode mode) {

                /*

                Change state of the "deselected" items
                Provides visual cues to the User

                 */
                for (TaskViewHolder holder : mSelectedViewHolders) {
                    holder.itemView.setSelected(false);
                }

                // Clear the selected ViewHolders List
                mSelectedViewHolders.clear();

                // Enables modification and creation of Tasks
                enableModification();
            }
        };

        // Constructor for TaskViewHolder
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            // Store reference to the current item view and its child views
            this.itemView = (LinearLayout) itemView;

            itemEditText = itemView.findViewById(R.id.item_edit_text);
            itemCheckBox = itemView.findViewById(R.id.item_checkbox);

            // Set Listeners to the item and its child views
            this.itemView.setOnLongClickListener(this);
            this.itemView.setOnClickListener(this);

            itemEditText.setOnEditorActionListener(this);
            itemEditText.addTextChangedListener(this);
            itemCheckBox.setOnCheckedChangeListener(this);
        }

        // Called every time an item's CheckBox is toggled
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            // Position of the CheckBox's ViewHolder
            int pos = getAdapterPosition();

            final Task current;

            // Toggle the checked state of the current Task
            if (isChecked) {

                // Remove from existing List
                current = mUncheckedTasks.remove(pos);

                // Add to the other List
                mCheckedTasks.add(0, current);

                // Update the Task object
                current.isTaskChecked = true;

            } else {

                // Remove from existing List
                current = mCheckedTasks.remove(pos - mUncheckedTasks.size());

                // Add to the other List
                mUncheckedTasks.add(0, current);

                // Update the Task object
                current.isTaskChecked = false;
            }

            // Update the data set in the Adapter
            notifyDataSetChanged();

            // Save checked state of the Task to the Room database on a worker thread
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {

                    /*
                     If the current Task was never saved to the database, so there's no entry with its ID
                     Then this query doesn't perform anything on the database
                     */
                    mDatabase.getTaskDao().updateTaskById(current.taskId, current.task, current.isTaskChecked);
                }
            });
        }

        // Called every time the User long presses on an item view
        @Override
        public boolean onLongClick(View v) {
            // Variable to return value
            boolean registered = false;

            // Register long click only if contextual action mode isn't already visible
            if (!mMultiSelect) {

                // Add current ViewHolder to the selected ViewHolders List
                mSelectedViewHolders.add(this);

                // Change state of the "selected" item view
                // Provides visual cues to the User
                this.itemView.setSelected(true);

                // Display the contextual action mode
                mActionMode = ((AppCompatActivity) v.getContext()).startSupportActionMode(actionModeCallbacks);

                // Long click registered successfully
                registered = true;
            }

            // Don't register long click if contextual action mode is already visible
            return registered;
        }

        // Called every time the User taps on an item view
        @Override
        public void onClick(View v) {

            // Register click only if contextual action mode is visible
            if (mMultiSelect) {

                /*

                Toggle the "selected" state of the tapped item view
                Also add / remove its ViewHolder to the selected ViewHolders List

                 */

                if (itemView.isSelected()) {
                    mSelectedViewHolders.remove(this);
                    itemView.setSelected(false);
                } else {
                    mSelectedViewHolders.add(this);
                    itemView.setSelected(true);
                }

                // Update the contextual action mode's Title
                mActionMode.setTitle(mSelectedViewHolders.size() + " task(s) selected");

                // Close the action mode if nothing is selected
                if (mSelectedViewHolders.size() == 0) {
                    mActionMode.finish();
                    mMultiSelect = false;
                }
            }
        }

        // Called every time an action is performed on an item's EditText
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            // Variable to return value
            boolean handled = false;

            /*

            Check for imeOption == actionDone
            Check for any "unsaved changes" on this item
            If the second check is removed, the User may accidentally save the same Task multiple times to the database

             */

            if (actionId == EditorInfo.IME_ACTION_DONE && itemView.isActivated()) {

                // Retrieve new contents of the Task from the EditText
                String taskText = v.getText().toString();

                // Save the contents of the EditText, but only if it contains more than just whitespaces
                if (taskText.trim().length() != 0) {

                    // Retrieve the current Task object
                    int pos = getAdapterPosition();

                    final Task current;
                    if (pos < mUncheckedTasks.size()) {
                        current = mUncheckedTasks.get(pos);
                    } else {
                        current = mCheckedTasks.get(pos - mUncheckedTasks.size());
                    }

                    // Update the contents of the Task object
                    current.task = taskText;

                    // Update the current Task to the database on a worker thread
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            if (mDatabase.getTaskDao().findById(current.taskId) != null) {

                                // Make an update Task query if a Task with the same ID already exists
                                mDatabase.getTaskDao().updateTaskById(current.taskId, current.task, current.isTaskChecked);
                                Log.d("Adapter", "Task Updated! (Task ID: " + current.taskId + ")");
                            } else {

                                // Else make a save Task query
                                current.taskId = mDatabase.getTaskDao().saveTask(current);
                                Log.d("Adapter", "New Task Saved! (Task ID: " + current.taskId);
                            }
                        }
                    });

                    /*

                    Provide visual cue to the User for "changes saved"
                    Enable the item's CheckBox

                     */
                    itemView.setActivated(false);
                    itemCheckBox.setEnabled(true);

                    // Action handled
                    handled = true;
                }
            }

            // Whether or not action was handled
            return handled;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        // Called every time the User modifies the contents of the current item's EditText
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            // Retrieve the current Task object
            int pos = getAdapterPosition();

            Task current;

            if (pos < mUncheckedTasks.size()) {
                current = mUncheckedTasks.get(pos);
            } else {
                current = mCheckedTasks.get(pos - mUncheckedTasks.size());
            }

            /*

            Provide visual cue to the User
            If the EditText only contains whitespaces, its contents are not "saved"
            Also, the contents of the EditText are considered "saved" only if they match the contents of its respective Task as well

             */
            if ((s.toString().trim().length() == 0) || (!current.task.equals(s.toString()))) {

                // For "unsaved changes"
                itemView.setActivated(true);

                // Disable the item's CheckBox
                itemCheckBox.setEnabled(false);

            } else {

                // For "changes saved"
                itemView.setActivated(false);

                // Enable the item's CheckBox
                itemCheckBox.setEnabled(true);

            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    // Default Constructor disabled
    private TaskAdapter() {

    }

    // Parameterized Constructor
    public TaskAdapter(Context context, HashMap<String, LinkedList<Task>> dataSet, FloatingActionButton newTaskBtn) {

        // Store reference to the data set HashMap, as well as the two Task LinkedLists
        this.mDataSet = dataSet;
        this.mUncheckedTasks = dataSet.get(MainActivity.UNCHECKED_TASKS);
        this.mCheckedTasks = dataSet.get(MainActivity.CHECKED_TASKS);

        // Store reference to the FloatingActionButton
        this.newTaskBtn = newTaskBtn;

        // Use the passed-in context to retrieve the singleton instance of the Room database
        this.mDatabase = TasksDatabase.getInstance(context);
    }

    // Called every time the RecyclerView creates a new ViewHolder
    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Retrieve the item layout as a View object
        LinearLayout itemView = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_task_item, parent, false);

        // Return a TaskViewHolder object that holds the item layout object
        return new TaskViewHolder(itemView);

    }

    // Called by the RecyclerView after onCreateViewHolder() or when the Adapter is notified of data set changes.
    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {

        // Retrieve the current Task object
        Task current;
        if (position < mUncheckedTasks.size()) {
            current = mUncheckedTasks.get(position);
        } else {
            current = mCheckedTasks.get(position - mUncheckedTasks.size());
        }

        /*

        Set the CheckBox for the current Task

        Temporarily disables OnCheckedChangeListener to update the checked state from the current Task object
        The OnCheckedChangeListener makes a call to notifyDataSetChanged(), thereby calling onBindViewHolder()
        If the Listener is not disabled, the two methods (onBindViewHolder() and onCheckedChanged()) call each other and mess up the "checked" state of the Task

         */
        holder.itemCheckBox.setOnCheckedChangeListener(null);
        holder.itemCheckBox.setChecked(current.isTaskChecked);
        holder.itemCheckBox.setOnCheckedChangeListener(holder);


        // Set the EditText for the current Task
        holder.itemEditText.setText(current.task);

        // Disable and strike-through a Task if it's "checked", otherwise revert those changes
        if (current.isTaskChecked) {
            holder.itemEditText.setPaintFlags(holder.itemEditText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.itemEditText.setPaintFlags(holder.itemEditText.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }

        // Disable everything if the contextual action mode is visible
        if (mMultiSelect) {

            holder.itemView.setActivated(false);
            holder.itemCheckBox.setEnabled(false);
            holder.itemEditText.setEnabled(false);

        } else {

            // If contextual action mode is not visible

            // Enable the Task for unchecked Tasks, disable otherwise
            if (!current.isTaskChecked) {

                holder.itemEditText.setEnabled(true);

                /*

                Whether the current Task's contents consist of text or just whitespaces
                Provide visual cue to the User for "saved" or "unsaved" changes
                Enable / disable the item's CheckBox accordingly

                 */
                if (current.task.trim().length() == 0) {

                    // Only whitespaces: Unsaved changes + disabled CheckBox
                    holder.itemView.setActivated(true);
                    holder.itemCheckBox.setEnabled(false);

                } else {

                    // Text found: Saved changes + enabled CheckBox
                    holder.itemView.setActivated(false);
                    holder.itemCheckBox.setEnabled(true);
                }
            } else {

                // Checked Tasks: Only the CheckBox is to be enabled
                holder.itemEditText.setEnabled(false);
                holder.itemView.setActivated(false);
                holder.itemCheckBox.setEnabled(true);
            }
        }
    }

    // Tells the RecyclerView how many ViewHolders are required
    @Override
    public int getItemCount() {

        // Determine item count based on the mCheckedTasks and mUncheckedTasks lists

        if (mUncheckedTasks == null) {
            if (mCheckedTasks == null) {

                // If there are no tasks
                return 0;
            } else {

                // If there are only checked tasks
                return mCheckedTasks.size();
            }
        } else if (mCheckedTasks == null) {

            // If there are only unchecked tasks
            return mUncheckedTasks.size();
        } else {

            // If there are both checked and unchecked tasks
            return mUncheckedTasks.size() + mCheckedTasks.size();
        }
    }

    private void disableModification() {

        // Signifies the contextual action mode is visible
        mMultiSelect = true;

        // Hide the FloatingActionButton
        newTaskBtn.setVisibility(View.GONE);

        // Update changes
        notifyDataSetChanged();
    }

    private void enableModification() {

        // Contextual action mode no longer visible
        mMultiSelect = false;

        // Bring back the FloatingActionButton
        newTaskBtn.setVisibility(View.VISIBLE);

        // Update changes
        notifyDataSetChanged();
    }
}
