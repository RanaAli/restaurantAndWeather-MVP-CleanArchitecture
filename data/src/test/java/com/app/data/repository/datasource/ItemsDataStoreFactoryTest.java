package com.app.data.repository.datasource;

import com.app.data.ApplicationTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemsDataStoreFactoryTest extends ApplicationTestCase {

  private ItemDataStoreFactory itemDataStoreFactory;

  @Before public void setUp() {
    itemDataStoreFactory = new ItemDataStoreFactory();
  }

  @Test public void testCreateCloudDataStore() {

    ItemsDataStore cloudDataStore = itemDataStoreFactory.createCloudDataStore();

    assertThat(cloudDataStore, is(notNullValue()));
    assertThat(cloudDataStore, is(instanceOf(CloudItemsDataStore.class)));
  }
}
