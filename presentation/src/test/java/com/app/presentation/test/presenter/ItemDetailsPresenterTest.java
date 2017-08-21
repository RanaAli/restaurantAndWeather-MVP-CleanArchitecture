package com.app.presentation.test.presenter;

import android.content.Context;
import com.app.domain.interactor.GetItemDetails;
import com.app.presentation.mapper.ItemsModelDataMapper;
import com.app.presentation.presenter.ItemsDetailsPresenter;
import com.app.presentation.view.ItemDetailsView;
import io.reactivex.observers.DisposableObserver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class) public class ItemDetailsPresenterTest {

  private ItemsDetailsPresenter itemsDetailsPresenter;

  @Mock private Context mockContext;
  @Mock private ItemDetailsView mockItemDetailsView;
  @Mock private GetItemDetails mockGetItemDetails;
  @Mock private ItemsModelDataMapper mockItemsModelDataMapper;

  @Before public void setUp() {
    itemsDetailsPresenter = new ItemsDetailsPresenter(mockGetItemDetails, mockItemsModelDataMapper);
    itemsDetailsPresenter.setView(mockItemDetailsView);
  }

  @Test @SuppressWarnings("unchecked") public void testItemDetailsPresenterInitialize() {
    given(mockItemDetailsView.context()).willReturn(mockContext);

    itemsDetailsPresenter.initialize();

    verify(mockItemDetailsView).hideRetry();
    verify(mockItemDetailsView).showLoading();
    verify(mockGetItemDetails).execute(any(DisposableObserver.class),
        any(GetItemDetails.Params.class));
  }
}
