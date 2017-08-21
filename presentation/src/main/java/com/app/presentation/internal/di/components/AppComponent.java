package com.app.presentation.internal.di.components;

import com.app.presentation.internal.di.PerActivity;
import com.app.presentation.internal.di.modules.ActivityModule;
import com.app.presentation.view.fragment.ItemDetailsFragment;
import com.app.presentation.view.fragment.ItemsListFragment;
import dagger.Component;

/**
 * A scope {@link PerActivity} component.
 * Injects Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class })
public interface AppComponent extends ActivityComponent {
  void inject(ItemsListFragment itemsListFragment);

  void inject(ItemDetailsFragment itemsDetailsFragment);
}
