package com.hotelms.service.Impl;

import com.hotelms.bean.ItemBean;
import com.hotelms.bean.RoomVo;
import com.hotelms.bean.Roomset;
import com.hotelms.dao.ItemMapper;
import com.hotelms.dao.RoomsetMapper;
import com.hotelms.service.RoomsetService;
import com.hotelms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RoomsetServiceImpl implements RoomsetService{

    @Autowired
    RoomsetMapper roomsetMapper;

    @Autowired
    ItemMapper itemMapper;


    @Override
    public boolean addNewRoom(Roomset roomset) {

        boolean b = roomsetMapper.addNewRoom(roomset);
        //System.out.println("service b=" + b);
        return b;
    }

    @Override
    public Roomset findRoomByRoomNumber(String roomNumber) {

        Roomset roomByRoomNumber = roomsetMapper.findRoomByRoomNumber(roomNumber);
        return roomByRoomNumber;
    }

    @Override
    public List<Roomset> findAllRoom() {

        List<Roomset> allRoom = roomsetMapper.findAllRoom();

        return allRoom;
    }

    @Override
    public boolean updateRoomInformationById(Roomset roomset) {

        roomsetMapper.updateByPrimaryKey(roomset);

        return true;

    }

    @Override
    public boolean deleteRoomById(RoomVo vo) {

        boolean b = roomsetMapper.deleteRoomById(vo);

        return b;
    }

    /**
     * 分页显示查询
     * @param num
     * @return
     */
    @Override
    public Page findPartRoom(String num) {
        //查询总记录数
        int totalRecordsNum = roomsetMapper.findTotalRecordsNum();
        //当前处于第几页
        int currentPage = Integer.parseInt(num);
        //得到page对象,关于页码的计算由Page完成
        Page<RoomVo> roomsetPage = new Page<>(totalRecordsNum, currentPage, Page.ROOMSET_PER_PAGE_NUM);
        //查询分页需要的参数
        int limit = Page.ROOMSET_PER_PAGE_NUM;
        int offset = (currentPage - 1) * Page.ROOMSET_PER_PAGE_NUM;
        //构建查询参数
        HashMap<String,Integer> map = new HashMap<>();
        map.put("limit",limit);
        map.put("offset",offset);
        //查询本页记录
        List<RoomVo> roomVos = roomsetMapper.findPartRooms(map);
        roomsetPage.setResult(roomVos);
        return roomsetPage;
    }

    /**
     * 条件查询
     * @param txtname
     * @param num
     * @return
     */
    @Override
    public Page findPartRoomBycondition(String txtname, String num) {
        //查询总记录数
        int totalRecordsNum = roomsetMapper.findTotalRecordsNumBycondition(txtname);
        //当前处于第几页
        int currentPage = Integer.parseInt(num);
        //得到page对象,关于页码的计算由Page完成
        Page<RoomVo> roomsetPage = new Page<>(totalRecordsNum, currentPage, Page.ROOMSET_PER_PAGE_NUM);
        //查询分页需要的参数
        int limit = Page.ROOMSET_PER_PAGE_NUM;
        int offset = (currentPage - 1) * Page.ROOMSET_PER_PAGE_NUM;
        //构建查询参数
        HashMap<String,Object> map = new HashMap<>();
        map.put("txtname",txtname);
        map.put("limit",limit);
        map.put("offset",offset);
        //查询本页记录
        List<RoomVo> roomVos = roomsetMapper.findPartRoomBycondition(map);
        roomsetPage.setResult(roomVos);
        return roomsetPage;
    }



    @Override
    public Roomset findRoomByRoomID(String id) {

        Roomset room = roomsetMapper.findRoomByRoomID(id);

        return room;
    }


    @Override
    public List<ItemBean> getListOfItem(int i) {

        List<ItemBean> listOfItem = itemMapper.getListOfItem(i);

        return listOfItem;
    }


    @Override
    public void deleteRoomByIds(String[] roomIDs) {
        roomsetMapper.deleteRoomByIds(roomIDs);
    }


    /**
     * 查询可用房间，并将房态字段和房间级别字段注入
     * @param roomNumber 房间号
     * @return 可用房间集合
     */
    public List<Roomset> findUsableRooms(String roomNumber) {

        List<Roomset> roomsets;
        if(roomNumber == null || roomNumber.length() == 0) {
            roomsets = roomsetMapper.selectUsableRooms();
        }else {
            roomsets = roomsetMapper.selectUsableRoomsByRoomNumber("%" + roomNumber + "%");
        }
        if(roomsets != null && roomsets.size() != 0) {
            for (Roomset roomset : roomsets) {
                roomset.setRoomStateName("空房");
                roomset.setGuestRoomLevelName(itemMapper.getOneNameOfItem(roomset.getGuestRoomLevelID()));
            }
        }
        return roomsets;
    }

}
