package com.hotelms.service;


import com.hotelms.bean.StayRegisterBean;
import com.hotelms.vo.PassengerStayRegisterVO;
import com.hotelms.vo.RoomStayRegisterVO;
import com.hotelms.vo.TeamStayRegisterVO;

import java.util.List;

public interface SatyregisterService {

    List<TeamStayRegisterVO> getAllTeamObject(String txtname);
    List<RoomStayRegisterVO> getAllRoomObject(int guestRoomLevelID);
    void saveStayRegister(StayRegisterBean stayRegisterBean,int LvKeLeiXingId,int tuanDuiId);

    List<StayRegisterBean> getAllStayRegisyerObject(int targetType);

    List<PassengerStayRegisterVO> getAllPassengerObject(String txtname);

    PassengerStayRegisterVO getPassengerById(int id);

    void savePassengerAndRegister(PassengerStayRegisterVO passenger,int stayRegisterID);

    void passengerRegister(PassengerStayRegisterVO passenger, int stayRegisterID);

    List<RoomStayRegisterVO> getRoomObjectByRoomId(String[] id);

    void volumeStayRegister(StayRegisterBean stayRegisterBean, int[] roomId);

    StayRegisterBean getStayRegisyerObjectById(int id);

    void changeStayRegisterRoom(String id, String roomId, String changRoomMoney, String changRoomTime);

    void addDeposit(int depositPayWayID, int stayregisterdetailId, int deposit);
}
