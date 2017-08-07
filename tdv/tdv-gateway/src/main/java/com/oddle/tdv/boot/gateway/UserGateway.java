package com.oddle.tdv.boot.gateway;

import com.oddle.tdv.communication.request.UserRequest;

public interface UserGateway {
    long register(UserRequest request);
}
