package com.hotelms.bean;


public class RoomVo extends Roomset{

    String roomName;

    String guestRoomLevel;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getGuestRoomLevel() {
        return guestRoomLevel;
    }

    public void setGuestRoomLevel(String guestRoomLevel) {
        this.guestRoomLevel = guestRoomLevel;
    }

    @Override
    public String toString() {
        return "RoomVo{" +
                "roomName='" + roomName + '\'' +
                ", guestRoomLevel='" + guestRoomLevel + '\'' +
                '}';
    }
}
