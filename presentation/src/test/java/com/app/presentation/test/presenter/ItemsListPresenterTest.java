
package com.app.presentation.test.presenter;

import android.content.Context;
import com.app.domain.interactor.SearchItem;
import com.app.presentation.mapper.ItemsModelDataMapper;
import com.app.presentation.presenter.ItemsListPresenter;
import com.app.presentation.view.ItemsListView;
import io.reactivex.observers.DisposableObserver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ItemsListPresenterTest {

    private ItemsListPresenter itemsListPresenter;

    @Mock
    private Context mockContext;
    @Mock
    private ItemsListView mockItemsListView;
    @Mock
    private SearchItem mockSearchItem;
    @Mock
    private ItemsModelDataMapper mockItemsModelDataMapper;

    @Before
    public void setUp() {
        itemsListPresenter =
                new ItemsListPresenter(mockSearchItem, mockItemsModelDataMapper);
        itemsListPresenter.setView(mockItemsListView);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testItemsListPresenterInitialize() {
        given(mockItemsListView.context()).willReturn(mockContext);

        itemsListPresenter.initialize();

        verify(mockItemsListView).hideRetry();
        verify(mockItemsListView).showLoading();
        verify(mockSearchItem).execute(any(DisposableObserver.class), any(SearchItem.Params.class));
    }
}
