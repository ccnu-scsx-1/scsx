package com.ccnu.scsx.params;

import com.ccnu.scsx.model.ScsxCompany;
import com.ccnu.scsx.model.ScsxUser;

/**
*Create By Joban on2017年1月3日下午3:28:25
*/
public class RegisterParams {
  
  private ScsxCompany company;
  
  private ScsxUser user;

  public ScsxCompany getCompany() {
    return company;
  }

  public void setCompany(ScsxCompany company) {
    this.company = company;
  }

  public ScsxUser getUser() {
    return user;
  }

  public void setUser(ScsxUser user) {
    this.user = user;
  }
  

}

