package com.ccnu.scsx.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.Date;

@JsonAutoDetect
public class ScsxResume {
    private String id;

    private String userId;

    private String name;

    private String email;

    private String number;

    private Byte age;

    private Boolean gender;

    private Byte position;

    private String skillLabel;

    private String resumePath;

    private String school;

    private String major;

    private Byte education;

    private Date educationStart;

    private Date educationEnd;

    private String company;

    private Date companyStart;

    private Date companyEnd;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Byte getPosition() {
        return position;
    }

    public void setPosition(Byte position) {
        this.position = position;
    }

    public String getSkillLabel() {
        return skillLabel;
    }

    public void setSkillLabel(String skillLabel) {
        this.skillLabel = skillLabel == null ? null : skillLabel.trim();
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath == null ? null : resumePath.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Byte getEducation() {
        return education;
    }

    public void setEducation(Byte education) {
        this.education = education;
    }

    public Date getEducationStart() {
        return educationStart;
    }

    public void setEducationStart(Date educationStart) {
        this.educationStart = educationStart;
    }

    public Date getEducationEnd() {
        return educationEnd;
    }

    public void setEducationEnd(Date educationEnd) {
        this.educationEnd = educationEnd;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Date getCompanyStart() {
        return companyStart;
    }

    public void setCompanyStart(Date companyStart) {
        this.companyStart = companyStart;
    }

    public Date getCompanyEnd() {
        return companyEnd;
    }

    public void setCompanyEnd(Date companyEnd) {
        this.companyEnd = companyEnd;
    }
}