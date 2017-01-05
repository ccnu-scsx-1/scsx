package com.ccnu.scsx.enu;

/**
 * Created by Joban on 2017/1/5.
 * 职位类型的Code
 */
public enum TypeCode {
  SOFTWARE(0, "软件"),
  BANK(1, "银行");

  private Integer code;
  private String description;

  private TypeCode(Integer code, String description) {
    this.code = code;
    this.description = description;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  // 普通方法
  public static String getDescByCode(int code) {
    for (TypeCode c : TypeCode.values()) {
      if (c.getCode() == code) {
        return c.description;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "TypeCode{" +
        "code=" + code +
        ", description='" + description + '\'' +
        '}';
  }
}
