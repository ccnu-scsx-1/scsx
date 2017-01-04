package com.ccnu.scsx.enu;

/**
 * Create By Joban on2017年1月2日下午4:11:35
 */
public enum PositionCode {
	Java_Engineer(0,"Java工程师"),
	C_Engineer(1,"C工程师"),
	Product_Manager(3,"产品经理"),
	Web_Engineer(4,"前端工程师"),
	Test_Engineer(5,"测试工程师"),
	CTO(6,"技术主管")
	;
	
	private Integer code;
	private String description;
	
	private PositionCode(Integer code, String description) {
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

	 // 普通方法  
    public static String getDescByCode(int code) {  
        for (PositionCode c : PositionCode.values()) {  
            if (c.getCode() == code) {  
                return c.description;  
            }  
        }  
        return null;  
    } 
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
