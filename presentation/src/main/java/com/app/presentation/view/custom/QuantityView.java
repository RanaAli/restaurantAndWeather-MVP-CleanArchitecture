package com.app.presentation.view.custom;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.app.presentation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RanaAli on 8/21/17.
 */

public class QuantityView {
    private View view;

    protected @BindView(R.id.tv_quantity_minus)
    TextView tvQuantityMinus;
    protected @BindView(R.id.tv_quantity)
    TextView tvQuantity;
    protected @BindView(R.id.tv_quantity_plus)
    TextView tvQuantityPlus;

    private Integer count = 1;
    private Integer min = 1;
    private Integer max = 10;

    private QuantityListener quantityListener;

    public QuantityView(View view) {
        this.view = view;
        ButterKnife.bind(this, this.view);

        setup();
    }

    private void setup() {
        setQuantity();

        tvQuantityMinus.setOnClickListener(minusOnClickListener);
        tvQuantityPlus.setOnClickListener(plusOnClickListener);
    }

    @SuppressLint("SetTextI18n")
    private void setQuantity() {
        tvQuantity.setText(count.toString());
    }

    private View.OnClickListener plusOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (count < max) {
                count++;
                setQuantity();
                triggerCallback();
            }
        }
    };

    private View.OnClickListener minusOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (count > min) {
                count--;
                setQuantity();
                triggerCallback();
            }
        }
    };

    private void triggerCallback() {
        if (quantityListener != null) {
            quantityListener.onQuantityChanged(count);
        }
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void setQuantityListener(QuantityListener quantityListener) {
        this.quantityListener = quantityListener;
    }

    public interface QuantityListener {
        void onQuantityChanged(int quantity);
    }
}
