package com.oddle.tdv.service.business.impl;

import com.oddle.tdv.communication.request.WeatherRequest;
import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.db.sql.model.LogWeather;
import com.oddle.tdv.db.sql.model.Weather;
import com.oddle.tdv.service.business.WeatherService;
import com.oddle.tdv.storage.db.CityRepository;
import com.oddle.tdv.storage.db.LogWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private LogWeatherRepository logWeatherRepo;

    @Override
    public long save(WeatherRequest request) {
        Weather weather = new Weather();
        Optional<City> optional = cityRepo.findById(request.getCityId());
        if (optional.isPresent()) {
            City city = optional.get();
            city.setName(request.getCityName());
            city.setWeather(weather);
            weather.setCity(city);
            weather.setCreateDate(request.getCreateDate() != null ? request.getCreateDate() : new Date());
            weather.setHumidity(request.getHumidity());
            weather.setPressure(request.getPressure());
            weather.setNote(request.getNote());
            weather.setStatus(request.getStatus());
            weather.setTemperature(request.getTemperature());
            weather.setWindy(request.getWindy());
            Long id = cityRepo.save(city).getId();

            LogWeather log = new LogWeather();
            log.setCity(city);
            log.setCreateDate(request.getCreateDate() != null ? request.getCreateDate() : new Date());
            log.setHumidity(request.getHumidity());
            log.setPressure(request.getPressure());
            log.setNote(request.getNote());
            log.setStatus(request.getStatus());
            log.setTemperature(request.getTemperature());
            log.setWindy(request.getWindy());
            logWeatherRepo.save(log);

            return id;
        } else {
            return -1;
        }
    }
}
