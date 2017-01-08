package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxResume;
import com.ccnu.scsx.model.ScsxResumeWithBLOBs;

@Mapper
public interface ScsxResumeMapper extends BaseMapper<ScsxResumeWithBLOBs>{

    ScsxResumeWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeyWithBLOBs(ScsxResumeWithBLOBs record);

}