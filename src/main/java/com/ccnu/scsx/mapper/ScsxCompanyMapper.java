package com.ccnu.scsx.mapper;

import com.ccnu.scsx.model.ScsxCompany;

public interface ScsxCompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScsxCompany record);

    int insertSelective(ScsxCompany record);

    ScsxCompany selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScsxCompany record);

    int updateByPrimaryKeyWithBLOBs(ScsxCompany record);

    int updateByPrimaryKey(ScsxCompany record);
}