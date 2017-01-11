package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxFeedContact;

@Mapper
public interface ScsxFeedContactMapper extends BaseMapper<ScsxFeedContact> {

  ScsxFeedContact selectByPrimaryKey(String id);

}