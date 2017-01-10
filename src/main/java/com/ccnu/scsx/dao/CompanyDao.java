package com.ccnu.scsx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccnu.scsx.dao.impl.BaseDaoImpl;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.mapper.ScsxCompanyMapper;
import com.ccnu.scsx.model.ScsxCompany;

/**
 * Create By Joban on2017年1月3日下午4:05:36
 */
@Repository
public class CompanyDao extends BaseDaoImpl<ScsxCompany> implements IBaseDao<ScsxCompany> {

  @Autowired
  private ScsxCompanyMapper companyMapper;

  @Override
  public BaseMapper<ScsxCompany> getMapper() {
    return companyMapper;
  }

  public void insertCompany(ScsxCompany company) {
    companyMapper.insertSelective(company);
  }

  public ScsxCompany getCompanyDetail(String company_id) {
    return companyMapper.selectByPrimaryKey(company_id);
  }

  public String findNameById(String companyId) {
    return companyMapper.findNameById(companyId);
  }

}

