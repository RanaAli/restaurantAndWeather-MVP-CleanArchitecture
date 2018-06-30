package com.app.data.repository;

import com.app.data.entity.mapper.WeatherEntityDataMapper;
import com.app.data.repository.datasource.weather.WeatherDataStore;
import com.app.data.repository.datasource.weather.WeatherDataStoreFactory;
import com.app.domain.model.weather.WeatherDataModel;
import com.app.domain.repository.WeatherRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link WeatherDataRepository} for retrieving Weather data.
 */
@Singleton
public class WeatherDataRepository implements WeatherRepository {

    private final WeatherDataStoreFactory weatherDataStoreFactory;
    private final WeatherEntityDataMapper weatherEntityDataMapper;


    @Inject
    public WeatherDataRepository(WeatherDataStoreFactory weatherDataStoreFactory,
                                 WeatherEntityDataMapper weatherEntityDataMapper) {

        this.weatherDataStoreFactory = weatherDataStoreFactory;
        this.weatherEntityDataMapper = weatherEntityDataMapper;
    }

    @Override
    public Observable<WeatherDataModel> weatherNearMe(String lat, String lon) {
        WeatherDataStore cloudDataStore = weatherDataStoreFactory.createCloudDataStore();
        return cloudDataStore.getWeather(lat, lon).map(weatherEntityDataMapper::map);
    }
}
