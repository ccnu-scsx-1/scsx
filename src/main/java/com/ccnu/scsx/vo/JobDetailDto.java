package com.ccnu.scsx.vo;

/**
 * Created by Joban on 2017/1/4.
 */
public class JobDetailDto {

  /*
    公司信息
   */
  private String company_name;
  private String company_url;
  private String company_tel;
  private String company_email;
  private String company_introduction;
  private int company_scale;
  /*
    职位详细信息
   */
  private String description;
  private String region;
  private int year_work;
  private int education;
  private int position;

  public String getCompany_name() {
    return company_name;
  }

  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  public String getCompany_url() {
    return company_url;
  }

  public void setCompany_url(String company_url) {
    this.company_url = company_url;
  }

  public String getCompany_tel() {
    return company_tel;
  }

  public void setCompany_tel(String company_tel) {
    this.company_tel = company_tel;
  }

  public String getCompany_email() {
    return company_email;
  }

  public void setCompany_email(String company_email) {
    this.company_email = company_email;
  }

  public String getCompany_introduction() {
    return company_introduction;
  }

  public void setCompany_introduction(String company_introduction) {
    this.company_introduction = company_introduction;
  }

  public int getCompany_scale() {
    return company_scale;
  }

  public void setCompany_scale(int company_scale) {
    this.company_scale = company_scale;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public int getYear_work() {
    return year_work;
  }

  public void setYear_work(int year_work) {
    this.year_work = year_work;
  }

  public int getEducation() {
    return education;
  }

  public void setEducation(int education) {
    this.education = education;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }
}
