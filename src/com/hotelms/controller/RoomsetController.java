package com.hotelms.controller;

import com.hotelms.bean.ItemBean;
import com.hotelms.bean.Roomset;
import com.hotelms.service.RoomsetService;
import com.hotelms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/RoomSet")
public class RoomsetController {

    @Autowired
    RoomsetService roomsetService;


    /**
     * 查找分页房间
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/tolist")
    public String findPartRoom(HttpServletRequest request,Model model){

        String currentPage = request.getParameter("currentPage");
        String txtname = request.getParameter("txtname");
        if(currentPage == null){
            currentPage = "1";
        }
        Page page = null;

        if(txtname == null ||txtname == ""){
            page = roomsetService.findPartRoom(currentPage);
        }else{

            page = roomsetService.findPartRoomBycondition(txtname,currentPage);
        }

        model.addAttribute("list",page);
        model.addAttribute("txtname",txtname);

        return "/WEB-INF/jsp/roomset/roomset.jsp";
    }
    /**
     * 新增跳转
     * @return
     */
    @RequestMapping(value = "/toadd",method = {RequestMethod.POST,RequestMethod.GET})
    public String toAdd(Model model){

        List<ItemBean> listOfItem = roomsetService.getListOfItem(1);
        List<ItemBean> listOfItem1 = roomsetService.getListOfItem(2);

        model.addAttribute("listTwo",listOfItem);
        model.addAttribute("listOne",listOfItem1);

        return "/WEB-INF/jsp/roomset/add.jsp";

    }

    /**
     * 添加房间
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/add",method = {RequestMethod.POST,RequestMethod.GET})
    public String addNewRoom(Roomset roomset,Model model){

        boolean b = roomsetService.addNewRoom(roomset);

        return "/RoomSet/tolist.do";
    }

    /**
     * 修改跳转
     * @return
     */
    @RequestMapping("/toupdate")
    public String toupdate(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        Roomset roomByRoomID = roomsetService.findRoomByRoomID(id);

        model.addAttribute("listPo",roomByRoomID);

        List<ItemBean> listOfItem = roomsetService.getListOfItem(1);
        List<ItemBean> listOfItem1 = roomsetService.getListOfItem(2);

        model.addAttribute("listTwo",listOfItem);
        model.addAttribute("listOne",listOfItem1);

        return "/WEB-INF/jsp/roomset/update.jsp";
    }

    /**
     * 修改房间信息
     * @return
     */
    @RequestMapping(value = "/update",method = {RequestMethod.POST,RequestMethod.GET})
    public String updateRoomDetail(HttpServletRequest request,Roomset roomset,Model model){
        //System.out.println("roomset="+roomset);
        String id = request.getParameter("id");
        System.out.println("id="+ id);

        roomset.setRoomID(Integer.parseInt(id));
        roomsetService.updateRoomInformationById(roomset);

        return "/RoomSet/tolist.do";
    }

    /**
     * 删除房间
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/delete")
    public String deleteRoom(HttpServletRequest request,Model model){

        //String类型转换成数组
        String id = request.getParameter("id");
        String[] roomIDs = id.split(",");

        roomsetService.deleteRoomByIds(roomIDs);

        return "/RoomSet/tolist.do";
    }
}
