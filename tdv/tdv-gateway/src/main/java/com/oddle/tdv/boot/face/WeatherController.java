package com.oddle.tdv.boot.face;

import com.oddle.tdv.boot.face.util.AbstractController;
import com.oddle.tdv.boot.gateway.WeatherGateway;
import com.oddle.tdv.communication.base.OddleResponse;
import com.oddle.tdv.communication.request.WeatherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/weather/")
public class WeatherController extends AbstractController {
    @Autowired
    private WeatherGateway weatherGateway;

    @PostMapping("/save")
    public OddleResponse<Long> save(@RequestBody WeatherRequest request) {
        return requestGW(request, weatherGateway::save);
    }

    @GetMapping("/echo")
    public WeatherRequest request() {
        WeatherRequest request = new WeatherRequest();
        request.setCityId(10L);
        request.setHumidity(20);
        request.setCreateDate(new Date());
        request.setNote("note");
        request.setPressure(10);
        request.setStatus("rainy");
        request.setTemperature(37);
        request.setWindy(3.4f);
        return request;
    }
}
