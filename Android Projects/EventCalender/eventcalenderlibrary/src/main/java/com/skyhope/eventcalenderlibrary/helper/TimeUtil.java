package com.skyhope.eventcalenderlibrary.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;



public class TimeUtil {
    private static final String DATE_FORMAT_1 = "dd MMMM yyyy";

    public static long getTimestamp(String dateString) {
        try {
            Date date = new SimpleDateFormat(DATE_FORMAT_1, Locale.ENGLISH).parse(dateString);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getDate(long time) {
        Date date = new Date(time);
        DateFormat format = new SimpleDateFormat(DATE_FORMAT_1, Locale.getDefault());
        format.setTimeZone(TimeZone.getDefault());
        return format.format(date);
    }
}
