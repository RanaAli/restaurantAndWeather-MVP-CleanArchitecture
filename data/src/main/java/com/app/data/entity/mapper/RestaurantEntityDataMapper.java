package com.app.data.entity.mapper;

import com.app.data.entity.restaurants.RestaurantEntity;
import com.app.domain.model.restaurants.RestaurantsDataModel;

import javax.inject.Inject;

public class RestaurantEntityDataMapper {

    @Inject public RestaurantEntityDataMapper() {
    }

    public RestaurantsDataModel map(RestaurantEntity restaurantEntity) {
        return new RestaurantsDataModel();
    }
}
