package com.hotelms.dao;

import com.hotelms.bean.RoomVo;
import com.hotelms.bean.Roomset;

import java.util.HashMap;
import java.util.List;

public interface RoomsetMapper {

    int deleteByPrimaryKey(Integer roomid);

    Roomset selectByPrimaryKey(Integer roomid);

    int updateByPrimaryKeySelective(Roomset record);

    int updateByPrimaryKey(Roomset record);

    boolean addNewRoom(Roomset roomset);

    Roomset findRoomByRoomNumber(String roomNumber);

    List<Roomset> findAllRoom();

    boolean deleteRoomById(RoomVo vo);

    int findTotalRecordsNum();

    List<RoomVo> findPartRooms(HashMap<String, Integer> map);

    List<RoomVo> findPartRoomBycondition(HashMap<String, Object> map);

    Roomset findRoomByRoomID(String id);

    int findTotalRecordsNumBycondition(String txtname);

    void deleteRoomByIds(String[] roomIDs);

     /**
     * 查询可用房间
     * @return 可用房间集合
     */
    public List<Roomset> selectUsableRooms();

    /**
     * 根据ID改变房间状态
     * 从1空房 改变为 3预定
     * @param roomId
     */
    public void updateRoomStateIDByIDToPreable(int roomId);

    /**
     * 根据ID改变房间状态
     * 改变为 1可用
     * @param roomId 房间id
     */
    public void updateRoomStateIDByIDToUsable(int roomId);

    /**
     * 根据id更改房间状态为满
     * 改变为 11满
     * @param roomID 房间id
     */
    public void updateRoomStateIDByIDToUsed(Integer roomID);

    /**
     * 根据ID查询房间信息
     * @param roomID 房间id
     * @return 房间信息
     */
    public Roomset selectRoomByID(Integer roomID);
}