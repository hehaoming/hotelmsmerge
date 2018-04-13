package com.hotelms.vo;


import com.hotelms.bean.ItemBean;

public class PassengerStayRegisterVO {
    /* id                     INT AUTO_INCREMENT
    PRIMARY KEY,
  name                   VARCHAR(32)  NULL,
  genderID               VARCHAR(12)  NULL,
  birthDate              VARCHAR(32)  NULL,
  nationID               INT(32)      NULL,
  licenceIssuingAuthorty VARCHAR(64)  NULL,
  papersValidity         VARCHAR(32)  NULL,
  profession             VARCHAR(32)  NULL,
  educationDegreeID      INT          NULL,
  passengerLevelID       INT          NULL,
  papersID               INT          NULL,
  papersNumber           VARCHAR(32)  NULL,
  unitsOrAddress         VARCHAR(64)  NULL,
  thingReasonID          VARCHAR(128) NULL,
  whereAreFrom           VARCHAR(128) NULL,
  whereToGo              VARCHAR(128) NULL,
  contacPhoneNumber      VARCHAR(11)  NULL,
  remarks                VARCHAR(128) NULL*/
    private int id;
    private String name;
    private ItemBean gender;
    private String birthDate;
    private ItemBean nation;
    private String licenceIssuingAuthorty;
    private String papersValidity;
    private String profession;
    private ItemBean educationDegree;
    private ItemBean passengerLevel;
    private ItemBean papers;
    private String papersNumber;
    private String unitsOrAddress;
    private ItemBean thingReasonID;
    private String whereAreFrom;
    private String whereToGo;
    private String contacPhoneNumber;
    private String remarks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemBean getGender() {
        return gender;
    }

    public void setGender(ItemBean gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public ItemBean getNation() {
        return nation;
    }

    public void setNation(ItemBean nation) {
        this.nation = nation;
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

    public ItemBean getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(ItemBean educationDegree) {
        this.educationDegree = educationDegree;
    }

    public ItemBean getPassengerLevel() {
        return passengerLevel;
    }

    public void setPassengerLevel(ItemBean passengerLevel) {
        this.passengerLevel = passengerLevel;
    }

    public ItemBean getPapers() {
        return papers;
    }

    public void setPapers(ItemBean papers) {
        this.papers = papers;
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

    public String getContacPhoneNumber() {
        return contacPhoneNumber;
    }

    public void setContacPhoneNumber(String contacPhoneNumber) {
        this.contacPhoneNumber = contacPhoneNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "PassengerStayRegisterVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate='" + birthDate + '\'' +
                ", nation=" + nation +
                ", licenceIssuingAuthorty='" + licenceIssuingAuthorty + '\'' +
                ", papersValidity='" + papersValidity + '\'' +
                ", profession='" + profession + '\'' +
                ", educationDegree=" + educationDegree +
                ", passengerLevel=" + passengerLevel +
                ", papers=" + papers +
                ", papersNumber='" + papersNumber + '\'' +
                ", unitsOrAddress='" + unitsOrAddress + '\'' +
                ", thingReasonID='" + thingReasonID + '\'' +
                ", whereAreFrom='" + whereAreFrom + '\'' +
                ", whereToGo='" + whereToGo + '\'' +
                ", contacPhoneNumber='" + contacPhoneNumber + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public ItemBean getThingReasonID() {
        return thingReasonID;
    }

    public void setThingReasonID(ItemBean thingReasonID) {
        this.thingReasonID = thingReasonID;
    }
}
