package com.hotelms.bean;

import com.hotelms.vo.PassengerStayRegisterVO;
import com.hotelms.vo.RoomStayRegisterVO;
import com.hotelms.vo.TeamStayRegisterVO;

public class StayRegisterBean {

    private int stayregisterdetailId;
    private RoomStayRegisterVO room;
    private PassengerStayRegisterVO passenger;
    private TeamStayRegisterVO team;
    private ItemBean passengerType;
    private ItemBean rentOutType;
    private int stayNumber;
    private int deposit;
    private ItemBean billUnit;
    private ItemBean depositPayWay;
    private String changingRoomNumber;
    private String changingRoomMoney;
    private String changingRoomTime;
    private String stayRegisterTime;
    private int isBillId;
    private String sumConst;
    public int getStayregisterdetailId() {
        return stayregisterdetailId;
    }

    public void setStayregisterdetailId(int stayregisterdetailId) {
        this.stayregisterdetailId = stayregisterdetailId;
    }

    public RoomStayRegisterVO getRoom() {
        return room;
    }

    public void setRoom(RoomStayRegisterVO room) {
        this.room = room;
    }

    public PassengerStayRegisterVO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerStayRegisterVO passenger) {
        this.passenger = passenger;
    }

    public TeamStayRegisterVO getTeam() {
        return team;
    }

    public void setTeam(TeamStayRegisterVO team) {
        this.team = team;
    }

    public ItemBean getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(ItemBean passengerType) {
        this.passengerType = passengerType;
    }

    public ItemBean getRentOutType() {
        return rentOutType;
    }

    public void setRentOutType(ItemBean rentOutType) {
        this.rentOutType = rentOutType;
    }

    public int getStayNumber() {
        return stayNumber;
    }

    public void setStayNumber(int stayNumber) {
        this.stayNumber = stayNumber;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public ItemBean getBillUnit() {
        return billUnit;
    }

    public void setBillUnit(ItemBean billUnit) {
        this.billUnit = billUnit;
    }

    public ItemBean getDepositPayWay() {
        return depositPayWay;
    }

    public void setDepositPayWay(ItemBean depositPayWay) {
        this.depositPayWay = depositPayWay;
    }


    public int getIsBillId() {
        return isBillId;
    }

    public void setIsBillId(int isBillId) {
        this.isBillId = isBillId;
    }


    public String getSumConst() {
        return sumConst;
    }

    public void setSumConst(String sumConst) {
        this.sumConst = sumConst;
    }

    @Override
    public String toString() {
        return "StayRegisterBean{" +
                "stayregisterdetailId=" + stayregisterdetailId +
                ", room=" + room +
                ", passenger=" + passenger +
                ", team=" + team +
                ", passengerType=" + passengerType +
                ", rentOutType=" + rentOutType +
                ", stayNumber=" + stayNumber +
                ", deposit=" + deposit +
                ", billUnit=" + billUnit +
                ", depositPayWay=" + depositPayWay +
                ", changingRoomNumber='" + changingRoomNumber + '\'' +
                ", changingRoomMoney='" + changingRoomMoney + '\'' +
                ", changingRoomTime='" + changingRoomTime + '\'' +
                ", stayRegisterTime='" + stayRegisterTime + '\'' +
                ", isBillId=" + isBillId +
                ", sumConst='" + sumConst + '\'' +
                '}';
    }

    public String getChangingRoomNumber() {
        return changingRoomNumber;
    }

    public void setChangingRoomNumber(String changingRoomNumber) {
        this.changingRoomNumber = changingRoomNumber;
    }

    public String getChangingRoomMoney() {
        return changingRoomMoney;
    }

    public void setChangingRoomMoney(String changingRoomMoney) {
        this.changingRoomMoney = changingRoomMoney;
    }

    public String getChangingRoomTime() {
        return changingRoomTime;
    }

    public void setChangingRoomTime(String changingRoomTime) {
        this.changingRoomTime = changingRoomTime;
    }

    public String getStayRegisterTime() {
        return stayRegisterTime;
    }

    public void setStayRegisterTime(String stayRegisterTime) {
        this.stayRegisterTime = stayRegisterTime;
    }
}
