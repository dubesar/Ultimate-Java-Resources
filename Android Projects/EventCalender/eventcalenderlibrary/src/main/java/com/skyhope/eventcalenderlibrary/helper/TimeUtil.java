package com.skyhope.eventcalenderlibrary.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/*
 *  ****************************************************************************
 *  * Created by : Md Tariqul Islam on 11/30/2018 at 12:04 PM.
 *  * Email : tariqul@w3engineers.com
 *  *
 *  * Purpose:
 *  *
 *  * Last edited by : Md Tariqul Islam on 11/30/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */


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
