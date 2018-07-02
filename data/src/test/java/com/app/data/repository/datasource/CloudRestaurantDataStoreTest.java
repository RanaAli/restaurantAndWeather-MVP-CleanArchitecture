package com.app.data.repository.datasource;

import com.app.data.entity.restaurants.RestaurantEntity;
import com.app.data.net.services.RestaurantsApi;
import com.app.data.repository.datasource.restaurants.CloudRestaurantDataStore;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class) public class CloudRestaurantDataStoreTest {
    private CloudRestaurantDataStore cloudRestaurantDataStore;

    @Mock private RestaurantsApi restaurantsApi;

    @Before public void setup(){
        cloudRestaurantDataStore = new CloudRestaurantDataStore(restaurantsApi);
    }

    @Test
    public void testRestaurantsNearMe() {
        Observable<RestaurantEntity>
                restaurantEntityObservable = Observable.just(new RestaurantEntity());

        String lon = "222";
        String lat = "111";

        given(restaurantsApi.getRestaurants(lat, lon))
                .willReturn(restaurantEntityObservable);

        cloudRestaurantDataStore.restaurantsNearMe(lat, lon);

        verify(restaurantsApi).getRestaurants(lat, lon);
    }
}
