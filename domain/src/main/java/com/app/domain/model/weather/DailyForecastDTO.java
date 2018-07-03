package com.app.domain.model.weather;

public class DailyForecastDTO {
    private Double min;
    private Double max;
    private String date;
    private String imageUrl;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
