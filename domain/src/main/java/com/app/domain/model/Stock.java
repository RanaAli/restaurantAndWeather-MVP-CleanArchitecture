package com.app.domain.model;

public class Stock {

  private Integer homeDeliveryQty;
  private Integer clickAndCollectQty;
  private Integer maxAvailableQty;

  public Integer getHomeDeliveryQty() {
    return homeDeliveryQty;
  }

  public void setHomeDeliveryQty(Integer homeDeliveryQty) {
    this.homeDeliveryQty = homeDeliveryQty;
  }

  public Integer getClickAndCollectQty() {
    return clickAndCollectQty;
  }

  public void setClickAndCollectQty(Integer clickAndCollectQty) {
    this.clickAndCollectQty = clickAndCollectQty;
  }

  public Integer getMaxAvailableQty() {
    return maxAvailableQty;
  }

  public void setMaxAvailableQty(Integer maxAvailableQty) {
    this.maxAvailableQty = maxAvailableQty;
  }
}
