package com.app.data.repository.datasource.restaurants;

import com.app.data.entity.restaurants.RestaurantEntity;

import io.reactivex.Observable;

public interface RestaurantDataStore {

    /**
     * Get an {@link Observable} which will emit restaurants nearby.
     */
    Observable<RestaurantEntity> restaurantsNearMe(String lat, String lon);
}
