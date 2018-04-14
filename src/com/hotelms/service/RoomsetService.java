package com.hotelms.service;

import com.hotelms.bean.ItemBean;
import com.hotelms.bean.RoomVo;
import com.hotelms.bean.Roomset;
import com.hotelms.utils.Page;

import java.util.List;

public interface RoomsetService {

    boolean addNewRoom(Roomset roomset);

    Roomset findRoomByRoomNumber(String roomNumber);

    List<Roomset> findAllRoom();

    boolean updateRoomInformationById(Roomset roomset);

    boolean deleteRoomById(RoomVo vo);

    Page findPartRoom(String num);

    Page findPartRoomBycondition(String txtname, String num);

    Roomset findRoomByRoomID(String id);

    List<ItemBean>  getListOfItem(int i);


    void deleteRoomByIds(String[] roomIDs);

    /**
     * 查询可用房间，并将房态字段和房间级别字段注入
     * @param roomNumber 房间号
     * @return 可用房间集合
     */
    public List<Roomset> findUsableRooms(String roomNumber);
}
