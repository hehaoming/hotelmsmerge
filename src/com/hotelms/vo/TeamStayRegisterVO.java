package com.hotelms.vo;


import com.hotelms.bean.ItemBean;

public class TeamStayRegisterVO {
    /*tuanduiID          INT AUTO_INCREMENT
    PRIMARY KEY,
    targetTypeID       INT         NULL,
    principal          VARCHAR(32) NULL,
    teamName           VARCHAR(32) NULL,
    teamCode           VARCHAR(64) NULL,
    registerTime       VARCHAR(64) NULL,
    contactPhoneNUmber VARCHAR(11) NULL*/
    private int tuanduiID;
    private ItemBean itemBean;
    private String principal;
    private String teamName;
    private String teamCode;
    private String registerTime;
    private String contactPhoneNUmber;


    public com.hotelms.bean.ItemBean getItemBean() {
        return itemBean;
    }

    public void setItemBean(com.hotelms.bean.ItemBean ItemBean) {
        this.itemBean = itemBean;
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

    @Override
    public String toString() {
        return "TeamStayRegisterVO{" +
                "tuanduiID='" + tuanduiID + '\'' +
                ", ItemBean=" + itemBean +
                ", principal='" + principal + '\'' +
                ", teamName='" + teamName + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", contactPhoneNUmber='" + contactPhoneNUmber + '\'' +
                '}';
    }

    public int getTuanduiID() {
        return tuanduiID;
    }

    public void setTuanduiID(int tuanduiID) {
        this.tuanduiID = tuanduiID;
    }
}
