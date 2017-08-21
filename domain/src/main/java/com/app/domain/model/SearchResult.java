package com.app.domain.model;

import java.util.List;

/**
 * Created by RanaAli on 8/20/17.
 */

public class SearchResult {

  private List<ItemDetails> itemDetails;

  public List<ItemDetails> getItemDetails() {
    return itemDetails;
  }

  public void setItemDetails(List<ItemDetails> itemDetails) {
    this.itemDetails = itemDetails;
  }
}
