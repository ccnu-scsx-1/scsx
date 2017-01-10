package com.ccnu.scsx.dao;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccnu.scsx.dao.impl.BaseDaoImpl;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.mapper.ScsxRecruitInfoMapper;
import com.ccnu.scsx.model.ScsxRecruitInfo;

/**
 * Create By Joban on2017年1月4日上午9:42:59
 */
@Repository
public class RecruitDao extends BaseDaoImpl<ScsxRecruitInfo> implements IBaseDao<ScsxRecruitInfo> {

  @Autowired
  private ScsxRecruitInfoMapper recruitInfoMapper;

  @Override
  public BaseMapper<ScsxRecruitInfo> getMapper() {
    return recruitInfoMapper;
  }

  public List<ScsxRecruitInfo> getInfos(int offset, int limit) {
    List<ScsxRecruitInfo> scsxRecruitInfos = recruitInfoMapper.getInfoList(offset, limit);
    return scsxRecruitInfos;
  }

  public ScsxRecruitInfo getInfoDetail(String info_id) {
    return recruitInfoMapper.selectByPrimaryKey(info_id);
  }

  public List<ScsxRecruitInfo> getInfosByTitle(int offset, int limit, String title) {
    StringBuilder titlelike = new StringBuilder();
    titlelike.append("%");
    titlelike.append(title);
    titlelike.append("%");
    return recruitInfoMapper.getInfoListByTitle(offset, limit, titlelike.toString());
  }

  public List<Map<String, Object>> getUserIntentionList(String userId) {
    return recruitInfoMapper.getUserIntentionList(userId);
  }

  public void insertInfoSelective(ScsxRecruitInfo info) {
    recruitInfoMapper.insertSelective(info);
  }

  public List<ScsxRecruitInfo> getInfoListByInfoIds(List<String> infoIds) {
    return recruitInfoMapper.getInfoListByInfoIds(infoIds);
  }

  /*public List<ScsxRecruitInfo> getListByUserIdAndInfoIds(String userId, List<String> infoIds) {
    return recruitInfoMapper.getListByUserIdAndInfoIds(userId, infoIds);
  }*/

}

