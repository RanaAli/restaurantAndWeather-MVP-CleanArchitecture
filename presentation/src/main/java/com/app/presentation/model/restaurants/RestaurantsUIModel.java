package com.app.presentation.model.restaurants;

import java.util.ArrayList;

public class RestaurantsUIModel {
    private ArrayList<RestaurantUIModel> dataModels = new ArrayList<>();

    public void add(RestaurantUIModel dataModel) {
        dataModels.add(dataModel);
    }

    public ArrayList<RestaurantUIModel> getDataModels() {
        return dataModels;
    }

    public void setDataModels(ArrayList<RestaurantUIModel> dataModels) {
        this.dataModels = dataModels;
    }
}
