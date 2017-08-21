package com.app.presentation.mapper;

import com.app.domain.model.ConfigurableAttribute;
import com.app.domain.model.ItemDetails;
import com.app.domain.model.Media;
import com.app.domain.model.Option;
import com.app.domain.model.SearchResult;
import com.app.domain.model.Stock;
import com.app.presentation.internal.di.PerActivity;
import com.app.presentation.model.ConfigurableAttributeModel;
import com.app.presentation.model.ItemDetailModel;
import com.app.presentation.model.SearchResultModel;
import com.app.presentation.model.OptionModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/**
 * Mapper class used to transform Items related data (in the domain layer) to Items related Models
 * in the
 * presentation layer.
 */
@PerActivity public class ItemsModelDataMapper {

  @Inject public ItemsModelDataMapper() {
  }

  /**
   * Transform an object of {@link SearchResult} into an object of {@link SearchResultModel}.
   *
   * @param searchResult Objects to be transformed.
   * @return List of {@link SearchResultModel}.
   */
  public SearchResultModel transform(SearchResult searchResult) {
    SearchResultModel searchResultModel = new SearchResultModel();

    searchResultModel.setItemDetails(transform(searchResult.getItemDetails()));

    return searchResultModel;
  }

  /**
   * Transform an object of {@link List<ItemDetails>} into an object of {@link
   * List< ItemDetailModel >}.
   *
   * @param itemDetailsList Objects to be transformed.
   * @return {@link List<ItemDetailModel>}.
   */
  public List<ItemDetailModel> transform(List<ItemDetails> itemDetailsList) {
    List<ItemDetailModel> itemDetailModelList = null;
    if (itemDetailsList != null) {
      itemDetailModelList = new ArrayList<>();
      for (ItemDetails itemDetails : itemDetailsList) {
        itemDetailModelList.add(transform(itemDetails));
      }
    }

    return itemDetailModelList;
  }

  /**
   * Transform an object of {@link ItemDetails} into an object of {@link ItemDetailModel}.
   *
   * @param itemDetails Objects to be transformed.
   * @return {@link ItemDetailModel}.
   */
  public ItemDetailModel transform(ItemDetails itemDetails) {
    ItemDetailModel itemDetailModel = null;
    if (itemDetails != null) {
      itemDetailModel = new ItemDetailModel();

      itemDetailModel.setTitle(itemDetails.getTitle());
      itemDetailModel.setPrice(itemDetails.getPrice());
      itemDetailModel.setMinPrice(itemDetails.getMinPrice());
      itemDetailModel.setImageUrl(itemDetails.getImageUrl());
      itemDetailModel.setDescription(itemDetails.getDescription());

      itemDetailModel.setImages(transformMedia(itemDetails.getMediaList()));

      itemDetailModel.setConfigurableAttributes(
          transformConfigurableAttributes(itemDetails.getConfigurableAttributes(),
              itemDetails.getRelatedProductsLookup()));
    }

    return itemDetailModel;
  }

  private List<String> transformMedia(List<Media> mediaList) {
    List<String> images = null;
    if (mediaList != null) {
      images = new ArrayList<>();
      for (Media media : mediaList) {
        String image = media.getSrc();
        images.add(image);
      }
    }
    return images;
  }

  private List<ConfigurableAttributeModel> transformConfigurableAttributes(
      List<ConfigurableAttribute> configurableAttributes,
      HashMap<String, ItemDetails> relatedProductsLookup) {

    List<ConfigurableAttributeModel> configurableAttributesModels = null;
    if (configurableAttributes != null) {
      configurableAttributesModels = new ArrayList<>();
      for (ConfigurableAttribute configurableAttribute : configurableAttributes) {
        configurableAttributesModels.add(
            transformConfigurableAttribute(configurableAttribute, relatedProductsLookup));
      }
    }
    return configurableAttributesModels;
  }

  private ConfigurableAttributeModel transformConfigurableAttribute(
      ConfigurableAttribute configurableAttribute,
      HashMap<String, ItemDetails> relatedProductsLookup) {

    ConfigurableAttributeModel configurableAttributeModel = null;
    if (configurableAttribute != null) {
      configurableAttributeModel = new ConfigurableAttributeModel();
      configurableAttributeModel.setCode(configurableAttribute.getCode());
      configurableAttributeModel.setOptions(
          transformOptionEntities(configurableAttribute.getOptions(), relatedProductsLookup));
    }
    return configurableAttributeModel;
  }

  private List<OptionModel> transformOptionEntities(List<Option> options,
      HashMap<String, ItemDetails> relatedProductsLookup) {
    List<OptionModel> optionsModels = null;
    if (options != null) {
      optionsModels = new ArrayList<>();

      for (Option option : options) {
        OptionModel optionModel = transformOptionEntity(option);
        setMaxAvailability(relatedProductsLookup, optionModel);
        optionsModels.add(optionModel);
      }
    }

    return optionsModels;
  }

  private void setMaxAvailability(HashMap<String, ItemDetails> relatedProductsLookup,
      OptionModel optionModel) {
    if (relatedProductsLookup != null) {
      String sku = optionModel.getSimpleProductSku();
      ItemDetails itemDetails = relatedProductsLookup.get(sku);
      Stock stock = itemDetails.getStock();
      if (stock != null) {
        Integer maxAvailableQty = stock.getMaxAvailableQty();
        optionModel.setMaxAvailableQty(maxAvailableQty);
      }
    }
  }

  private OptionModel transformOptionEntity(Option option) {
    OptionModel optionModel = new OptionModel();

    optionModel.setIsInStock(option.getIsInStock());
    optionModel.setLabel(option.getLabel());
    optionModel.setOptionId(option.getOptionId());

    List<String> simpleProductSkus = option.getSimpleProductSkus();
    if (simpleProductSkus != null && !simpleProductSkus.isEmpty()) {
      optionModel.setSimpleProductSku(simpleProductSkus.get(0));
    }

    return optionModel;
  }
}

