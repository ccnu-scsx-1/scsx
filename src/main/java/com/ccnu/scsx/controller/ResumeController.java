package com.ccnu.scsx.controller;

import com.alibaba.fastjson.JSON;
import com.ccnu.scsx.api.WebResultData;
import com.ccnu.scsx.enu.ErrorCode;
import com.ccnu.scsx.model.ScsxRecruitInfo;
import com.ccnu.scsx.model.ScsxResume;
import com.ccnu.scsx.model.ScsxResumeWithBLOBs;
import com.ccnu.scsx.model.ScsxUser;
import com.ccnu.scsx.service.ContactService;
import com.ccnu.scsx.service.RecruitService;
import com.ccnu.scsx.service.ResumeService;
import com.ccnu.scsx.service.UserService;
import com.ccnu.scsx.utils.DateUtils;
import com.ccnu.scsx.utils.ObjectUtils;
import com.ccnu.scsx.utils.UUIDUtils;
import com.ccnu.scsx.utils.WebResultUtils;
import com.ccnu.scsx.vo.InfoAndUserDto;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Joban on 2017/1/8.
 */
@Controller
@RequestMapping("/api")
public class ResumeController {

  @Value("${resume.path}")
  private String basicPath;
  @Value("${resume.storage}")
  private String storage;

  @Autowired
  private ResumeService resumeService;
  @Autowired
  private UserService userService;
  @Autowired
  private RecruitService recruitService;
  @Autowired
  private ContactService contactService;

  @ResponseBody
  @RequestMapping(value = "/resume/insert", method = RequestMethod.POST)
  public WebResultData insertResume(@RequestBody String object) {
    ScsxResumeWithBLOBs resume = JSON.parseObject(object, ScsxResumeWithBLOBs.class);
    String userId = resume.getUserId();
    if (isResumeExist(userId)) {
      resumeService.updateResumeByUserId(resume);
      return WebResultUtils.buildSucResult();
    }
    resume.setId(UUIDUtils.getUUID());
    resume.setResumePath(storage + resume.getResumePath());
    resumeService.insertWithBloBs(resume);
    return WebResultUtils.buildSucResult();
  }

  @ResponseBody
  @RequestMapping(value = "/resume/uploadResume", method = RequestMethod.POST)
  public WebResultData uploadResume(HttpServletRequest request,
      MultipartFile multipartFile, String userId) {
    if (!isExist(userId)) {
      return WebResultUtils.buildResult(ErrorCode.user_notExist);
    }
    String time = "";
    String originalFilename = multipartFile.getOriginalFilename();
    if (multipartFile != null && multipartFile.getSize() > 0) {
      time = new DateUtils().getTimeString();
      String path = basicPath + File.separator + time + originalFilename;
      File dic = new File(basicPath);
      if (!dic.exists()) {
        dic.mkdirs();
      }
      try {
        multipartFile.transferTo(new File(path));
      } catch (IOException e) {
        System.out.println("Faild To Upload!!!");
        return WebResultUtils.buildSucResult(ErrorCode.upload_faied);
      }
    }
    Map<String, Object> mapResult = new HashMap<String, Object>();//add fileId/filePath
    mapResult.put("fileName", time + originalFilename);
    return WebResultUtils.buildSucResult(mapResult);
  }

  @ResponseBody
  @RequestMapping(value = "/resume/resumeList", method = RequestMethod.POST)
  public WebResultData getResuemListByUserId(@RequestBody String object) {
    Map<String, String> map = JSON.parseObject(object, Map.class);
    String hrId = map.get("userId");//select infoid by userid
    List<Map<String, Object>> list = recruitService.getUserIntentionList(hrId);
    List<InfoAndUserDto> infoAndUserDtos = new ArrayList<InfoAndUserDto>();
    for (Map<String, Object> mapInfo : list) {
      List<String> userIds = contactService.selectUserByinfoId((String) mapInfo.get("id"));
      if (!ObjectUtils.isEmpty(userIds)) {
        for (String userId : userIds) {
          String username = userService.findNameById(userId);
          InfoAndUserDto infoAndUserDto = InfoAndUserDto
              .build(userId, mapInfo.get("title"), username);
          infoAndUserDtos.add(infoAndUserDto);
        }
      }
    }
    Map<String, Object> mapResult = new HashMap<String, Object>();
    mapResult.put("list", infoAndUserDtos);
    return WebResultUtils.buildSucResult(mapResult);
  }

  private boolean isExist(String userId) {
    ScsxUser user = userService.findById(userId);
    if (user == null) {
      return false;
    }
    return true;
  }

  private boolean isResumeExist(String userId) {
    String resumePath = resumeService.selectResumePathByUserId(userId);
    if (ObjectUtils.isEmpty(resumePath)) {
      return false;
    }
    return true;
  }

}
