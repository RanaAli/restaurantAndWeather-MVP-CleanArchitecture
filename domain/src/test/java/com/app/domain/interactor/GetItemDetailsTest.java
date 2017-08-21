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

@RunWith(MockitoJUnitRunner.class) public class GetItemDetailsTest {
  private GetItemDetails getItemDetails;

  @Mock private ItemsRepository mockItemsRepository;
  @Mock private ThreadExecutor mockThreadExecutor;
  @Mock private PostExecutionThread mockPostExecutionThread;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Before public void setUp() {
    getItemDetails =
        new GetItemDetails(mockThreadExecutor, mockPostExecutionThread, mockItemsRepository);
  }

  @Test public void testGetItemDetailsUseCaseObservable() {
    String slug = "fakeSlug";

    getItemDetails.buildUseCaseObservable(GetItemDetails.Params.forItem(slug));

    verify(mockItemsRepository).getItemDetails(slug);
    verifyNoMoreInteractions(mockItemsRepository);
    verifyZeroInteractions(mockPostExecutionThread);
    verifyZeroInteractions(mockThreadExecutor);
  }

  @Test public void testShouldFailWhenNoOrEmptyParameters() {
    expectedException.expect(NullPointerException.class);
    getItemDetails.buildUseCaseObservable(null);
  }
}
