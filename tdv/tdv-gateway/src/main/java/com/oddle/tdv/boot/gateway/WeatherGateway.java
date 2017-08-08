package com.oddle.tdv.boot.gateway;

import com.oddle.tdv.communication.request.WeatherRequest;

public interface WeatherGateway {
    long save(WeatherRequest request);
}
