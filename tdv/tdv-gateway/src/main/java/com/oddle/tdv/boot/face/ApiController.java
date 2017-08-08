package com.oddle.tdv.boot.face;

import com.oddle.tdv.boot.face.util.AbstractController;
import com.oddle.tdv.boot.gateway.ApiGateway;
import com.oddle.tdv.communication.base.OddleResponse;
import com.oddle.tdv.communication.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class ApiController extends AbstractController {
    @Autowired
    private ApiGateway apiGateway;

    @GetMapping("/get")
    public OddleResponse<WeatherResponse> get(@RequestParam long cityId) {
        return requestGW(cityId, apiGateway::get);
    }
}
