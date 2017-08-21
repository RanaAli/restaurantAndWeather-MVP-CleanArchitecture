package com.app.data.entity.mapper;

import com.app.data.entity.response.search.ItemDetailsEntity;
import com.app.data.entity.response.search.SearchEntity;
import com.app.domain.model.ItemDetails;
import com.app.domain.model.SearchResult;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class) public class ItemEntityDataMapperTest {

  private ItemEntityDataMapper itemEntityDataMapper;

  @Before public void setUp() throws Exception {
    itemEntityDataMapper = new ItemEntityDataMapper();
  }

  @Test public void testTransformSearchEntity() {
    List<ItemDetailsEntity> itemDetailsEntities = new ArrayList<>();
    itemDetailsEntities.add(new ItemDetailsEntity());
    itemDetailsEntities.add(new ItemDetailsEntity());
    itemDetailsEntities.add(new ItemDetailsEntity());

    SearchEntity searchEntity = new SearchEntity();
    searchEntity.setHits(itemDetailsEntities);

    SearchResult result = itemEntityDataMapper.transform(searchEntity);

    assertThat(result, is(instanceOf(SearchResult.class)));
    assertThat(result.getItemDetails(), not(equals(null)));
    assertThat(result.getItemDetails().size(), is(3));
  }

  @Test public void testTransformItemDetailEntityCollection() {
    List<ItemDetailsEntity> itemDetailsEntities = new ArrayList<>();
    itemDetailsEntities.add(new ItemDetailsEntity());
    itemDetailsEntities.add(new ItemDetailsEntity());
    itemDetailsEntities.add(new ItemDetailsEntity());

    List<ItemDetails> itemDetailsList = itemEntityDataMapper.transform(itemDetailsEntities);

    assertThat(itemDetailsList, not(equals(null)));
    assertThat(itemDetailsList.size(), not(equals(0)));
    assertThat(itemDetailsList.size(), is(3));
    assertThat(itemDetailsList.get(0), is(instanceOf(ItemDetails.class)));
  }
}
