package com.skyhope.eventcalenderlibrary.model;

/*
 *  ****************************************************************************
 *  * Created by : Md Tariqul Islam on 11/29/2018 at 6:49 PM.
 *  * Email : tariqul@w3engineers.com
 *  *
 *  * Purpose:
 *  *
 *  * Last edited by : Md Tariqul Islam on 11/29/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

public class DayContainerModel {
    private int year;
    private String month;
    private int monthNumber;
    private int day;
    private int index;
    private long timeInMillisecond;
    private String date;
    private boolean haveEvent;
    private Event event;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getTimeInMillisecond() {
        return timeInMillisecond;
    }

    public void setTimeInMillisecond(long timeInMillisecond) {
        this.timeInMillisecond = timeInMillisecond;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isHaveEvent() {
        return haveEvent;
    }

    public void setHaveEvent(boolean haveEvent) {
        this.haveEvent = haveEvent;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
