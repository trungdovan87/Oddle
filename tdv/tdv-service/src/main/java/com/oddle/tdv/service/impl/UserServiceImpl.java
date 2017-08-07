package com.oddle.tdv.service.impl;

import com.oddle.tdv.communication.request.UserRequest;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl {

   public long register(UserRequest request) {
        return 101;
    }
}
