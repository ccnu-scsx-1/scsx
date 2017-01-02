package com.ccnu.scsx.enu;
/**
*Create By Joban on2017年1月2日下午7:08:49
*/
public enum RoleCode {
	Normal(0,"普通用户"),
	HR(1,"人力资源")
	;
	
	private Integer code;
	private String description;
	
	private RoleCode(Integer code, String description) {
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

