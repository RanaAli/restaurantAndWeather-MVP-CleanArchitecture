package com.app.presentation.presenter;

import android.support.annotation.NonNull;

import com.app.domain.exception.DefaultErrorBundle;
import com.app.domain.exception.ErrorBundle;
import com.app.domain.interactor.DefaultObserver;
import com.app.domain.interactor.GetRestaurantsNearMe;
import com.app.domain.model.SearchResult;
import com.app.domain.model.restaurants.RestaurantsDataModel;
import com.app.presentation.exception.ErrorMessageFactory;
import com.app.presentation.internal.di.PerActivity;
import com.app.presentation.mapper.ItemsModelDataMapper;
import com.app.presentation.model.ItemDetailModel;
import com.app.presentation.model.SearchResultModel;
import com.app.presentation.view.ItemsListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
@PerActivity
public class ItemsListPresenter implements Presenter {

    private ItemsListView viewListView;

    //  private final SearchItem searchItem;
    private final GetRestaurantsNearMe restaurantsNearMe;
    private final ItemsModelDataMapper itemsModelDataMapper;
    private List<ItemDetailModel> itemDetails;
    private Integer page;

    @Inject
    public ItemsListPresenter(GetRestaurantsNearMe restaurantsNearMe, ItemsModelDataMapper itemsModelDataMapper) {

        this.restaurantsNearMe = restaurantsNearMe;
        this.itemsModelDataMapper = itemsModelDataMapper;
        itemDetails = new ArrayList<>();
        page = 0;
    }

    public void setView(@NonNull ItemsListView view) {
        this.viewListView = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
        this.restaurantsNearMe.dispose();
        this.viewListView = null;
    }

    /**
     * Initializes the presenter by start retrieving the list.
     */
    public void initialize() {
        this.loadItemsList();
    }

    /**
     * Loads all Items.
     */
    private void loadItemsList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getItemsList();
    }

    private void getItemsList() {
        this.restaurantsNearMe.execute(new ItemsListObserver(),
                GetRestaurantsNearMe.Params.forLocation("25.204849", "55.270783"));
    }

    public void onItemClicked() {
        this.viewListView.viewItem();
    }

    private void showViewLoading() {
        this.viewListView.showLoading();
    }

    private void hideViewLoading() {
        this.viewListView.hideLoading();
    }

    private void showViewRetry() {
        this.viewListView.showRetry();
    }

    private void hideViewRetry() {
        this.viewListView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage =
                ErrorMessageFactory.create(this.viewListView.context(), errorBundle.getException());
        this.viewListView.showError(errorMessage);
    }

    private void showItemsInView(SearchResult searchResult) {
        final SearchResultModel searchResultModel = this.itemsModelDataMapper.transform(searchResult);
        itemDetails.addAll(searchResultModel.getItemDetails());
        this.viewListView.renderItemsList(itemDetails);
    }

    public void loadMoreItems(int page) {
        this.page = page;
        this.getItemsList();
    }

    public void refreshItems() {
        this.page = 0;
        this.itemDetails.clear();
        this.getItemsList();
    }

    private final class ItemsListObserver extends DefaultObserver<RestaurantsDataModel> {
        @Override
        public void onNext(RestaurantsDataModel restaurantsDataModel) {
//      ItemsListPresenter.this.showItemsInView(searchResult);
        }

        @Override
        public void onComplete() {
            ItemsListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable exception) {
            ItemsListPresenter.this.hideViewLoading();
            ItemsListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) exception));
            ItemsListPresenter.this.showViewRetry();
        }
    }

}
