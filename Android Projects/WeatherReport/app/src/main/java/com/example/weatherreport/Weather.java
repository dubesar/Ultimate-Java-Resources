package com.example.weatherreport;

public class Weather {
    private String mCity;
    private String mTemperature;

    public Weather(String city, String temperature) {
        this.mCity = city;
        this.mTemperature = temperature;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getTemperature() {
        return this.mTemperature;
    }
}
