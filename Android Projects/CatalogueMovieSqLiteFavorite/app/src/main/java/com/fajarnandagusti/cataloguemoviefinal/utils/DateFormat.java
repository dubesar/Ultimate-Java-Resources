package com.fajarnandagusti.cataloguemoviefinal.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gustiawan on 11/16/2018.
 */

public class DateFormat {
    public static String dateConverter(String dateString){
        java.text.DateFormat currentDate = new SimpleDateFormat("yyyy-MM-dd");
        java.text.DateFormat newDate = new SimpleDateFormat("EEEE, dd MMMM yyyy");

        try {
            Date date = currentDate.parse(dateString);
            return newDate.format(date);
        }catch (ParseException e){
            Log.e("Date Format", e.toString());
        }

        return "";
    }
}
