package com.app.presentation.mapper;

import com.app.domain.model.restaurants.RestaurantDTO;
import com.app.domain.model.restaurants.RestaurantsDTO;
import com.app.presentation.internal.di.PerActivity;
import com.app.presentation.model.Restaurants.RestaurantUIModel;
import com.app.presentation.model.Restaurants.RestaurantsUIModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Mapper class used to transform Restaurant Items related data (in the domain layer) to Items related Models
 * in the presentation layer.
 */
@PerActivity
public class RestaurantsDataModelMapper {

    @Inject
    public RestaurantsDataModelMapper() {
    }

    public RestaurantsUIModel transform(RestaurantsDTO restaurantsDTO) {
        ArrayList<RestaurantDTO> dataModels = restaurantsDTO.getDataModels();

        RestaurantsUIModel uiModel = new RestaurantsUIModel();

        for (RestaurantDTO dataModel : dataModels) {
            RestaurantUIModel model = new RestaurantUIModel();

            model.setName(dataModel.getName());
            model.setLocation(dataModel.getLocation());
            model.setCuisine(dataModel.getCuisine());
            model.setRating(dataModel.getRating());
            model.setNumberOfReviews(dataModel.getNumberOfReviews());
            model.setImageUrl(dataModel.getImageUrl());

            uiModel.add(model);
        }

        return uiModel;
    }
}
