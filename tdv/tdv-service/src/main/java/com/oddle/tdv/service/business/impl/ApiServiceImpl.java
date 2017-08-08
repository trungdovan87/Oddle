package com.oddle.tdv.service.business.impl;

import com.oddle.tdv.communication.base.PageableData;
import com.oddle.tdv.communication.response.WeatherResponse;
import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.db.sql.model.Weather;
import com.oddle.tdv.service.business.ApiService;
import com.oddle.tdv.storage.db.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Optional;

public class ApiServiceImpl implements ApiService{
    @Autowired
    private CityRepository cityRepo;

    @Override
    public Optional<Weather> get(long id) {
        Optional<City> optional = cityRepo.findById(id);
        return (optional.isPresent() && optional.get().getWeather() != null) ? Optional.of(optional.get().getWeather()) : Optional.empty();
    }

    @Override
    public Page<City> search(PageableData<String> request) {
        return cityRepo.searchByName(request.getData(), request.getPageable().convertToPageable());
    }
}
