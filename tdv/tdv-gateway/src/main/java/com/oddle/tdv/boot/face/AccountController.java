package com.oddle.tdv.boot.face;


import com.oddle.tdv.communication.base.OddleResponse;
import com.oddle.tdv.communication.request.UserRequest;
import com.oddle.tdv.communication.response.UserResponse;
import com.oddle.tdv.db.sql.model.OddUser;
import com.oddle.tdv.storage.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/acc")
public class AccountController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/register")
    public OddleResponse<Boolean> register(@RequestBody UserRequest request) {
        try {
            OddUser user = new OddUser();
            user.setCreatedDate(new Date());
            user.setLastUpdate(new Date());

            user.setUserName(request.getUserName());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setPassword(request.getPassword());
            userRepository.save(user);
            return OddleResponse.createSuccessResponse(true);
        } catch (Exception ex) {
            return OddleResponse.createSuccessResponse(false);
        }


    }

    @GetMapping(path = "/echo")
    public ResponseEntity<UserResponse> echo() {
        UserResponse response = new UserResponse();
        response.setId(1l);
        response.setEmail("trung");
        response.setPassword("12334");
        response.setPhone("0902121");
        response.setUserName("admin");

        return ResponseEntity.ok(response);
    }
}
