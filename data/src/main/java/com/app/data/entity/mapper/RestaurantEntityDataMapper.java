package com.app.data.entity.mapper;

import com.app.data.entity.restaurantSearch.RestaurantSearchEntity;
import com.app.domain.model.restaurants.RestaurantsDataModel;

public class RestaurantEntityDataMapper {
    public RestaurantsDataModel map(RestaurantSearchEntity restaurantSearchEntity) {
        RestaurantsDataModel dataModel = new RestaurantsDataModel();
        return dataModel;
    }
}
