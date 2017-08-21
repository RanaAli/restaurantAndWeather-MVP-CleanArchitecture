package com.app.presentation.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.app.presentation.R;
import com.app.presentation.component.ImageHelper;
import java.util.List;

/**
 * Created by RanaAli on 8/21/17.
 */

public class ImageViewPagerAdapter extends PagerAdapter {
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private List<String> images;

  public ImageViewPagerAdapter(Context context) {
    mContext = context;
    mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  @Override public int getCount() {
    return images.size();
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return view == ((LinearLayout) object);
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    View itemView = mLayoutInflater.inflate(R.layout.image_pager_item, container, false);

    ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
    ImageHelper.setImage(mContext, images.get(position), imageView);

    container.addView(itemView);

    return itemView;
  }

  @Override public float getPageWidth(int position) {
    return 0.75f;
  }



  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((LinearLayout) object);
  }
}

