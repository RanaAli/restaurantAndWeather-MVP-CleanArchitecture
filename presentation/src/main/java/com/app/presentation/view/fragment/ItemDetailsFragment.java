package com.app.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.presentation.R;
import com.app.presentation.internal.di.components.AppComponent;
import com.app.presentation.model.weather.DailyForecastUIModel;
import com.app.presentation.model.weather.WeatherDailyForecastView;
import com.app.presentation.model.weather.WeatherUIModel;
import com.app.presentation.presenter.ItemsDetailsPresenter;
import com.app.presentation.view.ItemDetailsView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Fragment that shows details of certain Item.
 */
public class ItemDetailsFragment extends BaseFragment implements ItemDetailsView {

    @Inject
    ItemsDetailsPresenter itemsDetailsPresenter;

    @BindView(R.id.rl_progress)
    RelativeLayout rl_progress;

    @BindView(R.id.rl_retry)
    RelativeLayout rl_retry;

    @BindView(R.id.weatherText)
    TextView weatherText;

    @BindView(R.id.weatherDay)
    TextView weatherDay;

    @BindView(R.id.weatherTodayTemp)
    TextView todayTemp;

    @BindView(R.id.weatherWindSpeedValue)
    TextView windSpeed;

    @BindView(R.id.weatherPrecipitationValue)
    TextView precipitationValue;

    ArrayList<WeatherDailyForecastView> dailyForecastViews;

    private Unbinder unbinder;

    public static ItemDetailsFragment forItem() {
        final ItemDetailsFragment itemsDetailsFragment = new ItemDetailsFragment();
        return itemsDetailsFragment;
    }

    public ItemDetailsFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(AppComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater
                .inflate(R.layout.fragment_item_detail, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.itemsDetailsPresenter.setView(this);

        dailyForecastViews = new ArrayList<>();

        dailyForecastViews.add(
                new WeatherDailyForecastView(view.findViewById(R.id.weatherDailtyForecastView1)));
        dailyForecastViews.add(
                new WeatherDailyForecastView(view.findViewById(R.id.weatherDailtyForecastView2)));
        dailyForecastViews.add(
                new WeatherDailyForecastView(view.findViewById(R.id.weatherDailtyForecastView3)));
        dailyForecastViews.add(
                new WeatherDailyForecastView(view.findViewById(R.id.weatherDailtyForecastView4)));
        dailyForecastViews.add(
                new WeatherDailyForecastView(view.findViewById(R.id.weatherDailtyForecastView5)));

        if (savedInstanceState == null) {
            this.loadItemDetails();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.itemsDetailsPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.itemsDetailsPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.itemsDetailsPresenter.destroy();
    }

    @Override
    public void populate(WeatherUIModel weatherUIModel) {
        if (weatherUIModel != null) {
            weatherText.setText(weatherUIModel.getHeadLine());
            weatherDay.setText(weatherUIModel.getDay());

            List<DailyForecastUIModel>
                    dailyForecastUIModels = weatherUIModel.getDailyForecastUIModels();

            for (int count = 0; count < dailyForecastUIModels.size(); count++) {

                if (count == 1) {
                    DailyForecastUIModel dailyForecastUIModel = dailyForecastUIModels.get(count);
                    todayTemp.setText(String.format("%s", dailyForecastUIModel.getMax()));
                    windSpeed.setText(dailyForecastUIModel.getWindSpeed());
                    precipitationValue.setText(dailyForecastUIModel.getHoursOfPrecipitation());
                }

                dailyForecastViews.get(count).setData(dailyForecastUIModels.get(count));
            }

        }
    }

    @Override
    public void showLoading() {
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    /**
     * Load Item details.
     */
    private void loadItemDetails() {
        if (this.itemsDetailsPresenter != null) {
            this.itemsDetailsPresenter.initialize();
        }
    }

    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        ItemDetailsFragment.this.loadItemDetails();
    }
}
