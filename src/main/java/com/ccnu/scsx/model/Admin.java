package com.ccnu.scsx.model;

import java.util.Date;

public class Admin{
  
  private Long id;
  private String email;
  private String password;
  private Date create_time;
  private Date last_modify;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }

  public Date getLast_modify() {
    return last_modify;
  }

  public void setLast_modify(Date last_modify) {
    this.last_modify = last_modify;
  }

}
