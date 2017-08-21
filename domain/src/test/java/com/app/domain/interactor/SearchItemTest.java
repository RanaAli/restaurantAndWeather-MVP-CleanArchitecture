package com.app.domain.interactor;

import com.app.domain.executor.PostExecutionThread;
import com.app.domain.executor.ThreadExecutor;
import com.app.domain.repository.ItemsRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class) public class SearchItemTest {
  private SearchItem searchItem;

  @Mock private ItemsRepository mockItemsRepository;
  @Mock private ThreadExecutor mockThreadExecutor;
  @Mock private PostExecutionThread mockPostExecutionThread;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Before public void setUp() {
    searchItem = new SearchItem(mockItemsRepository, mockThreadExecutor, mockPostExecutionThread);
  }

  @Test public void testSearchItemUseCaseObservable() {
    String boy = "boy";
    String page = "1";
    String hits = "1";

    searchItem.buildUseCaseObservable(SearchItem.Params.forQuery(boy, page, hits));

    verify(mockItemsRepository).searchItem(boy, page, hits);
    verifyNoMoreInteractions(mockItemsRepository);
    verifyZeroInteractions(mockPostExecutionThread);
    verifyZeroInteractions(mockThreadExecutor);
  }

  @Test public void testShouldFailWhenNoOrEmptyParameters() {
    expectedException.expect(NullPointerException.class);
    searchItem.buildUseCaseObservable(null);
  }
}
