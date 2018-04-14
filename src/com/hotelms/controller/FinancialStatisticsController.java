package com.hotelms.controller;

import com.hotelms.bean.ListBean;
import com.hotelms.dao.FinancialStatisticsMapper;
import com.hotelms.service.FinancialStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("FinancialStatistics")
public class FinancialStatisticsController {


    @Autowired
    FinancialStatisticsService financialStatisticsService;

    /**
     * 从主页面点击财务统计 或搜索 或点击分页执行逻辑
     * 跳转financialstatistics/financialstatistics.jsp页面
     * @param currentPage 跳转分页数
     * @param datemin 最小时间
     * @param datemax 最大时间
     * @return
     */
    @RequestMapping("tolist")
    public String toList(String currentPage, String datemin, String datemax, Model model) {

        HashMap<String, Object> map = financialStatisticsService.showSomeStayRegister(currentPage, datemin, datemax);
        model.addAttribute("list",map.get("list"));
        model.addAttribute("chuZuFangJianShu",map.get("chuZuFangJianShu"));
        model.addAttribute("zhuSuRenShu",map.get("zhuSuRenShu"));
        model.addAttribute("xiaoFeiJinE",map.get("xiaoFeiJinE"));
        model.addAttribute("JieZhangJinE",map.get("JieZhangJinE"));
        return "/WEB-INF/jsp/financialstatistics/financialstatistics.jsp";
    }

    /**
     * 详情 显示详情 跳转详情页面
     * @param min 最早时间
     * @param max 最晚时间
     * @param id 订单id
     * @return
     */
    @RequestMapping("toinformation")
    public String toInformation(String min,String max,String id,Model model) {

        model.addAttribute("min",min);
        model.addAttribute("max",max);


        return "/WEB-INF/jsp/financialstatistics/particulars.jsp";
    }
}
