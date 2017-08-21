
package com.app.presentation.internal.di;

/**
 * Interface representing contract for clients that contains component for dependency injection.
 */
public interface HasComponent<C> {
  C getComponent();
}
