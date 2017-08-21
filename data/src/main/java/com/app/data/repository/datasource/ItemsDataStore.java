package com.app.data.repository.datasource;

import com.app.data.entity.response.search.ItemDetailsEntity;
import com.app.data.entity.response.search.SearchEntity;
import io.reactivex.Observable;

/**
 * Created by RanaAli on 8/20/17.
 */

public interface ItemsDataStore {

  /**
   * Get an {@link Observable} which will emit search results.
   */
  Observable<SearchEntity> searchItem(String searchString, String page, String hits);

  /**
   * Get an {@link Observable} which will emit detail info.
   */
  Observable<ItemDetailsEntity> getItemDetails(String slug);
}
