package com.ccnu.scsx.enu;

public enum ErrorCode {
  failure(-1, "Unknown Server Error"), 
  suc(0, "Success"), 
  invalid_param(2, "parameter bind exception "),
  sign_failuare(3,"sign fail "),
  param_empty(4,"param empty exception "),
  not_login(5,"user not login");

  private Integer code;
  private String description;

  private ErrorCode(Integer code, String description) {
    this.code = code;
    this.description = description;
  }

  public Integer code() {
    return this.code;
  }

  public String description() {
    return this.description;
  }

  @Override
  public String toString() {
    return "ErrorCode{" + code + ", " + description + "}";
  }
  
  public static String nameToCode(String name){
    if (ErrorCode.suc.name().equals(name)) {
      return ErrorCode.suc.code().toString();
    } else if (ErrorCode.failure.name().equals(name)) {
      return ErrorCode.failure.code().toString();
    } else {
      return name;
    }
  }
}
