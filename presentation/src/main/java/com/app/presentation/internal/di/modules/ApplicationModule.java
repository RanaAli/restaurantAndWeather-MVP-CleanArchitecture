package com.app.presentation.internal.di.modules;

import android.content.Context;
import com.app.data.executor.JobExecutor;
import com.app.data.repository.ItemsDataRepository;
import com.app.data.repository.RestaurantsDataRepository;
import com.app.domain.executor.PostExecutionThread;
import com.app.domain.executor.ThreadExecutor;
import com.app.domain.repository.ItemsRepository;
import com.app.domain.repository.RestaurantsRepository;
import com.app.presentation.AndroidApplication;
import com.app.presentation.UIThread;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton ItemsRepository provideItemsRepository(
      ItemsDataRepository itemsDataRepository) {
    return itemsDataRepository;
  }

  @Provides @Singleton RestaurantsRepository provideRestaurantsRepository(
          RestaurantsDataRepository restaurantsDataRepository) {
    return restaurantsDataRepository;
  }
}
