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
        if(LvKeLeiXingId == 56){
            TeamStayRegisterVO teamVO = new TeamStayRegisterVO();
            teamVO.setTuanduiID(tuanDuiId);
            stayRegisterBean.setTeam(teamVO);
        }
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

}
