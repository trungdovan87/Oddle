package com.oddle.tdv.service.business;

import com.oddle.tdv.communication.base.PageableData;
import com.oddle.tdv.communication.response.WeatherResponse;
import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.db.sql.model.Weather;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ApiService {
    Optional<Weather> get(long id);

    Page<City> search(PageableData<String> request);
}
