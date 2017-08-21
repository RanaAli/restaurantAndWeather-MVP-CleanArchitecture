package com.app.presentation.model;

public class OptionModel {
  private Integer optionId;
  private String label;
  private String simpleProductSku;
  private Boolean isInStock;
  private Integer maxAvailableQty;

  public Integer getOptionId() {
    return optionId;
  }

  public void setOptionId(Integer optionId) {
    this.optionId = optionId;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getSimpleProductSku() {
    return simpleProductSku;
  }

  public void setSimpleProductSku(String simpleProductSku) {
    this.simpleProductSku = simpleProductSku;
  }

  public Boolean getInStock() {
    return isInStock;
  }

  public void setInStock(Boolean inStock) {
    isInStock = inStock;
  }

  public Boolean getIsInStock() {
    return isInStock;
  }

  public void setIsInStock(Boolean isInStock) {
    this.isInStock = isInStock;
  }

  public Integer getMaxAvailableQty() {
    return maxAvailableQty;
  }

  public void setMaxAvailableQty(Integer maxAvailableQty) {
    this.maxAvailableQty = maxAvailableQty;
  }
}
