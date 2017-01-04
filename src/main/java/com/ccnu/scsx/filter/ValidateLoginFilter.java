package com.ccnu.scsx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class ValidateLoginFilter implements Filter {
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    String uri = httpServletRequest.getRequestURI();
    String contextPath = httpServletRequest.getContextPath();

    if (StringUtils.containsIgnoreCase(uri, "/static/")
        || StringUtils.containsIgnoreCase(uri, "/index")
        || StringUtils.containsIgnoreCase(uri, "/admin/login")
        || StringUtils.containsIgnoreCase(uri, "/api")
        || StringUtils.containsIgnoreCase(uri, "/download")
        || StringUtils.containsIgnoreCase(uri, "/third")) {
      chain.doFilter(request, response);
    } else {
      if (httpServletRequest.getSession().getAttribute("loginAdmin") != null) {
        if (StringUtils.equals(contextPath + "/", uri)) {
          httpServletResponse.sendRedirect(contextPath + "/page/wallpaperManage.html");//展示的首页
        } else {
          chain.doFilter(request, response);
        }
      } else {
        httpServletResponse.sendRedirect(contextPath + "/admin/login");
      }
    }
  }

  public void init(FilterConfig arg0) throws ServletException {
    // do nothing
  }

  public void destroy() {
    // do nothing
  }
}
