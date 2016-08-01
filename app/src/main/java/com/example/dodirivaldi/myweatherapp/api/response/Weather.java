package com.example.dodirivaldi.myweatherapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Dodi Rivaldi on 30/04/2016.
 */
public class Weather {
    @SerializedName("main")
    private WeatherMain weatherMain;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherMain getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(WeatherMain weatherMain) {
        this.weatherMain = weatherMain;
    }

    public ArrayList<WeatherItem> getListWeather() {
        return listWeather;
    }

    public void setListWeather(ArrayList<WeatherItem> listWeather) {
        this.listWeather = listWeather;
    }

    @SerializedName("weather")
    private ArrayList<WeatherItem> listWeather = new ArrayList<>();

    @SerializedName("name")
    private String city;

}
