package com.example.dodirivaldi.myweatherapp.api;

import com.example.dodirivaldi.myweatherapp.api.response.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dodi Rivaldi on 30/04/2016.
 */
public interface ApiClient {
    @GET("/data/2.5/weather")
    Call<Weather> getWeather(@Query("q") String q,
                            @Query("appid") String appId);
}
