
package com.app.presentation.view;

import android.content.Context;

/**
 * Interface representing View that will use to load data.
 */
public interface LoadDataView {
  /**
   * Show  view with  progress bar indicating  loading process.
   */
  void showLoading();

  /**
   * Hide  loading view.
   */
  void hideLoading();

  /**
   * Show  retry view in case of an error when retrieving data.
   */
  void showRetry();

  /**
   * Hide  retry view shown if there was an error when retrieving data.
   */
  void hideRetry();

  /**
   * Show an error message
   *
   * @param message A string representing an error.
   */
  void showError(String message);

  /**
   * Get  {@link android.content.Context}.
   */
  Context context();
}
