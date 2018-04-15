package com.hotelms.bean;

public class Consumption {
    private Integer consumptionId;

    private Integer stayRegisterId;

    private Integer consumptionNumber;

    private String commodityTypeName;

    private String commodityName;

    private Integer commoditySalePrice;

    private String consumptionTime;

    private Integer saleprice;

    public Integer getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Integer saleprice) {
        this.saleprice = saleprice;
    }

    public Consumption() {
    }

    public Integer getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(Integer consumptionId) {
        this.consumptionId = consumptionId;
    }

    public Integer getStayRegisterId() {
        return stayRegisterId;
    }

    public void setStayRegisterId(Integer stayRegisterId) {
        this.stayRegisterId = stayRegisterId;
    }

    public Integer getConsumptionNumber() {
        return consumptionNumber;
    }

    public void setConsumptionNumber(Integer consumptionNumber) {
        this.consumptionNumber = consumptionNumber;
    }

    public String getCommodityTypeName() {
        return commodityTypeName;
    }

    public void setCommodityTypeName(String commodityTypeName) {
        this.commodityTypeName = commodityTypeName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Integer getCommoditySalePrice() {
        return commoditySalePrice;
    }

    public void setCommoditySalePrice(Integer commoditySalePrice) {
        this.commoditySalePrice = commoditySalePrice;
    }

    public String getConsumptionTime() {
        return consumptionTime;
    }

    public void setConsumptionTime(String consumptionTime) {
        this.consumptionTime = consumptionTime;
    }


}