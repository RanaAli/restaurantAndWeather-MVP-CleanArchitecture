package com.app.presentation.view;

import android.widget.RadioGroup;
import com.app.presentation.model.weather.WeatherUIModel;
import com.app.presentation.view.custom.QuantityView;
import com.app.presentation.model.ItemDetailModel;
import com.app.presentation.model.OptionModel;
import java.util.List;

/**
 * Interface representing ItemDetailsFragment View.
 * In this case is used as view representing an Item.
 */
public interface ItemDetailsView extends LoadDataView {

  void renderItemDetails(ItemDetailModel itemDetailModel, List<OptionModel> options,
      RadioGroup.OnCheckedChangeListener onCheckedChangeListener);

  void disableRadioButton(int position);

  void enableRadioButton(int position);

  void setProductID(String id);

  void setQuantityChangeListener(QuantityView.QuantityListener quantityChangeListener);

  void setMaxQuantity(int max);

  void populate(WeatherUIModel weatherUIModel);
}
