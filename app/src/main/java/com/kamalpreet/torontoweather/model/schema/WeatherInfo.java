package com.kamalpreet.torontoweather.model.schema;

import com.google.gson.annotations.SerializedName;

public class WeatherInfo
{
    @SerializedName("temp")
    private String temp;

    public WeatherInfo(String temp)
    {
        this.temp = temp;
    }

    public String getTemp()
    {
        return temp;
    }

    public void setTemp(String temp)
    {
        this.temp = temp;
    }
}
