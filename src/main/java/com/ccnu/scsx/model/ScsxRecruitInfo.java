package com.ccnu.scsx.model;

import java.util.Date;

public class ScsxRecruitInfo {

  private String id;

  private String userId;

  private String companyId;

  private String title;

  private Integer salaryLow;

  private Integer salaryHigh;

  private String region;

  private Byte education;

  private Byte position;

  private Byte type;

  private String yearWork;

  private Date lastModify;

  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId == null ? null : userId.trim();
  }

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId == null ? null : companyId.trim();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title == null ? null : title.trim();
  }

  public Integer getSalaryLow() {
    return salaryLow;
  }

  public void setSalaryLow(Integer salaryLow) {
    this.salaryLow = salaryLow;
  }

  public Integer getSalaryHigh() {
    return salaryHigh;
  }

  public void setSalaryHigh(Integer salaryHigh) {
    this.salaryHigh = salaryHigh;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region == null ? null : region.trim();
  }

  public Byte getEducation() {
    return education;
  }

  public void setEducation(Byte education) {
    this.education = education;
  }

  public Byte getPosition() {
    return position;
  }

  public void setPosition(Byte position) {
    this.position = position;
  }

  public String getYearWork() {
    return yearWork;
  }

  public void setYearWork(String yearWork) {
    this.yearWork = yearWork;
  }

  public Date getLastModify() {
    return lastModify;
  }

  public void setLastModify(Date lastModify) {
    this.lastModify = lastModify;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description == null ? null : description.trim();
  }

  public Byte getType() {
    return type;
  }

  public void setType(Byte type) {
    this.type = type;
  }
}