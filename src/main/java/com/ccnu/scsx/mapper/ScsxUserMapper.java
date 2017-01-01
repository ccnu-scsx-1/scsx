package com.ccnu.scsx.mapper;

import com.ccnu.scsx.model.ScsxUser;

public interface ScsxUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScsxUser record);

    int insertSelective(ScsxUser record);

    ScsxUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScsxUser record);

    int updateByPrimaryKey(ScsxUser record);
}