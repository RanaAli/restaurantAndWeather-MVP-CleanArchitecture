package com.app.data.entity.mapper;

import com.app.data.entity.weather.DailyForecast;
import com.app.data.entity.weather.WeatherEntity;
import com.app.domain.model.weather.DailyForecastDTO;
import com.app.domain.model.weather.WeatherDTO;

import java.util.ArrayList;

import javax.inject.Inject;

public class WeatherEntityDataMapper {

    @Inject
    public WeatherEntityDataMapper() {
    }

    public WeatherDTO map(WeatherEntity weatherEntity) {
        WeatherDTO weatherDTO = new WeatherDTO();

        weatherDTO.setHeadLine(weatherEntity.getHeadline().getText());
        weatherDTO.setDate(weatherEntity.getHeadline().getEffectiveDate());

        ArrayList<DailyForecastDTO> dailyForecastDTOS = new ArrayList<>();

        for (DailyForecast dailyForecast : weatherEntity.getDailyForecasts()) {
            DailyForecastDTO dailyForecastDTO = new DailyForecastDTO();

            dailyForecastDTO.setMin(dailyForecast.getTemperature().getMinimum().getValue());
            dailyForecastDTO.setMax(dailyForecast.getTemperature().getMaximum().getValue());
            dailyForecastDTO.setDate(dailyForecast.getDate());

            dailyForecastDTOS.add(dailyForecastDTO);
        }

        weatherDTO.setDailyForecastDTOS(dailyForecastDTOS);


        return weatherDTO;
    }
}
