package com.app.presentation.test.mapper;

import com.app.domain.model.ItemDetails;
import com.app.domain.model.SearchResult;
import com.app.presentation.mapper.ItemsModelDataMapper;
import com.app.presentation.model.SearchResultModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class) public class ItemsModelDataMapperTest {

  private ItemsModelDataMapper itemsModelDataMapper;

  @Before public void setUp() throws Exception {
    itemsModelDataMapper = new ItemsModelDataMapper();
  }

  @Test public void testTransformSearchResult() {
    SearchResult searchResult = new SearchResult();
    List<ItemDetails> itemDetails = new ArrayList<>();
    itemDetails.add(new ItemDetails());
    itemDetails.add(new ItemDetails());
    itemDetails.add(new ItemDetails());
    searchResult.setItemDetails(itemDetails);

    SearchResultModel searchResultModel = itemsModelDataMapper.transform(searchResult);

    assertThat(searchResultModel, is(instanceOf(SearchResultModel.class)));
    assertThat(searchResultModel.getItemDetails().size(), is(3));
  }
}
