package com.ccnu.scsx.model;

public class total {
    private Integer id;

    private Integer orderId;

    private String persionPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPersionPhone() {
        return persionPhone;
    }

    public void setPersionPhone(String persionPhone) {
        this.persionPhone = persionPhone == null ? null : persionPhone.trim();
    }
}