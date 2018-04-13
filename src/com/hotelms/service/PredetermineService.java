package com.hotelms.service;

;
import com.hotelms.bean.ItemBean;
import com.hotelms.bean.Predetermine;


import java.util.ArrayList;
import java.util.List;

public interface PredetermineService {


    /**
     * 构建listOne状态集合
     * @return list状态集合
     */
    public ArrayList<ItemBean> getListOne();

    /**
     * 根据参数匹配查询符合条件的预订项
     * @param txtname 接待对象或旅客姓名匹配字段
     * @param state 状态码 0未安排 1已安排
     *
     */
    public List<Predetermine> findSomePredeterminesByStateAndName(String txtname, int state);

    /**
     * 增加预订单项
     * 有多少个房间增加多少订单项
     * @param id 团队或者旅客id
     * @param roomIdShuZu 房间id数组
     * @param predetermine 提交的数据包装类，主要有predetermineDay预定天数 deposit押金 arriveTime到达时间 type 1团队 2旅客
     *                     如果是修改页面提交的，会有predetermineID的值    add页面即为0
     */
    public void addPredetermine(String id,String[] roomIdShuZu,Predetermine predetermine);

    /**
     * 根据id修改订单项
     * @param id 订单项id
     */
    public void updatePredetermine(int id);

    /**
     * 根据预订单id查询订单项
     * @param id 订单项id
     * @return 订单项信息
     */
    public Predetermine findPredetermineByID(int id);

    /**
     * 根据预订单id数组删除预订单
     * @param ids 预订单id数组
     */
    public void deletePredetermines(int[] ids);

    /**
     * 根据预订单id数组将预订单转存入订单中，并更改预订单状态为“已完成”,更改房间状态信息为“满”
     * @param ids 预订单id数组
     */
    public void arrangeRoomToStayRegister(int[] ids);
}
