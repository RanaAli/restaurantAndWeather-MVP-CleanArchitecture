package com.app.data.repository.datasource.weather;

import com.app.data.entity.weather.WeatherEntity;

import io.reactivex.Observable;

public interface WeatherDataStore {

    /**
     * Get an {@link Observable} which will emit restaurants nearby.
     */
    Observable<WeatherEntity> getWeather();
}
