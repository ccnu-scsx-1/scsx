package com.ccnu.scsx.vo;

/**
 * Create By Joban on2017年1月4日上午11:11:50
 */
public class RecruitInfo {

  private String infoId;
  private String companyId;
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
}

