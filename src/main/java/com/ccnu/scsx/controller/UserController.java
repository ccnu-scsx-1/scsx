package com.ccnu.scsx.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ccnu.scsx.api.WebResultData;
import com.ccnu.scsx.enu.ErrorCode;
import com.ccnu.scsx.model.ScsxCompany;
import com.ccnu.scsx.model.ScsxUser;
import com.ccnu.scsx.params.IdParams;
import com.ccnu.scsx.params.LoginParams;
import com.ccnu.scsx.params.RegisterParams;
import com.ccnu.scsx.service.CompanyService;
import com.ccnu.scsx.service.UserService;
import com.ccnu.scsx.utils.ObjectUtils;
import com.ccnu.scsx.utils.WebResultUtils;
import com.ccnu.scsx.vo.UserInfoDto;

/**
 * Create By Joban on2017年1月1日下午10:21:56
 */

@Controller
@RequestMapping("/api")
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private CompanyService companyService;

  @ResponseBody
  @RequestMapping("/user/login")
  public WebResultData login(HttpServletRequest request, @RequestBody String object) {
    if (ObjectUtils.isEmpty(object)) {
      return WebResultUtils.buildResult(ErrorCode.param_empty);
    }
    LoginParams loginParams = JSON.parseObject(object, LoginParams.class);
    String name = loginParams.getName();
    String password = loginParams.getPassword();
    Byte role = loginParams.getRole();

    ScsxUser user = userService.findByNameAndPassword(name, password, role);
    if (user == null) {
      return WebResultUtils.buildFailureResult();
    }

    request.getSession().setAttribute("loginAdmin", user);
    Map<String, Object> mapResult = new HashMap<String, Object>();
    mapResult.put("name", user.getName());
    mapResult.put("id", user.getId());
    return WebResultUtils.buildSucResult(mapResult);
  }

  @SuppressWarnings("unchecked")
  @ResponseBody
  @RequestMapping("/user/logout")
  public WebResultData logout(HttpServletRequest request) {
    Enumeration<String> attrNames = request.getSession().getAttributeNames();
    while (attrNames.hasMoreElements()) {
      request.getSession().removeAttribute(attrNames.nextElement());
    }
    return WebResultUtils.buildSucResult();
  }

  @ResponseBody
  @RequestMapping(value = "/user/register")
  public WebResultData register(HttpServletRequest request, @RequestBody String object) {
    RegisterParams params = JSON.parseObject(object, RegisterParams.class);
    if (isExist(params)) {
      return WebResultUtils.buildResult(ErrorCode.user_exist);
    }
    ScsxUser user = params.getUser();
    Byte role = user.getRole();
    userService.register(user);
    if (role == 0) {
      return WebResultUtils.buildSucResult();
    }
    if (role == 1) {
      ScsxCompany company = params.getCompany();
      companyService.insertCompany(company);
      return WebResultUtils.buildSucResult();
    }
    return WebResultUtils.buildFailureResult();
  }

  @ResponseBody
  @RequestMapping(value = "/user/status", method = RequestMethod.POST)
  public WebResultData getStatus(HttpServletRequest request) {
    if (request.getSession().getAttribute("loginAdmin") != null) {
      return WebResultUtils.buildSucResult();
    }
    return WebResultUtils.buildResult(ErrorCode.not_login);
  }

  @ResponseBody
  @RequestMapping(value = "/user/info", method = RequestMethod.POST)
  public WebResultData getUserInfo(@RequestBody String object) {
    String userId = JSON.parseObject(object, IdParams.class);
    ScsxUser user = userService.findById(userId);
    UserInfoDto userInfoDto = UserInfoDto.build(user);

    Map<String, Object> mapResult = new HashMap<String, Object>();
    mapResult.put("info", userInfoDto);
    return WebResultUtils.buildSucResult(mapResult);
  }

  private Boolean isExist(RegisterParams params) {
    ScsxUser user = params.getUser();
    String username = user.getName();
    ScsxUser userOld = userService.findByName(username);
    if (userOld == null) {
      return false;
    }
    return true;
  }

}
