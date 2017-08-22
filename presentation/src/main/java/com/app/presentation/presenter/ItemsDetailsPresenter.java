package com.app.presentation.presenter;

import android.support.annotation.NonNull;
import android.widget.RadioGroup;
import com.app.domain.exception.DefaultErrorBundle;
import com.app.domain.exception.ErrorBundle;
import com.app.domain.interactor.DefaultObserver;
import com.app.domain.interactor.GetItemDetails;
import com.app.domain.model.ItemDetails;
import com.app.presentation.internal.di.PerActivity;
import com.app.presentation.model.ItemDetailModel;
import com.app.presentation.view.ItemDetailsView;
import com.app.presentation.view.custom.QuantityView;
import com.app.presentation.exception.ErrorMessageFactory;
import com.app.presentation.mapper.ItemsModelDataMapper;
import com.app.presentation.model.ConfigurableAttributeModel;
import com.app.presentation.model.OptionModel;
import java.util.List;
import javax.inject.Inject;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
@PerActivity public class ItemsDetailsPresenter implements Presenter {

  private static final String SLUG = "n-a-210306523";

  private ItemDetailsView viewDetailsView;

  private final GetItemDetails getItemDetails;
  private final ItemsModelDataMapper itemsModelDataMapper;

  private List<OptionModel> sizeOptions;

  @Inject public ItemsDetailsPresenter(GetItemDetails getItemDetails,
      ItemsModelDataMapper itemsModelDataMapper) {

    this.getItemDetails = getItemDetails;
    this.itemsModelDataMapper = itemsModelDataMapper;
  }

  public void setView(@NonNull ItemDetailsView view) {
    this.viewDetailsView = view;
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  @Override public void destroy() {
    this.getItemDetails.dispose();
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
    this.getItemDetails.execute(new itemDetailsObserver(), GetItemDetails.Params.forItem(SLUG));
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

  private void showItemDetailsInView(ItemDetails itemDetails) {
    final ItemDetailModel itemDetailModel = this.itemsModelDataMapper.transform(itemDetails);

    List<ConfigurableAttributeModel> configurableAttributes =
        itemDetailModel.getConfigurableAttributes();
    ConfigurableAttributeModel configurableAttributeModel = configurableAttributes.get(0);

    sizeOptions = configurableAttributeModel.getOptions();

    this.viewDetailsView.renderItemDetails(itemDetailModel, sizeOptions, onCheckedChangeListener);
    this.viewDetailsView.setQuantityChangeListener(quantityChangeListener);
  }

  private RadioGroup.OnCheckedChangeListener onCheckedChangeListener =
      new RadioGroup.OnCheckedChangeListener() {
        @Override public void onCheckedChanged(RadioGroup group, int checkedId) {

          updateProductId(checkedId);
          updateMaxQuantity(checkedId);
        }
      };

  private void updateMaxQuantity(int checkedId) {
    OptionModel optionModel = sizeOptions.get(checkedId);
    this.viewDetailsView.setMaxQuantity(optionModel.getMaxAvailableQty());
  }

  private void updateProductId(int checkedId) {
    OptionModel optionModel = sizeOptions.get(checkedId);
    String simpleProductSku = optionModel.getSimpleProductSku();
    setProductID(simpleProductSku);
  }

  private void setProductID(String productID) {
    this.viewDetailsView.setProductID(productID);
  }

  private QuantityView.QuantityListener quantityChangeListener =
      new QuantityView.QuantityListener() {
        @Override public void onQuantityChanged(int quantity) {
          updateSizeButtons(quantity);
        }
      };

  private void updateSizeButtons(int quantity) {
    for (int i = 0; i < sizeOptions.size(); i++) {
      OptionModel option = sizeOptions.get(i);
      if (option.getMaxAvailableQty() < quantity) {
        viewDetailsView.disableRadioButton(i);
      } else {
        viewDetailsView.enableRadioButton(i);
      }
    }
  }

  private final class itemDetailsObserver extends DefaultObserver<ItemDetails> {

    @Override public void onComplete() {
      ItemsDetailsPresenter.this.hideViewLoading();
    }

    @Override public void onError(Throwable e) {
      ItemsDetailsPresenter.this.hideViewLoading();
      ItemsDetailsPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      ItemsDetailsPresenter.this.showViewRetry();
    }

    @Override public void onNext(ItemDetails itemDetails) {
      ItemsDetailsPresenter.this.showItemDetailsInView(itemDetails);
    }
  }
}
