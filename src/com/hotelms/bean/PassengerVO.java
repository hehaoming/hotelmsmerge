package com.hotelms.bean;

public class PassengerVO extends Passenger {
    String genderName;
    String nationName;
    String passengerLevelName;
    String papersName;


    public PassengerVO(Integer id, String name, Integer genderID, String birthDate, Integer nationID, String licenceIssuingAuthorty, String papersValidity, String profession, Integer educationDegreeID, Integer passengerLevelID, Integer papersID, String papersNumber, String unitsOrAddress, Integer thingReasonID, String whereAreFrom, String whereToGo, String contacPhoneNumber, String remarks) {
        super(id, name, genderID, birthDate, nationID, licenceIssuingAuthorty, papersValidity, profession, educationDegreeID, passengerLevelID, papersID, papersNumber, unitsOrAddress, thingReasonID, whereAreFrom, whereToGo, contacPhoneNumber, remarks);
    }

    @Override
    public String toString() {
        return "PassengerVO{" +
                "genderName='" + genderName + '\'' +
                ", nationName='" + nationName + '\'' +
                ", passengerLevelName='" + passengerLevelName + '\'' +
                ", papersName='" + papersName + '\'' +
                '}';
    }

    @Override
    public String getGenderName() {
        return genderName;
    }

    @Override
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

    @Override
    public String getPapersName() {
        return papersName;
    }

    @Override
    public void setPapersName(String papersName) {
        this.papersName = papersName;
    }

    public PassengerVO(Integer id, String name, Integer genderID, String birthDate, Integer nationID, String licenceIssuingAuthorty, String papersValidity, String profession, Integer educationDegreeID, Integer passengerLevelID, Integer papersID, String papersNumber, String unitsOrAddress, Integer thingReasonID, String whereAreFrom, String whereToGo, String contacPhoneNumber, String remarks, String genderName, String nationName, String passengerLevelName, String papersName) {

        super(id, name, genderID, birthDate, nationID, licenceIssuingAuthorty, papersValidity, profession, educationDegreeID, passengerLevelID, papersID, papersNumber, unitsOrAddress, thingReasonID, whereAreFrom, whereToGo, contacPhoneNumber, remarks);
        this.genderName = genderName;
        this.nationName = nationName;
        this.passengerLevelName = passengerLevelName;
        this.papersName = papersName;
    }

    public PassengerVO(Integer id, String name, Integer genderID, String birthDate, Integer nationID, String licenceIssuingAuthorty, String papersValidity, String profession, Integer educationDegreeID, Integer passengerLevelID, Integer papersID, String papersNumber, String unitsOrAddress, Integer thingReasonID, String whereAreFrom, String whereToGo, String contacPhoneNumber, String remarks, String genderName, String papersName, String genderName1, String nationName, String passengerLevelName, String papersName1) {
        super(id, name, genderID, birthDate, nationID, licenceIssuingAuthorty, papersValidity, profession, educationDegreeID, passengerLevelID, papersID, papersNumber, unitsOrAddress, thingReasonID, whereAreFrom, whereToGo, contacPhoneNumber, remarks, genderName, papersName);
        this.genderName = genderName1;
        this.nationName = nationName;
        this.passengerLevelName = passengerLevelName;
        this.papersName = papersName1;
    }

    public PassengerVO(Integer id, String name, Integer genderID, String birthDate, Integer nationID, String licenceIssuingAuthorty, String papersValidity, String profession, Integer educationDegreeID, Integer passengerLevelID, Integer papersID, String papersNumber, String unitsOrAddress, Integer thingReasonID, String whereAreFrom, String whereToGo, String contacPhoneNumber, String remarks, String genderName, String papersName) {
        super(id, name, genderID, birthDate, nationID, licenceIssuingAuthorty, papersValidity, profession, educationDegreeID, passengerLevelID, papersID, papersNumber, unitsOrAddress, thingReasonID, whereAreFrom, whereToGo, contacPhoneNumber, remarks, genderName, papersName);
    }
}
