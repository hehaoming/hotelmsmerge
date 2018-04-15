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
    //from 陈志雄  标记
    List<StayRegisterBean> analysisAllInfo();

    RoomStayRegisterVO getRoomByRoomId(int roomId);

    List<PassengerStayRegisterVO> getAllPassengerObject(HashMap stringStringHashMap);


   /**
     * 根据预订单增加订单
     * @param map 预订单信息和总价格
     */
    public void insertRegisterByPredetermine(HashMap map);

    PassengerStayRegisterVO getPassengerById(int id);

    int savePassenger(PassengerStayRegisterVO passenger);

    void savePassengerRegister(HashMap hashMap);

    List<RoomStayRegisterVO> getRoomObjectByRoomId(String[] id);

    StayRegisterBean getStayRegisyerObjectById(int id);

    void changeStayRegisterRoom(HashMap<String, String> stringStringHashMap);

    void addDeposit(HashMap<String, Integer> stringStringHashMap);

    void updateStayRegisterTeam(HashMap<String, Integer> stringStringHashMap);

    List<StayRegisterBean> getIsBillStayRegisyerObject(HashMap<String, Integer> hashMap);
}
