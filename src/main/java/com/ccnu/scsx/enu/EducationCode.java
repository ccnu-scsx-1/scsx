package com.ccnu.scsx.enu;
/**
*Create By Joban on2017年1月2日下午6:56:15
*/
public enum EducationCode {
	College(0,"大专"),
	Bachelor(1,"本科"),
	Master(2,"硕士"),
	Doctor(3,"博士")
	;
	
	private Integer code;
	private String description;
	
	private EducationCode(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}

