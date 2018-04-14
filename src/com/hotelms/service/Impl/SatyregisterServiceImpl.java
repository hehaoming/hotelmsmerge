package com.hotelms.service.Impl;


import com.hotelms.bean.StayRegisterBean;
import com.hotelms.dao.SatyregisterMapper;
import com.hotelms.service.SatyregisterService;
import com.hotelms.vo.PassengerStayRegisterVO;
import com.hotelms.vo.RoomStayRegisterVO;
import com.hotelms.vo.TeamStayRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class SatyregisterServiceImpl implements SatyregisterService {

    @Autowired
    SatyregisterMapper satyregisterMapper;
    @Override
    public List<TeamStayRegisterVO> getAllTeamObject(String txtname) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("txtname",txtname);
        return satyregisterMapper.getAllTeamObject(stringStringHashMap);
    }

    @Override
    public List<RoomStayRegisterVO> getAllRoomObject(int guestRoomLevelID) {
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("guestRoomLevelID",guestRoomLevelID);
        return satyregisterMapper.getAllRoomObject(stringStringHashMap);
    }

    @Override
    @Transactional
    public void saveStayRegister(StayRegisterBean stayRegisterBean, int LvKeLeiXingId, int tuanDuiId) {
        if(LvKeLeiXingId == 73){
            TeamStayRegisterVO teamVO = new TeamStayRegisterVO();
            teamVO.setTuanduiID(tuanDuiId);
            stayRegisterBean.setTeam(teamVO);
        }
        saveOneStayRegister(stayRegisterBean);
    }

    private void saveOneStayRegister(StayRegisterBean stayRegisterBean) {
        int sumConst = 0;
        RoomStayRegisterVO roomStayRegisterVO = satyregisterMapper.getRoomByRoomId(stayRegisterBean.getRoom().getRoomID());
        if(stayRegisterBean.getRentOutType().getItemDetailsID() == 74){
            sumConst = roomStayRegisterVO.getStandarPriceDay() * stayRegisterBean.getStayNumber();
        }else if (stayRegisterBean.getRentOutType().getItemDetailsID() == 75){
            int stayHourNumber = stayRegisterBean.getStayNumber() > roomStayRegisterVO.getFirstDuration()?
                    stayRegisterBean.getStayNumber():roomStayRegisterVO.getFirstDuration();
            sumConst = roomStayRegisterVO.getFirstPrice() +
                    (stayHourNumber - roomStayRegisterVO.getFirstDuration()) * roomStayRegisterVO.getStandarPrice();
        }
        stayRegisterBean.setSumConst(sumConst + "");
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("roomStateID",11);
        stringIntegerHashMap.put("roomID",stayRegisterBean.getRoom().getRoomID());
        satyregisterMapper.updateRoomState(stringIntegerHashMap);
        satyregisterMapper.saveStayRegister(stayRegisterBean);
    }

    @Override
    public List<StayRegisterBean> getAllStayRegisyerObject(int targetType) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("targetType",targetType);
        return satyregisterMapper.getAllStayRegisyerObject(hashMap);
    }

    @Override
    public List<PassengerStayRegisterVO> getAllPassengerObject(String txtname) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("txtname",txtname);
        return satyregisterMapper.getAllPassengerObject(stringStringHashMap);
    }

    @Override
    public PassengerStayRegisterVO getPassengerById(int id) {
        return satyregisterMapper.getPassengerById(id);
    }

    @Override
    @Transactional
    public void savePassengerAndRegister(PassengerStayRegisterVO passenger,int stayRegisterID) {
        int id = satyregisterMapper.savePassenger(passenger);
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("id",id);
        stringStringHashMap.put("stayRegisterID",stayRegisterID);
        satyregisterMapper.savePassengerRegister(stringStringHashMap);
    }

    @Override
    public void passengerRegister(PassengerStayRegisterVO passenger, int stayRegisterID) {
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("id",passenger.getId());
        stringStringHashMap.put("stayRegisterID",stayRegisterID);
        satyregisterMapper.savePassengerRegister(stringStringHashMap);
    }

    @Override
    public List<RoomStayRegisterVO> getRoomObjectByRoomId(String[] id) {
        return satyregisterMapper.getRoomObjectByRoomId(id);
    }

    @Override
    @Transactional
    public void volumeStayRegister(StayRegisterBean stayRegisterBean, int[] roomId) {
        RoomStayRegisterVO roomStayRegisterVO = new RoomStayRegisterVO();
        for(int room : roomId) {
            roomStayRegisterVO.setRoomID(room);
            stayRegisterBean.setRoom(roomStayRegisterVO);
            saveOneStayRegister(stayRegisterBean);
        }
    }

    @Override
    public StayRegisterBean getStayRegisyerObjectById(int id) {
        return satyregisterMapper.getStayRegisyerObjectById(id);
    }

    @Override
    @Transactional
    public void changeStayRegisterRoom(String id, String roomId, String changRoomMoney, String changRoomTime) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("stayregisterdetailId",id);
        stringStringHashMap.put("room",roomId );
        stringStringHashMap.put("changingRoomTime",changRoomTime);
        stringStringHashMap.put("changingRoomMoney",changRoomMoney);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("roomStateID",11);
        stringIntegerHashMap.put("roomID",Integer.parseInt(roomId));
        satyregisterMapper.updateRoomState(stringIntegerHashMap);
        StayRegisterBean stayRegisyerObjectById = satyregisterMapper.getStayRegisyerObjectById(Integer.parseInt(id));
        stringIntegerHashMap.put("roomStateID",1);
        stringIntegerHashMap.put("roomID",stayRegisyerObjectById.getRoom().getRoomID());
        satyregisterMapper.updateRoomState(stringIntegerHashMap);
        satyregisterMapper.changeStayRegisterRoom(stringStringHashMap);
    }

    @Override
    public void addDeposit(int depositPayWayID, int stayregisterdetailId, int deposit) {
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("stayregisterdetailId",stayregisterdetailId);
        stringStringHashMap.put("depositPayWayId",depositPayWayID);
        stringStringHashMap.put("deposit",deposit);
/*        satyregisterMapper.addDeposit(stringStringHashMap);*/

    }

}
