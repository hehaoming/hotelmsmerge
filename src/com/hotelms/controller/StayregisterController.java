package com.hotelms.controller;


import com.hotelms.bean.ListBean;
import com.hotelms.bean.StayRegister;
import com.hotelms.bean.StayRegisterBean;
import com.hotelms.bean.Team;
import com.hotelms.dao.TeamMapper;
import com.hotelms.service.SatyregisterService;
import com.hotelms.utils.ItemUtils;
import com.hotelms.vo.PassengerStayRegisterVO;
import com.hotelms.vo.RoomStayRegisterVO;
import com.hotelms.vo.TeamStayRegisterVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/StayRegister")
public class StayregisterController {


    @Autowired
    SatyregisterService satyregisterService;
    @RequestMapping("/tolist")
    public String tolist(Model model, @RequestParam(value="LvKeLeiXingId",required=false,defaultValue="72") int targetType){
        List<StayRegisterBean> allStayRegisyerObject = satyregisterService.getAllStayRegisyerObject(targetType);
        ListBean listBean = new ListBean();
        listBean.setResult(allStayRegisyerObject);
        model.addAttribute("LvKeLeiXingId",targetType);
        model.addAttribute("isBillID",0);
        model.addAttribute("list",listBean);
        return "/WEB-INF/jsp/stayregister/list.jsp";
    }



    @RequestMapping("/selectTarget")
    @ResponseBody
    public List<TeamStayRegisterVO> selectTarget(@RequestParam(value="txtname",required=false,defaultValue="")String txtname) throws IOException {
        List<TeamStayRegisterVO> allTeamObject = satyregisterService.getAllTeamObject(txtname);
        return allTeamObject;
    }


    @RequestMapping("/toarrangeroom")
    public String toarrangeroom(@RequestParam(value="LvKeLeiXingId",required=true,defaultValue="72") int targetType,
                                @RequestParam(value="tuanDuiID",required=false,defaultValue="0") int tuanDuiID,
                                Model model){
        List<RoomStayRegisterVO> allRoomObject = satyregisterService.getAllRoomObject(0);
        model.addAttribute("list",allRoomObject);
        model.addAttribute("LvKeLeiXingId",targetType);
        model.addAttribute("tuanDuiID",tuanDuiID);
        model.addAttribute("listRentOutType", ItemUtils.getListOfItem(12));
        model.addAttribute("listPassengerType",ItemUtils.getListOfItem(13));
        model.addAttribute("listBillUnit",ItemUtils.getListOfItem(14));
        model.addAttribute("listPayWay",ItemUtils.getListOfItem(9));
        return "/WEB-INF/jsp/stayregister/arrangeroom.jsp";
    }


    @RequestMapping("/guestRoomLevelSelectRoom")
    @ResponseBody
    public List<RoomStayRegisterVO> guestRoomLevelSelectRoom(int guestRoomLevelID, HttpServletResponse response) throws IOException {
        List<RoomStayRegisterVO> allRoomObject = satyregisterService.getAllRoomObject(guestRoomLevelID);
        return allRoomObject;

    }

    @RequestMapping("/arrangeroom")
    public String arrangeroom(StayRegisterBean stayRegisterBean, int LvKeLeiXingId, int tuanDuiId, Model model) throws IOException {
        satyregisterService.saveStayRegister(stayRegisterBean, LvKeLeiXingId, tuanDuiId);
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        List<StayRegisterBean> allStayRegisyerObject = satyregisterService.getAllStayRegisyerObject(72);
        ListBean listBean = new ListBean();
        listBean.setResult(allStayRegisyerObject);
        model.addAttribute("list",listBean);
        return "/WEB-INF/jsp/stayregister/list.jsp";
    }

    @RequestMapping("/toregister")
    public String toregister(int id,int roomNumber,int LvKeLeiXingId,Model model){

        model.addAttribute("stayRegisterId",id);
        model.addAttribute("roomNumber",roomNumber);
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        model.addAttribute("listGender", ItemUtils.getListOfItem(5));
        model.addAttribute("listNation",ItemUtils.getListOfItem(16));
        model.addAttribute("listEducationDegree",ItemUtils.getListOfItem(6));
        model.addAttribute("listPassengerLevel",ItemUtils.getListOfItem(7));
        model.addAttribute("listPapers",ItemUtils.getListOfItem(8));
        model.addAttribute("listThingReason",ItemUtils.getListOfItem(11));
        return "/WEB-INF/jsp/stayregister/register.jsp";
    }

    @RequestMapping("/selectPassenger")
    @ResponseBody
    public List<PassengerStayRegisterVO> selectPassenger(@RequestParam(value="txtname",required=false,defaultValue="")String txtname){
        List<PassengerStayRegisterVO> allPassengerObject = satyregisterService.getAllPassengerObject(txtname);
        return allPassengerObject;
    }
    @RequestMapping("/confirmPassenger")
    @ResponseBody
    public PassengerStayRegisterVO confirmPassenger(int id){
        PassengerStayRegisterVO passenger = satyregisterService.getPassengerById(id);

        return passenger;
    }

    @RequestMapping("/register")
    public String register(PassengerStayRegisterVO passenger,int LvKeLeiXingId,Model model,int stayRegisterID){
        System.out.println(passenger);
        if(passenger.getId() == 0){
            satyregisterService.savePassengerAndRegister(passenger,stayRegisterID);
        }else{
            satyregisterService.passengerRegister(passenger,stayRegisterID);
        }
        List<StayRegisterBean> allStayRegisyerObject = satyregisterService.getAllStayRegisyerObject(LvKeLeiXingId);
        System.out.println(allStayRegisyerObject);
        ListBean listBean = new ListBean();
        listBean.setResult(allStayRegisyerObject);
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        model.addAttribute("list",listBean);
        return "/WEB-INF/jsp/stayregister/list.jsp";
    }

    @RequestMapping("/tovolumeroom")
    public String tovolumeroom(String tuanDuiID,String teamName,Model model){
        List<RoomStayRegisterVO> allRoomObject = satyregisterService.getAllRoomObject(0);
        model.addAttribute("list",allRoomObject);
        model.addAttribute("tuanDuiID",tuanDuiID);
        model.addAttribute("teamName",teamName);
        model.addAttribute("listRentOutType", ItemUtils.getListOfItem(12));
        model.addAttribute("listPassengerType",ItemUtils.getListOfItem(13));
        model.addAttribute("listBillUnit",ItemUtils.getListOfItem(14));
        model.addAttribute("listPayWay",ItemUtils.getListOfItem(9));
        return "/WEB-INF/jsp/stayregister/volumeroom.jsp";
    }

    @RequestMapping("/ajaxSelectRoom")
    @ResponseBody
    public List<RoomStayRegisterVO> ajaxSelectRoom(String[] id){
        List<RoomStayRegisterVO> allRoomObject = satyregisterService.getRoomObjectByRoomId(id);
        return allRoomObject;
    }

    @RequestMapping("/volumeroom")
    public String volumeroom(Model model,int[] roomId,StayRegisterBean stayRegisterBean){
        satyregisterService.volumeStayRegister(stayRegisterBean,roomId);
        model.addAttribute("LvKeLeiXingId",73);
        List<StayRegisterBean> allStayRegisyerObject = satyregisterService.getAllStayRegisyerObject(73);
        ListBean listBean = new ListBean();
        listBean.setResult(allStayRegisyerObject);
        model.addAttribute("list",listBean);
        return "/WEB-INF/jsp/stayregister/list.jsp";
    }
    @RequestMapping("/tochangroom")
    public String tochangroom(int id, String lvKeName, String LvKeLeiXingId, Model model){
        StayRegisterBean stayRegisterBean = satyregisterService.getStayRegisyerObjectById(id);
        model.addAttribute("stayId",id);
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        model.addAttribute("lvKeName",lvKeName);
        model.addAttribute("zhuSuFei",100);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("timestamp",sdf.format(new Date()));
        model.addAttribute("item",stayRegisterBean);
        return "/WEB-INF/jsp/stayregister/changroom.jsp";
    }

    @RequestMapping("/confirmChangRoom")
    public String confirmChangRoom(Model model,String id,String roomId,String changRoomMoney,String changRoomTime,int LvKeLeiXingId){
        satyregisterService.changeStayRegisterRoom(id,roomId,changRoomMoney,changRoomTime);
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        List<StayRegisterBean> allStayRegisyerObject = satyregisterService.getAllStayRegisyerObject(LvKeLeiXingId);
        ListBean listBean = new ListBean();
        listBean.setResult(allStayRegisyerObject);
        model.addAttribute("list",listBean);
        return "/WEB-INF/jsp/stayregister/list.jsp";
    }

    @RequestMapping("/todeposit")
    public String todeposit(int id,String lvKeName,int LvKeLeiXingId,Model model){
        StayRegisterBean stayRegisterBean = satyregisterService.getStayRegisyerObjectById(id);
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        model.addAttribute("lvKeName",lvKeName);
        model.addAttribute("item",stayRegisterBean);
        model.addAttribute("listTwo",ItemUtils.getListOfItem(9));
        return "/WEB-INF/jsp/stayregister/deposit.jsp";
    }

    @RequestMapping("/deposit")
    public String deposit(Model model,int LvKeLeiXingId,int stayregisterdetailId,int deposit,int depositPayWayID){
        satyregisterService.addDeposit(depositPayWayID,stayregisterdetailId,deposit);
        StayRegisterBean stayRegisterBean = satyregisterService.getStayRegisyerObjectById(stayregisterdetailId);
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        if(stayRegisterBean.getPassenger() != null) {
            model.addAttribute("lvKeName", stayRegisterBean.getPassenger().getName());
        }
        model.addAttribute("item",stayRegisterBean);
        model.addAttribute("listTwo",ItemUtils.getListOfItem(9));
        return "/WEB-INF/jsp/stayregister/deposit.jsp";
    }
    @RequestMapping("/toshiftteam")
    public String toshiftteam(int id,int stayregisterdetailsId,Model model){
        StayRegisterBean stayRegisterBean = satyregisterService.getStayRegisyerObjectById(stayregisterdetailsId);
        model.addAttribute("item",stayRegisterBean);
        List<TeamStayRegisterVO> allTeamObject = satyregisterService.getAllTeamObject("");
        model.addAttribute("listRT",allTeamObject);
        model.addAttribute("id",id);
        return "/WEB-INF/jsp/stayregister/shiftteam.jsp";
    }

    @RequestMapping("/changOver")
    public String changOver(int id,@RequestParam(value = "receiveTargetID",required = false)Integer receiveTargetID,int LvKeLeiXingId,Model model){
        satyregisterService.updateStayRegisterTeam(id,receiveTargetID);
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        List<StayRegisterBean> allStayRegisyerObject = satyregisterService.getAllStayRegisyerObject(LvKeLeiXingId);
        ListBean listBean = new ListBean();
        listBean.setResult(allStayRegisyerObject);
        model.addAttribute("list",listBean);
        return "/WEB-INF/jsp/stayregister/list.jsp";
    }

    @RequestMapping("/toshiftpersonage")
    public String toshiftpersonage(int id,int stayregisterdetailsId,Model model){
        StayRegisterBean stayRegisterBean = satyregisterService.getStayRegisyerObjectById(stayregisterdetailsId);
        model.addAttribute("item",stayRegisterBean);
        model.addAttribute("id",id);
        model.addAttribute("item",stayRegisterBean);
        return "/WEB-INF/jsp/stayregister/shiftpersonage.jsp";
    }



    @Autowired
    TeamMapper teamMapper;

    /**
     * 旅客 结账按钮 跳转结账页面
     * @param id 订单id
     * @param lvKeName 旅客名字
     * @return
     */
    @RequestMapping("topay")
    public String toPay(int id,String lvKeName,Model model) {

        StayRegisterBean stayRegisterBean = satyregisterService.getStayRegisyerObjectById(id);
        model.addAttribute("stayRegisterBean",stayRegisterBean);
        model.addAttribute("listOne",ItemUtils.getListOfItem(9));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        model.addAttribute("timestamp",timestamp);
        HashMap<String, Object> detailMoney = satyregisterService.getDetailMoney(stayRegisterBean);
        model.addAttribute("yingBuJinE",detailMoney.get("yingBuJinE"));
        model.addAttribute("shangPinXiaoFei",detailMoney.get("shangPinXiaoFei"));
        model.addAttribute("zhuSuFei",detailMoney.get("zhuSuFei"));
        return "/WEB-INF/jsp/stayregister/pay.jsp";
    }

    /**
     * pay.jsp 页面 结账按钮
     * @param id 订单id
     * @param remarks 应补缴费用
     * @param payTime 结账时间
     * @param payWay 结账方式id
     * @param roomId 房间id
     * @return
     */
    @RequestMapping("pay")
    public String pay(int id, int remarks,String payTime,int payWay,int roomId) {

        satyregisterService.updateStayRegisterAndRoomWhenPay(id,payTime,payWay,roomId);
        return "tolist.do";
    }

    /**
     * 团队页面下，搜索，变更是否结账下拉框，选择对象确定后
     * 根据条件搜索部分订单项
     * @param LvKeLeiXingId 团队还是旅客
     * @param isBillID 是否结账 0未结账 1已结账
     * @param txtname  房间号关键字
     * @param tuanDuiID 团队id
     * @param teamNameId 团队名称
     * @param teamCodeId 团队编号
     * @param principalId 负责人姓名
     * @param contactPhoneNUmberId 负责人手机号
     * @param registerTimeId 团队登记时间
     * @return
     */
    @RequestMapping("toteamlist")
    public String toTeamList(String LvKeLeiXingId,String isBillID,String txtname,String tuanDuiID,String teamNameId
            ,String teamCodeId,String principalId,String contactPhoneNUmberId,String registerTimeId,Model model) {
        ListBean listBean = satyregisterService
                .findStayRegistersByTeamIdAndBillIdAndRoomId(isBillID, tuanDuiID, txtname);
        model.addAttribute("list",listBean);
        model.addAttribute("LvKeLeiXingId",LvKeLeiXingId);
        model.addAttribute("tuanDui",tuanDuiID);
        model.addAttribute("teamNameId",teamNameId);
        model.addAttribute("teamCodeId",teamCodeId);
        model.addAttribute("principalId",principalId);
        model.addAttribute("contactPhoneNUmberId",contactPhoneNUmberId);
        model.addAttribute("registerTimeId",registerTimeId);
        model.addAttribute("isBillID",isBillID);
        int sumMoney = satyregisterService.getTotalMoney(listBean.getResult());
        model.addAttribute("teamSumConst",sumMoney);
        return "/WEB-INF/jsp/stayregister/list.jsp";
    }

    /**
     * 团队 结账按钮 跳转结账页面
     * @param tuanDuiID 团队id
     * @return
     */
    @RequestMapping("toteampay")
    public String toTeamPay(int tuanDuiID,Model model) {

        model.addAttribute("tuanDuiID",tuanDuiID);
        List<StayRegisterBean> registerBeans = satyregisterService.getStayRegistersByTeamAndNotBilled(tuanDuiID);
        model.addAttribute("list",registerBeans);
        HashMap<String, Integer> map = satyregisterService.getTotalDetailMoney(registerBeans);
        model.addAttribute("teamPayVo",map);
        model.addAttribute("fangJianShu",registerBeans.size());
        model.addAttribute("timestamp",new Timestamp(System.currentTimeMillis()));
        model.addAttribute("listPayWay",ItemUtils.getListOfItem(9));
        Team team = teamMapper.selectTeamByID(tuanDuiID);
        model.addAttribute("team",team);
        return "/WEB-INF/jsp/stayregister/teampay.jsp";
    }

    /**
     * 团队结账
     * @param id 订单数组
     * @param remarks 空
     * @param payWay 支付方式id
     * @param payTime 支付时间
     * @return
     */
    @RequestMapping("teamPay")
    public String teamPay(String[] id,String remarks,String payWay,String payTime) {

        satyregisterService.updateStayRegisterAndRoomWhenTeamPay(id,payWay,payTime);
        return "tolist.do";
    }

    /**
     * 团队结账 移除按钮 重新计算各种金额详情
     * @return 带有详情金额的map集合
     */
    @ResponseBody
    @RequestMapping("timeAjaxSelectRoomThree")
    public HashMap<String,Integer> deleteSomeRegistersWhenPay(@RequestParam String[] id
            , @RequestParam String zhuSuFei, @RequestParam String huanFangFei, @RequestParam String qiTaXiaoFei
            , @RequestParam String jieZhangJinE,@RequestParam String yaJin,@RequestParam String yingBuJinE) {

        System.out.println("aaaa");
        HashMap<String, Integer> map = satyregisterService.changeTotalDetailMoney(id, zhuSuFei
                , huanFangFei, qiTaXiaoFei, jieZhangJinE, yaJin, yingBuJinE);
        return map;
    }

    /**
     * 团队结账 查询按钮 查询登陆时间区间的订单
     */
    @ResponseBody
    @RequestMapping("timeAjaxSelectRoomOne")
    public List<StayRegisterBean> findSomeRegistersByDate(@RequestParam String receiveTargetID
            ,@RequestParam String datemin,@RequestParam String datemax) {

        List<StayRegisterBean> registers = satyregisterService
                .findSomeUnBilledRegistersByDateAndId(receiveTargetID, datemin, datemax);
        return registers;
    }
}
