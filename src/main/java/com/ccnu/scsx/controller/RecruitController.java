package com.ccnu.scsx.controller;

import com.alibaba.fastjson.JSON;
import com.ccnu.scsx.api.WebResultData;
import com.ccnu.scsx.enu.TypeCode;
import com.ccnu.scsx.model.ScsxCompany;
import com.ccnu.scsx.model.ScsxRecruitInfo;
import com.ccnu.scsx.service.CompanyService;
import com.ccnu.scsx.service.ContactService;
import com.ccnu.scsx.service.RecruitService;
import com.ccnu.scsx.utils.ObjectUtils;
import com.ccnu.scsx.utils.WebResultUtils;
import com.ccnu.scsx.vo.RecruitInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create By Joban on2017年1月4日上午9:39:03
 */
@Controller
@RequestMapping("/api")
public class RecruitController {

  @Autowired
  private RecruitService recruitService;
  @Autowired
  private CompanyService companyService;
  @Autowired
  private ContactService contactService;

  @ResponseBody
  @RequestMapping(value = "/recruit/insertInfo", method = RequestMethod.POST)
  public WebResultData insertInfo(@RequestBody String object) {
    ScsxRecruitInfo info = JSON.parseObject(object, ScsxRecruitInfo.class);
    String userId = info.getUserId();
    String companyId = companyService.findByUserId(userId).getId();
    info.setCompanyId(companyId);
    recruitService.insertInfoSelective(info);
    return WebResultUtils.buildSucResult();
  }

  @ResponseBody
  @RequestMapping(value = "/recruit/infoList", method = RequestMethod.POST)
  public WebResultData infoLists(@RequestBody String object) {
    Map<String, Integer> map = JSON.parseObject(object, Map.class);
    int pageNum = map.get("pageNum");
    List<ScsxRecruitInfo> scsxRecruitInfos = recruitService.getInfos(pageNum);
    List<RecruitInfo> infos = new ArrayList<RecruitInfo>();
    for (ScsxRecruitInfo info : scsxRecruitInfos) {
      String companyId = info.getCompanyId();
      String companyName = companyService.findNameById(companyId);
      RecruitInfo recruitInfo = RecruitInfo.build(info);
      recruitInfo.setCompanyName(companyName);
      infos.add(recruitInfo);
    }
    Map<String, Object> mapResult = new HashMap<String, Object>();
    mapResult.put("infos", infos);
    return WebResultUtils.buildSucResult(mapResult);
  }

  /*
   *此接口用于后期对职位分类
   */
  @ResponseBody
  @RequestMapping(value = "/recruit/infoListByRegion", method = RequestMethod.POST)
  public WebResultData infoListsByRegion(@RequestBody String object) {
    Map<String, Integer> map = JSON.parseObject(object, Map.class);
    int region = map.get("region");

    List<ScsxRecruitInfo> scsxRecruitInfos = null;//....查出位于region下的所有记录

    Map<String, Object> mapResult = new HashMap<String, Object>();
    for (TypeCode c : TypeCode.values()) {
      fun(scsxRecruitInfos, c.getCode(), mapResult);
    }
    return WebResultUtils.buildSucResult(mapResult);
  }

  @ResponseBody
  @RequestMapping(value = "/recruit/jobDetail", method = RequestMethod.POST)
  public WebResultData infoDetail(@RequestBody String object) {
    Map<String, String> map = JSON.parseObject(object, Map.class);
    String company_id = map.get("company_id");
    String info_id = map.get("info_id");
    ScsxRecruitInfo infoDetail = recruitService.getInfoDetail(info_id);
    ScsxCompany company = companyService.getCompanyDetail(company_id);

    Map<String, Object> mapResult = new HashMap<String, Object>();
    mapResult.put("company", company);
    mapResult.put("infoDetail", infoDetail);
    return WebResultUtils.buildSucResult(mapResult);
  }

  @ResponseBody
  @RequestMapping(value = "/recruit/searchBytitle", method = RequestMethod.POST)
  public WebResultData searchBytitle(@RequestBody String object) {
    Map<String, Object> map = JSON.parseObject(object, Map.class);
    String title = (String) map.get("title");
    Integer pageNum = (Integer) map.get("pageNum");
    List<ScsxRecruitInfo> scsxRecruitInfos = recruitService
        .getInfosByTitle(pageNum, title);
    List<RecruitInfo> infos = new ArrayList<RecruitInfo>();
    for (ScsxRecruitInfo info : scsxRecruitInfos) {
      RecruitInfo recruitInfo = RecruitInfo.build(info);
      infos.add(recruitInfo);
    }
    Map<String, Object> mapResult = new HashMap<String, Object>();
    mapResult.put("infos", infos);
    return WebResultUtils.buildSucResult(mapResult);
  }

  @ResponseBody
  @RequestMapping(value = "/recruit/infoListById", method = RequestMethod.POST)
  public WebResultData infoListById(@RequestBody String object) {
    Map<String, String> map = JSON.parseObject(object, Map.class);
    String userId = map.get("userId");
    List<String> infoIds = contactService.selectInfoByUserId(userId);
    Map<String, Object> mapResult = new HashMap<String, Object>();
    if (ObjectUtils.isNotEmpty(infoIds)) {
      List<ScsxRecruitInfo> scsxRecruitInfos = recruitService.getInfoListByInfoIds(infoIds);
      List<RecruitInfo> infos = new ArrayList<RecruitInfo>();
      for (ScsxRecruitInfo info : scsxRecruitInfos) {
        String companyId = info.getCompanyId();
        String companyName = companyService.findNameById(companyId);
        RecruitInfo recruitInfo = RecruitInfo.build(info);
        recruitInfo.setCompanyName(companyName);
        infos.add(recruitInfo);
      }
      mapResult.put("infos", infos);
    }
    return WebResultUtils.buildSucResult(mapResult);
  }

  private void fun(List<ScsxRecruitInfo> scsxRecruitInfos, int type,
      Map<String, Object> mapResult) {
    List<Map<String, Object>> titles = new ArrayList<Map<String, Object>>();
    for (ScsxRecruitInfo scsxRecruitInfo : scsxRecruitInfos) {
      if (scsxRecruitInfo.getType() == type) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", scsxRecruitInfo.getTitle());
        map.put("type", TypeCode.getDescByCode(type));
        titles.add(map);
      }
    }
  }


}

