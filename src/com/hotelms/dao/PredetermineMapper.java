package com.hotelms.dao;


import com.hotelms.bean.Predetermine;

import java.util.HashMap;
import java.util.List;

public interface PredetermineMapper {


    /**
     * 根据状态查询预订项
     * @param stateName 未完成 已完成
     * @return 查询结果 预订项集合
     */
    public List<Predetermine> selectSomePredeterminesByState(String stateName);

    /**
     * 根据状态和接待对象名称关键字查询预订项
     * @param map key=stateName 状态 teamIds 团队id数组  passengerIDs 旅客id数组
     * @return 查询结果 预订项集合
     */
    public List<Predetermine> selectSomePredeterminesByStateAndIds(HashMap<String, Object> map);

    /**
     * 增加预定项
     * @param predetermine
     */
    public void insertPredetermine(Predetermine predetermine);

    /**
     * 根据订单项id查询订单项信息
     * @param id 订单项id
     * @return 订单项信息
     */
    public Predetermine selectPredetermineByID(int id);

    /**
     * 根据id删除订单项
     * @param id 订单项id
     */
    public void deletePredetermineByID(Integer id);

    /**
     * 根据预订单id更改预订单状态为已安排
     * @param id 预订单id
     */
    public void updatePredetermineStateNameToOverById(int id);
}