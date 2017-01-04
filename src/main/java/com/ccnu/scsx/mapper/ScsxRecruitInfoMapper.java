package com.ccnu.scsx.mapper;

import com.ccnu.scsx.annotation.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxRecruitInfo;
import java.util.List;

@Mapper
public interface ScsxRecruitInfoMapper extends BaseMapper<ScsxRecruitInfo> {

  List<ScsxRecruitInfo> getInfoList(@Param("offset") int offset, @Param("limit") int limit);

}
