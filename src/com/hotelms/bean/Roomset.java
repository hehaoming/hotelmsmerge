package com.hotelms.bean;

import java.util.List;

public class Roomset {

    private Integer roomID;

    private Integer roomNumber;

    private Integer roomStateID;

    private Integer roomAmount;

    private Integer guestRoomLevelID;

    private Integer standarPriceDay;

    private Integer standarPrice;

    private Integer maxDuration;

    private Integer firstPrice;

    private Integer firstDuration;

    private String roomStateName;
    private String guestRoomLevelName;

    List<Roomset>  rooms;

    public List<Roomset> getRooms() {
        return rooms;
    }

    public void setRooms(List<Roomset> rooms) {
        this.rooms = rooms;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomStateID() {
        return roomStateID;
    }

    public void setRoomStateID(Integer roomStateID) {
        this.roomStateID = roomStateID;
    }

    public Integer getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }

    public Integer getGuestRoomLevelID() {
        return guestRoomLevelID;
    }

    public void setGuestRoomLevelID(Integer guestRoomLevelID) {
        this.guestRoomLevelID = guestRoomLevelID;
    }

    public Integer getStandarPriceDay() {
        return standarPriceDay;
    }

    public void setStandarPriceDay(Integer standarPriceDay) {
        this.standarPriceDay = standarPriceDay;
    }

    public Integer getStandarPrice() {
        return standarPrice;
    }

    public void setStandarPrice(Integer standarPrice) {
        this.standarPrice = standarPrice;
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Integer getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(Integer firstPrice) {
        this.firstPrice = firstPrice;
    }

    public Integer getFirstDuration() {
        return firstDuration;
    }

    public void setFirstDuration(Integer firstDuration) {
        this.firstDuration = firstDuration;
    }

    @Override
    public String toString() {
        return "Roomset{" +
                "roomID=" + roomID +
                ", roomNumber=" + roomNumber +
                ", roomStateID=" + roomStateID +
                ", roomAmount=" + roomAmount +
                ", guestRoomLevelID=" + guestRoomLevelID +
                ", standarPriceDay=" + standarPriceDay +
                ", standarPrice=" + standarPrice +
                ", maxDuration=" + maxDuration +
                ", firstPrice=" + firstPrice +
                ", firstDuration=" + firstDuration +
                ", rooms=" + rooms +
                '}';
    }

    public String getRoomStateName() {
        return roomStateName;
    }

    public void setRoomStateName(String roomStateName) {
        this.roomStateName = roomStateName;
    }

    public String getGuestRoomLevelName() {
        return guestRoomLevelName;
    }

    public void setGuestRoomLevelName(String guestRoomLevelName) {
        this.guestRoomLevelName = guestRoomLevelName;
    }
}