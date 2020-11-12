package com.example.todolist;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Data Access Object (DAO) interface that acts as a mediator between the Database and the Application.
 * Contains annotated methods, each linked with a SQL query.
 * All the queries are checked for errors at compile-time by Room.
 */
@Dao
public interface TaskDao {
    // Retrieve a list of all Tasks from the database
    @Query("SELECT * FROM task")
    List<Task> getAllTasks();

    // Retrieve a list of all unchecked Tasks from the database
    @Query("SELECT * FROM task WHERE is_checked = 0")
    List<Task> getUncheckedTasks();

    // Retrieve a list of all checked Tasks from the database
    @Query("SELECT * FROM task WHERE is_checked = 1")
    List<Task> getCheckedTasks();

    // Find a Task by its ID from the database
    @Query("SELECT * FROM task WHERE task_id = :taskId LIMIT 1")
    Task findById(long taskId);

    // Update a Task by its ID to the database
    @Query("UPDATE task SET task_name = :newTaskName, is_checked = :isTaskChecked WHERE task_id = :taskId")
    void updateTaskById(long taskId, String newTaskName, boolean isTaskChecked);

    // Insert Task(s) into the database
    @Insert
    long saveTask(Task task);

    // Delete Task(s) from the database
    @Delete
    void deleteTasks(Task ...tasks);
}
