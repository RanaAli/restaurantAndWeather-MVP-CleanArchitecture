package com.app.data.repository.datasource;

import com.app.data.repository.datasource.restaurants.CloudRestaurantDataStore;
import com.app.data.repository.datasource.restaurants.RestaurantDataStore;
import com.app.data.repository.datasource.restaurants.RestaurantsDataStoreFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)  public class RestaurantDataStoreFactoryTest {

    private RestaurantsDataStoreFactory restaurantsDataStoreFactory;

    @Before
    public void setup() {
        restaurantsDataStoreFactory = new RestaurantsDataStoreFactory();
    }

    @Test
    public void testCreateCloudDataStore() {

        RestaurantDataStore cloudDataStore = restaurantsDataStoreFactory.createCloudDataStore();

        assertThat(cloudDataStore, is(notNullValue()));
        assertThat(cloudDataStore, is(instanceOf(CloudRestaurantDataStore.class)));
    }
}
