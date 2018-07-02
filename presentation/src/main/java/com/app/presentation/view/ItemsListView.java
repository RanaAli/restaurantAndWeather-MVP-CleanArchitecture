package com.app.presentation.view;

import com.app.presentation.model.ItemDetailModel;
import com.app.presentation.model.restaurants.RestaurantUIModel;

import java.util.List;

/**
 * Interface representing View in size_button_selected model view presenter (MVP) pattern.
 * In this case is used as view representing size_button_selected list of Items.
 */
public interface ItemsListView extends LoadDataView {
  /**
   * View Item details.
   */
  void viewItem();

  /**
   * Render items list in the UI.
   *
   * @param itemDetailModels The object of {@link List< ItemDetailModel > } that will be shown.
   */
  void renderItemsList(List<RestaurantUIModel> itemDetailModels);
}
