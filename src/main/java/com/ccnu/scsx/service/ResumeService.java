package com.ccnu.scsx.service;

import com.ccnu.scsx.dao.ResumeDao;
import com.ccnu.scsx.model.ScsxResumeWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Joban on 2017/1/8.
 */
@Service
public class ResumeService {

  @Autowired
  private ResumeDao resumeDao;

  public void insertWithBloBs(ScsxResumeWithBLOBs resumeWithBLOBs) {
    resumeDao.insertWithBloBs(resumeWithBLOBs);
  }

  public String selectResumePathByUserId(String userId) {
    return resumeDao.selectResumePathByUserId(userId);
  }

  public void updateResumeByUserId(ScsxResumeWithBLOBs resumeWithBLOBs) {
    resumeDao.updateResumeByUserId(resumeWithBLOBs);
  }

  public ScsxResumeWithBLOBs findResumeByUserId(String userId) {
    return resumeDao.findResumeByUserId(userId);
  }

}
