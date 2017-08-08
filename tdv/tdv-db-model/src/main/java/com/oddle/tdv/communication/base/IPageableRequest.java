package com.oddle.tdv.communication.base;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Created by trungdovan on 22/01/2017.
 */
public interface IPageableRequest {
    default int calculateFirstResult() {
        if (getPageNumber() <= 0)
            throw new IllegalArgumentException("pageNumber must be > 0, pageNumber = " + this.getPageNumber());
        if (getPageSize() <= 0)
            throw new IllegalArgumentException("pageSize must be > 0, pageSize = " + this.getPageSize());
        return (this.getPageNumber() - 1) * this.getPageSize();
    }

    Integer getPageSize();

    Integer getPageNumber();

    default Pageable convertToPageable() {
        return PageRequest.of(getPageNumber(), getPageSize());
    }
}
