package com.app.data.net.services;

import com.app.data.entity.weather.WeatherEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherApi {

    String WEATHER_SEARCH = "5day/";

    @GET(WEATHER_SEARCH+"{key}")
    Observable<WeatherEntity> getWeather(@Path("key") String key,
                                         @Query("apikey") String apiKey,
                                         @Query("metric") boolean metric);

}
