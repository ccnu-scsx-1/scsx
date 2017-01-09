package com.ccnu.scsx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccnu.scsx.dao.UserDao;
import com.ccnu.scsx.model.ScsxUser;
import com.ccnu.scsx.utils.Md5Utils;
import com.ccnu.scsx.utils.UUIDUtils;

/**
 * Create By Joban on2017年1月2日上午9:23:59
 */

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  public ScsxUser findByNameAndPassword(String name, String password, Byte role) {
    String md5pwd = Md5Utils.getMD5(password);
    return userDao.findByNameAndPassword(name, md5pwd, role);
  }

  public ScsxUser findByName(String name) {
    return userDao.findByName(name);
  }

  public String register(ScsxUser user) {
    String md5pwd = Md5Utils.getMD5(user.getPassword());
    user.setPassword(md5pwd);
    String id = UUIDUtils.getUUID();
    user.setId(id);
    userDao.register(user);
    return id;
  }

  public ScsxUser findById(String id) {
    ScsxUser user = userDao.findById(id);
    return user;
  }

  public void updateById(ScsxUser user) {
    userDao.updateById(user);
  }

}
