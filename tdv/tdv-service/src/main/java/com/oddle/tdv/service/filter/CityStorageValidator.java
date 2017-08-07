package com.oddle.tdv.service.filter;

import com.oddle.tdv.communication.base.EResponseCode;
import com.oddle.tdv.communication.base.SubCode;
import com.oddle.tdv.communication.code.CodeConst;
import com.oddle.tdv.communication.request.CityRequest;
import com.oddle.tdv.exception.OddleException;
import com.oddle.tdv.storage.db.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CityStorageValidator {
    @Autowired
    private CityRepository cityRepo;

    public boolean validateCreate(CityRequest request) {
        if (cityRepo.findByName(request.getName()).isPresent()) {
            throw new OddleException(EResponseCode.WRONG_DATA,
                    new SubCode(CodeConst.CODE_CITY_NAME_EXIST, String.format(CodeConst.MSG_CITY_NAME_EXIST, request.getName()))
            );
        }
        return true;
    }
}
