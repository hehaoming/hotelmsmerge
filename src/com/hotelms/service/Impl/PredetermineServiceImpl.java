package com.hotelms.service.Impl;

import com.hotelms.bean.*;
import com.hotelms.dao.*;
import com.hotelms.service.PredetermineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service("PredetermineService")
public class PredetermineServiceImpl implements PredetermineService {

    @Autowired
    PredetermineMapper predetermineMapper;

    @Autowired
    PassengerMapper passengerMapper;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    RoomsetMapper roomsetMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    SatyregisterMapper stayregisterMapper;

    /**
     * 构建listOne状态集合 已安排 未安排
     * @return list状态集合
     */
    public ArrayList<ItemBean> getListOne() {

        ItemBean item = new ItemBean(0,0, "未安排");
        ItemBean item1 = new ItemBean(1,1, "已安排");
        ArrayList<ItemBean> list = new ArrayList<ItemBean>();
        list.add(item);
        list.add(item1);
        return list;
    }

    /**
     * 根据参数匹配查询符合条件的预订项
     * @param txtname 接待对象或旅客姓名匹配字段
     * @param state 状态码 0未安排 1已安排
     * @return 匹配结果 预订项集合
     */
    public List<Predetermine> findSomePredeterminesByStateAndName(String txtname, int state) {

        String stateName = state == 0 ? "未安排" : "已安排";
        List<Predetermine> predetermines;//查询结果
        if(txtname == null || txtname.length() == 0) {
            //从主页面跳转，没有两个参数的值时，或从list.jsp页面搜索跳转没有txtname时，此时state或有值或为默认值0
            //查询符合state的所有的预订项
            predetermines = predetermineMapper.selectSomePredeterminesByState(stateName);
        }else {
            //从list.jsp页面搜索跳转有txtname时，此时state有值
            //根据txtname的值查询预订项
            HashMap<String,Object> map = new HashMap<String, Object>();
            txtname = "%" + txtname + "%";
            map.put("stateName",stateName);
            int[] teamIds = teamMapper.selectIDsByLikeName(txtname);
            int[] passengerIDs = passengerMapper.selectIDsByLikeName(txtname);
            if(teamIds.length == 0 && passengerIDs.length == 0) {
                predetermines = new ArrayList<Predetermine>();
            }else {
                map.put("teamIds", teamIds);
                map.put("passengerIDs", passengerIDs);
                predetermines = predetermineMapper.selectSomePredeterminesByStateAndIds(map);
            }
        }
        System.out.println(predetermines);
        for (Predetermine predetermine : predetermines) {
            predetermine = setRoomAndNameIntoPredetermine(predetermine);
        }
        System.out.println(predetermines);
        return predetermines;
    }

    /**
     * 增加预订单项
     * 有多少个房间增加多少订单项
     * @param id 团队或者旅客id
     * @param roomIdShuZu 房间id数组
     * @param predetermine 提交的数据包装类，主要有predetermineDay预定天数 deposit押金 arriveTime到达时间 type 1团队 2旅客
     *                     如果是修改页面提交的，会有predetermineID的值    add页面即为0
     */
    @Transactional
    public void addPredetermine(String id,String[] roomIdShuZu,Predetermine predetermine) {

        //循环增加预定项
        for(String roomId : roomIdShuZu) {
            predetermine.setRoomID(Integer.valueOf(roomId));
            String phoneNumber;
            //根据type判断id存入tuanduiid或passengerid
            if(predetermine.getType() == 1) {
                predetermine.setTuanduiID(Integer.valueOf(id));
                phoneNumber = passengerMapper.selectPassengerPhoneNumberByID(Integer.parseInt(id));
            }else {
                predetermine.setPassengerID(Integer.valueOf(id));
                phoneNumber = teamMapper.selectTeamPhoneNumberByID(Integer.parseInt(id));
            }
            predetermine.setPassengerContactPhoneNumber(phoneNumber);
            predetermine.setPredetermineStateName("未安排");
            predetermineMapper.insertPredetermine(predetermine);//增加预定项
            roomsetMapper.updateRoomStateIDByIDToPreable(Integer.parseInt(roomId));//改变房间状态
        }
        //修改页面的删除订单项
        if(predetermine.getPredetermineID() !=  null && predetermine.getPredetermineID() > 0) {
            //如果修改去除了这个原有房间则修改原有房间状态
            Predetermine oldPredetermine = predetermineMapper.selectPredetermineByID(predetermine.getPredetermineID());
            if(!Arrays.toString(roomIdShuZu).contains(oldPredetermine.getRoomID() + "")) {
                roomsetMapper.updateRoomStateIDByIDToUsable(oldPredetermine.getRoomID());//改变房间状态
            }
            predetermineMapper.deletePredetermineByID(predetermine.getPredetermineID());
        }
    }

    /**
     * 根据id修改订单项
     * @param id 订单项id
     */
    @Transactional
    public void updatePredetermine(int id) {

    }

    /**
     * 根据订单id查询订单项
     * @param id 订单项id
     * @return 订单项信息
     */
    public Predetermine findPredetermineByID(int id) {

        Predetermine predetermine = predetermineMapper.selectPredetermineByID(id);
        predetermine = setRoomAndNameIntoPredetermine(predetermine);
        return predetermine;
    }

    /**
     * 根据预订单id数组删除预订单
     * @param ids 预订单id数组
     */
    @Transactional
    public void deletePredetermines(int[] ids) {
        //删除订单并更改房间房态
        for (int id : ids) {
            Predetermine predetermine = predetermineMapper.selectPredetermineByID(id);
            roomsetMapper.updateRoomStateIDByIDToUsable(predetermine.getRoomID());//更改房态
            predetermineMapper.deletePredetermineByID(id);//删除预订单
        }
    }

    /**
     * 根据预订单id数组将预订单转存入订单中，并更改预订单状态为“已完成”,更改房间状态信息为“满”
     * @param ids 预订单id数组
     */
    @Transactional
    public void arrangeRoomToStayRegister(int[] ids) {

        for(int id : ids) {
            Predetermine predetermine = predetermineMapper.selectPredetermineByID(id);
            stayregisterMapper.insertRegisterByPredetermine(predetermine);//增加订单
            predetermineMapper.updatePredetermineStateNameToOverById(id);//更改预订单状态为已安排
            roomsetMapper.updateRoomStateIDByIDToUsed(predetermine.getRoomID());//更改房间状态为满
        }
    }

    /**
     * 私有方法
     * 根据订单项的信息将对象名称，牵扯房间信息查询并注入
     * @param predetermine 订单项信息
     * @return 含有接待对象名称和房间信息的订单对象
     */
    private Predetermine setRoomAndNameIntoPredetermine(Predetermine predetermine) {

        predetermine.setRoomset(roomsetMapper.selectRoomByID(predetermine.getRoomID()));
        predetermine.getRoomset().setGuestRoomLevelName(itemMapper.getOneNameOfItem(predetermine
                .getRoomset().getGuestRoomLevelID()));
        if(predetermine.getTuanduiID() == null || predetermine.getTuanduiID() == 0) {
            //不是团队，是旅客
            Passenger passenger = passengerMapper.selectPassengerByID(predetermine.getPassengerID());
            predetermine.setReceptionName("散客");
            predetermine.setPersonName(passenger.getName());
        }else {
            //是团队
            Team team = teamMapper.selectTeamByID(predetermine.getTuanduiID());
            predetermine.setReceptionName(team.getTeamName());
            predetermine.setPersonName(team.getPrincipal());
        }
        System.out.println(predetermine.getRoomset());
        return predetermine;
    }
}
