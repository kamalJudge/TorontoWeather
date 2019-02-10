package com.kamalpreet.torontoweather.model.rest;

import com.kamalpreet.torontoweather.model.schema.OpenWeather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenWeatherUserEndPoint
{
    @GET("data/2.5/forecast?id=524901&appid=9e32b84116d7891d08a2f8513d6b77fe")
    Call<OpenWeather> getUser(@Query("ids") String Ids, @Query("appid") String appId);

}
