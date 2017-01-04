package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxCompany;

@Mapper
public interface ScsxCompanyMapper extends BaseMapper<ScsxCompany>{
    void deleteByPrimaryKey(String id);

    ScsxCompany selectByPrimaryKey(String id);

    void updateByPrimaryKeyWithBLOBs(ScsxCompany record);

}