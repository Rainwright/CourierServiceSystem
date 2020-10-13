package org.aaaa;

import java.time.LocalDate;
//*accountID,name,contact,nric,dob,houseNum,streetName,city,postcode,state,country,createdBy,createdOn,changedBy,changedOn*
public class Person {
    protected String name;
    protected String contact;
    protected String nric;
    protected String email;
    protected LocalDate dob;
    protected String num;
    protected String houseNum;
    protected String streetName;
    protected String city;
    protected String postcode;
    protected String country;
    protected String createdBy;
    protected LocalDate createdOn;
    protected String changedBy;
    protected LocalDate changedOn;

    public Person() {
        this.name = "";
        this.contact = "";
    }

    public Person(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public Person(String name, String contact, String nric, String email, LocalDate dob) {
        this.name = name;
        this.contact = contact;
        this.nric = nric;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public LocalDate getChangedOn() {
        return changedOn;
    }

    public void setChangedOn(LocalDate changedOn) {
        this.changedOn = changedOn;
    }
}
