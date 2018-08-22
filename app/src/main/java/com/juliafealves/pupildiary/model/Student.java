package com.juliafealves.pupildiary.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String website;
    private Double rate;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public Double getRate() {
        return rate;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name;
    }

    /**
     * Return the website formatted adding "http://" when necessary.
     * @return Website formatted.
     */
    public String getWebsiteFormatted(){
        if(!(this.website.startsWith("http://") || this.website.startsWith("https://")))
           return "http://" + this.website;

        return website;
    }
}
