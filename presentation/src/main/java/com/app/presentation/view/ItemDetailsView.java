package com.app.presentation.view;

import com.app.presentation.model.weather.WeatherUIModel;

/**
 * Interface representing ItemDetailsFragment View.
 * In this case is used as view representing an Item.
 */
public interface ItemDetailsView extends LoadDataView {
    void populate(WeatherUIModel weatherUIModel);
}
