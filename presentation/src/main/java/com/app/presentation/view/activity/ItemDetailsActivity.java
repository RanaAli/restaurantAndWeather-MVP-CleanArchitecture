package com.app.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.app.presentation.R;
import com.app.presentation.internal.di.HasComponent;
import com.app.presentation.internal.di.components.AppComponent;
import com.app.presentation.internal.di.components.DaggerAppComponent;
import com.app.presentation.view.fragment.ItemDetailsFragment;

/**
 * Activity that shows details of size_button_selected certain Item.
 */
public class ItemDetailsActivity extends BaseActivity implements HasComponent<AppComponent> {

  public static Intent getCallingIntent(Context context) {
    Intent callingIntent = new Intent(context, ItemDetailsActivity.class);
    return callingIntent;
  }

  private AppComponent appComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    setContentView(R.layout.activity_layout);

    this.initializeActivity();
    this.initializeInjector();
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  /**
   * Initializes this activity.
   */
  private void initializeActivity() {
    addFragment(R.id.fragmentContainer, ItemDetailsFragment.forItem());
  }

  private void initializeInjector() {
    this.appComponent = DaggerAppComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  @Override public AppComponent getComponent() {
    return appComponent;
  }
}
