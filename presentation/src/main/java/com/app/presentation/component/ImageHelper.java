package com.app.presentation.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import com.app.presentation.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by RanaAli on 8/20/17.
 */

public class ImageHelper {

  private static final String TAG = "ImageHelper";

  public static void setImage(Context context, final String url, ImageView imageInto) {

    if (imageInto != null) {
      if (context != null && url != null) {
        Log.v(TAG, "Loading image: " + url);
        Glide.with(context).load(url).listener(new RequestListener<Drawable>() {
          @Override
          public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Drawable> target,
              boolean b) {
            Log.e(TAG, "Failed to load: " + url);
            return false;
          }

          @Override
          public boolean onResourceReady(Drawable drawable, Object o, Target<Drawable> target,
              DataSource dataSource, boolean b) {
            return false;
          }
        }).into(imageInto);
      } else {
        imageInto.setImageResource(R.drawable.ic_launcher);
        Log.e(TAG, "Skipped Loading image: " + url);
      }
    } else {
      Log.e(TAG, "ImageView is null" + url);
    }
  }
}
