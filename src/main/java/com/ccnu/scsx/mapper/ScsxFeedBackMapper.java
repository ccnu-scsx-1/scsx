package com.ccnu.scsx.mapper;

import com.ccnu.scsx.model.ScsxFeedBack;

public interface ScsxFeedBackMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScsxFeedBack record);

    int insertSelective(ScsxFeedBack record);

    ScsxFeedBack selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScsxFeedBack record);

    int updateByPrimaryKeyWithBLOBs(ScsxFeedBack record);

    int updateByPrimaryKey(ScsxFeedBack record);
}