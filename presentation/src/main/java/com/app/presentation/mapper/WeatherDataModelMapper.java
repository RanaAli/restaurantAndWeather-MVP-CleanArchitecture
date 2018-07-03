package com.app.presentation.mapper;

import android.text.TextUtils;

import com.app.domain.model.weather.DailyForecastDTO;
import com.app.domain.model.weather.WeatherDTO;
import com.app.presentation.model.weather.DailyForecastUIModel;
import com.app.presentation.model.weather.WeatherUIModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

public class WeatherDataModelMapper {

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssz";
    public static final String DATA_DAY_FULL_NAME = "EEEE";
    public static final String DATA_DAY_FULL_HALF = "EEE";
    public static final String KM = " km";
    public static final String PERCENT = " %";

    @Inject
    public WeatherDataModelMapper() {
    }

    public WeatherUIModel map(WeatherDTO weatherDTO) {
        WeatherUIModel weatherUIModel = new WeatherUIModel();

        weatherUIModel.setHeadLine(weatherDTO.getHeadLine());
        weatherUIModel.setDay(getDay(weatherDTO.getDate(), DATA_DAY_FULL_NAME));


        ArrayList<DailyForecastUIModel> dailyForecastUIModels = new ArrayList<>();

        for (DailyForecastDTO dailyForecastDTO : weatherDTO.getDailyForecastDTOS()) {
            DailyForecastUIModel dailyForecastUIModel = new DailyForecastUIModel();

            dailyForecastUIModel.setDay(getDay(dailyForecastDTO.getDate(), DATA_DAY_FULL_HALF));
            dailyForecastUIModel.setMin(dailyForecastDTO.getMin());
            dailyForecastUIModel.setMax(dailyForecastDTO.getMax());
            dailyForecastUIModel.setWindSpeed(
                    dailyForecastDTO.getWindSpeed() + KM);
            dailyForecastUIModel.setHoursOfPrecipitation(
                    dailyForecastDTO.getHoursOfPrecipitation() + PERCENT);

            dailyForecastUIModels.add(dailyForecastUIModel);
        }

        weatherUIModel.setDailyForecastUIModels(dailyForecastUIModels);

        return weatherUIModel;
    }

    String getDay(String dateString, String returnDayFormat) {
        if (!TextUtils.isEmpty(dateString)) {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            Date startDate = null;
            try {
                startDate = df.parse(dateString);
                String newDateString = df.format(startDate);
                System.out.println(newDateString);


            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (startDate != null) {
                return new SimpleDateFormat(returnDayFormat, Locale.ENGLISH)
                        .format(startDate);
            }
        }
        return "";
    }
}
