package com.app.presentation.model.weather;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.presentation.R;
import com.app.presentation.component.ImageHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherDailyForecastView {

    private View view;

    @BindView(R.id.dayName)
    TextView dayTv;

    @BindView(R.id.dayMin)
    TextView minTv;

    @BindView(R.id.dayMax)
    TextView maxTv;

    @BindView(R.id.dayImage)
    ImageView imageView;

    public WeatherDailyForecastView(View view) {
        this.view = view;

        ButterKnife.bind(this, view);
    }

    public void setImage(String url) {
        ImageHelper.setImage(view.getContext(), url, imageView);
    }

    public void setData(DailyForecastUIModel uiModel) {
        dayTv.setText(uiModel.getDay());
        minTv.setText(String.format("%s", uiModel.getMin()));
        maxTv.setText(String.format("%s", uiModel.getMax()));
    }
}
