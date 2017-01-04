package com.ccnu.scsx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccnu.scsx.dao.AdminDao;
import com.ccnu.scsx.model.Admin;

@Service
public class AdminService {
  @Autowired
  private AdminDao adminDao;
  
  public Admin findAdminByEmailAndPassword(String email, String password){
    return adminDao.findAdminByEmailAndPassword(email, password);
  }

}
