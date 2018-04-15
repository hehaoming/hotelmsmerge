package com.hotelms.service.Impl;


import com.hotelms.bean.Consumption;
import com.hotelms.bean.ListBean;
import com.hotelms.bean.StayRegisterBean;
import com.hotelms.dao.FinancialStatisticsMapper;
import com.hotelms.dao.RoomsetMapper;
import com.hotelms.dao.SatyregisterMapper;
import com.hotelms.service.SatyregisterService;
import com.hotelms.vo.PassengerStayRegisterVO;
import com.hotelms.vo.RoomStayRegisterVO;
import com.hotelms.vo.TeamStayRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SatyregisterServiceImpl implements SatyregisterService {

    @Autowired
    SatyregisterMapper satyregisterMapper;
    @Override
    public List<TeamStayRegisterVO> getAllTeamObject(String txtname) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("txtname",txtname);
        return satyregisterMapper.getAllTeamObject(stringStringHashMap);
    }

    @Override
    public List<RoomStayRegisterVO> getAllRoomObject(int guestRoomLevelID) {
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("guestRoomLevelID",guestRoomLevelID);
        return satyregisterMapper.getAllRoomObject(stringStringHashMap);
    }

    @Override
    @Transactional
    public void saveStayRegister(StayRegisterBean stayRegisterBean, int LvKeLeiXingId, int tuanDuiId) {
        if(LvKeLeiXingId == 73){
            TeamStayRegisterVO teamVO = new TeamStayRegisterVO();
            teamVO.setTuanduiID(tuanDuiId);
            stayRegisterBean.setTeam(teamVO);
        }
        saveOneStayRegister(stayRegisterBean);
    }

    private void saveOneStayRegister(StayRegisterBean stayRegisterBean) {
        int sumConst = 0;
        RoomStayRegisterVO roomStayRegisterVO = satyregisterMapper.getRoomByRoomId(stayRegisterBean.getRoom().getRoomID());
        if(stayRegisterBean.getRentOutType().getItemDetailsID() == 74){
            sumConst = roomStayRegisterVO.getStandarPriceDay() * stayRegisterBean.getStayNumber();
        }else if (stayRegisterBean.getRentOutType().getItemDetailsID() == 75){
            int stayHourNumber = stayRegisterBean.getStayNumber() > roomStayRegisterVO.getFirstDuration()?
                    stayRegisterBean.getStayNumber():roomStayRegisterVO.getFirstDuration();
            sumConst = roomStayRegisterVO.getFirstPrice() +
                    (stayHourNumber - roomStayRegisterVO.getFirstDuration()) * roomStayRegisterVO.getStandarPrice();
        }
        stayRegisterBean.setSumConst(sumConst + "");
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("roomStateID",11);
        stringIntegerHashMap.put("roomID",stayRegisterBean.getRoom().getRoomID());
        satyregisterMapper.updateRoomState(stringIntegerHashMap);
        satyregisterMapper.saveStayRegister(stayRegisterBean);
    }

    @Override
    public List<StayRegisterBean> getAllStayRegisyerObject(int targetType) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("targetType",targetType);
        return satyregisterMapper.getAllStayRegisyerObject(hashMap);
    }

    @Override
    public List<PassengerStayRegisterVO> getAllPassengerObject(String txtname) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("txtname",txtname);
        return satyregisterMapper.getAllPassengerObject(stringStringHashMap);
    }

    @Override
    public PassengerStayRegisterVO getPassengerById(int id) {
        return satyregisterMapper.getPassengerById(id);
    }

    @Override
    @Transactional
    public void savePassengerAndRegister(PassengerStayRegisterVO passenger,int stayRegisterID) {
        int id = satyregisterMapper.savePassenger(passenger);
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("id",id);
        stringStringHashMap.put("stayRegisterID",stayRegisterID);
        satyregisterMapper.savePassengerRegister(stringStringHashMap);
    }

    @Override
    public void passengerRegister(PassengerStayRegisterVO passenger, int stayRegisterID) {
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("id",passenger.getId());
        stringStringHashMap.put("stayRegisterID",stayRegisterID);
        satyregisterMapper.savePassengerRegister(stringStringHashMap);
    }

    @Override
    public List<RoomStayRegisterVO> getRoomObjectByRoomId(String[] id) {
        return satyregisterMapper.getRoomObjectByRoomId(id);
    }

    @Override
    @Transactional
    public void volumeStayRegister(StayRegisterBean stayRegisterBean, int[] roomId) {
        RoomStayRegisterVO roomStayRegisterVO = new RoomStayRegisterVO();
        for(int room : roomId) {
            roomStayRegisterVO.setRoomID(room);
            stayRegisterBean.setRoom(roomStayRegisterVO);
            saveOneStayRegister(stayRegisterBean);
        }
    }

    @Override
    public StayRegisterBean getStayRegisyerObjectById(int id) {
        return satyregisterMapper.getStayRegisyerObjectById(id);
    }

    @Override
    @Transactional
    public void changeStayRegisterRoom(String id, String roomId, String changRoomMoney, String changRoomTime) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("stayregisterdetailId",id);
        stringStringHashMap.put("room",roomId );
        stringStringHashMap.put("changingRoomTime",changRoomTime);
        stringStringHashMap.put("changingRoomMoney",changRoomMoney);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("roomStateID",11);
        stringIntegerHashMap.put("roomID",Integer.parseInt(roomId));
        satyregisterMapper.updateRoomState(stringIntegerHashMap);
        StayRegisterBean stayRegisyerObjectById = satyregisterMapper.getStayRegisyerObjectById(Integer.parseInt(id));
        stringIntegerHashMap.put("roomStateID",1);
        stringIntegerHashMap.put("roomID",stayRegisyerObjectById.getRoom().getRoomID());
        satyregisterMapper.updateRoomState(stringIntegerHashMap);
        satyregisterMapper.changeStayRegisterRoom(stringStringHashMap);
    }

    @Override
    public void addDeposit(int depositPayWayID, int stayregisterdetailId, int deposit) {
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("stayregisterdetailId", stayregisterdetailId);
        stringStringHashMap.put("depositPayWayId", depositPayWayID);
        stringStringHashMap.put("deposit", deposit);
        satyregisterMapper.addDeposit(stringStringHashMap);

    }

    @Override
    public void updateStayRegisterTeam(int id, Integer receiveTargetID) {
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("stayregisterdetailId", id);
        stringStringHashMap.put("team", receiveTargetID);
        satyregisterMapper.updateStayRegisterTeam(stringStringHashMap);
    }

    @Autowired
    FinancialStatisticsMapper financialStatisticsMapper;

    @Autowired
    RoomsetMapper roomsetMapper;

    /**
     * 获取应补缴金额，商品消费金额，住宿费
     * @param stayRegisterBean 含有订单及其关联信息的订单包装类
     * @return 应补缴金额，商品消费金额，住宿费的map集合
     *          key yingBuJinE 应补缴金额
     *          key shangPinXiaoFei 商品消费金额
     *          key zhuSuFei 住宿费
     */
    @Override
    public HashMap<String, Object> getDetailMoney(StayRegisterBean stayRegisterBean) {

        int yingBuJinE = Integer.parseInt(stayRegisterBean.getSumConst()) - stayRegisterBean.getDeposit();
        List<Consumption> consumptions = financialStatisticsMapper
                .selectConsumptionsByStayId(stayRegisterBean.getStayregisterdetailId());
        int shangPinXiaoFei = 0;
        for(Consumption consumption : consumptions) {
            shangPinXiaoFei += consumption.getCommoditySalePrice() * consumption.getConsumptionNumber();
        }
        int zhuSuFei = 0;
        if(stayRegisterBean.getRentOutType().getItemDetailsID() == 74) {
            zhuSuFei = stayRegisterBean.getStayNumber() * stayRegisterBean.getRoom().getStandarPriceDay();
        }else {
            if(stayRegisterBean.getStayNumber() < stayRegisterBean.getRoom().getFirstDuration()) {
                zhuSuFei = stayRegisterBean.getRoom().getFirstPrice();
            }else {
                zhuSuFei = stayRegisterBean.getStayNumber() * stayRegisterBean.getRoom().getStandarPrice();
            }
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("yingBuJinE",yingBuJinE);
        map.put("shangPinXiaoFei",shangPinXiaoFei);
        map.put("zhuSuFei",zhuSuFei);
        return map;
    }

    /**
     * 根据id改变订单状态，填入订单结账时间和结账方式
     * 根据房间id改变房间状态为可用
     * @param id 订单id
     * @param payTime 结账时间
     * @param payWay 结账方式id
     * @param roomId 房间id
     */
    @Override
    public void updateStayRegisterAndRoomWhenPay(int id, String payTime, int payWay, int roomId) {

        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("payTime",payTime);
        map.put("payWay",payWay);
        satyregisterMapper.updateSatyRegisterWhenPay(map);
        roomsetMapper.updateRoomStateIDByIDToUsable(roomId);
    }

    /**
     * 根据结账情况，团队id，房间情况关键字搜索部分订单项
     * @param isBillID 是否结账 0未结账 1已结账 可能为空
     * @param tuanDuiID 团队id 可能为空
     * @param txtname 房间号关键字 可能为空
     * @return 含有符合条件的订单集合的分页工具对象
     */
    @Override
    public ListBean findStayRegistersByTeamIdAndBillIdAndRoomId(String isBillID, String tuanDuiID, String txtname) {

        ListBean list = new ListBean();
        HashMap<String,Object> map = new HashMap<>();
        map.put("isBillID",isBillID);
        map.put("tuanduiID",tuanDuiID);
        if(txtname == null || txtname.length() == 0) {
            map.put("txtname", null);
        }else {
            map.put("txtname", "%" + txtname + "%");
        }
        List<StayRegisterBean> stayRegisters = satyregisterMapper.selectStayRegistersByTeamIdAndBillIdAndRoomId(map);
        list.setResult(stayRegisters);
        return list;
    }

    /**
     * 计算订单集合的总金额
     * @param stayRegisterBeans 订单集合
     * @return 总金额
     */
    @Override
    public int getTotalMoney(List<StayRegisterBean> stayRegisterBeans) {

        int sumMoney = 0;
        if(stayRegisterBeans != null) {
            for (StayRegisterBean stayRegisterBean : stayRegisterBeans) {
                sumMoney += Integer.parseInt(stayRegisterBean.getSumConst());
            }
        }
        return sumMoney;
    }

    /**
     * 根据团队id查找未结账的订单集合
     * @param tuanDuiID 团队id
     * @return 订单集合
     */
    @Override
    public List<StayRegisterBean> getStayRegistersByTeamAndNotBilled(int tuanDuiID) {

        List<StayRegisterBean> stayRegisterBeans = satyregisterMapper.selectNotBilledStayRegistersByTeamId(tuanDuiID);
        return stayRegisterBeans;
    }

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
    @Override
    public HashMap<String, Integer> getTotalDetailMoney(List<StayRegisterBean> registerBeans) {

        HashMap<String,Integer> map = new HashMap<>();
        int stayMoney = 0;
        int changRoomMoney = 0;
        int otherMoney = 0;
        int payMoney = 0;
        int depositMoney = 0;
        int payRepairMoney = 0;
        if(registerBeans != null) {
            for(StayRegisterBean stayRegisterBean : registerBeans) {
                HashMap<String, Object> detailMoney = getDetailMoney(stayRegisterBean);
                payRepairMoney +=  (int) detailMoney.get("yingBuJinE");
                otherMoney += (int) detailMoney.get("shangPinXiaoFei");
                stayMoney += (int) detailMoney.get("zhuSuFei");
                if(stayRegisterBean.getChangingRoomMoney() != null
                        && stayRegisterBean.getChangingRoomMoney().length() != 0) {
                    changRoomMoney += Integer.parseInt(stayRegisterBean.getChangingRoomMoney());
                }
                payMoney += Integer.parseInt(stayRegisterBean.getSumConst());
                depositMoney += stayRegisterBean.getDeposit();
            }
        }
        map.put("stayMoney",stayMoney);
        map.put("changRoomMoney",changRoomMoney);
        map.put("otherMoney",otherMoney);
        map.put("payMoney",payMoney);
        map.put("depositMoney",depositMoney);
        map.put("payRepairMoney",payRepairMoney);
        return map;
    }

    /**
     * 根据订单id改变订单状态和房间状态
     * 订单数组的方式，增加支付方式和支付时间
     * @param ids 订单数组
     * @param payWay 支付方式id
     * @param payTime 支付时间
     * @return
     */
    @Override
    public void updateStayRegisterAndRoomWhenTeamPay(String[] ids, String payWay, String payTime) {

        if(ids != null && ids.length != 0) {
            for(String id : ids) {
                StayRegisterBean registerBean = satyregisterMapper.getStayRegisyerObjectById(Integer.parseInt(id));
                updateStayRegisterAndRoomWhenPay(Integer.parseInt(id),payTime,Integer.parseInt(payWay)
                        ,registerBean.getRoom().getRoomID());
            }
        }
    }

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
     *          key depositMoney 押金
     *          key payRepairMoney 应补金额
     */
    @Override
    public HashMap<String, Integer> changeTotalDetailMoney(String[] ids, String zhuSuFei, String huanFangFei
            , String qiTaXiaoFei, String jieZhangJinE, String yaJin, String yingBuJinE) {

        List<StayRegisterBean> stayRegisterBeans = new ArrayList<>();
        if(ids != null && ids.length != 0) {
            for(String id : ids) {
                StayRegisterBean registerBean = satyregisterMapper.getStayRegisyerObjectById(Integer.parseInt(id));
                stayRegisterBeans.add(registerBean);
            }
        }
        HashMap<String, Integer> money = null;
        if(stayRegisterBeans != null && stayRegisterBeans.size() != 0) {
            money = getTotalDetailMoney(stayRegisterBeans);
        }
        HashMap<String,Integer> map = new HashMap<>();
        if(money != null) {
            map.put("stayMoney",Integer.parseInt(zhuSuFei) - money.get("stayMoney"));
            map.put("changRoomMoney",Integer.parseInt(huanFangFei) - money.get("changRoomMoney"));
            map.put("otherMoney",Integer.parseInt(qiTaXiaoFei) - money.get("otherMoney"));
            map.put("payMoney",Integer.parseInt(jieZhangJinE) - money.get("payMoney"));
            map.put("depositMoney",Integer.parseInt(yaJin) - money.get("depositMoney"));
            map.put("payRepairMoney",Integer.parseInt(yingBuJinE) - money.get("payRepairMoney"));
        }else {
            map.put("stayMoney",Integer.parseInt(zhuSuFei));
            map.put("changRoomMoney",Integer.parseInt(huanFangFei));
            map.put("otherMoney",Integer.parseInt(qiTaXiaoFei));
            map.put("payMoney",Integer.parseInt(jieZhangJinE));
            map.put("depositMoney",Integer.parseInt(yaJin));
            map.put("payRepairMoney",Integer.parseInt(yingBuJinE));
        }
        return map;
    }

    /**
     * 根据团队id查找在某个时间段的订单信息
     * @param receiveTargetID 团队id
     * @param datemin 最早时间
     * @param datemax 最晚时间
     * @return 订单集合
     */
    @Override
    public List<StayRegisterBean> findSomeUnBilledRegistersByDateAndId(String receiveTargetID, String datemin, String datemax) {

        HashMap<String,String> map = new HashMap<>();
        map.put("teamID",receiveTargetID);
        map.put("datemin",datemin);
        map.put("datemax",datemax);
        List<StayRegisterBean> stayRegisterBeans = satyregisterMapper.selectUnBilledRegistersByDateAndId(map);
        return stayRegisterBeans;
    }
}
