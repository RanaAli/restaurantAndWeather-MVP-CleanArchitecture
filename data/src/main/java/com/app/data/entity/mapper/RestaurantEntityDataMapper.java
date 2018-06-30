package com.app.data.entity.mapper;

import com.app.data.entity.restaurants.DummyRestaurant;
import com.app.data.entity.restaurants.Restaurant;
import com.app.data.entity.restaurants.RestaurantEntity;
import com.app.domain.model.restaurants.RestaurantDTO;
import com.app.domain.model.restaurants.RestaurantsDTO;

import java.util.List;

import javax.inject.Inject;

public class RestaurantEntityDataMapper {

    @Inject
    public RestaurantEntityDataMapper() {
    }

    public RestaurantsDTO map(RestaurantEntity restaurantEntity) {
        RestaurantsDTO dataModel = new RestaurantsDTO();

        List<DummyRestaurant> restaurants = restaurantEntity.getRestaurants();

        for (DummyRestaurant dummyRestaurant : restaurants) {
            RestaurantDTO dto = new RestaurantDTO();

            Restaurant restaurant = dummyRestaurant.getRestaurant();

            dto.setName(restaurant.getName());
            dto.setLocation(restaurant.getLocation() == null ?
                    "" : restaurant.getLocation().getCity());
            dto.setCuisine(restaurant.getCuisines());
            dto.setRating(restaurant.getUserRating().getAggregateRating());
            dto.setNumberOfReviews(restaurant.getAllReviews() == null ?
                    "0" : restaurant.getAllReviews().size() + "");
            dto.setImageUrl(restaurant.getThumb());

            dataModel.add(dto);
        }


        return dataModel;
    }
}
