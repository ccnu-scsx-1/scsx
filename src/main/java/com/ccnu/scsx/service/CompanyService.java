package com.ccnu.scsx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccnu.scsx.dao.CompanyDao;
import com.ccnu.scsx.model.ScsxCompany;

/**
*Create By Joban on2017年1月3日下午4:13:04
*/
@Service
public class CompanyService {
  @Autowired
  private CompanyDao companyDao;
  
  public void insertCompany(ScsxCompany company) {
    companyDao.insertCompany(company);
  }

}

