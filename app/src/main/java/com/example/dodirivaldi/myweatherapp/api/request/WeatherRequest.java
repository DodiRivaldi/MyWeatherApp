package com.example.dodirivaldi.myweatherapp.api.request;

import com.example.dodirivaldi.myweatherapp.api.ApiClient;
import com.example.dodirivaldi.myweatherapp.api.ApiService;
import com.example.dodirivaldi.myweatherapp.api.response.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dodi Rivaldi on 30/04/2016.
 */
public class WeatherRequest {
    private ApiClient apiClient;
    private Call<Weather> request;
    private OnWeatherRequestListener listener;

    public WeatherRequest(OnWeatherRequestListener listener){
        apiClient = ApiService.createService(ApiClient.class);
        this.listener=listener;
    }

    public void CallApi(String te){
        request =apiClient.getWeather(te,ApiService.API_KEY);
        request.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response!=null && response.isSuccessful()){
                    Weather mWeather = response.body();
                    listener.onRequestWeatherSuccess(mWeather);
                }

                else {
                    listener.onRequestWeatherFailure("Response Invalid");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                String errorMessage = t.getMessage() !=null?
                        t.getMessage():"Unable to connect to server";
                listener.onRequestWeatherFailure(errorMessage);
            }
        });
    }

    public void cancelApi(){
        if (request!=null){
            request.cancel();
        }
    }


    public interface OnWeatherRequestListener{
        void onRequestWeatherSuccess (Weather weatherRespone);
        void onRequestWeatherFailure(String message);
    }
}
