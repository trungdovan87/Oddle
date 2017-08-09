package com.oddle.tdv.service.business.impl;

import com.oddle.tdv.db.sql.model.LogWeather;
import com.oddle.tdv.service.business.LogWeatherService;
import com.oddle.tdv.storage.db.LogWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

public class LogWeatherServiceImpl implements LogWeatherService{
    @Autowired
    private LogWeatherRepository logRepo;

    @Override
    public List<LogWeather> getByCityId(long cityId) {
        return logRepo.getByCityId(cityId, PageRequest.of(0, 1000)).stream().collect(Collectors.toList());
    }

    @Override
    public boolean delete(long id) {
        logRepo.deleteById(id);
        return true;
    }
}
