package com.oddle.tdv.boot.face.util;

import com.oddle.tdv.communication.base.EResponseCode;
import com.oddle.tdv.communication.base.OddleResponse;
import com.oddle.tdv.communication.base.SubCode;
import com.oddle.tdv.communication.code.CodeConst;
import com.oddle.tdv.exception.OddleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    protected <T, R> OddleResponse<R> requestGW(T request, FunctionalGateway<T, R> runner) {
        try {
            R result = runner.apply(request);
            return OddleResponse.createSuccessResponse(result);
        } catch (OddleException ex) {
            return OddleResponse.createErrorResponse(ex.getCode(), ex.getSubCode());
        } catch (Exception ex) {
            logger.warn("Unable to runGateway, request: " + request, ex);
            return OddleResponse.createErrorResponse(EResponseCode.UNKNOWN_ERROR,
                    new SubCode(CodeConst.CODE_UNKNOWN_ERR,"failure: exception: " + ex.getClass().getName() + ", message: " + ex.getMessage())
            );
        }
    }

    protected <T, R> OddleResponse<R> requestGW(T request, OptionalGateway<T, R> runner) {
        try {
            Optional<R> result = runner.apply(request);
            return OddleResponse.createSuccessResponse(result.orElse(null));
        } catch (OddleException ex) {
            return OddleResponse.createErrorResponse(ex.getCode(), ex.getSubCode());
        } catch (Exception ex) {
            logger.warn("Unable to runGateway, request: " + request, ex);
            return OddleResponse.createErrorResponse(EResponseCode.UNKNOWN_ERROR,
                    new SubCode(CodeConst.CODE_UNKNOWN_ERR,"failure: type: " + ex.getClass().getName() + ", message: " + ex.getMessage())
            );
        }
    }
}
