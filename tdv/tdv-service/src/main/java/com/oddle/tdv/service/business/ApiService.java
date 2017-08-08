package com.oddle.tdv.service.business;

import com.oddle.tdv.db.sql.model.Weather;

import java.util.Optional;

public interface ApiService {
    Optional<Weather> get(long id);
}
