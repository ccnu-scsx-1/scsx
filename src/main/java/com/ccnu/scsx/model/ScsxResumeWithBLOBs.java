package com.ccnu.scsx.model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ScsxResumeWithBLOBs extends ScsxResume {
    private String companyContent;

    private String eduExp;

    private String workExp;

    private String proExp;

    public String getCompanyContent() {
        return companyContent;
    }

    public void setCompanyContent(String companyContent) {
        this.companyContent = companyContent == null ? null : companyContent.trim();
    }

    public String getEduExp() {
        return eduExp;
    }

    public void setEduExp(String eduExp) {
        this.eduExp = eduExp == null ? null : eduExp.trim();
    }

    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp == null ? null : workExp.trim();
    }

    public String getProExp() {
        return proExp;
    }

    public void setProExp(String proExp) {
        this.proExp = proExp == null ? null : proExp.trim();
    }
}