package com.hotelms.dao;

import com.hotelms.bean.Passenger;
import com.hotelms.bean.PassengerVO;

import java.util.HashMap;
import java.util.List;

public interface PassengerMapper {
    int deleteByPrimaryKey(String[] arrs);

    Passenger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Passenger record);

    int updateByPrimaryKey(Passenger record);

    int addpassenge(Passenger passenger);

    List<PassengerVO> selectAllPassenger(HashMap hashMap);

    List<PassengerVO> selectPassengerByName(HashMap hashMap);

    int selectAccount();

     /**
     * 查询所有旅客信息
     * @return 所有旅客信息集合
     */
    public List<Passenger> selectAllPassengers();

    /**
     * 根据ID查询旅客电话信息
     * @param id 旅客id
     * @return 旅客电话信息
     */
    public String selectPassengerPhoneNumberByID(int id);

    /**
     * 根据id查询旅客信息
     * @param id 旅客id
     * @return 旅客信息
     */
    public Passenger selectPassengerByID(int id);

    /**
     * 根据模糊匹配关键字查询id数组
     * @param txtname 模糊匹配关键字
     * @return id数组
     */
    public int[] selectIDsByLikeName(String txtname);
}