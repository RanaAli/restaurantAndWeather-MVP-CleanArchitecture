package com.app.presentation.test.view.activity;

import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import com.app.presentation.R;
import com.app.presentation.view.activity.ItemListActivity;
import com.app.presentation.view.activity.StoriesListActivity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemListActivityTest extends ActivityInstrumentationTestCase2<ItemListActivity> {

  private static final String TITLE = "Item List";
  private ItemListActivity itemListActivity;

  public ItemListActivityTest() {
    super(ItemListActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    this.setActivityIntent(createTargetIntent());
    itemListActivity = getActivity();
  }

  @Override protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testContainsItemsListFragment() {
    Fragment itemListFragment =
        itemListActivity.getFragmentManager().findFragmentById(R.id.fragmentContainer);
    assertThat(itemListFragment, is(notNullValue()));
  }

  public void testContainsProperTitle() {
    String actualTitle = this.itemListActivity.getTitle().toString().trim();

    assertThat(actualTitle, is(TITLE));
  }

  private Intent createTargetIntent() {
    Intent intentLaunchActivity =
        ItemListActivity.getCallingIntent(getInstrumentation().getTargetContext());

    return intentLaunchActivity;
  }
}
