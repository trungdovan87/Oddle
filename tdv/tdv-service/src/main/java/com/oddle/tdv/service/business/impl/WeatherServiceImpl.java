package com.oddle.tdv.service.business.impl;

import com.oddle.tdv.communication.request.WeatherRequest;
import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.db.sql.model.Weather;
import com.oddle.tdv.service.business.WeatherService;
import com.oddle.tdv.storage.db.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private CityRepository cityRepo;

    @Override
    public long save(WeatherRequest request) {
        Weather weather = new Weather();
        City city = cityRepo.getOne(request.getCityId());
        city.setWeather(weather);
        weather.setCity(city);
        weather.setCreateDate(request.getCreateDate() != null ? request.getCreateDate() :new Date());
        weather.setHumidity(request.getHumidity());
        weather.setPressure(request.getPressure());
        weather.setNote(request.getNote());
        weather.setStatus(request.getStatus());
        weather.setTemperature(request.getTemperature());
        weather.setWindy(request.getWindy());
        return cityRepo.save(city).getId();
    }
}
