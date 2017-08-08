package com.oddle.tdv.communication.base;

public class PageableData<T> {
    private IPageableRequest pageable;
    private T data;

    public PageableData(T data, IPageableRequest pageable) {
        this.data = data;
        this.pageable = pageable;
    }

    public IPageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(IPageableRequest pageable) {
        this.pageable = pageable;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
