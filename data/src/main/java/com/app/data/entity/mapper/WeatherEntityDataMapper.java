package com.app.data.entity.mapper;

import com.app.data.entity.weather.WeatherEntity;
import com.app.domain.model.weather.WeatherDataModel;

public class WeatherEntityDataMapper {

    public WeatherDataModel map(WeatherEntity weatherEntity) {
        return new WeatherDataModel();
    }
}
