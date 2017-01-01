package com.ccnu.scsx.mapper;

import com.ccnu.scsx.model.ScsxResume;

public interface ScsxResumeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScsxResume record);

    int insertSelective(ScsxResume record);

    ScsxResume selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScsxResume record);

    int updateByPrimaryKey(ScsxResume record);
}