package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxResume;
import com.ccnu.scsx.model.ScsxResumeWithBLOBs;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScsxResumeMapper extends BaseMapper<ScsxResumeWithBLOBs> {

  ScsxResumeWithBLOBs selectByPrimaryKey(String id);

  int updateByPrimaryKeyWithBLOBs(ScsxResumeWithBLOBs record);

  String selectResumePathByUserId(@Param("userId") String userId);

  ScsxResumeWithBLOBs findResumeByUserId(@Param("userId") String userId);

}