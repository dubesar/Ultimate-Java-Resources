package com.example.todolist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Model class for the application.
 * Represents a single Task on the To-do list.
 * Also used by the Room database as an Entity.
 */
@Entity
public class Task {

    // Task ID: Primary key set to auto-increment
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    public long taskId;

    // Contents of the Task
    @ColumnInfo(name = "task_name")
    public String task;

    // Checked state of the Task
    @ColumnInfo(name = "is_checked")
    public boolean isTaskChecked;

    // Default constructor
    public Task() {
        this.taskId = 0;
        this.task = "";
        this.isTaskChecked = false;
    }

    // Parameterized constructor: Ignored by Room
    @Ignore
    public Task(String task, boolean isTaskChecked) {
        this.taskId = 0;
        this.task = task;
        this.isTaskChecked = isTaskChecked;
    }
}
