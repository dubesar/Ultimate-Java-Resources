package com.fajarnandagusti.cataloguemoviefinal.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.fajarnandagusti.cataloguemoviefinal.R;
import com.fajarnandagusti.cataloguemoviefinal.scheduler.DailyReminderReceiver;
import com.fajarnandagusti.cataloguemoviefinal.scheduler.ReleaseReminderReceiver;
import com.fajarnandagusti.cataloguemoviefinal.scheduler.ReminderPreference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.KEY_FIELD_DAILY_REMINDER;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.KEY_FIELD_UPCOMING_REMINDER;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.KEY_HEADER_DAILY_REMINDER;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.KEY_HEADER_UPCOMING_REMINDER;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.TYPE_REMINDER_PREF;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.TYPE_REMINDER_RECIEVE;

public class SettingActivity extends AppCompatActivity {
    @BindView(R.id.dailyReminder)
    Switch dailyReminder;
    @BindView(R.id.releaseReminder)
    Switch releaseReminder;

    public DailyReminderReceiver dailyReminderReceiver;
    public ReleaseReminderReceiver releaseReminderReceiver;
    public ReminderPreference reminderPreference;
    public SharedPreferences sReleaseReminder, sDailyReminder;
    public SharedPreferences.Editor editorReleaseReminder, editorDailyReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ButterKnife.bind(this);

        dailyReminderReceiver = new DailyReminderReceiver();
        releaseReminderReceiver = new ReleaseReminderReceiver();
        reminderPreference = new ReminderPreference(this);
        setPreference();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Settings");
    }

    private void setPreference() {
        sReleaseReminder = getSharedPreferences(KEY_HEADER_UPCOMING_REMINDER, MODE_PRIVATE);
        sDailyReminder = getSharedPreferences(KEY_HEADER_DAILY_REMINDER, MODE_PRIVATE);
        boolean checkSwUpcomingReminder = sReleaseReminder.getBoolean(KEY_FIELD_UPCOMING_REMINDER, false);
        releaseReminder.setChecked(checkSwUpcomingReminder);
        boolean checkSwDailyReminder = sDailyReminder.getBoolean(KEY_FIELD_DAILY_REMINDER, false);
        dailyReminder.setChecked(checkSwDailyReminder);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @OnCheckedChanged(R.id.dailyReminder)
    public  void  setDailyRemind(boolean isChecked){
        editorDailyReminder = sDailyReminder.edit();
        if (isChecked) {
            editorDailyReminder.putBoolean(KEY_FIELD_DAILY_REMINDER, true);
            editorDailyReminder.commit();
            dailyReminderOn();
        } else {
            editorDailyReminder.putBoolean(KEY_FIELD_DAILY_REMINDER, false);
            editorDailyReminder.commit();
            dailyReminderOff();
        }
    }

    private void dailyReminderOff() {
        dailyReminderReceiver.cancelReminder(SettingActivity.this);
    }

    private void dailyReminderOn() {
        String time = "07:00";
        String message = getResources().getString(R.string.daily_reminder_message);
        reminderPreference.setReminderDailyTime(time);
        reminderPreference.setReminderDailyMessage(message);
        dailyReminderReceiver.setReminder(SettingActivity.this, TYPE_REMINDER_RECIEVE, time, message);
    }

    @OnCheckedChanged(R.id.releaseReminder)
    public  void setReleaseRemind(boolean isChecked){
        editorReleaseReminder = sReleaseReminder.edit();
        if (isChecked) {
            editorReleaseReminder.putBoolean(KEY_FIELD_UPCOMING_REMINDER, true);
            editorReleaseReminder.commit();
            releaseReminderOn();
        } else {
            editorReleaseReminder.putBoolean(KEY_FIELD_UPCOMING_REMINDER, false);
            editorReleaseReminder.commit();
            releaseReminderOff();
        }
    }

    private void releaseReminderOff() {
        releaseReminderReceiver.cancelReminder(SettingActivity.this);
    }

    private void releaseReminderOn() {
        String time = "08:00";
        String message = getResources().getString(R.string.release_movie_message);
        reminderPreference.setReminderReleaseTime(time);
        reminderPreference.setReminderReleaseMessage(message);
        releaseReminderReceiver.setReminder(SettingActivity.this, TYPE_REMINDER_PREF, time, message);

    }

    public void setBahasa(View view){
        Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
        startActivity(mIntent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


}
