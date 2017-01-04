package com.ccnu.scsx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccnu.scsx.service.RecruitService;

/**
 * Create By Joban on2017年1月4日上午9:39:03
 */
@Controller
public class RecruitController {
  @Autowired
  private RecruitService recruitService;

}

