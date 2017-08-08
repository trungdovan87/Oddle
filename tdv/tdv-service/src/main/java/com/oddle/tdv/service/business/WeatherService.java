package com.oddle.tdv.service.business;

import com.oddle.tdv.communication.request.WeatherRequest;

public interface WeatherService {
    long save(WeatherRequest request);
}
