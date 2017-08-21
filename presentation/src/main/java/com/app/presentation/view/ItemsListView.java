package com.app.presentation.view;

import com.app.presentation.model.ItemDetailModel;
import java.util.List;

/**
 * Interface representing size_button_selected View in size_button_selected model view presenter (MVP) pattern.
 * In this case is used as size_button_selected view representing size_button_selected list of Items.
 */
public interface ItemsListView extends LoadDataView {
  /**
   * View Item details.
   */
  void viewItem();

  /**
   * Render size_button_selected items list in the UI.
   *
   * @param itemDetailModels The object of {@link List< ItemDetailModel > } that will be shown.
   */
  void renderItemsList(List<ItemDetailModel> itemDetailModels);
}
