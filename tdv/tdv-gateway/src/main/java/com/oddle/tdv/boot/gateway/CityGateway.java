package com.oddle.tdv.boot.gateway;

import com.oddle.tdv.communication.request.CityRequest;

import java.util.Optional;

public interface CityGateway {
    long create(CityRequest request);

    boolean delete(long id);
}
