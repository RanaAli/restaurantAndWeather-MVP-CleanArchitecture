package com.app.data.net.services;

import com.app.data.entity.restaurants.RestaurantEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    String WEATHER_SEARCH = "search";

    @GET(WEATHER_SEARCH)
    Observable<RestaurantEntity> getWeather(@Query("apikey") String apiKey, @Query("q") String latNLon,
                                            @Query("details") String details);

}
