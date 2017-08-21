package com.app.data.repository.datasource;

import com.app.data.entity.response.search.ItemDetailsEntity;
import com.app.data.entity.response.search.SearchEntity;
import com.app.data.net.services.ItemApi;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class) public class CloudItemsDataStoreTest {

  private CloudItemsDataStore cloudItemsDataStore;

  @Mock private ItemApi itemApi;

  @Before public void setUp() {
    cloudItemsDataStore = new CloudItemsDataStore(itemApi);
  }

  @Test public void testSearchFromApi() {
    Observable<SearchEntity> fakeObservable = Observable.just(new SearchEntity());
    String boy = "boy";
    String page = "1";
    String hits = "1";

    given(itemApi.searchItem(boy, page, hits)).willReturn(fakeObservable);

    cloudItemsDataStore.searchItem(boy, page, hits);

    verify(itemApi).searchItem(boy, page, hits);
  }

  @Test public void testItemDetailsFromApi() {
    Observable<ItemDetailsEntity> fakeObservable = Observable.just(new ItemDetailsEntity());

    String slug = "fakeslug";
    given(itemApi.getItemDetails(slug)).willReturn(fakeObservable);

    cloudItemsDataStore.getItemDetails(slug);

    verify(itemApi).getItemDetails(slug);
  }
}
