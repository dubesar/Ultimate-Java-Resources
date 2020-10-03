package com.example.stopwatch;

import android.util.Log;

public class TimeFormatUtils {

    public static String toDisplayString(int timeHundreds){
        int hundreds,seconds,minutes;

        String[] formatterArrayMillis = new String[2];
        String formattedSeconds,formattedMinutes;

        hundreds=timeHundreds%100;
        String milliSecStr = Integer.toString(hundreds);
        formatterArrayMillis[0] = "0" + milliSecStr;
        formatterArrayMillis[1] = milliSecStr;

        seconds=(timeHundreds/=100)%60;
        minutes=(timeHundreds/=60)%60;

        formattedSeconds=Integer.toString(seconds/10)+
                Integer.toString(seconds%10);
        formattedMinutes=Integer.toString(minutes/10)+
                Integer.toString(minutes%10);

        int millSecDigitsCnt = milliSecStr.length();
        String timeString =
                formattedMinutes+":"+
                        formattedSeconds+"."+
                        formatterArrayMillis[millSecDigitsCnt - 1];

        return timeString;
    }

}
