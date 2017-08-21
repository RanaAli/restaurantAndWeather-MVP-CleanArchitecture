package com.app.presentation.test.view.activity;

import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import com.app.presentation.R;
import com.app.presentation.view.activity.ItemDetailsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class ItemDetailsActivityTest extends ActivityInstrumentationTestCase2<ItemDetailsActivity> {

  public static final String TITLE = "Item Details";
  private ItemDetailsActivity itemDetailsActivity;

  public ItemDetailsActivityTest() {
    super(ItemDetailsActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    this.setActivityIntent(createTargetIntent());
    this.itemDetailsActivity = getActivity();
  }

  @Override protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testContainsDetailsFragment() {
    Fragment itemDetailsFragment =
        itemDetailsActivity.getFragmentManager().findFragmentById(R.id.fragmentContainer);
    assertThat(itemDetailsFragment, is(notNullValue()));
  }

  public void testContainsProperTitle() {
    String actualTitle = this.itemDetailsActivity.getTitle().toString().trim();

    assertThat(actualTitle, is(TITLE));
  }

  public void testLoadViews() {
    onView(withId(R.id.imageViewPager)).check(matches(isDisplayed()));

    onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
    onView(withId(R.id.rl_retry)).check(matches(not(isDisplayed())));
    onView(withId(R.id.bt_retry)).check(matches(not(isDisplayed())));
  }

  private Intent createTargetIntent() {
    Intent intentLaunchActivity =
        ItemDetailsActivity.getCallingIntent(getInstrumentation().getTargetContext());

    return intentLaunchActivity;
  }
}
