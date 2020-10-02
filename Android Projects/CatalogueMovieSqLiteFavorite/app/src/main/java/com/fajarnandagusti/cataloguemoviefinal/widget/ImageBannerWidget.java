package com.fajarnandagusti.cataloguemoviefinal.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.fajarnandagusti.cataloguemoviefinal.R;
import com.fajarnandagusti.cataloguemoviefinal.adapter.MovieAdapter;

import java.util.Objects;

import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.EXTRA_ITEM;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.ON_CLICK_FAVORITE_ACTION;
import static com.fajarnandagusti.cataloguemoviefinal.utils.Utility.TOAST_ACTION;

/**
 * Implementation of App Widget functionality.
 */
public class ImageBannerWidget extends AppWidgetProvider {

    int appWidgetId, viewIndex;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Intent intent = new Intent(context, StackWidgetService.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.image_banner_widget);
        views.setRemoteAdapter(R.id.stack_view, intent);
        views.setEmptyView(R.id.stack_view, R.id.empty_view);

        Intent toastIntent = new Intent(context, ImageBannerWidget.class);
        toastIntent.setAction(TOAST_ACTION);
        toastIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

        PendingIntent toastPendingIntent = PendingIntent.getBroadcast(context, 0, toastIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        views.setPendingIntentTemplate(R.id.stack_view, toastPendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        AppWidgetManager mgr = AppWidgetManager.getInstance(context);

        switch (Objects.requireNonNull(intent.getAction())) {
            case TOAST_ACTION:
                appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                        AppWidgetManager.INVALID_APPWIDGET_ID);
                viewIndex = intent.getIntExtra(EXTRA_ITEM, 0);
                String title  = intent.getStringExtra(MovieAdapter.EXTRA_MOVIE);

                Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
                break;
            case ON_CLICK_FAVORITE_ACTION: {
                Log.d("TAG", "onReceive: " + "RECEIVED");
                int widgetIDs[] = mgr.getAppWidgetIds(new ComponentName(context, ImageBannerWidget.class));
                onUpdate(context, mgr, widgetIDs);
                mgr.notifyAppWidgetViewDataChanged(widgetIDs, R.id.stack_view);
                break;

            }
        }

        super.onReceive(context, intent);
    }
}

