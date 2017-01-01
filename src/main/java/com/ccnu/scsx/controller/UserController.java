package com.ccnu.scsx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccnu.scsx.api.WebResultData;
import com.ccnu.scsx.utils.ObjectUtils;
import com.ccnu.scsx.utils.WebResultUtils;

/**
 * Create By Joban on2017年1月1日下午10:21:56
 */

@Controller
@RequestMapping("/api")
public class UserController {

	@ResponseBody
	@RequestMapping("scsx/login")
	public WebResultData login(HttpServletRequest request) {
		String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    String id = "";
	    //...select id by name
	    if (ObjectUtils.isEmpty(id)){
	    	return WebResultUtils.buildFailureResult();
	    }
	    
	    request.getSession().setAttribute("loginAdmin", name);
	    Map<String, Object> mapResult = new HashMap<String, Object>();
	    mapResult.put("id", id);
	    return WebResultUtils.buildSucResult(mapResult);
	}

}
