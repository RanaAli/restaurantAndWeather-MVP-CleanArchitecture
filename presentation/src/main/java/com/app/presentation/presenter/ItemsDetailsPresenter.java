package com.app.presentation.presenter;

import android.support.annotation.NonNull;

import com.app.domain.exception.DefaultErrorBundle;
import com.app.domain.exception.ErrorBundle;
import com.app.domain.interactor.DefaultObserver;
import com.app.domain.interactor.GetWeatherNearMe;
import com.app.domain.model.weather.WeatherDTO;
import com.app.presentation.exception.ErrorMessageFactory;
import com.app.presentation.internal.di.PerActivity;
import com.app.presentation.mapper.WeatherDataModelMapper;
import com.app.presentation.model.weather.WeatherUIModel;
import com.app.presentation.view.ItemDetailsView;

import javax.inject.Inject;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
@PerActivity
public class ItemsDetailsPresenter implements Presenter {


    private ItemDetailsView viewDetailsView;

    private final GetWeatherNearMe getWeatherNearMe;
    private final WeatherDataModelMapper weatherDataModelMapper;

    @Inject
    public ItemsDetailsPresenter(GetWeatherNearMe getWeatherNearMe,
                                 WeatherDataModelMapper weatherDataModelMapper) {
        this.getWeatherNearMe = getWeatherNearMe;
        this.weatherDataModelMapper = weatherDataModelMapper;
    }

    public void setView(@NonNull ItemDetailsView view) {
        this.viewDetailsView = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
        this.getWeatherNearMe.dispose();
        this.viewDetailsView = null;
    }

    /**
     * Initializes the presenter by showing/hiding proper views
     * and retrieving details.
     */
    public void initialize() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getItemDetails();
    }

    private void getItemDetails() {
        this.getWeatherNearMe.execute(new weatherDetailsObserver(), new GetWeatherNearMe.Params());
    }

    private void showViewLoading() {
        this.viewDetailsView.showLoading();
    }

    private void hideViewLoading() {
        this.viewDetailsView.hideLoading();
    }

    private void showViewRetry() {
        this.viewDetailsView.showRetry();
    }

    private void hideViewRetry() {
        this.viewDetailsView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage =
                ErrorMessageFactory.create(this.viewDetailsView.context(), errorBundle.getException());
        this.viewDetailsView.showError(errorMessage);
    }

    private final class weatherDetailsObserver extends DefaultObserver<WeatherDTO> {

        @Override
        public void onComplete() {
            ItemsDetailsPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            ItemsDetailsPresenter.this.hideViewLoading();
            ItemsDetailsPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            ItemsDetailsPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(WeatherDTO weatherDTO) {
            WeatherUIModel weatherUIModel = weatherDataModelMapper.map(weatherDTO);
            viewDetailsView.populate(weatherUIModel);
        }
    }
}
