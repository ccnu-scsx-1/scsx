package com.ccnu.scsx.service;

import com.ccnu.scsx.dao.ContactDao;
import com.ccnu.scsx.model.ScsxContact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Joban on 2017/1/6.
 */
@Service
public class ContactService {

  @Autowired
  private ContactDao contactDao;

  public ScsxContact getContactByUserAndInfo(String userId, String infoId) {
    return contactDao.getContactByUserAndInfo(userId, infoId);
  }

  public void insertContact(ScsxContact contact) {
    contactDao.insertContact(contact);
  }

  public List<String> selectInfoByUserId(String userId) {
    return contactDao.selectInfoByUserId(userId);
  }

  public List<String> selectUserByinfoId(String infoId) {
    return contactDao.selectUserByinfoId(infoId);
  }

}
