package com.app.domain.model.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherDTO {
    private String headLine = "";
    private String date = "";

    private List<DailyForecastDTO> dailyForecastDTOS = new ArrayList<>();

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public List<DailyForecastDTO> getDailyForecastDTOS() {
        return dailyForecastDTOS;
    }

    public void setDailyForecastDTOS(List<DailyForecastDTO> dailyForecastDTOS) {
        this.dailyForecastDTOS = dailyForecastDTOS;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
