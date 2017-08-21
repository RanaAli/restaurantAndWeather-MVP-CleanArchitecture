package com.app.presentation.model;

import java.util.List;

/**
 * Created by RanaAli on 8/20/17.
 */

public class ItemDetailModel {
  private String title;
  private String description;
  private String imageUrl;
  private Integer price;
  private Integer minPrice;
  private List<ConfigurableAttributeModel> configurableAttributes = null;
  private List<String> images;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public List<ConfigurableAttributeModel> getConfigurableAttributes() {
    return configurableAttributes;
  }

  public void setConfigurableAttributes(List<ConfigurableAttributeModel> configurableAttributes) {
    this.configurableAttributes = configurableAttributes;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public Integer getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(Integer minPrice) {
    this.minPrice = minPrice;
  }
}
