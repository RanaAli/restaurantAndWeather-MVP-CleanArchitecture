package com.app.data.repository.datasource.weather;

import com.app.data.entity.weather.WeatherEntity;
import com.app.data.net.services.WeatherApi;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CloudWeatherDataStore implements WeatherDataStore {

    private final WeatherApi weatherApi;
    private final String WEATHER_URSER_KEY = "Bsw6x143hzPBACYRcga6KU0z2MIDTpKH";

    /**
     * Construct a {@link WeatherDataStore} based on connections to the api (Cloud).
     *
     * @param weatherApi The {@link WeatherApi} implementation to use.
     */
    public CloudWeatherDataStore(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Override
    public Observable<WeatherEntity> getWeather() {
        return weatherApi.getWeather("323053", WEATHER_URSER_KEY, true)
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.computation());
    }
}
