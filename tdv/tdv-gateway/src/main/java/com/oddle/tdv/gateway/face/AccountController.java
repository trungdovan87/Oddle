package com.oddle.tdv.gateway.face;


import com.oddle.tdv.communication.base.OddleResponse;
import com.oddle.tdv.storage.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/acc")
public class AccountController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/register")
    public ResponseEntity<OddleResponse<Boolean>> register() {

        return ResponseEntity.ok(OddleResponse.createSuccessResponse(false));
    }
}
