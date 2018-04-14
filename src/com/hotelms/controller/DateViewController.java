package com.hotelms.controller;

import com.hotelms.bean.StayRegisterBean;
import com.hotelms.service.DateViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DateViewController {
    @Autowired
    DateViewService dateViewService;

    @RequestMapping("DateView/tolist.do")
    public String tolist(HttpServletRequest request, Model model){

        List<StayRegisterBean> stayRegisterInfos = dateViewService.analysisAllInfo();

//        String[] year1 = null;
//        String[] year2 = null;
//        String[] year3 = null;
//        String[] year4 = null;
//        String[] year5 = null;
//        String[] year6 = null;
//        String[] year7 = null;
//        String[] year8 = null;
//        String[] year9 = null;
//        String[] year10 = null;
//        String[] year11 = null;
//        String[] year12 = null;
//
//
//        //遍历数组，并且分割年月，将2018年的第一个月称为year1 不断遍历，直到遍历一年12个月为止
//        for (StayRegisterBean stayRegisterInfo : stayRegisterInfos) {
//            String[] Time = stayRegisterInfo.getPayTime().split(" ");
//            String Date = Time[0];
//            String[] Dater = Date.split("-");
//            if(Dater[0].equals("2018")&&Dater[1].equals("01")){
//                int i = 0;
//                year1[i] = Dater[0]+Dater[1];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("02")) {
//                int i = 0;
//                year2[i] = Dater[0] + Dater[1];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("03")) {
//                int i = 0;
//                year3[i] = Dater[0] + Dater[2];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("04")) {
//                int i = 0;
//                year4[i] = Dater[0] + Dater[3];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("05")) {
//                int i = 0;
//                year5[i] = Dater[0] + Dater[4];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("06")) {
//                int i = 0;
//                year6[i] = Dater[0] + Dater[5];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("07")) {
//                int i = 0;
//                year7[i] = Dater[0] + Dater[6];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("08")) {
//                int i = 0;
//                year8[i] = Dater[0] + Dater[7];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("09")) {
//                int i = 0;
//                year9[i] = Dater[0] + Dater[8];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("10")) {
//                int i = 0;
//                year10[i] = Dater[0] + Dater[9];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("11")) {
//                int i = 0;
//                year11[i] = Dater[0] + Dater[10];
//                i++;
//            }else if(Dater[0].equals("2018") && Dater[1].equals("12")) {
//                int i = 0;
//                year12[i] = Dater[0] + Dater[11];
//                i++;
//            }
//        }

        int sZongFeiYong1 = 0;
        int tZongFeiYong1 = 0;
        int sZongFeiYong2 = 0;
        int tZongFeiYong2 = 0;
        int sZongFeiYong3 = 0;
        int tZongFeiYong3 = 0;
        int sZongFeiYong4 = 0;
        int tZongFeiYong4 = 0;
        int sZongFeiYong5 = 0;
        int tZongFeiYong5 = 0;
        int sZongFeiYong6 = 0;
        int tZongFeiYong6 = 0;
        int sZongFeiYong7 = 0;
        int tZongFeiYong7 = 0;
        int sZongFeiYong8 = 0;
        int tZongFeiYong8 = 0;
        int sZongFeiYong9 = 0;
        int tZongFeiYong9 = 0;
        int sZongFeiYong10 = 0;
        int tZongFeiYong10 = 0;
        int sZongFeiYong11 = 0;
        int tZongFeiYong11 = 0;
        int sZongFeiYong12 = 0;
        int tZongFeiYong12 = 0;


        for (StayRegisterBean stayRegisterInfo : stayRegisterInfos) {
            String[] Time = stayRegisterInfo.getPayTime().split(" ");
            String Date = Time[0];
            String[] Dater = Date.split("-");
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("01")){
                sZongFeiYong1=sZongFeiYong1+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("01")){
                tZongFeiYong1=sZongFeiYong1+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("02")){
                sZongFeiYong2=sZongFeiYong2+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("02")){
                tZongFeiYong2=sZongFeiYong2+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("03")){
                sZongFeiYong3=sZongFeiYong3+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("03")){
                tZongFeiYong3=sZongFeiYong3+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("04")){
                sZongFeiYong4=sZongFeiYong4+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("04")){
                tZongFeiYong4=sZongFeiYong4+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("05")){
                sZongFeiYong5=sZongFeiYong5+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("05")){
                tZongFeiYong5=sZongFeiYong5+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("06")){
                sZongFeiYong6=sZongFeiYong6+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("06")){
                tZongFeiYong6=sZongFeiYong6+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("07")){
                sZongFeiYong7=sZongFeiYong7+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("07")){
                tZongFeiYong7=sZongFeiYong7+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("08")){
                sZongFeiYong8=sZongFeiYong8+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("08")){
                tZongFeiYong8=sZongFeiYong8+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("09")){
                sZongFeiYong9=sZongFeiYong9+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("09")){
                tZongFeiYong9=sZongFeiYong9+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("10")){
                sZongFeiYong10=sZongFeiYong10+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("10")){
                tZongFeiYong10=sZongFeiYong10+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("11")){
                sZongFeiYong11=sZongFeiYong11+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("11")){
                tZongFeiYong11=sZongFeiYong11+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
            if (stayRegisterInfo.getTeam()==null&&Dater[1].equals("12")){
                sZongFeiYong12=sZongFeiYong12+Integer.valueOf(stayRegisterInfo.getSumConst());
            }else if (stayRegisterInfo.getTeam()!=null&&Dater[1].equals("12")){
                tZongFeiYong12=sZongFeiYong12+Integer.valueOf(stayRegisterInfo.getSumConst());
            }
        }

        model.addAttribute("sZongFeiYong1",sZongFeiYong1);
        model.addAttribute("tZongFeiYong1",tZongFeiYong1);
        model.addAttribute("sZongFeiYong2",sZongFeiYong2);
        model.addAttribute("tZongFeiYong2",tZongFeiYong2);
        model.addAttribute("sZongFeiYong3",sZongFeiYong3);
        model.addAttribute("tZongFeiYong3",tZongFeiYong3);
        model.addAttribute("sZongFeiYong4",sZongFeiYong4);
        model.addAttribute("tZongFeiYong4",tZongFeiYong4);
        model.addAttribute("sZongFeiYong5",sZongFeiYong5);
        model.addAttribute("tZongFeiYong5",tZongFeiYong5);
        model.addAttribute("sZongFeiYong6",sZongFeiYong6);
        model.addAttribute("tZongFeiYong6",tZongFeiYong6);
        model.addAttribute("sZongFeiYong7",sZongFeiYong7);
        model.addAttribute("tZongFeiYong7",tZongFeiYong7);
        model.addAttribute("sZongFeiYong8",sZongFeiYong8);
        model.addAttribute("tZongFeiYong8",tZongFeiYong8);
        model.addAttribute("sZongFeiYong9",sZongFeiYong9);
        model.addAttribute("tZongFeiYong9",tZongFeiYong9);
        model.addAttribute("sZongFeiYong10",sZongFeiYong10);
        model.addAttribute("tZongFeiYong10",tZongFeiYong10);
        model.addAttribute("sZongFeiYong11",sZongFeiYong11);
        model.addAttribute("tZongFeiYong11",tZongFeiYong11);
        model.addAttribute("sZongFeiYong12",sZongFeiYong12);
        model.addAttribute("tZongFeiYong12",tZongFeiYong12);

        model.addAttribute("year1","2018年1月");
        model.addAttribute("year2","2018年2月");
        model.addAttribute("year3","2018年3月");
        model.addAttribute("year4","2018年4月");
        model.addAttribute("year5","2018年5月");
        model.addAttribute("year6","2018年6月");
        model.addAttribute("year7","2018年7月");
        model.addAttribute("year8","2018年8月");
        model.addAttribute("year9","2018年9月");
        model.addAttribute("year10","2018年10月");
        model.addAttribute("year11","2018年11月");
        model.addAttribute("year12","2018年12月");







        return "/WEB-INF/jsp/dateview/shili.jsp";
    }
}
