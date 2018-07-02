package com.app.presentation.internal.di.components;

import android.content.Context;
import com.app.domain.executor.PostExecutionThread;
import com.app.domain.executor.ThreadExecutor;
import com.app.domain.repository.ItemsRepository;
import com.app.domain.repository.RestaurantsRepository;
import com.app.domain.repository.WeatherRepository;
import com.app.presentation.internal.di.modules.ApplicationModule;
import com.app.presentation.view.activity.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class) public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  //Exposed to sub-graphs.
  Context context();

  ThreadExecutor threadExecutor();

  PostExecutionThread postExecutionThread();

  ItemsRepository itemsRepository();

  RestaurantsRepository restaurantsRepository();

  WeatherRepository weatherRepository();
}
