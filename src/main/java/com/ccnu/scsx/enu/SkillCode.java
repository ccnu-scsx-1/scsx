package com.ccnu.scsx.enu;

/**
 * Create By Joban on2017年1月2日下午5:27:37
 */
public enum SkillCode {
	Linux(0,"Linux熟练"),
	Windows(1,"Windows熟练"),
	Net(2,".net熟练"),
	Js(3,"精通js"),
	CSS(4,"熟练CSS"),
	Spring(5,"Spring熟练")
	;

	private Integer code;
	private String description;

	private SkillCode(Integer code, String description) {
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
