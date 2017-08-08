package com.oddle.tdv.service.business.impl;

import com.oddle.tdv.db.sql.model.Weather;
import com.oddle.tdv.service.business.ApiService;

import java.util.Optional;

public class ApiServiceImpl implements ApiService{
    @Override
    public Optional<Weather> get(long id) {
       // return Optional.of(new Weather());
        return Optional.empty();
    }
}
