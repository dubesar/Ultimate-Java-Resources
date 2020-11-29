package com.example.todolist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Abstract RoomDatabase class to be implemented by Room at compile-time. (Need to check on that)
 * Based on the Singleton Software Design Pattern.
 */
@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class TasksDatabase extends RoomDatabase {
    // The singleton instance of the database
    private static TasksDatabase INSTANCE = null;

    // Abstract method to be implemented by Room
    public abstract TaskDao getTaskDao();

    // Static method to get the singleton instance of the database
    public static TasksDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, TasksDatabase.class, "tasks-database").build();
        }
        return INSTANCE;
    }

    // Static method to destroy the singleton instance of the database
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
