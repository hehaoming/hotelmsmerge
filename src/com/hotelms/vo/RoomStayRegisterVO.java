package com.hotelms.vo;


import com.hotelms.bean.ItemBean;

public class RoomStayRegisterVO {
    /* roomID
  roomNumber       INT NULL,
  roomStateID      INT NULL,
  roomAmount       INT NULL,
  guestRoomLevelID INT NULL,
  standarPriceDay  INT NULL,
  standarPrice     INT NULL,
  maxDuration      INT NULL,
  firstPrice       INT NULL,
  firstDuration    INT NULL*/
    private int roomID;
    private int roomNumber;
    private ItemBean roomState;
    private int roomAmount;
    private ItemBean guestRoomLevel;
    private int standarPriceDay;
    private int standarPrice;
    private int maxDuration;
    private int firstPrice;
    private int firstDuration;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public ItemBean getRoomState() {
        return roomState;
    }

    public void setRoomState(ItemBean roomState) {
        this.roomState = roomState;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    public ItemBean getGuestRoomLevel() {
        return guestRoomLevel;
    }

    public void setGuestRoomLevel(ItemBean guestRoomLevel) {
        this.guestRoomLevel = guestRoomLevel;
    }

    public int getStandarPriceDay() {
        return standarPriceDay;
    }

    public void setStandarPriceDay(int standarPriceDay) {
        this.standarPriceDay = standarPriceDay;
    }

    public int getStandarPrice() {
        return standarPrice;
    }

    public void setStandarPrice(int standarPrice) {
        this.standarPrice = standarPrice;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public int getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(int firstPrice) {
        this.firstPrice = firstPrice;
    }

    public int getFirstDuration() {
        return firstDuration;
    }

    public void setFirstDuration(int firstDuration) {
        this.firstDuration = firstDuration;
    }

    @Override
    public String toString() {
        return "RoomStayRegisterVO{" +
                "roomID=" + roomID +
                ", roomNumber=" + roomNumber +
                ", roomState=" + roomState +
                ", roomAmount=" + roomAmount +
                ", guestRoomLevel=" + guestRoomLevel +
                ", standarPriceDay=" + standarPriceDay +
                ", standarPrice=" + standarPrice +
                ", maxDuration=" + maxDuration +
                ", firstPrice=" + firstPrice +
                ", firstDuration=" + firstDuration +
                '}';
    }
}
