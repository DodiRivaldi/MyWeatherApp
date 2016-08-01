package com.example.dodirivaldi.myweatherapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dodirivaldi.myweatherapp.api.request.WeatherRequest;
import com.example.dodirivaldi.myweatherapp.api.response.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
implements WeatherRequest.OnWeatherRequestListener{

    @BindView(R.id.tv_city)
    TextView tvCity;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.tv_humidity)
    TextView tvHumidity;

    @BindView(R.id.tv_main)
    TextView tvMain;

    @BindView(R.id.tv_temp)
    TextView tvTemp;

    private ProgressDialog progressDialog;
    private WeatherRequest mWeatherRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mWeatherRequest = new WeatherRequest(this);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Harap Tunggu...");
        progressDialog.show();

        String city = "London,UK";
        mWeatherRequest.CallApi(city);

    }

    @Override
    public void onRequestWeatherSuccess(Weather weatherRespone) {
        progressDialog.dismiss();
        tvCity.setText(weatherRespone.getCity());
        tvDescription.setText(weatherRespone.getListWeather().get(0).getDescription());
        double degrees = weatherRespone.getWeatherMain().getTemp()-273;
        tvTemp.setText(degrees+" C");
        tvHumidity.setText(weatherRespone.getWeatherMain().getHumidity()+" %");
        tvMain.setText(weatherRespone.getListWeather().get(0).getMain());
    }

    @Override
    public void onRequestWeatherFailure(String message) {

    }
}
