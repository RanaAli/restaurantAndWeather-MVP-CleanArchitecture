package com.app.data.repository;

/**
 * Created by RanaAli on 8/20/17.
 */

import com.app.data.entity.mapper.ItemEntityDataMapper;
import com.app.data.repository.datasource.ItemDataStoreFactory;
import com.app.data.repository.datasource.ItemsDataStore;
import com.app.domain.model.ItemDetails;
import com.app.domain.model.SearchResult;
import com.app.domain.repository.ItemsRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * {@link ItemsRepository} for retrieving Stories data.
 */
@Singleton public class ItemsDataRepository implements ItemsRepository {

  private final ItemDataStoreFactory itemDataStoreFactory;
  private final ItemEntityDataMapper itemEntityDataMapper;

  /**
   * Constructs a {@link ItemsRepository}.
   *
   * @param itemDataStoreFactory A {@link ItemDataStoreFactory} factory to construct different data
   * source implementations.
   * @param itemEntityDataMapper {@link ItemEntityDataMapper}.
   */
  @Inject public ItemsDataRepository(ItemDataStoreFactory itemDataStoreFactory,
      ItemEntityDataMapper itemEntityDataMapper) {
    this.itemDataStoreFactory = itemDataStoreFactory;
    this.itemEntityDataMapper = itemEntityDataMapper;
  }

  @Override
  public Observable<SearchResult> searchItem(String searchString, String page, String hits) {
    final ItemsDataStore itemsDataStore = itemDataStoreFactory.createCloudDataStore();
    return itemsDataStore.searchItem(searchString, page, hits).map(itemEntityDataMapper::transform);
  }

  @Override public Observable<ItemDetails> getItemDetails(String slug) {
    final ItemsDataStore itemsDataStore = itemDataStoreFactory.createCloudDataStore();
    return itemsDataStore.getItemDetails(slug).map(itemEntityDataMapper::transform);
  }
}
