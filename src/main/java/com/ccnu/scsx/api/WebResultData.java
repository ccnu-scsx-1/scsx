package com.ccnu.scsx.api;

public class WebResultData {
  public static final int UNCOMPRESS = 0, COMPRESS = 1;
  private String status;
  private String msg;
  private Object data;

  public WebResultData() {}

  public WebResultData(String status) {
    this.status = status;
  }

  public WebResultData(String status, Object data) {
    this.status = status;
    this.data = data;
  }

  public WebResultData(String status, String msg, Object data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

}
