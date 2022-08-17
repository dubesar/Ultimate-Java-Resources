package com.fajarnandagusti.cataloguemoviefinal.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.fajarnandagusti.cataloguemoviefinal.R;
import com.fajarnandagusti.cataloguemoviefinal.adapter.MovieAdapter;
import com.fajarnandagusti.cataloguemoviefinal.model.Favorite;
import com.fajarnandagusti.cataloguemoviefinal.utils.Utility;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.fajarnandagusti.cataloguemoviefinal.database.DatabaseContract.FavoriteColumn.CONTENT_URI;

/**
 * Created by Gustiawan on 11/17/2018.
 */

public  class StackRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory {
    private ArrayList<Favorite> mWidgetItems = new ArrayList<>();
    private Context mContext;

    public StackRemoteViewFactory(Context applicationContext, Intent intent) {
        mContext = applicationContext;
        int mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {
        mWidgetItems.clear();
        final long identityToken = Binder.clearCallingIdentity();
        Cursor cursor = mContext.getContentResolver().query(CONTENT_URI, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Favorite favorite = new Favorite(cursor);
                mWidgetItems.add(favorite);
                cursor.moveToNext();
            }
            while (!cursor.isAfterLast());
        }

        if (cursor != null) {
            cursor.close();
        }
        Binder.restoreCallingIdentity(identityToken);

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return mWidgetItems.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        Favorite currentMovieFavorite ;
        Bundle extras = new Bundle();
        Bitmap bmp = null;
        String releaseDate = null;
        try {
            currentMovieFavorite = mWidgetItems.get(position);
            bmp = Glide.with(mContext)
                    .load(Utility.URL + currentMovieFavorite.getPosterPath()).asBitmap()
                    .error(new ColorDrawable(mContext.getResources().getColor(R.color.colorPrimaryDark)))
                    .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();

            releaseDate = currentMovieFavorite.getReleaseDate();
            extras.putString(MovieAdapter.EXTRA_MOVIE,currentMovieFavorite.getTitle());

        } catch (InterruptedException | ExecutionException | IndexOutOfBoundsException e) {
            Log.d("Error loading", "error");
        }

        RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.widget_items);
        rv.setImageViewBitmap(R.id.imgWidget, bmp);
        rv.setTextViewText(R.id.txtDate, releaseDate);
        Intent fillInIntent = new Intent();
        fillInIntent.putExtras(extras);

        rv.setOnClickFillInIntent(R.id.imgWidget, fillInIntent);
        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
