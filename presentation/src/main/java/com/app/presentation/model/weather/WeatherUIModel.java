package com.app.presentation.model.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherUIModel {
    private String headLine = "";
    private String day = "";

    private List<DailyForecastUIModel> dailyForecastUIModels = new ArrayList<>();

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<DailyForecastUIModel> getDailyForecastUIModels() {
        return dailyForecastUIModels;
    }

    public void setDailyForecastUIModels(List<DailyForecastUIModel> dailyForecastUIModels) {
        this.dailyForecastUIModels = dailyForecastUIModels;
    }
}
