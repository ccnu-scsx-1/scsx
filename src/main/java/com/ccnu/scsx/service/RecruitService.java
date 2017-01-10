package com.ccnu.scsx.service;

import com.ccnu.scsx.model.ScsxRecruitInfo;
import com.ccnu.scsx.utils.PageUtils;
import com.ccnu.scsx.utils.UUIDUtils;
import java.util.List;
import java.util.Map;
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

  public ScsxRecruitInfo getInfoDetail(String info_id) {
    return recruitDao.getInfoDetail(info_id);
  }

  public List<ScsxRecruitInfo> getInfosByTitle(int pageNum, String title) {
    PageUtils pageUtils = new PageUtils();
    int limit = pageUtils.getPageSize();
    int offset = pageUtils.getOffsetByPageNum(pageNum);
    List<ScsxRecruitInfo> infos = recruitDao.getInfosByTitle(offset, limit, title);
    return infos;
  }

  public List<Map<String, Object>> getUserIntentionList(String userId) {
    return recruitDao.getUserIntentionList(userId);
  }

  public void insertInfoSelective(ScsxRecruitInfo info) {
    String infoId = UUIDUtils.getUUID();
    info.setId(infoId);
    recruitDao.insertInfoSelective(info);
  }

  public List<ScsxRecruitInfo> getInfoListByInfoIds(List<String> infoIds) {
    return recruitDao.getInfoListByInfoIds(infoIds);
  }

  /*public List<ScsxRecruitInfo> getListByUserIdAndInfoIds(String userId, List<String> infoIds) {
    return recruitDao.getListByUserIdAndInfoIds(userId, infoIds);
  }*/

}

