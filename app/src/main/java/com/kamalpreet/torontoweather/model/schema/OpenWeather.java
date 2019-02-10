package com.kamalpreet.torontoweather.model.schema;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OpenWeather
{

    @SerializedName("list")
    private ArrayList<WeatherList> weatherLists;

    public OpenWeather(ArrayList<WeatherList> weatherLists)
    {
        this.weatherLists = weatherLists;
    }

    public ArrayList<WeatherList> getWeatherLists() {
        return weatherLists;
    }

    public void setWeatherLists(ArrayList<WeatherList> weatherLists) {
        this.weatherLists = weatherLists;
    }
}
