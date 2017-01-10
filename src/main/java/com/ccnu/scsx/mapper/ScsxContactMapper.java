package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxContact;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScsxContactMapper extends BaseMapper<ScsxContact> {

  ScsxContact getContactByUserAndInfo(@Param("userId") String userId,
      @Param("infoId") String infoId);

  List<String> selectInfoByUserId(@Param("userId") String userId);

  List<String> selectUserByinfoId(@Param("infoId") String infoId);

}