package com.hotelms.bean;

public class PassengerVO extends Passenger {
    String genderName;

    public PassengerVO(Integer id, String name, String genderID, String birthDate, Integer nationID, String licenceIssuingAuthorty, String papersValidity, String profession, Integer educationDegreeID, Integer passengerLevelID, Integer papersID, String papersNumber, String unitsOrAddress, Integer thingReasonID, String whereAreFrom, String whereToGo, String contactPhoneNumber, String remarks) {
        super(id, name, genderID, birthDate, nationID, licenceIssuingAuthorty, papersValidity, profession, educationDegreeID, passengerLevelID, papersID, papersNumber, unitsOrAddress, thingReasonID, whereAreFrom, whereToGo, contactPhoneNumber, remarks);
    }

    public PassengerVO(){}

    String nationName;
    String passengerLevelName;
    String papersName;

    @Override
    public String toString() {
        return "PassengerVO{" +
                "genderName='" + genderName + '\'' +
                ", nationName='" + nationName + '\'' +
                ", passengerLevelName='" + passengerLevelName + '\'' +
                ", papersName='" + papersName + '\'' +
                '}';
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getPassengerLevelName() {
        return passengerLevelName;
    }

    public void setPassengerLevelName(String passengerLevelName) {
        this.passengerLevelName = passengerLevelName;
    }

    public String getPapersName() {
        return papersName;
    }

    public void setPapersName(String papersName) {
        this.papersName = papersName;
    }

    public PassengerVO(String genderName, String nationName, String passengerLevelName, String papersName) {

        this.genderName = genderName;
        this.nationName = nationName;
        this.passengerLevelName = passengerLevelName;
        this.papersName = papersName;
    }

    public PassengerVO(Integer id, String name, String genderID, String birthDate, Integer nationID, String licenceIssuingAuthorty, String papersValidity, String profession, Integer educationDegreeID, Integer passengerLevelID, Integer papersID, String papersNumber, String unitsOrAddress, Integer thingReasonID, String whereAreFrom, String whereToGo, String contactPhoneNumber, String remarks, String genderName, String nationName, String passengerLevelName, String papersName) {
        super(id, name, genderID, birthDate, nationID, licenceIssuingAuthorty, papersValidity, profession, educationDegreeID, passengerLevelID, papersID, papersNumber, unitsOrAddress, thingReasonID, whereAreFrom, whereToGo, contactPhoneNumber, remarks);
        this.genderName = genderName;
        this.nationName = nationName;
        this.passengerLevelName = passengerLevelName;
        this.papersName = papersName;
    }
}
