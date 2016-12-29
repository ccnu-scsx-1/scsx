package com.ccnu.scsx.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccnu.scsx.dao.impl.BaseDaoImpl;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.mapper.AdminMapper;
import com.ccnu.scsx.model.Admin;

@Repository
public class AdminDao extends BaseDaoImpl<Admin> implements IBaseDao<Admin>{
  @Autowired
  private AdminMapper adminMapper;//无法扫描到mapper
  
  public BaseMapper<Admin> getMapper(){
    return adminMapper;
  }
  
  public Admin findAdminByEmailAndPassword(String email, String password){
    Map<String, String> map = new HashMap<String, String>();
    map.put("email", email);
    map.put("password", password);
    return adminMapper.findAdminByEmailAndPassword(map);
  }
  
}
