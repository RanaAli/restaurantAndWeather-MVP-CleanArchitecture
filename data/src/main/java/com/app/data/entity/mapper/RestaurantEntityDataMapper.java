package com.app.data.entity.mapper;

import com.app.data.entity.restaurantSearch.RestaurantSearchEntity;
import com.app.domain.model.restaurants.RestaurantsDataModel;

import javax.inject.Inject;

public class RestaurantEntityDataMapper {

    @Inject public RestaurantEntityDataMapper() {
    }

    public RestaurantsDataModel map(RestaurantSearchEntity restaurantSearchEntity) {
        RestaurantsDataModel dataModel = new RestaurantsDataModel();
        return dataModel;
    }
}
