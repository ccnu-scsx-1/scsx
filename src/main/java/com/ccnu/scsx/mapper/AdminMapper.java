package com.ccnu.scsx.mapper;

import java.util.Map;


import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.model.Admin;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
  Admin findAdminByEmailAndPassword(Map<String, String> map);
}
