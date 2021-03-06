package com.ccnu.scsx.vo;

/**
 * Created by Joban on 2017/1/10.
 */
public class InfoAndUserDto {

  private Object userId;
  private Object title;
  private Object infoId;

  private String username;

  public Object getUserId() {
    return userId;
  }

  public void setUserId(Object userId) {
    this.userId = userId;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public Object getTitle() {
    return title;
  }

  public Object getInfoId() {
    return infoId;
  }

  public void setInfoId(Object infoId) {
    this.infoId = infoId;
  }

  public void setTitle(Object title) {
    this.title = title;
  }

  public static InfoAndUserDto build(Object userId, Object title, String username, Object infoId) {
    InfoAndUserDto infoAndUserDto = new InfoAndUserDto();
    infoAndUserDto.setTitle(title);
    infoAndUserDto.setUserId(userId);
    infoAndUserDto.setUsername(username);
    infoAndUserDto.setInfoId(infoId);
    return infoAndUserDto;
  }

}
