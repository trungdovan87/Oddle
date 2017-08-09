package com.oddle.tdv.boot.gateway;

import com.oddle.tdv.communication.response.LogWeatherResponse;

import java.util.List;

public interface LogWeatherGateway {
    List<LogWeatherResponse> getByCityId(long cityId);
    boolean delete(long id);
}
