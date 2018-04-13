package com.hotelms.dao;

import com.hotelms.bean.Predetermine;
import com.hotelms.bean.StayRegisterBean;
import com.hotelms.vo.PassengerStayRegisterVO;
import com.hotelms.vo.RoomStayRegisterVO;
import com.hotelms.vo.TeamStayRegisterVO;

import java.util.HashMap;
import java.util.List;

public interface SatyregisterMapper {
    List<TeamStayRegisterVO> getAllTeamObject(HashMap hashMap);
    List<RoomStayRegisterVO> getAllRoomObject(HashMap hashMap);

    int saveStayRegister(StayRegisterBean stayRegisterBean);
    int updateRoomState(HashMap hashMap);

    List<StayRegisterBean> getAllStayRegisyerObject(HashMap hashMap);

    RoomStayRegisterVO getRoomByRoomId(int roomId);

    List<PassengerStayRegisterVO> getAllPassengerObject(HashMap stringStringHashMap);

        /**
     * 根据预订单增加订单
     * @param predetermine 预订单信息
     */
    public void insertRegisterByPredetermine(Predetermine predetermine);
}
