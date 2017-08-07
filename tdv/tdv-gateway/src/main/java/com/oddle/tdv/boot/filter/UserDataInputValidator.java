package com.oddle.tdv.boot.filter;

import com.oddle.tdv.communication.request.UserRequest;
import org.springframework.stereotype.Component;

public class UserDataInputValidator {
    public boolean validateRegister(UserRequest request) {
        return true;
    }
}
