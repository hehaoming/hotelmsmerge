package com.hotelms.bean;

public class Commodity {

    private int commodityID;
    private String commodityName;   //商品名称
    private int commodityTypeID;  //商品类别
    private int uOMID;  //计量单位
    private int salePrice;  //销售价格

    //private

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityID=" + commodityID +
                ", commodityName='" + commodityName + '\'' +
                ", commodityTypeID=" + commodityTypeID +
                ", uOMID='" + uOMID + '\'' +
                ", salePrice=" + salePrice +
                '}';
    }

    public int getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getCommodityTypeID() {
        return commodityTypeID;
    }

    public void setCommodityTypeID(int commodityTypeID) {
        this.commodityTypeID = commodityTypeID;
    }

    public int getuOMID() {
        return uOMID;
    }

    public void setuOMID(int uOMID) {
        this.uOMID = uOMID;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }
}
