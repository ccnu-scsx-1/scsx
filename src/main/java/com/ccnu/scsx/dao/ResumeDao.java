package com.ccnu.scsx.dao;

import com.ccnu.scsx.dao.impl.BaseDaoImpl;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.mapper.ScsxResumeMapper;
import com.ccnu.scsx.model.ScsxResume;
import com.ccnu.scsx.model.ScsxResumeWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Joban on 2017/1/8.
 */
@Repository
public class ResumeDao extends BaseDaoImpl<ScsxResumeWithBLOBs> implements
    IBaseDao<ScsxResumeWithBLOBs> {

  @Autowired
  private ScsxResumeMapper resumeMapper;

  public BaseMapper<ScsxResumeWithBLOBs> getMapper() {
    return resumeMapper;
  }

  public void insertWithBloBs(ScsxResumeWithBLOBs resumeWithBLOBs) {
    resumeMapper.insertSelective(resumeWithBLOBs);
  }

  public String selectResumePathByUserId(String userId) {
    return resumeMapper.selectResumePathByUserId(userId);
  }

  public void updateResumeByUserId(ScsxResumeWithBLOBs resumeWithBLOBs) {
    resumeMapper.updateByPrimaryKeySelective(resumeWithBLOBs);
  }

}
