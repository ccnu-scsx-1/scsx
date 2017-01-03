package com.ccnu.scsx.params;
/**
*Create By Joban on2017年1月3日上午11:13:34
*/
public class LoginParams {
	private String name;
	private String password;
	private Byte role;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Byte getRole() {
		return role;
	}
	public void setRole(Byte role) {
		this.role = role;
	}
}

