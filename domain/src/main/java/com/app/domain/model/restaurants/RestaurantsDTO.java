package com.app.domain.model.restaurants;

import java.util.ArrayList;

public class RestaurantsDTO {

    private ArrayList<RestaurantDTO> dataModels = new ArrayList<>();

    public void add(RestaurantDTO dataModel){
        dataModels.add(dataModel);
    }

    public ArrayList<RestaurantDTO> getDataModels() {
        return dataModels;
    }

    public void setDataModels(ArrayList<RestaurantDTO> dataModels) {
        this.dataModels = dataModels;
    }
}
