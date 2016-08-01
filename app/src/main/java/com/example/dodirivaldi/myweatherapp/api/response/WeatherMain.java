package com.example.dodirivaldi.myweatherapp.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dodi Rivaldi on 30/04/2016.
 */
public class WeatherMain {
    @SerializedName("temp")
    private double temp;

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    @SerializedName("pressure")

    private double pressure;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("temp_min")
    private double temp_min;

    @SerializedName("temp_max")
    private double temp_max;
}
