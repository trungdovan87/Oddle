package com.oddle.tdv.boot.face;

import com.oddle.tdv.boot.face.util.AbstractController;
import com.oddle.tdv.boot.gateway.CityGateway;
import com.oddle.tdv.communication.base.OddleResponse;
import com.oddle.tdv.communication.request.CityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/city")
public class CityController extends AbstractController{
    @Autowired
    private CityGateway cityGateway;

    @PostMapping("/create")
    public OddleResponse<Long> create(@RequestBody CityRequest request) {
        return requestGW(request, cityGateway::create);
    }
}
