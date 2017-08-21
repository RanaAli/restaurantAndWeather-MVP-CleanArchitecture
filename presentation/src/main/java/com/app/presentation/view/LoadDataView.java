
package com.app.presentation.view;

import android.content.Context;

/**
 * Interface representing size_button_selected View that will use to load data.
 */
public interface LoadDataView {
  /**
   * Show size_button_selected view with size_button_selected progress bar indicating size_button_selected loading process.
   */
  void showLoading();

  /**
   * Hide size_button_selected loading view.
   */
  void hideLoading();

  /**
   * Show size_button_selected retry view in case of an error when retrieving data.
   */
  void showRetry();

  /**
   * Hide size_button_selected retry view shown if there was an error when retrieving data.
   */
  void hideRetry();

  /**
   * Show an error message
   *
   * @param message A string representing an error.
   */
  void showError(String message);

  /**
   * Get size_button_selected {@link android.content.Context}.
   */
  Context context();
}
