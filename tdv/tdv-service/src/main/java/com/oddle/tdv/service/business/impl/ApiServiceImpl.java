package com.oddle.tdv.service.business.impl;

import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.db.sql.model.Weather;
import com.oddle.tdv.service.business.ApiService;
import com.oddle.tdv.storage.db.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ApiServiceImpl implements ApiService{
    @Autowired
    private CityRepository cityRepo;

    @Override
    public Optional<Weather> get(long id) {
       // return Optional.of(new Weather());
        Optional<City> optional = cityRepo.findById(id);
        return (optional.isPresent() && optional.get().getWeather() != null) ? Optional.of(optional.get().getWeather()) : Optional.empty();
    }
}
