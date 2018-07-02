package com.app.data.entity.mapper;

import com.app.data.entity.restaurants.DummyRestaurant;
import com.app.data.entity.restaurants.RestaurantEntity;
import com.app.domain.model.restaurants.RestaurantsDTO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantEntityDataMapperTest {

    private RestaurantEntityDataMapper restaurantEntityDataMapper;

    @Before public void setup() {
        restaurantEntityDataMapper = new RestaurantEntityDataMapper();
    }

    @Test public void testMapRestaurantEntity() {
        List<DummyRestaurant> dummyRestaurants = new ArrayList<>();

        dummyRestaurants.add(new DummyRestaurant());
        dummyRestaurants.add(new DummyRestaurant());
        dummyRestaurants.add(new DummyRestaurant());
        dummyRestaurants.add(new DummyRestaurant());

        RestaurantEntity restaurantEntity = new RestaurantEntity();

        restaurantEntity.setRestaurants(dummyRestaurants);

        RestaurantsDTO restaurantsDTO = restaurantEntityDataMapper.map(restaurantEntity);

        assertThat(restaurantsDTO, is(instanceOf(RestaurantsDTO.class)));
        assertThat(restaurantsDTO.getDataModels(), not(equals(null)));
        assertThat(restaurantsDTO.getDataModels().size(), is(4));

    }
}
