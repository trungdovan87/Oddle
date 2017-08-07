package com.oddle.tdv.boot.gateway;

import com.oddle.tdv.communication.request.CityRequest;

public interface CityGateway {
    long create(CityRequest request);
}
