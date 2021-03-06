package com.app.presentation.model.weather;

public class DailyForecastUIModel {
    private Double min;
    private Double max;
    private String day;
    private String imageURL;
    private String windSpeed;
    private String HoursOfPrecipitation;

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getHoursOfPrecipitation() {
        return HoursOfPrecipitation;
    }

    public void setHoursOfPrecipitation(String hoursOfPrecipitation) {
        HoursOfPrecipitation = hoursOfPrecipitation;
    }
}
