package com.oddle.tdv.boot.gateway;

import com.oddle.tdv.communication.base.PageableData;
import com.oddle.tdv.communication.response.WeatherResponse;

import java.util.List;
import java.util.Optional;

public interface ApiGateway {
    Optional<WeatherResponse> get(long id);

    List<WeatherResponse> search(PageableData<String> request);
}
