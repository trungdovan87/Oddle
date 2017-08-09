package com.oddle.tdv.service.business;

import com.oddle.tdv.communication.request.CityRequest;

public interface CityService {
    long create(CityRequest request);

    boolean delete(long id);
}
