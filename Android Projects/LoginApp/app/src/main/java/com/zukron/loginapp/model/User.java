package com.zukron.loginapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Project name is LoginApp
 * Created by Zukron Alviandy R on 10/7/2020
 * Contact me if any issues on zukronalviandy@gmail.com
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey
    @NonNull
    private String username;
    @ColumnInfo(name = "full_name")
    private String fullName;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "date_created")
    private String dateCreated;

    public User(@NonNull String username, String fullName, String email, @NonNull String password, String dateCreated) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
