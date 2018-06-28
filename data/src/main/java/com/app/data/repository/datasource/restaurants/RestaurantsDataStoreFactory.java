package com.app.data.repository.datasource.restaurants;

/**
 * Created by RanaAli on 8/20/17.
 */

import com.app.data.net.RestClient;
import com.app.data.net.services.RestaurantsApi;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link RestaurantDataStore}.
 */
@Singleton public class RestaurantsDataStoreFactory {

  @Inject public RestaurantsDataStoreFactory() {
  }

  /**
   * Create {@link RestaurantDataStore} to retrieve data from the Cloud.
   */
  public RestaurantDataStore createCloudDataStore() {
    final RestaurantsApi restaurantsApi = RestClient.getService(RestaurantsApi.class);

    return new CloudRestaurantDataStore(restaurantsApi);
  }
}
