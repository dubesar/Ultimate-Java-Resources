package com.fajarnandagusti.cataloguemoviefinal.scheduler;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

import com.fajarnandagusti.cataloguemoviefinal.R;
import com.fajarnandagusti.cataloguemoviefinal.activity.MainActivity;

import java.util.Calendar;

import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.EXTRA_MESSAGE_PREF;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.EXTRA_TYPE_PREF;

/**
 * Created by Gustiawan on 11/17/2018.
 */

public class DailyReminderReceiver extends BroadcastReceiver {
    private final int NOTIF_ID_REMINDER = 1;

    public DailyReminderReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra(EXTRA_MESSAGE_PREF);
        String title = "Daily Reminder";
        int notifId = NOTIF_ID_REMINDER;

        showReminderNotification(context,title,message,notifId);
    }

    private void showReminderNotification(Context context, String title, String message, int notifId) {
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = TaskStackBuilder.create(context)
                .addNextIntent(intent)
                .getPendingIntent(NOTIF_ID_REMINDER, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationHelper notificationHelper = new NotificationHelper(context);
        notificationHelper.createNotification(title, message);
    }

    public void setReminder(Context context, String type, String time, String message){
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, DailyReminderReceiver.class);
        intent.putExtra(EXTRA_MESSAGE_PREF,message);
        intent.putExtra(EXTRA_TYPE_PREF,type);
        String timeArray[] = time.split(":");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
        calendar.set(Calendar.SECOND,0);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, NOTIF_ID_REMINDER,intent,0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        Toast.makeText(context, R.string.dailyReminderSaved, Toast.LENGTH_SHORT).show();
    }
    public void cancelReminder(Context context){
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, DailyReminderReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, NOTIF_ID_REMINDER,intent,0);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(context, R.string.dailyReminderCanceled, Toast.LENGTH_SHORT).show();
    }
}
