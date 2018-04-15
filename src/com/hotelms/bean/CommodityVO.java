package com.hotelms.bean;


import org.apache.ibatis.annotations.Param;

public class CommodityVO extends Commodity{

    private String commodityType;
    private String uOM;

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public String getuOM() {
        return uOM;
    }

    public void setuOM(String uOM) {
        this.uOM = uOM;
    }
}
