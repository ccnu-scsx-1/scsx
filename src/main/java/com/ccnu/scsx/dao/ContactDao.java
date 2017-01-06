package com.ccnu.scsx.dao;

import com.ccnu.scsx.dao.impl.BaseDaoImpl;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.mapper.ScsxContactMapper;
import com.ccnu.scsx.model.ScsxContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Joban on 2017/1/6.
 */
@Repository
public class ContactDao extends BaseDaoImpl<ScsxContact> implements IBaseDao<ScsxContact> {

  @Autowired
  private ScsxContactMapper contactMapper;

  public BaseMapper<ScsxContact> getMapper() {
    return contactMapper;
  }

  public ScsxContact getContactByUserAndInfo(String userId, String infoId) {
    return contactMapper.getContactByUserAndInfo(userId, infoId);
  }

  public void insertContact(ScsxContact contact) {
    contactMapper.insert(contact);
  }

}
