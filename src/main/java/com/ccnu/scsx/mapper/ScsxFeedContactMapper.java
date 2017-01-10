package com.ccnu.scsx.mapper;

import com.ccnu.scsx.model.ScsxFeedContact;

public interface ScsxFeedContactMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScsxFeedContact record);

    int insertSelective(ScsxFeedContact record);

    ScsxFeedContact selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScsxFeedContact record);

    int updateByPrimaryKey(ScsxFeedContact record);
}