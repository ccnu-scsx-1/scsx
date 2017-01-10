package com.ccnu.scsx.vo;

/**
 * Created by Joban on 2017/1/10.
 */
public class InfoAndUserDto {

  private Object infoId;
  private Object title;

  private String username;

  public Object getInfoId() {
    return infoId;
  }

  public void setInfoId(Object infoId) {
    this.infoId = infoId;
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

  public void setTitle(Object title) {
    this.title = title;
  }

  public static InfoAndUserDto build(Object infoId, Object title, String username) {
    InfoAndUserDto infoAndUserDto = new InfoAndUserDto();
    infoAndUserDto.setTitle(title);
    infoAndUserDto.setInfoId(infoId);
    infoAndUserDto.setUsername(username);
    return infoAndUserDto;
  }

}
