package com.hotelms.bean;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReceiveTargetBean {

    /*
    接待对象：


     */

    //table_id
    int rt_id;

    //对象类别
    int targetTypeID;

    //负责人
    String principal;

    //团队名称
    String teamName;

    String targetTypeName;

    //团队编号
    String teamCode;

    //登记时间
    String registerTime;

    //联系电话
    String contactPhoneNUmber;


    public ReceiveTargetBean() {
    }

    public ReceiveTargetBean(int rt_id, int targetTypeID, String principal, String teamName, String teamCode, String registerTime, String contactPhoneNUmber) {
        this.rt_id = rt_id;
        this.targetTypeID = targetTypeID;
        this.principal = principal;
        this.teamName = teamName;
        this.teamCode = teamCode;
        this.registerTime = registerTime;
        this.contactPhoneNUmber = contactPhoneNUmber;
    }

    public String getTargetTypeName() {
        String re = null;
        if (getTargetTypeID() == 72) {
            re = "散客";
        } else {
            re = "团队";
        }

        return re;
    }

    public int getRt_id() {
        return rt_id;
    }

    public void setRt_id(int rt_id) {
        this.rt_id = rt_id;
    }

    public int getTargetTypeID() {
        return targetTypeID;
    }

    public void setTargetTypeID(int targetTypeID) {
        this.targetTypeID = targetTypeID;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getContactPhoneNUmber() {
        return contactPhoneNUmber;
    }

    public void setContactPhoneNUmber(String contactPhoneNUmber) {
        this.contactPhoneNUmber = contactPhoneNUmber;
    }
}
