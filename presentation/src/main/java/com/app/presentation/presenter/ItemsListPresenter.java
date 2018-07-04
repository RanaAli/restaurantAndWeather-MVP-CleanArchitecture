package com.app.presentation.presenter;

import android.support.annotation.NonNull;

import com.app.domain.exception.DefaultErrorBundle;
import com.app.domain.exception.ErrorBundle;
import com.app.domain.interactor.DefaultObserver;
import com.app.domain.interactor.GetRestaurantsNearMe;
import com.app.domain.model.restaurants.RestaurantsDTO;
import com.app.presentation.exception.ErrorMessageFactory;
import com.app.presentation.internal.di.PerActivity;
import com.app.presentation.mapper.RestaurantsDataModelMapper;
import com.app.presentation.model.restaurants.RestaurantUIModel;
import com.app.presentation.model.restaurants.RestaurantsUIModel;
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

    private final GetRestaurantsNearMe restaurantsNearMe;
    private final RestaurantsDataModelMapper itemsModelDataMapper;
    private List<RestaurantUIModel> itemDetails;
    private Integer page;

    @Inject
    public ItemsListPresenter(GetRestaurantsNearMe restaurantsNearMe,
                              RestaurantsDataModelMapper itemsModelDataMapper) {

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

    private void showItemsInView(RestaurantsDTO searchResult) {
        RestaurantsUIModel restaurantsUIModel = this.itemsModelDataMapper.transform(searchResult);
        itemDetails.addAll(restaurantsUIModel.getDataModels());
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

    private final class ItemsListObserver extends DefaultObserver<RestaurantsDTO> {
        @Override
        public void onNext(RestaurantsDTO restaurantsDTO) {
            ItemsListPresenter.this.showItemsInView(restaurantsDTO);
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
