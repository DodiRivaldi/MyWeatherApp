package com.example.dodirivaldi.myweatherapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dodi Rivaldi on 30/04/2016.
 */
public class ApiService {
    public static String API_KEY ="29d85fcc7fd47e7b064b21a661f54b63";
    public static String BASE_URL ="http://api.openweathermap.org";
    public static String BASE_PATH ="/data/2.5";

    public static <S> S createService(Class<S> serviceSClass){
        final OkHttpClient okHttpClient =new OkHttpClient
                .Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .build();



        Gson gson = new GsonBuilder()
            .create();

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return builder.create(serviceSClass);
    }
}
