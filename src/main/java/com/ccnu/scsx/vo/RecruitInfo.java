package com.ccnu.scsx.vo;

import com.ccnu.scsx.model.ScsxRecruitInfo;

/**
 * Create By Joban on2017年1月4日上午11:11:50
 */
public class RecruitInfo {

  private String infoId;
  private String companyId;
  private String companyName;
  private String title;
  private int salary_high;
  private int salary_low;
  private String region;

  public String getInfoId() {
    return infoId;
  }

  public void setInfoId(String infoId) {
    this.infoId = infoId;
  }

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getSalary_high() {
    return salary_high;
  }

  public void setSalary_high(int salary_high) {
    this.salary_high = salary_high;
  }

  public int getSalary_low() {
    return salary_low;
  }

  public void setSalary_low(int salary_low) {
    this.salary_low = salary_low;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public static RecruitInfo build(ScsxRecruitInfo scsxRecruitInfo) {
    RecruitInfo info = new RecruitInfo();
    info.setCompanyId(scsxRecruitInfo.getCompanyId());
    info.setInfoId(scsxRecruitInfo.getId());
    info.setRegion(scsxRecruitInfo.getRegion());
    info.setTitle(scsxRecruitInfo.getTitle());
    info.setSalary_high(scsxRecruitInfo.getSalaryHigh());
    info.setSalary_low(scsxRecruitInfo.getSalaryLow());
    return info;
  }

}

