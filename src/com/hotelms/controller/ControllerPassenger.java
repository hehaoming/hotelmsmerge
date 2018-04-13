package com.hotelms.controller;

import com.hotelms.bean.ItemBean;
import com.hotelms.bean.ListBean;
import com.hotelms.bean.Passenger;
import com.hotelms.bean.PassengerVO;

import com.hotelms.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControllerPassenger {
    @Autowired
    PassengerService passengerService ;

    @RequestMapping("Passenger/toadd.do")
    public String getLiset(Model model) {
        List<ItemBean> listGeander = passengerService.getListOfItem(5);
        List<ItemBean> listNation = passengerService.getListOfItem(12);
        List<ItemBean> listEducationDegree = passengerService.getListOfItem(6);
        List<ItemBean> listPassengerLevel = passengerService.getListOfItem(7);
        List<ItemBean> listPapers = passengerService.getListOfItem(8);
        List<ItemBean> listThingReason = passengerService.getListOfItem(11);

        model.addAttribute("listGender",listGeander);
        model.addAttribute("listNation",listNation);
        model.addAttribute("listEducationDegree",listEducationDegree);
        model.addAttribute("listPassengerLevel",listPassengerLevel);
        model.addAttribute("listPapers",listPapers);
        model.addAttribute("listThingReason",listThingReason);

        return "/WEB-INF/jsp/passenger/add.jsp";
    }

    @RequestMapping("Passenger/add")
    public String AddTouist(Passenger passenger, Model model){
        System.out.println(passenger+"passenger");

        int i = passengerService.AddPassenger(passenger);
        System.out.println("i="+i);

        return "redirect:/Passenger/tolist.do";
    }

    @RequestMapping("Passenger/tolist.do")
    public String listshow(HttpServletRequest request, Model model){
        String name = request.getParameter("txtname");
        String currentage = request.getParameter("currentPage");
        System.out.println(currentage+"=-fds=-f=ds-f=ds-=f-dsa");
        ListBean list = new ListBean();
        if(currentage==null||currentage==""){
           currentage="1";
        }

        if (name==""||name==null) {

            List<PassengerVO> passengers = passengerService.selectAllPassenger(Integer.valueOf(currentage),2);
            for (Passenger passenger : passengers) {
                System.out.println(passenger);
            }
            list.setResult(passengers);

        }else {
            List<PassengerVO> passengers = passengerService.selectPassengerByName(name,Integer.valueOf(currentage),2);
            list.setResult(passengers);
        }

        int account = passengerService.selectAccount();
        list.setTotalPageByItemNum(account,2);
        list.setCurrentPage(Integer.valueOf(currentage));


        model.addAttribute("list", list);

        return "/WEB-INF/jsp/passenger/list.jsp";
    }

    @RequestMapping("Passenger/delete.do")
    public String delePassenger(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        String[] st = id.split(",");
        int i = passengerService.deleteByPrimaryKey(st);
        return "redirect:/Passenger/tolist.do";
    }

    @RequestMapping("Passenger/toupdate.do")
    public String toupdate(HttpServletRequest request,Model model){
        Integer id =Integer.valueOf(request.getParameter("id"));
        Passenger passenger = passengerService.selectByPrimaryKey(id);

        List<ItemBean> listGeander = passengerService.getListOfItem(5);
        List<ItemBean> listNation = passengerService.getListOfItem(12);
        List<ItemBean> listEducationDegree = passengerService.getListOfItem(6);
        List<ItemBean> listPassengerLevel = passengerService.getListOfItem(7);
        List<ItemBean> listPapers = passengerService.getListOfItem(8);
        List<ItemBean> listThingReason = passengerService.getListOfItem(11);

        model.addAttribute("listGender",listGeander);
        model.addAttribute("listNation",listNation);
        model.addAttribute("listEducationDegree",listEducationDegree);
        model.addAttribute("listPassengerLevel",listPassengerLevel);
        model.addAttribute("listPapers",listPapers);
        model.addAttribute("listThingReason",listThingReason);

        model.addAttribute("list",passenger);
        return "/WEB-INF/jsp/passenger/update.jsp";
    }

    @RequestMapping("Passenger/update.do")
    public String update(Passenger passenger,Model model){
        System.out.println(passenger+"passenger");

        int i = passengerService.updateByPrimaryKey(passenger);

        System.out.println("i="+i);

        return "redirect:/Passenger/tolist.do";
    }
}
