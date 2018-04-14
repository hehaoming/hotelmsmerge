package com.hotelms.controller;

import com.hotelms.bean.Commodity;
import com.hotelms.bean.CommodityVO;
import com.hotelms.bean.ItemBean;
import com.hotelms.bean.ListBean;
import com.hotelms.service.CommodityService;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Commodity")
public class CommodityController {

    @Autowired
    @Qualifier("commodityservice")
    private CommodityService commodityService;


    @RequestMapping("/commodity")
    public String getjsp(Model model){

        List<ItemBean> listOne = commodityService.commodityTypeAll();
        List<HashMap> commodityAll = commodityService.findCommodityAll();

        model.addAttribute("listOne",listOne);
        model.addAttribute("commodityAll",commodityAll);

        return "/WEB-INF/jsp/commodity/list.jsp";
    }


    @RequestMapping("/add")
    public String getaddjsp(Commodity commodity){

        commodityService.addNewCommodity(commodity);

        return "redirect:/Commodity/tolist.do";
    }


    @RequestMapping("/tolist")
    public String tolist(Model model,HttpServletRequest request){


        List<ItemBean> listOne = commodityService.commodityTypeAll();
        model.addAttribute("listOne",listOne);

        ListBean listBean = new ListBean();
        if(request.getParameter("currentPage") == null|| request.getParameter("currentPage").equals("") ){
            listBean.setCurrentPage(1);
        }else {
            listBean.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
        }

        //txtname  id
        //id
        //
        String typeID = request.getParameter("commodityTypeID");//有值 null
        String name = request.getParameter("txtname");//有值 null “”
        //判断id null  给他一个默认值
        if (typeID == null){
            typeID = "19";
        }
        //txtname null和“”     有值
        List<Commodity> list = null;
        ArrayList<CommodityVO> commodityVOS;
            if(name == null || "".equals(name)) {
//                int commodityTypeNum = commodityService.findCommodityTypeNum(Integer.parseInt(typeID));
//                listBean.setTotalPageByItemNum(commodityTypeNum,2);
//                list = commodityService.findLimitCommodityType(listBean.getCurrentPage(),2);

                int number = commodityService.findCommodityTotalNumberByType(typeID);//查询单一类型的商品总数
                listBean.setTotalPageByItemNum(number,2);
                list = commodityService.findLimitCommoditysByType(listBean.getCurrentPage(),2,typeID);
                commodityVOS = commodityService.queryCommodityTypeName(list);
            }else {
//                int commodityLikeNum = commodityService.findCommodityLikeNum(name);
//                listBean.setTotalPageByItemNum(commodityLikeNum,2);
//                list = commodityService.findLimitCommodityLike(listBean.getCurrentPage(),2);
                int number = commodityService.findCommodityByLikeTypeNum(typeID, name);
                System.out.println(number+"dsfjkdsjfsd");
                listBean.setTotalPageByItemNum(number,2);
                list = commodityService.findLimitCommoditysByLikeType(listBean.getCurrentPage(), 2, name,typeID);
                commodityVOS = commodityService.queryCommodityTypeName(list);
            }

        listBean.setResult(commodityVOS);
        model.addAttribute("list",listBean);
        model.addAttribute("commodityTypeID",typeID);

        return "/WEB-INF/jsp/commodity/list.jsp";
    }


    @RequestMapping("/toadd")
    public String toadd(Model model){

        List<ItemBean> listOne = commodityService.commodityTypeAll();
        List<ItemBean> listTwo = commodityService.uOMIDAll();

        model.addAttribute("listOne",listOne);
        model.addAttribute("listTwo",listTwo);

        return "/WEB-INF/jsp/commodity/add.jsp";
    }


    @RequestMapping("/toupdate")
    public String toupdate(HttpServletRequest request,Model model){

        List<ItemBean> listOne = commodityService.commodityTypeAll();
        List<ItemBean> listTwo = commodityService.uOMIDAll();
        String ID = request.getParameter("commodityID");
        Commodity commodityinfo = commodityService.findCommodityByID(Integer.parseInt(ID));

        model.addAttribute("listOne",listOne);
        model.addAttribute("listTwo",listTwo);
        model.addAttribute("commodityinfo",commodityinfo);

        return "/WEB-INF/jsp/commodity/update.jsp";
    }

    @RequestMapping("/update")
    public String updatejsp(int id,String commodityName,int commodityTypeID,int uOMID,int salePrice){

        commodityService.updateCommodity(id,commodityName, commodityTypeID, uOMID, salePrice);

        return "redirect:/Commodity/tolist.do";
    }


    @RequestMapping("/delete")
    public String todelete(Commodity commodity){

        commodityService.removeCommodityByID(commodity.getCommodityID());

        return "redirect:/Commodity/tolist.do";
    }


//    @RequestMapping("/newadd")
//    public String addtype(){
//
//    }

    @ResponseBody
    @RequestMapping("/YZ")
    public int checkname(@RequestParam  String commodityName){
        System.out.println(commodityName);
        Commodity commodity = commodityService.checkName(commodityName);

        if (commodity == null){
            return 0;
        } else {
            return 1;
        }

    }
}
