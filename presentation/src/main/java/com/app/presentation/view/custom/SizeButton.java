package com.app.presentation.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup.LayoutParams;
import com.app.presentation.R;

/**
 * Created by RanaAli on 8/20/17.
 */

public class SizeButton extends RadioButton {

  public static final int TEXT_SIZE = 10;

  public SizeButton(Context context) {
    super(context);

    setup();
  }

  public SizeButton(Context context, AttributeSet attrs) {
    super(context, attrs);

    setup();
  }

  public SizeButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    setup();
  }

  private void setup() {
    setBackgroundResource(R.drawable.selector_size_button);
    setButtonDrawable(android.R.color.transparent);
    setTextSize(TypedValue.COMPLEX_UNIT_SP, TEXT_SIZE);
    setTextColor(getResources().getColorStateList(R.color.selector_size_button_text));
    LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    params.setMargins(getResources().getDimensionPixelSize(R.dimen.layout_margin),
        getResources().getDimensionPixelSize(R.dimen.layout_margin),
        getResources().getDimensionPixelSize(R.dimen.layout_margin),
        getResources().getDimensionPixelSize(R.dimen.layout_margin));
    setLayoutParams(params);
  }
}
