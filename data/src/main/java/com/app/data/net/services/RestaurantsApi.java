package com.app.data.net.services;

import com.app.data.entity.restaurants.RestaurantEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestaurantsApi {

    String RESTAURANT_SEARCH = "search";

    @GET(RESTAURANT_SEARCH)
    Observable<RestaurantEntity> getRestaurants(
            @Query("lat") String lat, @Query("lon") String lon);

}
