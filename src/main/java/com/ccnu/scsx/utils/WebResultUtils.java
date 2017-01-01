package com.ccnu.scsx.utils;

import com.ccnu.scsx.api.WebResultData;
import com.ccnu.scsx.enu.ErrorCode;

public class WebResultUtils {
  public static WebResultData buildSucResult() {
    return buildResult(ErrorCode.suc);
  }

  public static WebResultData buildFailureResult() {
    return buildResult(ErrorCode.failure);
  }
  
  public static WebResultData buildSucResult(Object data) {
    WebResultData webResultData = buildResult(ErrorCode.suc);
    webResultData.setData(data);
    return webResultData;
  }

  public static WebResultData buildResult(ErrorCode errorCode) {
    WebResultData webResultData = new WebResultData();
    webResultData.setStatus(errorCode.code().toString());
    webResultData.setMsg(errorCode.description());
    return webResultData;
  }
}
