package com.app.data.repository.datasource;

import com.app.data.entity.response.search.ItemDetailsEntity;
import com.app.data.entity.response.search.SearchEntity;
import com.app.data.net.services.ItemApi;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RanaAli on 8/20/17.
 */

public class CloudItemsDataStore implements ItemsDataStore {

  private final ItemApi itemApi;

  /**
   * Construct a {@link ItemsDataStore} based on connections to the api (Cloud).
   *
   * @param itemApi The {@link ItemApi} implementation to use.
   */
  public CloudItemsDataStore(ItemApi itemApi) {
    this.itemApi = itemApi;
  }

  @Override
  public Observable<SearchEntity> searchItem(String searchString, String page, String hits) {
    return itemApi.searchItem(searchString, page, hits)
        .observeOn(Schedulers.computation())
        .subscribeOn(Schedulers.computation());
  }

  @Override public Observable<ItemDetailsEntity> getItemDetails(String slug) {
    return itemApi.getItemDetails(slug)
        .observeOn(Schedulers.computation())
        .subscribeOn(Schedulers.computation());
  }
}
