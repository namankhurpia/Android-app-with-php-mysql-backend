package com.namankhurpia.udemy_app_php_backend.schema;

public class contacts {

    private String name;
    private String password;
    private String contact;

    public contacts(String name, String password, String contact, String country) {

        this.setName(name);
        this.setContact(contact);
        this.setPassword(password);
        this.setCountry(country);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;

}
