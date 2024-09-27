package com.fajarnandagusti.cataloguemoviefinal.scheduler;

import android.content.Context;
import android.content.SharedPreferences;

import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.KEY_REMINDER_DAILY;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.KEY_REMINDER_MESSAGE_DAILY;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.KEY_REMINDER_MESSAGE_RELEASE;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.PREF_NAME;

/**
 * Created by Gustiawan on 11/17/2018.
 */

public class ReminderPreference {
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    public ReminderPreference(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setReminderReleaseTime(String time){
        editor.putString(KEY_REMINDER_DAILY,time);
        editor.commit();
    }
    public void setReminderReleaseMessage (String message){
        editor.putString(KEY_REMINDER_MESSAGE_RELEASE,message);
    }
    public void setReminderDailyTime(String time){
        editor.putString(KEY_REMINDER_DAILY,time);
        editor.commit();
    }
    public void setReminderDailyMessage(String message){
        editor.putString(KEY_REMINDER_MESSAGE_DAILY,message);
    }
}
