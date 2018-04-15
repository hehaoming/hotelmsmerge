package com.hotelms.dao;

import com.hotelms.bean.Predetermine;
import com.hotelms.bean.StayRegister;
import com.hotelms.bean.StayRegisterBean;
import com.hotelms.vo.PassengerStayRegisterVO;
import com.hotelms.vo.RoomStayRegisterVO;
import com.hotelms.vo.TeamStayRegisterVO;

import java.util.HashMap;
import java.util.List;

public interface SatyregisterMapper {
    List<TeamStayRegisterVO> getAllTeamObject(HashMap hashMap);
    List<RoomStayRegisterVO> getAllRoomObject(HashMap hashMap);

    int saveStayRegister(StayRegisterBean stayRegisterBean);
    int updateRoomState(HashMap hashMap);

    List<StayRegisterBean> getAllStayRegisyerObject(HashMap hashMap);
    //from 陈志雄  标记
    List<StayRegisterBean> analysisAllInfo();

    RoomStayRegisterVO getRoomByRoomId(int roomId);

    List<PassengerStayRegisterVO> getAllPassengerObject(HashMap stringStringHashMap);


   /**
     * 根据预订单增加订单
     * @param map 预订单信息和总价格
     */
    public void insertRegisterByPredetermine(HashMap map);

    PassengerStayRegisterVO getPassengerById(int id);

    int savePassenger(PassengerStayRegisterVO passenger);

    void savePassengerRegister(HashMap hashMap);

    List<RoomStayRegisterVO> getRoomObjectByRoomId(String[] id);

    StayRegisterBean getStayRegisyerObjectById(int id);

    void changeStayRegisterRoom(HashMap<String, String> stringStringHashMap);

    void addDeposit(HashMap<String, Integer> stringStringHashMap);

    void updateStayRegisterTeam(HashMap<String, Integer> stringStringHashMap);

    /**
     * 改变订单状态为已结账，增加结账时间，结账方式
     * @param map 结账时间，结账方式，订单id
     *            key id 订单id
     *            key payTime 结账时间
     *            key payWay 结账方式id
     */
    public void updateSatyRegisterWhenPay(HashMap<String, Object> map);

    /**
     * 根据结账情况，团队id，房间情况关键字搜索部分订单
     * @param map 含有结账状态，团队id，房间关键字的map集合
     *          key isBillID 是否结账 0未结账 1已结账 可能为空
     *          key tuanDuiID 团队id 可能为空
     *          key txtname 房间号关键字 可能为空
     * @return 符合条件的订单集合
     */
    public List<StayRegisterBean> selectStayRegistersByTeamIdAndBillIdAndRoomId(HashMap<String, Object> map);

    /**
     * 根据团队id查找未结账的订单集合
     * @param tuanDuiID 团队id
     * @return 订单集合
     */
    public List<StayRegisterBean> selectNotBilledStayRegistersByTeamId(int tuanDuiID);

    /**
     * 根据团队id查找在某个时间段的订单信息
     * @param map 查询条件集合
     *              key teamID 团队id
     *              key datemin 最早时间
     *              key datemax 最晚时间
     * @return 订单集合
     */
    public List<StayRegisterBean> selectUnBilledRegistersByDateAndId(HashMap<String, String> map);

    List<StayRegisterBean> getIsBillStayRegisyerObject(HashMap<String, Integer> hashMap);
}
