package com.ccnu.scsx.enu;

public enum ErrorCode {
  failure(-1, "Unknown Server Error"), 
  suc(0, "Success"), 
  invalid_param(2, "parameter bind exception "),
  sign_failuare(3,"sign fail "),
  param_empty(4,"参数为空异常"),
  not_login(5,"用户未登录"),
  user_exist(6,"该用户已存在!"),
  upload_faied(7,"上传简历失败!!!"),
  user_notExist(8,"用户不存在!"),
  already_submit(9,"该职位已经投递！！！"),
  login_error(10,"用户名或密码错误！！！")
  ;

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
