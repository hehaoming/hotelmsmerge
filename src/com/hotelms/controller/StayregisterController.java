package com.hotelms.controller;


import com.hotelms.bean.ListBean;
import com.hotelms.bean.StayRegisterBean;
import com.hotelms.service.SatyregisterService;
import com.hotelms.utils.ItemUtils;
import com.hotelms.vo.PassengerStayRegisterVO;
import com.hotelms.vo.RoomStayRegisterVO;
import com.hotelms.vo.TeamStayRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/StayRegister")
public class StayregisterController {


    @Autowired
    SatyregisterService satyregisterService;
    @RequestMapping("/tolist")
    public String tolist(Model model, @RequestParam(value="LvKeLeiXingId",required=false,defaultValue="55") int targetType){
        List<StayRegisterBean> allStayRegisyerObject = satyregisterService.getAllStayRegisyerObject(targetType);
        ListBean listBean = new ListBean();
        listBean.setResult(allStayRegisyerObject);
        model.addAttribute("LvKeLeiXingId",targetType);
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
    public String toarrangeroom(@RequestParam(value="LvKeLeiXingId",required=true,defaultValue="55") int targetType,
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
        System.out.println(stayRegisterBean);
        satyregisterService.saveStayRegister(stayRegisterBean, LvKeLeiXingId, tuanDuiId);
        model.addAttribute("LvKeLeiXingId",55);
        List<StayRegisterBean> allStayRegisyerObject = satyregisterService.getAllStayRegisyerObject(55);
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
    public String confirmPassenger(){
        return null;
    }
}
