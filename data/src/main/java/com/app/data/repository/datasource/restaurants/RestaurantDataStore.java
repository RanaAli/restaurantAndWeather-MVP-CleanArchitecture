package com.app.data.repository.datasource.restaurants;

import com.app.data.entity.restaurantSearch.RestaurantSearchEntity;

import io.reactivex.Observable;

public interface RestaurantDataStore {

    /**
     * Get an {@link Observable} which will emit restaurants nearby.
     */
    Observable<RestaurantSearchEntity> restaurantsNearMe(String lat, String lon);
}
