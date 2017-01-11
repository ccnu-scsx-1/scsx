package com.ccnu.scsx.dao;

import com.ccnu.scsx.dao.impl.BaseDaoImpl;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.mapper.ScsxFeedContactMapper;
import com.ccnu.scsx.model.ScsxFeedContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Joban on 2017/1/11.
 */
@Repository
public class FeedContactDao extends BaseDaoImpl<ScsxFeedContact> implements
    IBaseDao<ScsxFeedContact> {

  @Autowired
  private ScsxFeedContactMapper feedContactMapper;

  public BaseMapper<ScsxFeedContact> getMapper() {
    return feedContactMapper;
  }

  public void insertSelective(ScsxFeedContact feedContact) {
    feedContactMapper.insertSelective(feedContact);
  }

}
