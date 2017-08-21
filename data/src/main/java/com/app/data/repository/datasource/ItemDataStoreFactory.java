package com.app.data.repository.datasource;

/**
 * Created by RanaAli on 8/20/17.
 */

import com.app.data.net.RestClient;
import com.app.data.net.services.ItemApi;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link ItemsDataStore}.
 */
@Singleton public class ItemDataStoreFactory {

  @Inject public ItemDataStoreFactory() {
  }

  /**
   * Create {@link ItemsDataStore} to retrieve data from the Cloud.
   */
  public ItemsDataStore createCloudDataStore() {
    final ItemApi itemApi = RestClient.getService(ItemApi.class);

    return new CloudItemsDataStore(itemApi);
  }
}
