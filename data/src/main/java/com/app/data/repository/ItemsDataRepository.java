package com.app.data.repository;

/**
 * Created by RanaAli on 8/20/17.
 */

import com.app.domain.model.ItemDetails;
import com.app.domain.model.SearchResult;
import com.app.domain.repository.ItemsRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link ItemsRepository} for retrieving Stories data.
 */
@Singleton
public class ItemsDataRepository implements ItemsRepository {

    @Inject
    public ItemsDataRepository() {
    }

    @Override
    public Observable<SearchResult> searchItem(String searchString, String page, String hits) {
        return null;
    }

    @Override
    public Observable<ItemDetails> getItemDetails(String slug) {
        return null;
    }
}
