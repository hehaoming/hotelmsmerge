package com.hotelms.dao;

import com.hotelms.bean.Consumption;
import com.hotelms.bean.StayRegister;

import java.util.HashMap;
import java.util.List;

public interface FinancialStatisticsMapper {


    /**
     * 查询所有已结账订单的个数
     * @param map 含有查询条件
     *            key datemin 最早时间 可能为空
     *            key datemax 最晚时间 可能为空
     * @return 已结账订单的个数
     */
    public int selectAllBilledStayRegisterNumberWithDate(HashMap map);

    /**
     * 查询所有已结账订单信息
     * @param map 含有查询条件
     *            key datemin 最早时间 可能为空
     *            key datemax 最晚时间 可能为空
     *            key limit 查询数据个数
     *            key offset 查询起始位置
     * @return 已结账订单集合
     */
    public List<StayRegister> selectSomeBilledStayRegistersWithDate(HashMap map);

    /**
     * 根据订单id查询与此相关的消费信息
     * @param stayRegisterDetailId 订单id
     * @return 消费信息集合
     */
    public List<Consumption> selectConsumptionsByStayId(Integer stayRegisterDetailId);
}
