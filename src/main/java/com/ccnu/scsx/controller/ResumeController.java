package com.ccnu.scsx.controller;

import com.alibaba.fastjson.JSON;
import com.ccnu.scsx.api.WebResultData;
import com.ccnu.scsx.model.ScsxResumeWithBLOBs;
import com.ccnu.scsx.service.ResumeService;
import com.ccnu.scsx.utils.WebResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Joban on 2017/1/8.
 */
@Controller
@RequestMapping("/api")
public class ResumeController {

  @Autowired
  private ResumeService resumeService;

  @ResponseBody
  @RequestMapping(value = "/resume/insert", method = RequestMethod.POST)
  public WebResultData insertResume(@RequestBody String object) {
    ScsxResumeWithBLOBs resume = JSON.parseObject(object, ScsxResumeWithBLOBs.class);
    resumeService.insertWithBloBs(resume);
    return WebResultUtils.buildSucResult();
  }

}
