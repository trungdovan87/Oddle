package com.oddle.tdv.gateway.face;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "/tools")
public class ToolController {
    @RequestMapping(path = "/encode")
    public ResponseEntity<String> encode(final @RequestParam String pass, final @RequestParam String salt) {
        Objects.nonNull(pass);
        Objects.nonNull(salt);
        return ResponseEntity.ok(pass + salt);
    }
}
