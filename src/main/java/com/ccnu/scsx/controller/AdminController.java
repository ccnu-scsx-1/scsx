package com.ccnu.scsx.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccnu.scsx.model.Admin;
import com.ccnu.scsx.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  private AdminService adminService;

  /** 登录页 */
  @RequestMapping("/login")
  public String showLogin() {
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(HttpServletRequest request) {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    Admin admin = adminService.findAdminByEmailAndPassword(email, password);
    if (admin != null) {
      request.getSession().setAttribute("loginAdmin", admin);
      return "redirect:/page/Welcome.html";
    } else {
      request.setAttribute("errorMsg", "用户名或密码错误");
      return "login";
    }
  }

  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest request) {
    Enumeration<String> attrNames = request.getSession().getAttributeNames();
    while (attrNames.hasMoreElements()) {
      request.getSession().removeAttribute(attrNames.nextElement());
    }
    return "login";
  }
}