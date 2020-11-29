package com.example.todolist;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * The only Activity used in the application.
 *
 *
 * Uses model class "Task".
 *
 *
 * Its layout contains a RelativeLayout, a FloatingActionButton and a RecyclerView.
 * The RecyclerView holds the list of all Tasks entered by the User.
 * The FloatingActionButton creates a new "unchecked" Task, and adds it to the top of the RecyclerView.
 * The RelativeLayout serves as a welcoming message that is only visible if there are no items in the RecyclerView.
 * At a point in time, either the RelativeLayout is visible or the RecyclerView.
 *
 *
 * The application uses two LinkedLists of type Task to manage the "checked" and "unchecked" state of Tasks.
 * Prioritising Tasks that are pending, the "unchecked" Tasks are displayed over the "checked" Tasks.
 * Besides this priority, the two lists together work effectively as a Stack.
 *
 *
 * To bind the two lists together the application uses a HashMap that holds references to both the LinkedLists.
 *
 *
 * The CheckBox's state of a Task is updated to the database instantly.
 * To save a Task's EditText field to the database, tap "Done" on the keyboard.
 */
public class MainActivity extends AppCompatActivity {
    // Keys for the data set HashMap
    public static final String UNCHECKED_TASKS = BuildConfig.APPLICATION_ID + ".unchecked_tasks";
    public static final String CHECKED_TASKS = BuildConfig.APPLICATION_ID + ".checked_tasks";

    // Data set HashMap and Task LinkedLists
    private HashMap<String, LinkedList<Task>> mDataSet = new LinkedHashMap<>();
    private LinkedList<Task> mUncheckedTasks = new LinkedList<>();
    private LinkedList<Task> mCheckedTasks = new LinkedList<>();

    // Other member variables
    private RecyclerView mRecyclerView;
    private TaskAdapter mAdapter;
    private RVEmptyObserver mObserver;
    private View mEmptyView;
    private FloatingActionButton newTaskBtn;
    private TasksDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve the singleton instance of the Room database
        mDatabase = TasksDatabase.getInstance(this);

        // Find references to the RecyclerView, EmptyView and the FloatingActionButton
        mRecyclerView = findViewById(R.id.recycler_view);
        mEmptyView = findViewById(R.id.empty_view);
        newTaskBtn = findViewById(R.id.fab_new_task);

        // Bind the Task LinkedLists to the Data set HashMap
        mDataSet.put(UNCHECKED_TASKS, mUncheckedTasks);
        mDataSet.put(CHECKED_TASKS, mCheckedTasks);

        // Set Adapter and LayoutManager to the RecyclerView
        mAdapter = new TaskAdapter(this, mDataSet, newTaskBtn);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Retrieve saved data from the Room database on a worker thread
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                mUncheckedTasks.addAll(mDatabase.getTaskDao().getUncheckedTasks());
                mCheckedTasks.addAll(mDatabase.getTaskDao().getCheckedTasks());

                mAdapter.notifyDataSetChanged();

                /*

                Register AdapterDataObserver after saved data is retrieved
                The AdapterDataObserver determines whether RecyclerView or the EmptyView is displayed

                 */
                mObserver = new RVEmptyObserver(MainActivity.this, mRecyclerView, mEmptyView);
                mAdapter.registerAdapterDataObserver(mObserver);
            }
        });

        // Set OnClickListener to the FloatingActionButton
        newTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a new "unchecked" Task
                Task newTask = new Task();
                mUncheckedTasks.add(0, newTask);

                // TODO: Animate insertion of new Task.
                // Update data set in the Adapter
                mAdapter.notifyDataSetChanged();

                // Scroll RecyclerView to the newly created Task
                mRecyclerView.scrollToPosition(0);

                // TODO: Bring newTask's itemEditText in focus.
            }
        });
    }

    @Override
    protected void onDestroy() {
        // Unregister AdapterDataObserver
        if (mRecyclerView.getAdapter() != null) {
            mRecyclerView.getAdapter().unregisterAdapterDataObserver(mObserver);
        }

        // Destroy the singleton instance of the Room database
        TasksDatabase.destroyInstance();

        super.onDestroy();
    }
}