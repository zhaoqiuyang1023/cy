package com.cy.common;

public enum ResponseEnum {


    LackOfIntegral("0001", "积分不足"),
    NoAssociatedStores("0002", "没有关联店铺");

    private String code;
    private String desc;

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private ResponseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
