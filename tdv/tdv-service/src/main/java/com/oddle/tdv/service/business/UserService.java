package com.oddle.tdv.service.business;

import com.oddle.tdv.communication.request.UserRequest;

public interface UserService {
    long register(UserRequest request);
}
