package com.oddle.tdv.boot.face;

import com.oddle.tdv.boot.face.util.AbstractController;
import com.oddle.tdv.boot.gateway.ApiGateway;
import com.oddle.tdv.communication.base.OddleResponse;
import com.oddle.tdv.communication.base.PageableData;
import com.oddle.tdv.communication.base.PagingRequest;
import com.oddle.tdv.communication.response.WeatherResponse;
import com.oddle.tdv.storage.db.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public OddleResponse<List<WeatherResponse>> search(@RequestParam String name,
                                      @RequestParam(required = false) Integer pageNumber,
                                      @RequestParam(required = false) Integer pageSize
                                      ) {
        PageableData request = new PageableData<>(name, new PagingRequest(pageNumber, pageSize));
        return requestGW(request, apiGateway::search);
    }
}
