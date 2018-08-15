package com.juliafealves.pupildiary.model;

public class Student {
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
}
