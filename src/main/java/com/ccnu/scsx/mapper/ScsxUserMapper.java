package com.ccnu.scsx.mapper;

import java.util.Map;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.ScsxUser;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScsxUserMapper extends BaseMapper<ScsxUser> {

  ScsxUser findByNameAndPassword(Map<String, Object> map);

  ScsxUser findByName(@Param("name") String name);
}