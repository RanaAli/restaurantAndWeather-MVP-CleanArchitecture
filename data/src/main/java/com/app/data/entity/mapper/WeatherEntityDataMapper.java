package com.app.data.entity.mapper;

import com.app.data.entity.weather.WeatherEntity;
import com.app.domain.model.weather.WeatherDataModel;

import javax.inject.Inject;

public class WeatherEntityDataMapper {

    @Inject
    public WeatherEntityDataMapper() {
    }

    public WeatherDataModel map(WeatherEntity weatherEntity) {
        return new WeatherDataModel();
    }
}
