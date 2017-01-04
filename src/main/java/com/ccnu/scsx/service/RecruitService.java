package com.ccnu.scsx.service;

import com.ccnu.scsx.model.ScsxRecruitInfo;
import com.ccnu.scsx.utils.PageUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccnu.scsx.dao.RecruitDao;

/**
 * Create By Joban on2017年1月4日上午9:42:28
 */
@Service
public class RecruitService {

  @Autowired
  private RecruitDao recruitDao;

  public List<ScsxRecruitInfo> getInfos(int pageNum) {
    PageUtils pageUtils = new PageUtils();
    int limit = pageUtils.getPageSize();
    int offset = pageUtils.getOffsetByPageNum(pageNum);
    List<ScsxRecruitInfo> infos = recruitDao.getInfos(offset, limit);
    return infos;
  }

}

