package com.oddle.tdv.service.business;

import com.oddle.tdv.communication.request.WeatherRequest;
import com.oddle.tdv.db.sql.model.LogWeather;

import java.util.List;

public interface LogWeatherService {
    List<LogWeather> getByCityId(long cityId);
}
