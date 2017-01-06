package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxContact;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScsxContactMapper extends BaseMapper<ScsxContact> {

  ScsxContact getContactByUserAndInfo(@Param("userId") String userId,
      @Param("infoId") String infoId);

}