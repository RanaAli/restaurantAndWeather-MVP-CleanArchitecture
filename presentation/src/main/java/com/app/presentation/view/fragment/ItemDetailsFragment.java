package com.app.presentation.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.presentation.R;
import com.app.presentation.internal.di.components.AppComponent;
import com.app.presentation.model.ItemDetailModel;
import com.app.presentation.model.OptionModel;
import com.app.presentation.model.weather.DailyForecastUIModel;
import com.app.presentation.model.weather.WeatherDailyForecastView;
import com.app.presentation.model.weather.WeatherUIModel;
import com.app.presentation.presenter.ItemsDetailsPresenter;
import com.app.presentation.view.ItemDetailsView;
import com.app.presentation.view.adapter.ImageViewPagerAdapter;
import com.app.presentation.view.custom.QuantityView;
import com.app.presentation.view.custom.SizeButton;

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

    private static final int FIRST_CHILD = 0;

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

    ArrayList<WeatherDailyForecastView> dailyForecastViews;

    private QuantityView quantityView;
    private ArrayList<SizeButton> sizeButtonList;
    private Unbinder unbinder;

    public static ItemDetailsFragment forItem() {
        final ItemDetailsFragment itemsDetailsFragment = new ItemDetailsFragment();
        return itemsDetailsFragment;
    }

    public ItemDetailsFragment() {
        setRetainInstance(true);
        sizeButtonList = new ArrayList<>();
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

//        quantityView = new QuantityView(quantityLl);
//        viewPager.setPageMargin(-40);

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

    @SuppressLint("SetTextI18n")
    @Override
    public void renderItemDetails(ItemDetailModel itemDetailModel, List<OptionModel> options,
                                  RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        if (itemDetailModel != null) {
//            tv_title.setText(itemDetailModel.getTitle());
//            tv_price.setText(itemDetailModel.getMinPrice().toString());
//            tv_oldPrice.setText(itemDetailModel.getPrice().toString());
//
//            setImages(itemDetailModel);
//
//            radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
//            addSizeOptions(options);
        }
    }

    @Override
    public void populate(WeatherUIModel weatherUIModel) {
        if (weatherUIModel != null) {
            weatherText.setText(weatherUIModel.getHeadLine());
            weatherDay.setText(weatherUIModel.getDay());

            List<DailyForecastUIModel>
                    dailyForecastUIModels = weatherUIModel.getDailyForecastUIModels();

            for (int count = 0; count < dailyForecastUIModels.size(); count++) {
                if(count == 1){
                    todayTemp.setText(dailyForecastUIModels.get(count).getMax() + "");
                }
                dailyForecastViews.get(count).setData(dailyForecastUIModels.get(count));
            }

        }
    }

    private void setImages(ItemDetailModel itemDetailModel) {
        List<String> images = itemDetailModel.getImages();
        if (images != null && !images.isEmpty()) {
            ImageViewPagerAdapter imageViewPagerAdapter =
                    new ImageViewPagerAdapter(getActivity().getApplicationContext());
            imageViewPagerAdapter.setImages(images);
//            viewPager.setAdapter(imageViewPagerAdapter);
        }
    }

    @Override
    public void disableRadioButton(int position) {
        SizeButton sizeButton = sizeButtonList.get(position);
        sizeButton.setEnabled(false);
    }

    @Override
    public void enableRadioButton(int position) {
        SizeButton sizeButton = sizeButtonList.get(position);
        sizeButton.setEnabled(true);
    }

    @Override
    public void setProductID(String id) {
//        tv_idValue.setText(id);
    }

    @Override
    public void setQuantityChangeListener(QuantityView.QuantityListener quantityChangeListener) {
        quantityView.setQuantityListener(quantityChangeListener);
    }

    @Override
    public void setMaxQuantity(int max) {
        quantityView.setMax(max);
    }

    private void addSizeOptions(List<OptionModel> options) {
        for (int count = 0; count < options.size(); count++) {
            OptionModel optionModel = options.get(count);
            SizeButton sizeButton = new SizeButton(getActivity().getApplicationContext());
            sizeButton.setText(optionModel.getLabel());
            sizeButton.setEnabled(optionModel.getInStock());
            sizeButton.setId(count);

            sizeButtonList.add(sizeButton);
//            radioGroup.addView(sizeButton);
        }
//        radioGroup.check((radioGroup.getChildAt(FIRST_CHILD)).getId());
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
