package com.app.presentation.mapper;

import com.app.domain.model.weather.WeatherDataModel;
import com.app.presentation.model.weather.WeatherUIModel;

import javax.inject.Inject;

public class WeatherDataModelMapper {

    @Inject
    public WeatherDataModelMapper() {
    }

    public WeatherUIModel map(WeatherDataModel weatherDataModel) {
        return new WeatherUIModel();
    }
}
