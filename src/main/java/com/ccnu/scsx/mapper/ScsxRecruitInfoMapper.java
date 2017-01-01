package com.ccnu.scsx.mapper;

import com.ccnu.scsx.model.ScsxRecruitInfo;

public interface ScsxRecruitInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScsxRecruitInfo record);

    int insertSelective(ScsxRecruitInfo record);

    ScsxRecruitInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScsxRecruitInfo record);

    int updateByPrimaryKeyWithBLOBs(ScsxRecruitInfo record);

    int updateByPrimaryKey(ScsxRecruitInfo record);
}