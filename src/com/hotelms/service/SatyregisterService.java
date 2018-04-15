package com.hotelms.service;


import com.hotelms.bean.ListBean;
import com.hotelms.bean.StayRegisterBean;
import com.hotelms.vo.PassengerStayRegisterVO;
import com.hotelms.vo.RoomStayRegisterVO;
import com.hotelms.vo.TeamStayRegisterVO;

import java.util.HashMap;
import java.util.List;

public interface SatyregisterService {

    List<TeamStayRegisterVO> getAllTeamObject(String txtname);
    List<RoomStayRegisterVO> getAllRoomObject(int guestRoomLevelID);
    void saveStayRegister(StayRegisterBean stayRegisterBean,int LvKeLeiXingId,int tuanDuiId);

    List<StayRegisterBean> getAllStayRegisyerObject(int targetType);

    List<PassengerStayRegisterVO> getAllPassengerObject(String txtname);

    PassengerStayRegisterVO getPassengerById(int id);

    void savePassengerAndRegister(PassengerStayRegisterVO passenger,int stayRegisterID);

    void passengerRegister(PassengerStayRegisterVO passenger, int stayRegisterID);

    List<RoomStayRegisterVO> getRoomObjectByRoomId(String[] id);

    void volumeStayRegister(StayRegisterBean stayRegisterBean, int[] roomId);

    StayRegisterBean getStayRegisyerObjectById(int id);

    void changeStayRegisterRoom(String id, String roomId, String changRoomMoney, String changRoomTime);

    void addDeposit(int depositPayWayID, int stayregisterdetailId, int deposit);

    /**
     * 获取应补缴金额，商品消费金额，住宿费
     * @param stayRegisterBean 含有订单及其关联信息的订单包装类
     * @return 应补缴金额，商品消费金额，住宿费的map集合
     *          key yingBuJinE 应补缴金额
     *          key shangPinXiaoFei 商品消费金额
     *          key zhuSuFei 住宿费
     */
    public HashMap<String,Object> getDetailMoney(StayRegisterBean stayRegisterBean);

    /**
     * 根据id改变订单状态，填入订单结账时间和结账方式
     * 根据房间id改变房间状态为可用
     * @param id 订单id
     * @param payTime 结账时间
     * @param payWay 结账方式id
     * @param roomId 房间id
     */
    public void updateStayRegisterAndRoomWhenPay(int id, String payTime, int payWay, int roomId);

    /**
     * 根据结账情况，团队id，房间情况关键字搜索部分订单项
     * @param isBillID 是否结账
     * @param tuanDuiID 团队id
     * @param txtname 房间号关键字
     * @return 含有符合条件的订单集合的分页对象
     */
    public ListBean findStayRegistersByTeamIdAndBillIdAndRoomId(String isBillID, String tuanDuiID, String txtname);

    /**
     * 计算订单集合的总金额
     * @param stayRegisterBeans 订单集合
     * @return 总金额
     */
    public int getTotalMoney(List<StayRegisterBean> stayRegisterBeans);

    /**
     * 根据团队id查找未结账的订单集合
     * @param tuanDuiID 团队id
     * @return 订单集合
     */
    public List<StayRegisterBean> getStayRegistersByTeamAndNotBilled(int tuanDuiID);

    /**
     * 计算订单集合中详细的金额
     * @param registerBeans 订单集合
     * @return 带有详细信息的map集合
     *          key stayMoney 住宿费
     *          key changRoomMoney 换房费
     *          key otherMoney 其他（商品）
     *          key payMoney 结账金额
     *          key depositMoney 押金
     *          key payRepairMoney 应补金额
     */
    public HashMap<String,Integer> getTotalDetailMoney(List<StayRegisterBean> registerBeans);

    /**
     * 根据订单id改变订单状态和房间状态
     * 订单数组的方式，增加支付方式和支付时间
     * @param id 订单数组
     * @param payWay 支付方式id
     * @param payTime 支付时间
     * @return
     */
    public void updateStayRegisterAndRoomWhenTeamPay(String[] id, String payWay, String payTime);

    /**
     * 根据订单id数组获取若干订单，计算详细金额情况
     * 将去除这些金额情况的剩余详细金额情况返回
     * @param ids 订单id数组
     * @param zhuSuFei 住宿费
     * @param huanFangFei 换房费
     * @param qiTaXiaoFei 其他费用（商品）
     * @param jieZhangJinE 总费用
     * @param yaJin 押金
     * @param yingBuJinE 应补缴金额
     * @return 带有详细金额情况的map集合
     *          key stayMoney 住宿费
     *          key changRoomMoney 换房费
     *          key otherMoney 其他（商品）
     *          key payMoney 结账金额
     *          key depositMoney 应补金额
     *          key payRepairMoney 应补金额
     */
    public HashMap<String,Integer> changeTotalDetailMoney(String[] ids, String zhuSuFei, String huanFangFei, String qiTaXiaoFei, String jieZhangJinE, String yaJin, String yingBuJinE);

    /**
     * 根据团队id查找在某个时间段的订单信息
     * @param receiveTargetID 团队id
     * @param datemin 最早时间
     * @param datemax 最晚时间
     * @return 订单集合
     */
    public List<StayRegisterBean> findSomeUnBilledRegistersByDateAndId(String receiveTargetID, String datemin, String datemax);
}
