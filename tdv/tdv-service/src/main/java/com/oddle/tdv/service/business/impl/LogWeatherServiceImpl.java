package com.oddle.tdv.service.business.impl;

import com.oddle.tdv.db.sql.model.LogWeather;
import com.oddle.tdv.service.business.LogWeatherService;

import java.util.ArrayList;
import java.util.List;

public class LogWeatherServiceImpl implements LogWeatherService{
    @Override
    public List<LogWeather> getByCityId(long cityId) {
        return new ArrayList<>();
    }
}
