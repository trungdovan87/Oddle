package com.oddle.tdv.boot.face;

import com.oddle.tdv.boot.face.util.AbstractController;
import com.oddle.tdv.boot.gateway.LogWeatherGateway;
import com.oddle.tdv.boot.gateway.WeatherGateway;
import com.oddle.tdv.communication.base.OddleResponse;
import com.oddle.tdv.communication.request.WeatherRequest;
import com.oddle.tdv.communication.response.LogWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/log/")
public class LogWeatherController extends AbstractController {
    @Autowired
    private LogWeatherGateway logWeatherGateway;

    @GetMapping("/get-by-city-id")
    public OddleResponse<List<LogWeatherResponse>> getByCityId(@RequestParam long cityId) {
        return requestGW(cityId, logWeatherGateway::getByCityId);
    }
}
