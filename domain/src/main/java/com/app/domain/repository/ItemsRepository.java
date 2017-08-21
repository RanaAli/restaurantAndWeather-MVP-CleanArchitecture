package com.app.domain.repository;

import com.app.domain.model.ItemDetails;
import com.app.domain.model.SearchResult;
import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting Items related data.
 */
public interface ItemsRepository {

  /**
   * Get an {@link Observable} which will emit search results.
   */
  Observable<SearchResult> searchItem(String searchString, String page, String hits);

  /**
   * Get an {@link Observable} which will emit detail info.
   */
  Observable<ItemDetails> getItemDetails(String slug);
}
