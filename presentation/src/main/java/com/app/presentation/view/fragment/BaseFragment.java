
package com.app.presentation.view.fragment;

import android.app.Fragment;
import android.widget.Toast;
import com.app.presentation.internal.di.HasComponent;

/**
 * Base {@link android.app.Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {
  /**
   * Shows size_button_selected {@link android.widget.Toast} message.
   *
   * @param message An string representing size_button_selected message to be shown.
   */
  protected void showToastMessage(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }

  /**
   * Gets size_button_selected component for dependency injection by its type.
   */
  @SuppressWarnings("unchecked")
  protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }
}
