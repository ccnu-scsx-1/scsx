package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxCompany;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScsxCompanyMapper extends BaseMapper<ScsxCompany> {

  void deleteByPrimaryKey(String id);

  ScsxCompany selectByPrimaryKey(String id);

  void updateByPrimaryKeyWithBLOBs(ScsxCompany record);

  String findNameById(@Param("companyId") String companyId);

  ScsxCompany findByUserId(@Param("userId") String userId);

}