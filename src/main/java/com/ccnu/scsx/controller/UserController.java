package com.ccnu.scsx.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccnu.scsx.api.WebResultData;
import com.ccnu.scsx.enu.ErrorCode;
import com.ccnu.scsx.model.ScsxUser;
import com.ccnu.scsx.service.UserService;
import com.ccnu.scsx.utils.WebResultUtils;

/**
 * Create By Joban on2017年1月1日下午10:21:56
 */

@Controller
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/user/login")
	public WebResultData login(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		ScsxUser user = userService.findByNameAndPassword(name, password);
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
	public WebResultData register(HttpServletRequest request, ScsxUser user) {
		userService.register(user);
		return WebResultUtils.buildSucResult();
	}

	@ResponseBody
	@RequestMapping(value = "/user/status", method = RequestMethod.POST)
	public WebResultData getStatus(HttpServletRequest request, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		if (request.getSession().getAttribute("loginAdmin") != null) {
			return WebResultUtils.buildSucResult();
		}
		return WebResultUtils.buildResult(ErrorCode.not_login);
	}

}
