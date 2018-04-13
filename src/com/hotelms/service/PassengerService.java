package com.hotelms.service;

import com.hotelms.bean.ItemBean;
import com.hotelms.bean.Passenger;
import com.hotelms.bean.PassengerVO;

import java.util.List;

public interface PassengerService {
    int AddPassenger(Passenger passenger);

    /*
     * 获取某一分类下的具体类别
     * @param itemID：分类的id
     * @return List<ItemBean>分下类下的所有类别名称
     * */
    public List<ItemBean>  getListOfItem(int itemID);

    List<PassengerVO> selectAllPassenger(int currentage,int limit);

    List<PassengerVO> selectPassengerByName(String name, int currentage, int limit);

    int deleteByPrimaryKey(String[] arrs);

    Passenger selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Passenger passenger);

    int selectAccount();

    

    /**
     * 查询所有的旅客信息，并将旅客信息中的性别信息字段、证件信息名称字段查询并加入
     * @return 旅客信息集合
     */
    public List<Passenger> findAllPassengersWithPaperNameAndSexName();


    /**
     * 根据旅客ID查询旅客电话信息
     * @param id
     * @return 旅客电话信息
     */
    public String findPassengerPhoneNumberByID(int id);

}
