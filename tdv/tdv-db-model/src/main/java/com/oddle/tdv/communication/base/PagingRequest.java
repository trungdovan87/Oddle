package com.oddle.tdv.communication.base;

/**
 * Created by trungdovan on 20/01/2017.
 */
public class PagingRequest implements IPageableRequest {
  private Integer pageNumber;
  private Integer pageSize;

  private static final Integer DEFAULT_PAGE_NUMBER = 0;
  private static final Integer DEFAULT_PAGE_SIZE = 20;

  public PagingRequest() {
  }

  public PagingRequest(Integer pageNumber, Integer pageSize) {
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
  }

  public Integer getPageNumber() {
    return pageNumber == null ? DEFAULT_PAGE_NUMBER : pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  @Override
  public Integer getPageSize() {
    return pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
}
