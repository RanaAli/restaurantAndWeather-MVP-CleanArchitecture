package com.app.domain.model;

import java.util.HashMap;
import java.util.List;

/**
 * Created by RanaAli on 8/20/17.
 */

public class ItemDetails {

  private String id;
  private String title;
  private String description;
  private String imageUrl;
  private Integer price;
  private Integer minPrice;
  private List<ConfigurableAttribute> configurableAttributes = null;
  private HashMap<String, ItemDetails> relatedProductsLookup;
  private List<Media> mediaList = null;
  private Stock stock;

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

  public List<ConfigurableAttribute> getConfigurableAttributes() {
    return configurableAttributes;
  }

  public void setConfigurableAttributes(List<ConfigurableAttribute> configurableAttributes) {
    this.configurableAttributes = configurableAttributes;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(Integer minPrice) {
    this.minPrice = minPrice;
  }

  public HashMap<String, ItemDetails> getRelatedProductsLookup() {
    return relatedProductsLookup;
  }

  public void setRelatedProductsLookup(HashMap<String, ItemDetails> relatedProductsLookup) {
    this.relatedProductsLookup = relatedProductsLookup;
  }

  public Stock getStock() {
    return stock;
  }

  public void setStock(Stock stock) {
    this.stock = stock;
  }

  public List<Media> getMediaList() {
    return mediaList;
  }

  public void setMediaList(List<Media> mediaList) {
    this.mediaList = mediaList;
  }
}
