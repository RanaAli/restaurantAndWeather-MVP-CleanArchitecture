package com.app.domain.model;

import java.util.List;

public class Option {
  private Integer optionId;
  private String label;
  private List<String> simpleProductSkus = null;
  private Boolean isInStock;

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

  public List<String> getSimpleProductSkus() {
    return simpleProductSkus;
  }

  public void setSimpleProductSkus(List<String> simpleProductSkus) {
    this.simpleProductSkus = simpleProductSkus;
  }

  public Boolean getIsInStock() {
    return isInStock;
  }

  public void setIsInStock(Boolean isInStock) {
    this.isInStock = isInStock;
  }
}
