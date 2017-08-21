package com.app.data.entity.response.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;

public class ItemDetailsEntity {

  @SerializedName("productId") @Expose private Integer productId;
  @SerializedName("categoryPositions") @Expose private CategoryPositions categoryPositions;
  @SerializedName("sku") @Expose private String sku;
  @SerializedName("createdAt") @Expose private String createdAt;
  @SerializedName("typeId") @Expose private String typeId;
  @SerializedName("name") @Expose private String name;
  @SerializedName("slug") @Expose private String slug;
  @SerializedName("brand") @Expose private String brand;
  @SerializedName("age") @Expose private List<Object> age = null;
  @SerializedName("image") @Expose private String image;
  @SerializedName("smallImage") @Expose private String smallImage;
  @SerializedName("thumbnail") @Expose private String thumbnail;
  @SerializedName("motherReference") @Expose private String motherReference;
  @SerializedName("description") @Expose private String description;
  @SerializedName("price") @Expose private Integer price;
  @SerializedName("specialPrice") @Expose private Integer specialPrice;
  @SerializedName("specialFromDate") @Expose private String specialFromDate;
  @SerializedName("newsFromDate") @Expose private String newsFromDate;
  @SerializedName("newsToDate") @Expose private String newsToDate;
  @SerializedName("onlineDateWithStock") @Expose private String onlineDateWithStock;
  @SerializedName("onlineDate") @Expose private String onlineDate;
  @SerializedName("status") @Expose private Integer status;
  @SerializedName("visibility") @Expose private Integer visibility;
  @SerializedName("carrycotCompatible") @Expose private String carrycotCompatible;
  @SerializedName("trippTrapp") @Expose private Integer trippTrapp;
  @SerializedName("togRating") @Expose private String togRating;
  @SerializedName("style") @Expose private String style;
  @SerializedName("rating") @Expose private String rating;
  @SerializedName("sideImpactProtection") @Expose private String sideImpactProtection;
  @SerializedName("cotTypeSize") @Expose private String cotTypeSize;
  @SerializedName("sizeCode") @Expose private String sizeCode;
  @SerializedName("sizeCodeId") @Expose private Integer sizeCodeId;
  @SerializedName("collectionCharacter") @Expose private String collectionCharacter;
  @SerializedName("color") @Expose private String color;
  @SerializedName("colorId") @Expose private Integer colorId;
  @SerializedName("gender") @Expose private String gender;
  @SerializedName("developmentStage") @Expose private String developmentStage;
  @SerializedName("childWeight") @Expose private String childWeight;
  @SerializedName("noWheels") @Expose private String noWheels;
  @SerializedName("colorHex") @Expose private String colorHex;
  @SerializedName("copyAttributes") @Expose private List<Object> copyAttributes = null;
  @SerializedName("giftMessageAvailable") @Expose private String giftMessageAvailable;
  @SerializedName("giftWrappingAvailable") @Expose private String giftWrappingAvailable;
  @SerializedName("parentSku") @Expose private String parentSku;
  @SerializedName("styleColorId") @Expose private String styleColorId;
  @SerializedName("ranged") @Expose private Integer ranged;
  @SerializedName("analytics") @Expose private Analytics analytics;
  @SerializedName("categoryIds") @Expose private List<Integer> categoryIds = null;
  @SerializedName("categories") @Expose private List<String> categories = null;
  @SerializedName("media") @Expose private List<MediaEntity> media = null;
  @SerializedName("likes") @Expose private Integer likes;
  @SerializedName("minPrice") @Expose private Integer minPrice;
  @SerializedName("stock") @Expose private StockEntity stock;
  @SerializedName("isInStock") @Expose private Boolean isInStock;
  @SerializedName("isInHomeDeliveryStock") @Expose private Boolean isInHomeDeliveryStock;
  @SerializedName("isInClickAndCollectStock") @Expose private Boolean isInClickAndCollectStock;
  @SerializedName("isClearance") @Expose private Boolean isClearance;
  @SerializedName("customAllField") @Expose private String customAllField;
  @SerializedName("recommended") @Expose private List<Object> recommended = null;
  @SerializedName("crossSell") @Expose private List<Object> crossSell = null;
  @SerializedName("upSell") @Expose private List<Object> upSell = null;
  @SerializedName("discounted") @Expose private String discounted;
  @SerializedName("availableColors") @Expose private List<String> availableColors = null;
  @SerializedName("simpleType") @Expose private String simpleType;
  @SerializedName("sameColorSiblings") @Expose private List<String> sameColorSiblings = null;
  @SerializedName("areAnyOptionsInStock") @Expose private Boolean areAnyOptionsInStock;
  @SerializedName("stockOfAllOptions") @Expose private StockOfAllOptions stockOfAllOptions;
  @SerializedName("isClearanceFacet") @Expose private String isClearanceFacet;
  @SerializedName("isInStockFacet") @Expose private String isInStockFacet;
  @SerializedName("areAnyOptionsInStockFacet") @Expose private String areAnyOptionsInStockFacet;
  @SerializedName("isInHomeDeliveryStockFacet") @Expose private String isInHomeDeliveryStockFacet;
  @SerializedName("isInClickAndCollectStockFacet") @Expose private String
      isInClickAndCollectStockFacet;
  @SerializedName("sizesInStock") @Expose private List<String> sizesInStock = null;
  @SerializedName("sizesInHomeDeliveryStock") @Expose private List<String>
      sizesInHomeDeliveryStock = null;
  @SerializedName("sizesInClickAndCollectStock") @Expose private List<Object>
      sizesInClickAndCollectStock = null;
  @SerializedName("visibleSku") @Expose private String visibleSku;
  @SerializedName("stats") @Expose private Stats stats;
  @SerializedName("badges") @Expose private Badges badges;

  @SerializedName("configurableAttributes") @Expose private List<ConfigurableAttributeEntity>
      configurableAttributes = null;
  @SerializedName("relatedProductsLookup") @Expose private HashMap<String, ItemDetailsEntity>
      relatedProductsLookup;

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public CategoryPositions getCategoryPositions() {
    return categoryPositions;
  }

  public void setCategoryPositions(CategoryPositions categoryPositions) {
    this.categoryPositions = categoryPositions;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public List<Object> getAge() {
    return age;
  }

  public void setAge(List<Object> age) {
    this.age = age;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getSmallImage() {
    return smallImage;
  }

  public void setSmallImage(String smallImage) {
    this.smallImage = smallImage;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getMotherReference() {
    return motherReference;
  }

  public void setMotherReference(String motherReference) {
    this.motherReference = motherReference;
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

  public Integer getSpecialPrice() {
    return specialPrice;
  }

  public void setSpecialPrice(Integer specialPrice) {
    this.specialPrice = specialPrice;
  }

  public String getSpecialFromDate() {
    return specialFromDate;
  }

  public void setSpecialFromDate(String specialFromDate) {
    this.specialFromDate = specialFromDate;
  }

  public String getNewsFromDate() {
    return newsFromDate;
  }

  public void setNewsFromDate(String newsFromDate) {
    this.newsFromDate = newsFromDate;
  }

  public String getNewsToDate() {
    return newsToDate;
  }

  public void setNewsToDate(String newsToDate) {
    this.newsToDate = newsToDate;
  }

  public String getOnlineDateWithStock() {
    return onlineDateWithStock;
  }

  public void setOnlineDateWithStock(String onlineDateWithStock) {
    this.onlineDateWithStock = onlineDateWithStock;
  }

  public String getOnlineDate() {
    return onlineDate;
  }

  public void setOnlineDate(String onlineDate) {
    this.onlineDate = onlineDate;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getVisibility() {
    return visibility;
  }

  public void setVisibility(Integer visibility) {
    this.visibility = visibility;
  }

  public String getCarrycotCompatible() {
    return carrycotCompatible;
  }

  public void setCarrycotCompatible(String carrycotCompatible) {
    this.carrycotCompatible = carrycotCompatible;
  }

  public Integer getTrippTrapp() {
    return trippTrapp;
  }

  public void setTrippTrapp(Integer trippTrapp) {
    this.trippTrapp = trippTrapp;
  }

  public String getTogRating() {
    return togRating;
  }

  public void setTogRating(String togRating) {
    this.togRating = togRating;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getSideImpactProtection() {
    return sideImpactProtection;
  }

  public void setSideImpactProtection(String sideImpactProtection) {
    this.sideImpactProtection = sideImpactProtection;
  }

  public String getCotTypeSize() {
    return cotTypeSize;
  }

  public void setCotTypeSize(String cotTypeSize) {
    this.cotTypeSize = cotTypeSize;
  }

  public String getSizeCode() {
    return sizeCode;
  }

  public void setSizeCode(String sizeCode) {
    this.sizeCode = sizeCode;
  }

  public Integer getSizeCodeId() {
    return sizeCodeId;
  }

  public void setSizeCodeId(Integer sizeCodeId) {
    this.sizeCodeId = sizeCodeId;
  }

  public String getCollectionCharacter() {
    return collectionCharacter;
  }

  public void setCollectionCharacter(String collectionCharacter) {
    this.collectionCharacter = collectionCharacter;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Integer getColorId() {
    return colorId;
  }

  public void setColorId(Integer colorId) {
    this.colorId = colorId;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDevelopmentStage() {
    return developmentStage;
  }

  public void setDevelopmentStage(String developmentStage) {
    this.developmentStage = developmentStage;
  }

  public String getChildWeight() {
    return childWeight;
  }

  public void setChildWeight(String childWeight) {
    this.childWeight = childWeight;
  }

  public String getNoWheels() {
    return noWheels;
  }

  public void setNoWheels(String noWheels) {
    this.noWheels = noWheels;
  }

  public String getColorHex() {
    return colorHex;
  }

  public void setColorHex(String colorHex) {
    this.colorHex = colorHex;
  }

  public List<Object> getCopyAttributes() {
    return copyAttributes;
  }

  public void setCopyAttributes(List<Object> copyAttributes) {
    this.copyAttributes = copyAttributes;
  }

  public String getGiftMessageAvailable() {
    return giftMessageAvailable;
  }

  public void setGiftMessageAvailable(String giftMessageAvailable) {
    this.giftMessageAvailable = giftMessageAvailable;
  }

  public String getGiftWrappingAvailable() {
    return giftWrappingAvailable;
  }

  public void setGiftWrappingAvailable(String giftWrappingAvailable) {
    this.giftWrappingAvailable = giftWrappingAvailable;
  }

  public String getParentSku() {
    return parentSku;
  }

  public void setParentSku(String parentSku) {
    this.parentSku = parentSku;
  }

  public String getStyleColorId() {
    return styleColorId;
  }

  public void setStyleColorId(String styleColorId) {
    this.styleColorId = styleColorId;
  }

  public Integer getRanged() {
    return ranged;
  }

  public void setRanged(Integer ranged) {
    this.ranged = ranged;
  }

  public Analytics getAnalytics() {
    return analytics;
  }

  public void setAnalytics(Analytics analytics) {
    this.analytics = analytics;
  }

  public List<Integer> getCategoryIds() {
    return categoryIds;
  }

  public void setCategoryIds(List<Integer> categoryIds) {
    this.categoryIds = categoryIds;
  }

  public List<String> getCategories() {
    return categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public List<MediaEntity> getMedia() {
    return media;
  }

  public void setMedia(List<MediaEntity> media) {
    this.media = media;
  }

  public Integer getLikes() {
    return likes;
  }

  public void setLikes(Integer likes) {
    this.likes = likes;
  }

  public Integer getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(Integer minPrice) {
    this.minPrice = minPrice;
  }

  public StockEntity getStock() {
    return stock;
  }

  public void setStock(StockEntity stock) {
    this.stock = stock;
  }

  public Boolean getIsInStock() {
    return isInStock;
  }

  public void setIsInStock(Boolean isInStock) {
    this.isInStock = isInStock;
  }

  public Boolean getIsInHomeDeliveryStock() {
    return isInHomeDeliveryStock;
  }

  public void setIsInHomeDeliveryStock(Boolean isInHomeDeliveryStock) {
    this.isInHomeDeliveryStock = isInHomeDeliveryStock;
  }

  public Boolean getIsInClickAndCollectStock() {
    return isInClickAndCollectStock;
  }

  public void setIsInClickAndCollectStock(Boolean isInClickAndCollectStock) {
    this.isInClickAndCollectStock = isInClickAndCollectStock;
  }

  public Boolean getIsClearance() {
    return isClearance;
  }

  public void setIsClearance(Boolean isClearance) {
    this.isClearance = isClearance;
  }

  public String getCustomAllField() {
    return customAllField;
  }

  public void setCustomAllField(String customAllField) {
    this.customAllField = customAllField;
  }

  public List<Object> getRecommended() {
    return recommended;
  }

  public void setRecommended(List<Object> recommended) {
    this.recommended = recommended;
  }

  public List<Object> getCrossSell() {
    return crossSell;
  }

  public void setCrossSell(List<Object> crossSell) {
    this.crossSell = crossSell;
  }

  public List<Object> getUpSell() {
    return upSell;
  }

  public void setUpSell(List<Object> upSell) {
    this.upSell = upSell;
  }

  public String getDiscounted() {
    return discounted;
  }

  public void setDiscounted(String discounted) {
    this.discounted = discounted;
  }

  public List<String> getAvailableColors() {
    return availableColors;
  }

  public void setAvailableColors(List<String> availableColors) {
    this.availableColors = availableColors;
  }

  public String getSimpleType() {
    return simpleType;
  }

  public void setSimpleType(String simpleType) {
    this.simpleType = simpleType;
  }

  public List<String> getSameColorSiblings() {
    return sameColorSiblings;
  }

  public void setSameColorSiblings(List<String> sameColorSiblings) {
    this.sameColorSiblings = sameColorSiblings;
  }

  public Boolean getAreAnyOptionsInStock() {
    return areAnyOptionsInStock;
  }

  public void setAreAnyOptionsInStock(Boolean areAnyOptionsInStock) {
    this.areAnyOptionsInStock = areAnyOptionsInStock;
  }

  public StockOfAllOptions getStockOfAllOptions() {
    return stockOfAllOptions;
  }

  public void setStockOfAllOptions(StockOfAllOptions stockOfAllOptions) {
    this.stockOfAllOptions = stockOfAllOptions;
  }

  public String getIsClearanceFacet() {
    return isClearanceFacet;
  }

  public void setIsClearanceFacet(String isClearanceFacet) {
    this.isClearanceFacet = isClearanceFacet;
  }

  public String getIsInStockFacet() {
    return isInStockFacet;
  }

  public void setIsInStockFacet(String isInStockFacet) {
    this.isInStockFacet = isInStockFacet;
  }

  public String getAreAnyOptionsInStockFacet() {
    return areAnyOptionsInStockFacet;
  }

  public void setAreAnyOptionsInStockFacet(String areAnyOptionsInStockFacet) {
    this.areAnyOptionsInStockFacet = areAnyOptionsInStockFacet;
  }

  public String getIsInHomeDeliveryStockFacet() {
    return isInHomeDeliveryStockFacet;
  }

  public void setIsInHomeDeliveryStockFacet(String isInHomeDeliveryStockFacet) {
    this.isInHomeDeliveryStockFacet = isInHomeDeliveryStockFacet;
  }

  public String getIsInClickAndCollectStockFacet() {
    return isInClickAndCollectStockFacet;
  }

  public void setIsInClickAndCollectStockFacet(String isInClickAndCollectStockFacet) {
    this.isInClickAndCollectStockFacet = isInClickAndCollectStockFacet;
  }

  public List<String> getSizesInStock() {
    return sizesInStock;
  }

  public void setSizesInStock(List<String> sizesInStock) {
    this.sizesInStock = sizesInStock;
  }

  public List<String> getSizesInHomeDeliveryStock() {
    return sizesInHomeDeliveryStock;
  }

  public void setSizesInHomeDeliveryStock(List<String> sizesInHomeDeliveryStock) {
    this.sizesInHomeDeliveryStock = sizesInHomeDeliveryStock;
  }

  public List<Object> getSizesInClickAndCollectStock() {
    return sizesInClickAndCollectStock;
  }

  public void setSizesInClickAndCollectStock(List<Object> sizesInClickAndCollectStock) {
    this.sizesInClickAndCollectStock = sizesInClickAndCollectStock;
  }

  public String getVisibleSku() {
    return visibleSku;
  }

  public void setVisibleSku(String visibleSku) {
    this.visibleSku = visibleSku;
  }

  public Stats getStats() {
    return stats;
  }

  public void setStats(Stats stats) {
    this.stats = stats;
  }

  public Badges getBadges() {
    return badges;
  }

  public void setBadges(Badges badges) {
    this.badges = badges;
  }

  public Boolean getInStock() {
    return isInStock;
  }

  public void setInStock(Boolean inStock) {
    isInStock = inStock;
  }

  public Boolean getInHomeDeliveryStock() {
    return isInHomeDeliveryStock;
  }

  public void setInHomeDeliveryStock(Boolean inHomeDeliveryStock) {
    isInHomeDeliveryStock = inHomeDeliveryStock;
  }

  public Boolean getInClickAndCollectStock() {
    return isInClickAndCollectStock;
  }

  public void setInClickAndCollectStock(Boolean inClickAndCollectStock) {
    isInClickAndCollectStock = inClickAndCollectStock;
  }

  public Boolean getClearance() {
    return isClearance;
  }

  public void setClearance(Boolean clearance) {
    isClearance = clearance;
  }

  public List<ConfigurableAttributeEntity> getConfigurableAttributes() {
    return configurableAttributes;
  }

  public void setConfigurableAttributes(List<ConfigurableAttributeEntity> configurableAttributes) {
    this.configurableAttributes = configurableAttributes;
  }

  public HashMap<String, ItemDetailsEntity> getRelatedProductsLookup() {
    return relatedProductsLookup;
  }

  public void setRelatedProductsLookup(HashMap<String, ItemDetailsEntity> relatedProductsLookup) {
    this.relatedProductsLookup = relatedProductsLookup;
  }
}
