package com.oddle.tdv.communication.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oddle.tdv.communication.base.Constant;

import java.util.Date;

public class WeatherResponse {
    private Long cityId;
    private String cityName;

    private float temperature;
    private String status;
    private float windy;
    private float humidity;
    private float pressure;

    @JsonFormat(pattern = Constant.DATE_TIME_FORMAT)
    private Date createDate;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getWindy() {
        return windy;
    }

    public void setWindy(float windy) {
        this.windy = windy;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
