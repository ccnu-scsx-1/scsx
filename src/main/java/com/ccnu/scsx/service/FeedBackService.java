package com.ccnu.scsx.service;

import com.ccnu.scsx.dao.FeedBackDao;
import com.ccnu.scsx.dao.FeedContactDao;
import com.ccnu.scsx.model.ScsxFeedBack;
import com.ccnu.scsx.model.ScsxFeedContact;
import com.ccnu.scsx.utils.UUIDUtils;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Joban on 2017/1/11.
 */
@Service
public class FeedBackService {

  @Autowired
  private FeedBackDao feedBackDao;
  @Autowired
  private FeedContactDao feedContactDao;

  public String insertSelective(Map<String, Object> map) {
    String infoId = (String) map.get("infoId");
    String content = (String) map.get("content");
    String title = (String) map.get("title");
    Boolean result = (Boolean) map.get("result");
    String feedBackId = UUIDUtils.getUUID();
    ScsxFeedBack feedBack = ScsxFeedBack.build(feedBackId, infoId, title, content, result);
    feedBackDao.insertSelective(feedBack);
    return feedBackId;
  }

  public void insertFeedContact(String feedBackId, String userId, int role) {
    String id = UUIDUtils.getUUID();
    ScsxFeedContact feedContact = ScsxFeedContact.build(id, feedBackId, userId, role);
    feedContactDao.insertSelective(feedContact);
  }

}
