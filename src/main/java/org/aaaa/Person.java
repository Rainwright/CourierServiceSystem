package org.aaaa;

import java.time.LocalDate;

public class Person extends Data {
    protected String name;
    protected String contact;
    protected String nric;
    protected String email;
    protected LocalDate dob;

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
}