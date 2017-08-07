package com.oddle.tdv.service.business.impl;

import com.oddle.tdv.service.business.CityService;
import com.oddle.tdv.communication.request.CityRequest;
import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.storage.db.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepo;

    @Override
    public long create(CityRequest request) {
        City city = new City();
        city.setName(request.getName());
        city.setNote(request.getNote());
        return cityRepo.save(city).getId();
    }
}
