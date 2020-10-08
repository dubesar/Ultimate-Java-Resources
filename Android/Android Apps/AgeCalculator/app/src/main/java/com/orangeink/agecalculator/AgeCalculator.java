package com.orangeink.agecalculator;

import java.util.Calendar;

public class AgeCalculator {

    private int startYear, startMonth, startDay;
    private int endYear, endMonth, endDay;
    private int resYear, resMonth, resDay;
    private int dayOfBirth;


    public AgeCalculator(Calendar startCalendar, Calendar endCalendar) {
        endYear = endCalendar.get(Calendar.YEAR);
        endMonth = endCalendar.get(Calendar.MONTH);
        endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
        startYear = startCalendar.get(Calendar.YEAR);
        startMonth = startCalendar.get(Calendar.MONTH);
        startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
        dayOfBirth = startCalendar.get(Calendar.DAY_OF_WEEK);
    }

    public String getDayOfBirth() {
        switch (dayOfBirth) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return "";
        }
    }

    public void calculateYear() {
        resYear = endYear - startYear;
    }

    public void calculateMonth() {
        if (endMonth >= startMonth) {
            resMonth = endMonth - startMonth;
        } else {
            resMonth = endMonth - startMonth;
            resMonth = 12 + resMonth;
            resYear--;
        }
    }

    public void calculateDay() {
        if (endDay >= startDay) {
            resDay = endDay - startDay;
        } else {
            resDay = endDay - startDay;
            resDay = 30 + resDay;
            if (resMonth == 0) {
                resMonth = 11;
                resYear--;
            } else {
                resMonth--;
            }
        }
    }

    public String getResult() {
        calculateYear();
        calculateMonth();
        calculateDay();
        return resDay + ":" + resMonth + ":" + resYear;
    }

    public String getNextBirthday() {
        Calendar earlier = Calendar.getInstance();
        Calendar later = Calendar.getInstance();
        int currentDay, currentYear, currentMonth;
        currentYear = earlier.get(Calendar.YEAR);
        currentMonth = earlier.get(Calendar.MONTH);
        currentDay = earlier.get(Calendar.DATE);
        earlier.set(currentYear, currentMonth, currentDay);
        if (earlier.get(Calendar.MONTH) >= later.get(Calendar.MONTH)) {
            later.set(currentYear + 1, startMonth, startDay);
        } else
            later.set(currentYear, startMonth, startDay);
        int earlierDays = earlier.get(Calendar.DAY_OF_YEAR);
        int laterDays = later.get(Calendar.DAY_OF_YEAR);
        long remain = earlierDays - laterDays;
        return String.valueOf(remain);
    }

}
