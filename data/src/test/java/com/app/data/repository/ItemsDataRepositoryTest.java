package com.app.data.repository;

import com.app.data.entity.mapper.ItemEntityDataMapper;
import com.app.data.entity.response.search.ItemDetailsEntity;
import com.app.data.entity.response.search.SearchEntity;
import com.app.data.repository.datasource.ItemDataStoreFactory;
import com.app.data.repository.datasource.ItemsDataStore;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class) public class ItemsDataRepositoryTest {

  private ItemsDataRepository itemsDataRepository;

  @Mock private ItemDataStoreFactory mockItemDataStoreFactory;
  @Mock private ItemEntityDataMapper mockItemEntityDataMapper;
  @Mock private ItemsDataStore mockItemsDataStore;

  @Before public void setUp() {
    itemsDataRepository =
        new ItemsDataRepository(mockItemDataStoreFactory, mockItemEntityDataMapper);
    given(mockItemDataStoreFactory.createCloudDataStore()).willReturn(mockItemsDataStore);
  }

  @Test public void testSearchItem() {
    Observable<SearchEntity> fakeObservable = Observable.just(new SearchEntity());
    String boy = "boy";
    String page = "1";
    String hits = "1";

    given(mockItemsDataStore.searchItem(boy, page, hits)).willReturn(fakeObservable);

    itemsDataRepository.searchItem(boy, page, hits);

    verify(mockItemDataStoreFactory).createCloudDataStore();
    verify(mockItemsDataStore).searchItem(boy, page, hits);
  }

  @Test public void testItemDetails() {
    Observable<ItemDetailsEntity> fakeObservable = Observable.just(new ItemDetailsEntity());

    String slug = "fakeslug";
    given(mockItemsDataStore.getItemDetails(slug)).willReturn(fakeObservable);

    itemsDataRepository.getItemDetails(slug);

    verify(mockItemDataStoreFactory).createCloudDataStore();
    verify(mockItemsDataStore).getItemDetails(slug);
  }
}



