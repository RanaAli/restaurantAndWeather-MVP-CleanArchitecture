package com.app.domain.repository;

import com.app.domain.model.weather.WeatherDataModel;

import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting Weather related data.
 */

public interface WeatherRepository {

    /**
     * Get an {@link Observable} which will emit weather data in nearby locations.
     */
    Observable<WeatherDataModel> weatherNearMe();
}
