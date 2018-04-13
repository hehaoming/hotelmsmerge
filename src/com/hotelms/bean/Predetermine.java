package com.hotelms.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Predetermine {
    private Integer predetermineID;

    private Integer roomID;

    private Integer tuanduiID;

    private Integer passengerID;

    private Timestamp arriveTime;

    private Integer deposit;

    private Integer predetermineDay;

    private String passengerContactPhoneNumber;

    private String predetermineStateName;

    private Integer payWayID;

    private Integer type;


    private Roomset roomset;
    private String receptionName;
    private String personName;

    public Predetermine() {
    }

    public Integer getPredetermineID() {
        return predetermineID;
    }

    public void setPredetermineID(Integer predetermineID) {
        this.predetermineID = predetermineID;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public Integer getTuanduiID() {
        return tuanduiID;
    }

    public void setTuanduiID(Integer tuanduiID) {
        this.tuanduiID = tuanduiID;
    }

    public Integer getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Integer passengerID) {
        this.passengerID = passengerID;
    }

    public Timestamp getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Timestamp arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getPredetermineDay() {
        return predetermineDay;
    }

    public void setPredetermineDay(Integer predetermineDay) {
        this.predetermineDay = predetermineDay;
    }

    public String getPassengerContactPhoneNumber() {
        return passengerContactPhoneNumber;
    }

    public void setPassengerContactPhoneNumber(String passengerContactPhoneNumber) {
        this.passengerContactPhoneNumber = passengerContactPhoneNumber;
    }

    public String getPredetermineStateName() {
        return predetermineStateName;
    }

    public void setPredetermineStateName(String predetermineStateName) {
        this.predetermineStateName = predetermineStateName;
    }

    public Integer getPayWayID() {
        return payWayID;
    }

    public void setPayWayID(Integer payWayID) {
        this.payWayID = payWayID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Roomset getRoomset() {
        return roomset;
    }

    public void setRoomset(Roomset roomset) {
        this.roomset = roomset;
    }

    public String getReceptionName() {
        return receptionName;
    }

    public void setReceptionName(String receptionName) {
        this.receptionName = receptionName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Predetermine{" +
                "predetermineID=" + predetermineID +
                ", roomID=" + roomID +
                ", tuanduiID=" + tuanduiID +
                ", passengerID=" + passengerID +
                ", arriveTime=" + arriveTime +
                ", deposit=" + deposit +
                ", predetermineDay=" + predetermineDay +
                ", passengerContactPhoneNumber=" + passengerContactPhoneNumber +
                ", predetermineStateName='" + predetermineStateName + '\'' +
                '}';
    }
}