package com.ccnu.scsx.model;

public class ScsxUser {
	private String id;

	private String name;
	
	private String email;
	
	private String password;

	private Byte gender;

	private Byte age;

	private String number;

	private Byte position;

	private Byte role;

	private String resumeId;

	private String infoId;

	private Byte yearWork;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
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
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	public Byte getPosition() {
		return position;
	}

	public void setPosition(Byte position) {
		this.position = position;
	}

	public Byte getRole() {
		return role;
	}

	public void setRole(Byte role) {
		this.role = role;
	}

	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId == null ? null : resumeId.trim();
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId == null ? null : infoId.trim();
	}

	public Byte getYearWork() {
		return yearWork;
	}

	public void setYearWork(Byte yearWork) {
		this.yearWork = yearWork;
	}

}