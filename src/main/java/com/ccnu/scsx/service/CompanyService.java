package com.ccnu.scsx.service;

import com.ccnu.scsx.utils.UUIDUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccnu.scsx.dao.CompanyDao;
import com.ccnu.scsx.model.ScsxCompany;

/**
 * Create By Joban on2017年1月3日下午4:13:04
 */
@Service
public class CompanyService {

  @Autowired
  private CompanyDao companyDao;

  public void insertCompany(ScsxCompany company) {
    String id = UUIDUtils.getUUID();
    company.setId(id);
    companyDao.insertCompany(company);
  }

  public ScsxCompany getCompanyDetail(String company_id) {
    return companyDao.getCompanyDetail(company_id);
  }

  public String findNameById(@Param("companyId") String companyId) {
    return companyDao.findNameById(companyId);
  }

}

