package com.hotelms.bean;

public class ItemBean {
    private int itemDetailsID;
    private int itemID;
    private String category;

    public ItemBean() {
    }

    public ItemBean(int itemDetailsID, int itemID, String category) {
        this.itemDetailsID = itemDetailsID;
        this.itemID = itemID;
        this.category = category;
    }
    public int getItemDetailsID() {
        return itemDetailsID;
    }

    public void setItemDetailsID(int itemDetailsID) {
        this.itemDetailsID = itemDetailsID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "itemDetailsID=" + itemDetailsID +
                ", itemID=" + itemID +
                ", category='" + category + '\'' +
                '}';
    }
}
