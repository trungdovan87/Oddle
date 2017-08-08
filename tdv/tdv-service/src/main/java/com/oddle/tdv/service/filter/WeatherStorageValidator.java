package com.oddle.tdv.service.filter;

import com.oddle.tdv.communication.base.EResponseCode;
import com.oddle.tdv.communication.base.SubCode;
import com.oddle.tdv.communication.code.CodeConst;
import com.oddle.tdv.communication.request.WeatherRequest;
import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.exception.OddleException;
import com.oddle.tdv.storage.db.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class WeatherStorageValidator {
    @Autowired
    private CityRepository cityRepo;

    public boolean validateSave(WeatherRequest request) {

        Optional<City> optional = cityRepo.findById(request.getCityId());
        if (!optional.isPresent()) {
            throw new OddleException(EResponseCode.WRONG_DATA,
                    new SubCode(CodeConst.CODE_CITY_ID_IS_NULL,
                            String.format(CodeConst.MSG_CITY_ID_IS_NOT_EXIST, request.getCityId())
                    ));
        }
        return true;
    }
}
