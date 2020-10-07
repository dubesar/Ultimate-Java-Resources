package com.skyhope.eventcalenderlibrary.helper;

import android.content.Context;
import android.content.SharedPreferences;
/*
 *  ****************************************************************************
 *  * Created by : Md Tariqul Islam on 12/11/2018 at 12:57 PM.
 *  * Email : tariqul@w3engineers.com
 *  *
 *  * Purpose:
 *  *
 *  * Last edited by : Md Tariqul Islam on 12/11/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */


public class PreferenceHelper {
    private static PreferenceHelper sInstance;
    private SharedPreferences mSharedPreferences;

    public static PreferenceHelper init(Context context) {
        if (sInstance == null) {
            sInstance = new PreferenceHelper(context);
        }
        return sInstance;
    }

    public PreferenceHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences("EventCalender", Context.MODE_PRIVATE);
    }

    public void write(String key, String value) {
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString(key, value);
        mEditor.apply();
    }

    public void write(String key, int value) {
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt(key, value);
        mEditor.apply();
    }

    public String readString(String key) {
        return mSharedPreferences.getString(key, null);
    }

    public int readInteger(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public void remove(String key) {
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.remove(key);
        mEditor.apply();
    }
}
