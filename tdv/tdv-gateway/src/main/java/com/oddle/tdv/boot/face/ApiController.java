package com.oddle.tdv.boot.face;

import com.oddle.tdv.boot.face.util.AbstractController;
import com.oddle.tdv.boot.gateway.ApiGateway;
import com.oddle.tdv.communication.base.OddleResponse;
import com.oddle.tdv.communication.response.WeatherResponse;
import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.storage.db.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class ApiController extends AbstractController {
    @Autowired
    private ApiGateway apiGateway;

    @Autowired
    private CityRepository cityRepo;

    @GetMapping("/get")
    public OddleResponse<WeatherResponse> get(@RequestParam long cityId) {
        return requestGW(cityId, apiGateway::get);
    }

    @GetMapping("/search")
    public OddleResponse<Long> search() {
        Page<City> page = cityRepo.searchByName("P", PageRequest.of(0, 10));
        System.out.println("size: " + page.getSize());
        page.forEach(city -> {
            System.out.println("city id : " + city.getId());
            System.out.println("city name : " + city.getName());
            System.out.println("-----");
        });
        return OddleResponse.createSuccessResponse(2L);
    }
}
