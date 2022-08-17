package com.fajarnandagusti.cataloguemoviefinal.scheduler;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.fajarnandagusti.cataloguemoviefinal.R;
import com.fajarnandagusti.cataloguemoviefinal.activity.DetailMovieActivity;
import com.fajarnandagusti.cataloguemoviefinal.api.ApiService;
import com.fajarnandagusti.cataloguemoviefinal.api.Client;
import com.fajarnandagusti.cataloguemoviefinal.model.Movies;
import com.fajarnandagusti.cataloguemoviefinal.model.ResponseMovie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.API_KEY;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.BASE_URL_API;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.EXTRA_MESSAGE_RECIEVE;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.EXTRA_TYPE_RECIEVE;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.LANGUAGE;

/**
 * Created by Gustiawan on 11/17/2018.
 */

public class ReleaseReminderReceiver extends BroadcastReceiver {

    public List<Movies> listMovie = new ArrayList<>();
    private final int NOTIF_ID_RELEASE = 21;

    public ReleaseReminderReceiver() {

    }

    public void setReminder(Context context, String type, String time, String message){
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, ReleaseReminderReceiver.class);
        intent.putExtra(EXTRA_MESSAGE_RECIEVE,message);
        intent.putExtra(EXTRA_TYPE_RECIEVE,type);
        String timeArray[] = time.split(":");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
        calendar.set(Calendar.SECOND,0);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, NOTIF_ID_RELEASE,intent,0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        Toast.makeText(context, R.string.reminderSave, Toast.LENGTH_SHORT).show();
    }

    public void cancelReminder(Context context){
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,ReleaseReminderReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, NOTIF_ID_RELEASE,intent,0);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(context,R.string.reminderCancel, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        getUpcomingMovie(context);
    }

    private void getUpcomingMovie(final Context context) {
        ApiService service = Client.getClient(BASE_URL_API).create(ApiService.class);
        Call<ResponseMovie> call = service.getUpComingMovie(API_KEY);
        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                listMovie = response.body().getMovies();
                List<Movies> items = response.body().getMovies();
                int index = new Random().nextInt(items.size());
                Movies item = items.get(index);
                int notifId = 200;
                String title = items.get(index).getTitle();
                String message = items.get(index).getOverview();
                showNotification(context, title, message, notifId, item);
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Log.d("getUpCommingMovie", "onFailure: " + t.toString());
            }
        });
    }

    private void showNotification(Context context, String title, String message, int notifId, Movies item) {

        Intent i = new Intent(context, DetailMovieActivity.class);
        i.putExtra("title", item.getTitle());
        i.putExtra("poster_path", item.getPosterPath());
        i.putExtra("overview", item.getOverview());
        i.putExtra("release_date", item.getReleaseDate());
        PendingIntent pendingIntent = PendingIntent.getActivity(context, notifId, i, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationHelper notificationHelper = new NotificationHelper(context);

        notificationHelper.createNotification(title, message);
    }
}
