package com.app.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.app.presentation.R;
import com.app.presentation.internal.di.HasComponent;
import com.app.presentation.internal.di.components.AppComponent;
import com.app.presentation.internal.di.components.DaggerAppComponent;
import com.app.presentation.view.fragment.ItemsListFragment;

/**
 * Activity that shows size_button_selected list of Items.
 */
public class ItemListActivity extends BaseActivity
    implements HasComponent<AppComponent>, ItemsListFragment.ListListener {

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ItemListActivity.class);
  }

  private AppComponent appComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    setContentView(R.layout.activity_layout);

    this.initializeInjector();
    if (savedInstanceState == null) {
      addFragment(R.id.fragmentContainer, new ItemsListFragment());
    }
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

  @Override public void onItemClicked() {
    this.navigator.navigateToItemDetails(this);
  }
}
