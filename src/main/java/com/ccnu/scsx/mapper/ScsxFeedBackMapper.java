package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxFeedBack;

@Mapper
public interface ScsxFeedBackMapper extends BaseMapper<ScsxFeedBack> {

    ScsxFeedBack selectByPrimaryKey(String id);

}