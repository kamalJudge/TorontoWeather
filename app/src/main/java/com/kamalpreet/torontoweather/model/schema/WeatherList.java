package com.kamalpreet.torontoweather.model.schema;

import com.google.gson.annotations.SerializedName;

public class WeatherList
{
    @SerializedName("main")
    private WeatherInfo weather;

    @SerializedName("dt")
    private String date;

    public WeatherList(WeatherInfo weather, String date)
    {
        this.weather = weather;
        this.date = date;
    }

    public WeatherInfo getWeather() {
        return weather;
    }

    public void setWeather(WeatherInfo weather) {
        this.weather = weather;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
