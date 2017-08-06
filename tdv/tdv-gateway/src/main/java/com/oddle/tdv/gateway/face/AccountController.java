package com.oddle.tdv.gateway.face;


import com.oddle.tdv.communication.base.OddleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/acc")
public class AccountController {
    @RequestMapping(path = "/register")
    public ResponseEntity<OddleResponse<Boolean>> register(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        return ResponseEntity.ok(OddleResponse.createSuccessResponse(false));
    }
}
