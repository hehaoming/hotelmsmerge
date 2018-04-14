package com.hotelms.controller;


import com.hotelms.bean.*;
import com.hotelms.dao.ItemMapper;
import com.hotelms.dao.TeamMapper;
import com.hotelms.service.PassengerService;
import com.hotelms.service.PredetermineService;

import com.hotelms.service.RoomsetService;
import com.hotelms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("Predetermine")
@Controller
public class PredetermineController {

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    PredetermineService predetermineService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    RoomsetService roomSetService;

    @Autowired
    ItemMapper itemMapper;

    /**
     * 主页面（main/main.jsp）点击 客房预定 跳转 此方法
     * predetermine/list.jsp 点击 搜索 跳转此方法             搜索未完成
     * 此方法构建安排状态，查询预订项，并跳转 predetermine/list.jsp 页面
     * @param model
     * @return
     */
    @RequestMapping("tolist")
    public String tolistPredetermine(Model model, String txtname, String state , String currentPage) {

        //获取listOne（状态）集合
        ArrayList<ItemBean> list = predetermineService.getListOne();
        model.addAttribute("listOne", list);
        if(state == null || state.length() == 0) {
            state = "0";
        }
        if(currentPage == null || currentPage.length() == 0) {
            currentPage = "1";
        }
        model.addAttribute("state", state);
        //根据传入参数查询预订项
        List<Predetermine> predetermines = predetermineService
                .findSomePredeterminesByStateAndName(txtname, Integer.parseInt(state));
        Page<Predetermine> page = new Page<Predetermine>();
        page.setResult(predetermines);
        page.setTotalPage(predetermines.size());
        page.setCurrentPage(Integer.parseInt(currentPage));
        //model中加入按页面查找的查询结果的属性
        model.addAttribute("list",page);
        return "/WEB-INF/jsp/predetermine/list.jsp";
    }

    /**
     * 根据id修改订单项 此方法用于查询该id的订单项 并跳转predetermine/update.jsp页面
     * @param id 订单项id
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdatePredetermine(int id, Model model) {

        //查询到的含有房间信息和对象名称的信息
        Predetermine predetermine = predetermineService.findPredetermineByID(id);
        if(predetermine.getType() == 1) {//存入对象id
            model.addAttribute("id",predetermine.getTuanduiID());
        }else {
            model.addAttribute("id",predetermine.getPassengerID());
        }
        //支付方式列表
        List<ItemBean> listOne = itemMapper.getListOfItem(9);
        //将订单中的房间信息放入房间信息集合中，可以和修改查找之后的房间集合对应
        Roomset roomset = predetermine.getRoomset();
        List<Roomset> roomsets = new ArrayList<Roomset>();
        roomsets.add(roomset);
        model.addAttribute("roomsets",roomsets);
        model.addAttribute("predetermine",predetermine);
        model.addAttribute("listOne",listOne);
        return "/WEB-INF/jsp/predetermine/update.jsp";
    }

    /**
     * predetermine/add.jsp 保存 之后的业务逻辑
     * 增加订单项，改变房间状态
     * @param id 对象id 即团队id或旅客id
     * @param roomIdShuZu 预定房间id数组
     * @param predetermine 提交的数据包装类，主要有predetermineDay预定天数 deposit押金 arriveTime到达时间 type 1团队 2散客
     * @return
     */
    @RequestMapping("add")
    public String addPredetermine(String id,String[] roomIdShuZu,Predetermine predetermine) {


        System.out.println("id = " + id);
        System.out.println("predetermine = " + predetermine);
        System.out.println("roomIdShuZu = " + Arrays.toString(roomIdShuZu));
        predetermineService.addPredetermine(id,roomIdShuZu,predetermine);
        return "tolist.do";
    }


    /**
     * predetermine/list.jsp页面 添加 按钮之后的业务逻辑
     * 即 获取对象相关信息 跳转 predetermine/add.jsp
     * @param type 1团队 2散客
     * @param id 对象的id
     * @param name 对象的名称
     * @return
     */
    @RequestMapping("toadd")
    public String toAddPredetermine(String type, String id, String name, Model model) {

        //获取支付方式 支付方式 9
        List<ItemBean> listOne = itemMapper.getListOfItem(9);
        model.addAttribute("listOne",listOne);
        model.addAttribute("name",name);
        model.addAttribute("type",type);
        model.addAttribute("id",id);
        return "/WEB-INF/jsp/predetermine/add.jsp";
    }

    /**
     * predetermine/list.jsp页面 选择对象 的ajks业务逻辑
     * 即从数据库中获取全部的团队对象并返回
     * @param txtname 为空
     * @return 查询到的全部团队对象集合
     */
    @ResponseBody
    @RequestMapping("selectTarget")
    public List<Team> selectTarget(@RequestParam String txtname) {

        //查询团队信息语句
        List<Team> teams = teamMapper.selectAllTeams();
        System.out.println(teams);
        return teams;
    }

    /**
     * predetermine/list.jsp页面 选择对象 的ajks业务逻辑
     * 即从数据库中获取全部的旅客对象并返回
     * @param txtname 为空
     * @return 查询到的全部旅客对象集合
     */
    @ResponseBody
    @RequestMapping("selectPassenger")
    public List<Passenger> selectPassenger(@RequestParam String txtname) {

        //查询旅客信息
        List<Passenger> passengers = passengerService.findAllPassengersWithPaperNameAndSexName();
        return passengers;
    }

    /**
     * predetermine/list.jsp页面 旅客 选择对象 确认对象执行
     * 查询对应id的旅客的电话信息
     * @param id 选中的旅客id
     * @return 旅客电话号码
     */
    @ResponseBody
    @RequestMapping("confirmPassenger")
    public String confirmPassenger(@RequestParam int id) {

        String phoneNumber = passengerService.findPassengerPhoneNumberByID(id);
        System.out.println(phoneNumber);
        return phoneNumber;
    }

    /**
     * predetermine/add.jsp 选择房间 查询可使用房间
     * @param roomNumber 空
     * @return 可用房间列表
     */
    @ResponseBody
    @RequestMapping("selectRoom")
    public List<Roomset> findUsableRooms(@RequestParam String roomNumber) {

        List<Roomset> usableRooms = roomSetService.findUsableRooms(roomNumber);
        return usableRooms;
    }

    /**
     * 根据id数组删除预定单数据
     * @param id 预订单id数组
     */
    @RequestMapping("delete")
    public String deletePredetermines(int[] id) {

        System.out.println(Arrays.toString(id));
        predetermineService.deletePredetermines(id);
        return "tolist.do";
    }


    /**
     * 根据预订单id数组将预订单转为订单
     * @param id 预订单id数组
     * @param tiaoZhuan 是否跳转登记页面 1跳转 2不跳
     * @return
     */
    @RequestMapping("arrangeRoom")
    public String arrangeRoom(int[] id,String tiaoZhuan) {

        predetermineService.arrangeRoomToStayRegister(id);
        if("1".equals(tiaoZhuan)) {
            return "forward:/StayRegister/tolist.do";
        }else {
            return "tolist.do";
        }
    }
}
