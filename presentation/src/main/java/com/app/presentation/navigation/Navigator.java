package com.app.presentation.navigation;

import android.content.Context;
import android.content.Intent;
import com.app.presentation.view.activity.ItemDetailsActivity;
import com.app.presentation.view.activity.ItemListActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton public class Navigator {

  @Inject public Navigator() {
    //empty
  }

  /**
   * Goes to the Items list screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToItemsList(Context context) {
    if (context != null) {
      Intent intentToLaunch = ItemListActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the details screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToItemDetails(Context context) {
    if (context != null) {
      Intent intentToLaunch = ItemDetailsActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }
}
