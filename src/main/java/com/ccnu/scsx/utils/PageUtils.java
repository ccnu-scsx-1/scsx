package com.ccnu.scsx.utils;

/**
 * Created by Joban on 2017/1/4.
 */
public class PageUtils {

  private int pageSize = 10;
  private int pageNum;
  private int offset;

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getOffsetByPageNum(int PageNum) {
    return (PageNum - 1) * 10;
  }

}
