package com.oddle.tdv;

import com.oddle.tdv.communication.request.UserRequest;

public interface UserService {
    long register(UserRequest request);
}
