package com.app.domain.repository;

import com.app.domain.model.restaurants.RestaurantsDTO;

import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting Restaurants related data.
 */

public interface RestaurantsRepository {

    /**
     * Get an {@link Observable} which will emit restaurants nearby.
     */
    Observable<RestaurantsDTO> restaurantsNearMe(String lat, String lon);
}
