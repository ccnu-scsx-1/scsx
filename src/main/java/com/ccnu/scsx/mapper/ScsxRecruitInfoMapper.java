package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxRecruitInfo;
import java.util.List;

@Mapper
public interface ScsxRecruitInfoMapper extends BaseMapper<ScsxRecruitInfo> {

  List<ScsxRecruitInfo> getInfoList(@Param("offset") int offset, @Param("limit") int limit);

  List<ScsxRecruitInfo> getInfoListByTitle(@Param("offset") int offset, @Param("limit") int limit,
      @Param("title") String title);

  List<Map<String, Object>> getUserIntentionList(@Param("user_id") String user_id);

  List<ScsxRecruitInfo> getInfoListByInfoIds(@Param("list") List<String> infoIds);

  /*List<ScsxRecruitInfo> getListByUserIdAndInfoIds(@Param("user_id") String user_id,
      @Param("list") List<String> infoIds);*/

}
