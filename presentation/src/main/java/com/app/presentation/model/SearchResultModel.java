package com.app.presentation.model;

import java.util.List;

/**
 * Created by RanaAli on 8/20/17.
 */

public class SearchResultModel {

  private List<ItemDetailModel> itemDetails;

  public List<ItemDetailModel> getItemDetails() {
    return itemDetails;
  }

  public void setItemDetails(List<ItemDetailModel> itemDetails) {
    this.itemDetails = itemDetails;
  }
}
