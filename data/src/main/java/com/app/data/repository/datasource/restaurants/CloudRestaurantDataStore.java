package com.app.data.repository.datasource.restaurants;

import com.app.data.entity.restaurants.RestaurantEntity;
import com.app.data.net.services.RestaurantsApi;
import com.app.data.repository.datasource.ItemsDataStore;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CloudRestaurantDataStore implements RestaurantDataStore {

    private final RestaurantsApi restaurantsApi;

    /**
     * Construct a {@link RestaurantDataStore} based on connections to the api (Cloud).
     *
     * @param restaurantsApi The {@link RestaurantsApi} implementation to use.
     */
    public CloudRestaurantDataStore(RestaurantsApi restaurantsApi) {
        this.restaurantsApi = restaurantsApi;
    }

    @Override
    public Observable<RestaurantEntity> restaurantsNearMe(String lat, String lon) {
        return restaurantsApi.getRestaurants(lat, lon)
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.computation());
    }
}
