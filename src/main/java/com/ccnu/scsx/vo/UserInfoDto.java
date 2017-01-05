package com.ccnu.scsx.vo;

import com.ccnu.scsx.enu.PositionCode;
import com.ccnu.scsx.enu.RoleCode;
import com.ccnu.scsx.model.ScsxUser;

/**
*Create By Joban on2017年1月3日下午7:12:51
*/
public class UserInfoDto {

  private String name;
  
  private String email;
  
  private String gender;

  private int age;

  private String number;
  
  private String position;

  private String role;

  private String resumeId;

  private String infoId;

  private int yearWork;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getResumeId() {
    return resumeId;
  }

  public void setResumeId(String resumeId) {
    this.resumeId = resumeId;
  }

  public String getInfoId() {
    return infoId;
  }

  public void setInfoId(String infoId) {
    this.infoId = infoId;
  }

  public int getYearWork() {
    return yearWork;
  }

  public void setYearWork(int yearWork) {
    this.yearWork = yearWork;
  }
  
  public static UserInfoDto build(ScsxUser user) {
    UserInfoDto userInfoDto = new UserInfoDto();
    userInfoDto.setAge(user.getAge());
    userInfoDto.setEmail(user.getEmail());
    userInfoDto.setGender((user.getGender()==0)?"男":"女");
    userInfoDto.setName(user.getName());
    userInfoDto.setNumber(user.getNumber());
    userInfoDto.setPosition(PositionCode.getDescByCode(user.getPosition()));
    userInfoDto.setResumeId(user.getResumeId());
    userInfoDto.setRole(RoleCode.getDescByCode(user.getRole()));
    userInfoDto.setYearWork(user.getYearWork());
    userInfoDto.setInfoId(user.getInfoId());
    return userInfoDto;
  }
  
}

