package com.hotelms.bean;

public class Passenger {
    private Integer id;

    private String name;

    private Integer genderID;

    private String birthDate;

    private Integer nationID;

    private String licenceIssuingAuthorty;

    private String papersValidity;

    private String profession;

    private Integer educationDegreeID;

    private Integer passengerLevelID;

    private Integer papersID;

    private String papersNumber;

    private String unitsOrAddress;

    private Integer thingReasonID;

    private String whereAreFrom;

    private String whereToGo;

    private String contacPhoneNumber;

    private String remarks;


    private String genderName;
    private String papersName;


    public Passenger() {
    }

    public Passenger(Integer id, String name, Integer genderID, String birthDate, Integer nationID
            , String licenceIssuingAuthorty, String papersValidity, String profession, Integer educationDegreeID
            , Integer passengerLevelID, Integer papersID, String papersNumber, String unitsOrAddress
            , Integer thingReasonID, String whereAreFrom, String whereToGo, String contacPhoneNumber, String remarks) {
        this.id = id;
        this.name = name;
        this.genderID = genderID;
        this.birthDate = birthDate;
        this.nationID = nationID;
        this.licenceIssuingAuthorty = licenceIssuingAuthorty;
        this.papersValidity = papersValidity;
        this.profession = profession;
        this.educationDegreeID = educationDegreeID;
        this.passengerLevelID = passengerLevelID;
        this.papersID = papersID;
        this.papersNumber = papersNumber;
        this.unitsOrAddress = unitsOrAddress;
        this.thingReasonID = thingReasonID;
        this.whereAreFrom = whereAreFrom;
        this.whereToGo = whereToGo;
        this.contacPhoneNumber = contacPhoneNumber;
        this.remarks = remarks;
    }
    public Passenger(Integer id, String name, Integer genderID, String birthDate, Integer nationID, String licenceIssuingAuthorty, String papersValidity, String profession, Integer educationDegreeID, Integer passengerLevelID, Integer papersID, String papersNumber, String unitsOrAddress, Integer thingReasonID, String whereAreFrom, String whereToGo, String contacPhoneNumber, String remarks, String genderName, String papersName) {
        this.id = id;
        this.name = name;
        this.genderID = genderID;
        this.birthDate = birthDate;
        this.nationID = nationID;
        this.licenceIssuingAuthorty = licenceIssuingAuthorty;
        this.papersValidity = papersValidity;
        this.profession = profession;
        this.educationDegreeID = educationDegreeID;
        this.passengerLevelID = passengerLevelID;
        this.papersID = papersID;
        this.papersNumber = papersNumber;
        this.unitsOrAddress = unitsOrAddress;
        this.thingReasonID = thingReasonID;
        this.whereAreFrom = whereAreFrom;
        this.whereToGo = whereToGo;
        this.contacPhoneNumber = contacPhoneNumber;
        this.remarks = remarks;
        this.genderName = genderName;
        this.papersName = papersName;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genderID='" + genderID + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", nationID=" + nationID +
                ", licenceIssuingAuthorty='" + licenceIssuingAuthorty + '\'' +
                ", papersValidity='" + papersValidity + '\'' +
                ", profession='" + profession + '\'' +
                ", educationDegreeID=" + educationDegreeID +
                ", passengerLevelID=" + passengerLevelID +
                ", papersID=" + papersID +
                ", papersNumber='" + papersNumber + '\'' +
                ", unitsOrAddress='" + unitsOrAddress + '\'' +
                ", thingReasonID=" + thingReasonID +
                ", whereAreFrom='" + whereAreFrom + '\'' +
                ", whereToGo='" + whereToGo + '\'' +
                ", contactPhoneNumber='" + contacPhoneNumber + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGenderID() {
        return genderID;
    }

    public void setGenderID(Integer genderID) {
        this.genderID = genderID;
    }

    public String getContacPhoneNumber() {
        return contacPhoneNumber;
    }

    public void setContacPhoneNumber(String contacPhoneNumber) {
        this.contacPhoneNumber = contacPhoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getNationID() {
        return nationID;
    }

    public void setNationID(Integer nationID) {
        this.nationID = nationID;
    }

    public String getLicenceIssuingAuthorty() {
        return licenceIssuingAuthorty;
    }

    public void setLicenceIssuingAuthorty(String licenceIssuingAuthorty) {
        this.licenceIssuingAuthorty = licenceIssuingAuthorty;
    }

    public String getPapersValidity() {
        return papersValidity;
    }

    public void setPapersValidity(String papersValidity) {
        this.papersValidity = papersValidity;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getEducationDegreeID() {
        return educationDegreeID;
    }

    public void setEducationDegreeID(Integer educationDegreeID) {
        this.educationDegreeID = educationDegreeID;
    }

    public Integer getPassengerLevelID() {
        return passengerLevelID;
    }

    public void setPassengerLevelID(Integer passengerLevelID) {
        this.passengerLevelID = passengerLevelID;
    }

    public Integer getPapersID() {
        return papersID;
    }

    public void setPapersID(Integer papersID) {
        this.papersID = papersID;
    }

    public String getPapersNumber() {
        return papersNumber;
    }

    public void setPapersNumber(String papersNumber) {
        this.papersNumber = papersNumber;
    }

    public String getUnitsOrAddress() {
        return unitsOrAddress;
    }

    public void setUnitsOrAddress(String unitsOrAddress) {
        this.unitsOrAddress = unitsOrAddress;
    }

    public Integer getThingReasonID() {
        return thingReasonID;
    }

    public void setThingReasonID(Integer thingReasonID) {
        this.thingReasonID = thingReasonID;
    }

    public String getWhereAreFrom() {
        return whereAreFrom;
    }

    public void setWhereAreFrom(String whereAreFrom) {
        this.whereAreFrom = whereAreFrom;
    }

    public String getWhereToGo() {
        return whereToGo;
    }

    public void setWhereToGo(String whereToGo) {
        this.whereToGo = whereToGo;
    }

    public String getContactPhoneNumber() {
        return contacPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contacPhoneNumber = contactPhoneNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getPapersName() {
        return papersName;
    }

    public void setPapersName(String papersName) {
        this.papersName = papersName;
    }
}