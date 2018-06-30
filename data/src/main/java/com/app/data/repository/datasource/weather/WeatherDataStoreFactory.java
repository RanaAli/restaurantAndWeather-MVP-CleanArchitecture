package com.app.data.repository.datasource.weather;

/**
 * Created by RanaAli on 8/20/17.
 */

import com.app.data.net.RestClient;
import com.app.data.net.services.RestaurantsApi;
import com.app.data.net.services.WeatherApi;
import com.app.data.repository.datasource.restaurants.CloudRestaurantDataStore;
import com.app.data.repository.datasource.restaurants.RestaurantDataStore;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link WeatherDataStore}.
 */
@Singleton public class WeatherDataStoreFactory {

  @Inject public WeatherDataStoreFactory() {
  }

  /**
   * Create {@link WeatherDataStore} to retrieve data from the Cloud.
   */
  public WeatherDataStore createCloudDataStore() {
    WeatherApi weatherService = RestClient.getWeatherService(WeatherApi.class);

    return new CloudWeatherDataStore(weatherService);
  }
}
