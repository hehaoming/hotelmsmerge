package com.hotelms.bean;

public class Team {
    private Integer tuanduiID;

    private Integer targettypeID;

    private String principal;

    private String teamName;

    private String teamCode;

    private String registerTime;

    private String contactPhoneNumber;

    public Team() {
    }

    public Team(Integer tuanduiID, Integer targettypeID, String principal, String teamName
            , String teamCode, String registerTime, String contactPhoneNumber) {
        this.tuanduiID = tuanduiID;
        this.targettypeID = targettypeID;
        this.principal = principal;
        this.teamName = teamName;
        this.teamCode = teamCode;
        this.registerTime = registerTime;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public Integer getTuanduiID() {
        return tuanduiID;
    }

    public void setTuanduiID(Integer tuanduiID) {
        this.tuanduiID = tuanduiID;
    }

    public Integer getTargettypeID() {
        return targettypeID;
    }

    public void setTargettypeID(Integer targettypeID) {
        this.targettypeID = targettypeID;
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

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    @Override
    public String toString() {
        return "Team{" +
                "tuanduiID=" + tuanduiID +
                ", targettypeID=" + targettypeID +
                ", principal='" + principal + '\'' +
                ", teamName='" + teamName + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", contactPhoneNumber=" + contactPhoneNumber +
                '}';
    }
}