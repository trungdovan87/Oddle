package com.oddle.tdv.boot.gateway;

import com.oddle.tdv.communication.response.WeatherResponse;

import java.util.Optional;

public interface ApiGateway {
    Optional<WeatherResponse> get(long id);
}
