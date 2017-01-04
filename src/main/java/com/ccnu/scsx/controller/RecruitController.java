package com.ccnu.scsx.controller;

import com.alibaba.fastjson.JSON;
import com.ccnu.scsx.api.WebResultData;
import com.ccnu.scsx.model.ScsxRecruitInfo;
import com.ccnu.scsx.utils.WebResultUtils;
import com.ccnu.scsx.vo.RecruitInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccnu.scsx.service.RecruitService;
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

  @ResponseBody
  @RequestMapping(value = "/recruit/infoList", method = RequestMethod.POST)
  public WebResultData infoLists(@RequestBody String object) {
    Map<String, Integer> map = JSON.parseObject(object, Map.class);
    int pageNum = map.get("pageNum");
    List<ScsxRecruitInfo> scsxRecruitInfos = recruitService.getInfos(pageNum);
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
  @RequestMapping(value = "/recruit/jobDetail", method = RequestMethod.POST)
  public WebResultData infoDetail(@RequestBody String object) {
    Map<String, String> map = JSON.parseObject(object, Map.class);
    String company_id = map.get("company_id");
    String info_id = map.get("info_id");
    /*
    todo
     */
    Map<String, Object> mapResult = new HashMap<String, Object>();

    return WebResultUtils.buildSucResult(mapResult);
  }

}

