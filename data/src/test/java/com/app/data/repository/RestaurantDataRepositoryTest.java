package com.app.data.repository;

import com.app.data.entity.mapper.RestaurantEntityDataMapper;
import com.app.data.entity.restaurants.RestaurantEntity;
import com.app.data.repository.datasource.restaurants.RestaurantDataStore;
import com.app.data.repository.datasource.restaurants.RestaurantsDataStoreFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantDataRepositoryTest {
    private RestaurantsDataRepository restaurantsDataRepository;

    @Mock
    private RestaurantsDataStoreFactory restaurantsDataStoreFactory;
    @Mock
    private RestaurantEntityDataMapper restaurantEntityDataMapper;
    @Mock
    private RestaurantDataStore restaurantDataStore;

    @Before
    public void setup() {
        restaurantsDataRepository = new RestaurantsDataRepository(restaurantsDataStoreFactory,
                restaurantEntityDataMapper);

        given(restaurantsDataStoreFactory.createCloudDataStore()).willReturn(restaurantDataStore);
    }

    @Test
    public void testRestaurantsNearMe() {
        Observable<RestaurantEntity>
                restaurantEntityObservable = Observable.just(new RestaurantEntity());

        String lon = "222";
        String lat = "111";

        given(restaurantDataStore.restaurantsNearMe(lat, lon))
                .willReturn(restaurantEntityObservable);

        restaurantsDataRepository.restaurantsNearMe(lat, lon);

        verify(restaurantsDataStoreFactory).createCloudDataStore();
        verify(restaurantDataStore).restaurantsNearMe(lat, lon);
    }
}
