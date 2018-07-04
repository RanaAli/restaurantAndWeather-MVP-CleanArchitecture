package com.app.data.repository;

import com.app.data.entity.mapper.RestaurantEntityDataMapper;
import com.app.data.repository.datasource.restaurants.RestaurantDataStore;
import com.app.data.repository.datasource.restaurants.RestaurantsDataStoreFactory;
import com.app.domain.model.restaurants.RestaurantsDTO;
import com.app.domain.repository.RestaurantsRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link RestaurantsRepository} for retrieving Restaurants data.
 */
@Singleton public class RestaurantsDataRepository implements RestaurantsRepository{

    private final RestaurantsDataStoreFactory restaurantsDataStoreFactory;
    private final RestaurantEntityDataMapper resturantEntityDataMapper;

    /**
     * Constructs a {@link RestaurantsRepository}.
     *
     * @param restaurantsDataStoreFactory  A {@link RestaurantsDataStoreFactory} factory to construct different data
     * source implementations.
     * @param restaurantEntityDataMapper {@link RestaurantEntityDataMapper}.
     */
    @Inject public RestaurantsDataRepository(RestaurantsDataStoreFactory restaurantsDataStoreFactory,
                                     RestaurantEntityDataMapper restaurantEntityDataMapper) {
        this.restaurantsDataStoreFactory = restaurantsDataStoreFactory;
        this.resturantEntityDataMapper = restaurantEntityDataMapper;
    }

    @Override
    public Observable<RestaurantsDTO> restaurantsNearMe(String lat, String lon) {
        final RestaurantDataStore dataStore = restaurantsDataStoreFactory.createCloudDataStore();
        return dataStore.restaurantsNearMe(lat, lon).map(resturantEntityDataMapper::map);
    }
}
