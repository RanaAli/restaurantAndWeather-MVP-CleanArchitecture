package com.app.data.entity.mapper;

import com.app.data.entity.response.search.ItemDetailsEntity;
import com.app.data.entity.response.search.MediaEntity;
import com.app.data.entity.response.search.SearchEntity;
import com.app.data.entity.response.search.ConfigurableAttributeEntity;
import com.app.data.entity.response.search.OptionEntity;
import com.app.data.entity.response.search.StockEntity;
import com.app.domain.model.ConfigurableAttribute;
import com.app.domain.model.ItemDetails;
import com.app.domain.model.Media;
import com.app.domain.model.Option;
import com.app.domain.model.SearchResult;
import com.app.domain.model.Stock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/**
 * Created by RanaAli on 8/20/17.
 */

public class ItemEntityDataMapper {

  @Inject public ItemEntityDataMapper() {
  }

  /**
   * Transform a {@link SearchEntity} into an {@link SearchResult}.
   *
   * @param searchEntity {@link SearchEntity} Object to be transformed.
   * @return {@link SearchResult}
   */
  public SearchResult transform(SearchEntity searchEntity) {
    SearchResult searchResult = new SearchResult();

    List<ItemDetails> itemDetailsList = transform(searchEntity.getHits());

    searchResult.setItemDetails(itemDetailsList);
    return searchResult;
  }

  /**
   * Transform a {@link List< ItemDetailsEntity >} into an {@link List<ItemDetails>}.
   *
   * @param hits {@link List<ItemDetailsEntity>}
   * @return {@link List<ItemDetails>}
   */
  public List<ItemDetails> transform(List<ItemDetailsEntity> hits) {
    List<ItemDetails> itemDetailsList = null;
    if (hits != null) {
      itemDetailsList = new ArrayList<>();
      for (ItemDetailsEntity itemDetailsEntity : hits) {
        itemDetailsList.add(transform(itemDetailsEntity));
      }
    }
    return itemDetailsList;
  }

  /**
   * Transform a {@link ItemDetailsEntity} into an {@link ItemDetails}.
   *
   * @param itemDetailsEntity {@link ItemDetailsEntity} Object to be transformed.
   * @return {@link ItemDetails}
   */
  public ItemDetails transform(ItemDetailsEntity itemDetailsEntity) {
    ItemDetails itemDetails = null;
    if (itemDetailsEntity != null) {
      itemDetails = new ItemDetails();

      itemDetails.setTitle(itemDetailsEntity.getName());
      itemDetails.setPrice(itemDetailsEntity.getPrice());
      itemDetails.setMinPrice(itemDetailsEntity.getMinPrice());
      itemDetails.setImageUrl(itemDetailsEntity.getImage());
      itemDetails.setDescription(itemDetailsEntity.getDescription());
      itemDetails.setStock(transformStock(itemDetailsEntity.getStock()));

      itemDetails.setMediaList(TransformMediaEntityList(itemDetailsEntity.getMedia()));

      itemDetails.setConfigurableAttributes(
          transformConfigurableAttributeEntities(itemDetailsEntity.getConfigurableAttributes()));

      itemDetails.setRelatedProductsLookup(
          transformRelatedProductsLookup(itemDetailsEntity.getRelatedProductsLookup()));
    }

    return itemDetails;
  }

  private List<Media> TransformMediaEntityList(List<MediaEntity> mediaEntityList) {
    List<Media> mediaList = null;
    if (mediaEntityList != null) {
      mediaList = new ArrayList<>();
      for (MediaEntity mediaEntity : mediaEntityList) {
        Media media = transformMediaEntity(mediaEntity);
        mediaList.add(media);
      }
    }
    return mediaList;
  }

  private Media transformMediaEntity(MediaEntity mediaEntity) {
    Media media = null;
    if (mediaEntity != null) {
      media = new Media();
      media.setMediaType(mediaEntity.getMediaType());
      media.setPosition(mediaEntity.getPosition());
      media.setSrc(mediaEntity.getSrc());
      media.setVideoUrl(mediaEntity.getVideoUrl());
    }
    return media;
  }

  private Stock transformStock(StockEntity stockEntity) {
    Stock stock = null;
    if (stockEntity != null) {
      stock = new Stock();
      stock.setClickAndCollectQty(stockEntity.getClickAndCollectQty());
      stock.setHomeDeliveryQty(stockEntity.getHomeDeliveryQty());
      stock.setMaxAvailableQty(stockEntity.getMaxAvailableQty());
    }
    return stock;
  }

  private HashMap<String, ItemDetails> transformRelatedProductsLookup(
      HashMap<String, ItemDetailsEntity> hashMap) {
    HashMap<String, ItemDetails> itemDetailsHashMap = null;

    if (hashMap != null && !hashMap.isEmpty()) {
      itemDetailsHashMap = new HashMap<>();
      Set<String> strings = hashMap.keySet();
      for (String key : strings) {
        ItemDetailsEntity itemDetailsEntity = hashMap.get(key);
        ItemDetails itemDetails = transform(itemDetailsEntity);
        itemDetailsHashMap.put(key, itemDetails);
      }
    }
    return itemDetailsHashMap;
  }

  private List<ConfigurableAttribute> transformConfigurableAttributeEntities(
      List<ConfigurableAttributeEntity> configurableAttributeEntities) {

    List<ConfigurableAttribute> configurableAttributes = null;
    if (configurableAttributeEntities != null) {
      configurableAttributes = new ArrayList<>();
      for (ConfigurableAttributeEntity configurableAttributeEntity : configurableAttributeEntities) {
        configurableAttributes.add(transformConfigurableAttribute(configurableAttributeEntity));
      }
    }
    return configurableAttributes;
  }

  private ConfigurableAttribute transformConfigurableAttribute(
      ConfigurableAttributeEntity configurableAttributeEntity) {

    ConfigurableAttribute configurableAttribute = null;
    if (configurableAttributeEntity != null) {
      configurableAttribute = new ConfigurableAttribute();

      configurableAttribute.setCode(configurableAttributeEntity.getCode());
      configurableAttribute.setOptions(
          transformOptionEntities(configurableAttributeEntity.getOptions()));
    }
    return configurableAttribute;
  }

  private List<Option> transformOptionEntities(List<OptionEntity> optionEntities) {
    List<Option> options = null;
    if (optionEntities != null) {
      options = new ArrayList<>();
      for (OptionEntity optionEntity : optionEntities) {
        Option option = transformOptionEntity(optionEntity);
        options.add(option);
      }
    }

    return options;
  }

  private Option transformOptionEntity(OptionEntity optionEntity) {
    Option option = new Option();

    option.setIsInStock(optionEntity.getIsInStock());
    option.setLabel(optionEntity.getLabel());
    option.setOptionId(optionEntity.getOptionId());
    option.setSimpleProductSkus(optionEntity.getSimpleProductSkus());

    return option;
  }
}
