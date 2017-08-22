
package com.app.presentation.exception;

import android.content.Context;
import com.app.data.exception.NetworkConnectionException;
import com.app.data.exception.NotFoundException;
import com.app.presentation.R;

/**
 * Factory used to create error messages from an Exception as condition.
 */
public class ErrorMessageFactory {

  private ErrorMessageFactory() {
    //empty
  }

  /**
   * Creates String representing an error message.
   *
   * @param context Context needed to retrieve string resources.
   * @param exception An exception used as condition to retrieve the correct error message.
   * @return {@link String} an error message.
   */
  public static String create(Context context, Exception exception) {
    String message = context.getString(R.string.exception_message_generic);

    if (exception instanceof NetworkConnectionException) {
      message = context.getString(R.string.exception_message_no_connection);
    } else if (exception instanceof NotFoundException) {
      message = context.getString(R.string.exception_message_not_found);
    }

    return message;
  }
}
