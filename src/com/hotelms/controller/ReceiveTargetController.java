package com.hotelms.controller;


import com.hotelms.bean.ListBean;
import com.hotelms.bean.ReceiveTargetBean;
import com.hotelms.service.ReceiveTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import java.util.List;

@Controller
public class ReceiveTargetController {

    @Autowired
    ReceiveTargetService receiveTargetService;


    /*增*/
    @RequestMapping("/ReceiveTargetBean/toadd.do")
    public String toAdd() {
        return "/WEB-INF/jsp/receivetarget/add.jsp";
    }



    @RequestMapping("/ReceiveTarget/add.do")
    public String addReceiveTarget(ReceiveTargetBean receiveTargetBean) {

        String re;

        if (receiveTargetService.addReceiveTarget(receiveTargetBean)) {
            //不能到这里的。也可以啊；
            re = "/ReceiveTargetBean/tolist.do";
        } else {
            re = "/error";
        }


        return re;
    }

    /*删*/
    @RequestMapping("/ReceiveTargetBean/delete.do")
    public String toDelete(HttpServletRequest request) {
        String re;
        String rt_id = request.getParameter("rt_id");

        System.out.println(rt_id);
        rt_id = "(" + rt_id.trim() + ")";

        System.out.println(rt_id);

        if (receiveTargetService.deleteReceiveTargetByID(rt_id)) {

            re = "/ReceiveTargetBean/tolist.do";
        } else {
            re = "/error.jsp";
        }
        return re;
    }


    /*改*/

    @RequestMapping("/ReceiveTargetBean/toupdate.do")
    public String toUpdate(HttpServletRequest request) {
        String id = request.getParameter("id");

        ReceiveTargetBean receiveTargetBean = receiveTargetService.findReceiveTargetByID(Integer.parseInt(id));

        request.setAttribute("list", receiveTargetBean);
        return "/WEB-INF/jsp/receivetarget/update.jsp";
    }

    @RequestMapping("/ReceiveTarget/update.do")
    public String updateReceiveTarget(ReceiveTargetBean receiveTargetBean) {
        String re = null;
        if (receiveTargetService.updateReceiveTarget(receiveTargetBean)) {
            re = "/ReceiveTargetBean/tolist.do";
        } else {
            re = "/error.jsp";
        }
        return re;
    }


    //查貌似都是把page发给list；不知道中间有没有什么中转，还是直接写在里面？

    //查多查少

    @Autowired
    ListBean list;


    @Autowired
    ListBean listByLimit;

    //    @RequestMapping("/ReceiveTarget/tolist.do&txtname=")
//    public ModelAndView findReceiveTargetByName(String txtname,int page){
//        int page1 = 1;
//        if (page != 0){
//            page1 = page;
//        }
//
//        List<ReceiveTargetBean> receiveTargetBeanList = receiveTargetService.findReceiveTargetByName(txtname);
//
//        list.setResult(receiveTargetBeanList);
//
//        list.setCurrentPage(page1);
//
//        list.setTotalPageByItemNum(receiveTargetBeanList.size()+1,10);
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.addObject("list",list);
//
//        modelAndView.setViewName("/WEB-INF/jsp/receivetarget/list");
//
//        return modelAndView;
//    }

    @RequestMapping("/ReceiveTarget/tolist.do")
    public ModelAndView findReceiveTargetByName(HttpServletRequest request) {

        String page1 = request.getParameter("currentPage");
        int page;


        if (page1 != null) {
            page = Integer.parseInt(page1);
        } else {
            page = 1;
        }

        ModelAndView modelAndView = new ModelAndView();
        String txtname = request.getParameter("txtname");


        List<ReceiveTargetBean> receiveTargetBeanList = receiveTargetService.findReceiveTargetByName(txtname);
        list.setResult(receiveTargetBeanList);
        list.setCurrentPage(page);
        list.setTotalPageByItemNum(receiveTargetBeanList.size() + 1, 10);

        //强行分页
        listByLimit = pageUtils(list, page);

        modelAndView.addObject("list", listByLimit);

        modelAndView.setViewName("/WEB-INF/jsp/receivetarget/list.jsp");

        return modelAndView;
    }


//    @RequestMapping("/ReceiveTargetBean/tolist.do")
//    public ModelAndView findAllReceiveTarget(HttpServletRequest request) {
//
//        String page1 = request.getParameter("currentPage");
//        int page;
//
//        if(page1 != null){
//            page = Integer.parseInt(page1);
//        }else {
//            page =1;
//        }
//
//        List<ReceiveTargetBean> receiveTargetBeanList = receiveTargetService.findAllReceiveTarget();
//
//        list.setResult(receiveTargetBeanList);
//
//        list.setCurrentPage(page);
//        list.setTotalPageByItemNum(receiveTargetBeanList.size() + 1, 10);
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.addObject("list", list);
//
//        modelAndView.setViewName("/WEB-INF/jsp/receivetarget/list.jsp");
//
//        return modelAndView;
//    }


//    @RequestMapping(value ={"/ReceiveTargetBean/tolist.do","/ReceiveTarget/tolist.do"} )
//    public ModelAndView findAllReceiveTar(HttpServletRequest request) {
//
//        String txtname = request.getParameter("txtname");
//        List<ReceiveTargetBean> receiveTargetBeanList;
//
//        if(txtname != null) {
//            receiveTargetBeanList = receiveTargetService.findReceiveTargetByName(txtname);
//        }else {
//            receiveTargetBeanList = receiveTargetService.findAllReceiveTarget();
//        }
//
//            list.setResult(receiveTargetBeanList);
//            list.setCurrentPage(1);
//            list.setTotalPageByItemNum(receiveTargetBeanList.size() + 1, 10);
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.addObject("list", list);
//
//        modelAndView.setViewName("/WEB-INF/jsp/receivetarget/list.jsp");
//
//        return modelAndView;
//    }


    /*
    强行分页方法.测试可行，
    主要是不再分别写limit查询方法。太麻烦
    使用方法：
    listByLimit = pageUtils(list,page);

    好像list有缓存
    所以还是换个名字吧
     */

    public ListBean pageUtils(ListBean list, int page) {

        int limit = 10;

        List list1 = list.getResult();
        int num = list1.size();


        int start = (page - 1) * limit;
        int end = (start + limit) < num ? (start + limit) : num;

        List list2 = new ArrayList();

        int i;
        for (i = start; i < end; i++) {
            Object object = list1.get(i);
            list2.add(object);
        }

        list.setResult(list2);


        return list;


    }
    @RequestMapping("/ReceiveTargetBean/tolist.do")
    public ModelAndView findAllReceiveTarget(HttpServletRequest request) {

        String page1 = request.getParameter("currentPage");
        int page;

        if (page1 != null) {
            page = Integer.parseInt(page1);
        } else {
            page = 1;
        }


        List<ReceiveTargetBean> receiveTargetBeanList = receiveTargetService.findAllReceiveTarget();


        list.setResult(receiveTargetBeanList);


        list.setCurrentPage(page);
        list.setTotalPageByItemNum(receiveTargetBeanList.size() + 1, 10);

        listByLimit = pageUtils(list, page);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("list", listByLimit);

        modelAndView.setViewName("/WEB-INF/jsp/receivetarget/list.jsp");

        return modelAndView;
    }


}
