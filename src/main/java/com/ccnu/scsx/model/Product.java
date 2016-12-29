package com.ccnu.scsx.model;

import java.util.Date;

public class Product {
	private int id;
	private String img;
	private String remark;
	private String name;
	private String description;
	private Date create_time;
	private Date last_modify;
	private double price;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLast_modify() {
		return last_modify;
	}

	public void setLast_modify(Date last_modify) {
		this.last_modify = last_modify;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public static Product build(String name, String remark, String description, String img, double price) {
		Product product = new Product();
		product.setName(name);
		product.setRemark(remark);
		product.setDescription(description);
		product.setImg(img);
		product.setPrice(price);
		Date now = new Date();
		product.setCreate_time(now);
		product.setLast_modify(now);
		return product;
	}
	
}
