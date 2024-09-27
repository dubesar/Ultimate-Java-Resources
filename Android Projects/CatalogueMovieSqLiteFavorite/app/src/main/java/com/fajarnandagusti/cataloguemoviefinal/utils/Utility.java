package com.fajarnandagusti.cataloguemoviefinal.utils;

import com.fajarnandagusti.cataloguemoviefinal.BuildConfig;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public class Utility {
    public final static String EXTRA_MOVIE = "movie";
    public final static String URL = "http://image.tmdb.org/t/p/w500";
    public final static String API_KEY = BuildConfig.API_KEY;

    public static final String BASE_URL_API = "https://api.themoviedb.org/";

    public final static String KEY_PARCELABLE ="key_parcelable";

    public final static String include_adult = "false";
    public final static String page = "1";

    public static final String AUTHORITY = "com.fajarnandagusti.cataloguemoviefinal";
    public static final String SCHEME = "content";


    public static final String KEY_HEADER_UPCOMING_REMINDER = "upcomingReminder";
    public static final String KEY_HEADER_DAILY_REMINDER = "dailyReminder";

    public static final String KEY_FIELD_UPCOMING_REMINDER = "checkedUpcoming";
    public static final String KEY_FIELD_DAILY_REMINDER = "checkedDaily";

    public final static String PREF_NAME = "reminderPreferences";
    public static final String LANGUAGE = "en-US";

    public final static String KEY_REMINDER_DAILY = "DailyTime";
    public final static String KEY_REMINDER_MESSAGE_RELEASE = "reminderMessageRelease";
    public final static String KEY_REMINDER_MESSAGE_DAILY = "reminderMessageDaily";
    public static final String EXTRA_MESSAGE_PREF = "message";
    public static final String EXTRA_TYPE_PREF = "type";
    public static final String TYPE_REMINDER_PREF = "reminderAlarm";
    public static final String EXTRA_MESSAGE_RECIEVE = "messageRelease";
    public static final String EXTRA_TYPE_RECIEVE = "typeRelease";
    public static final String TYPE_REMINDER_RECIEVE = "reminderAlarmRelease";

    public static final String NOTIFICATION_CHANNEL_ID = "10001";

    public final static int NOTIFICATION_ID = 501;
    public final static int NOTIFICATION_ID_ = 21;

    public static final String TOAST_ACTION = "com.fajarnandagusti.cataloguemoviefinal.TOAST_ACTION";
    public static final String EXTRA_ITEM = "com.fajarnandagusti.cataloguemoviefinal.EXTRA_ITEM";
    public static final String ON_CLICK_FAVORITE_ACTION = "com.fajarnandagusti.cataloguemoviefinal.ON_CLICK_FAVORITE_ACTION";
}
