package com.ccnu.scsx.dao;

import com.ccnu.scsx.dao.impl.BaseDaoImpl;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.mapper.ScsxFeedBackMapper;
import com.ccnu.scsx.model.ScsxFeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Joban on 2017/1/11.
 */
@Repository
public class FeedBackDao extends BaseDaoImpl<ScsxFeedBack> implements IBaseDao<ScsxFeedBack> {

  @Autowired
  private ScsxFeedBackMapper feedBackMapper;

  public BaseMapper<ScsxFeedBack> getMapper() {
    return feedBackMapper;
  }

  public void insertSelective(ScsxFeedBack feedBack) {
    feedBackMapper.insertSelective(feedBack);
  }

}
