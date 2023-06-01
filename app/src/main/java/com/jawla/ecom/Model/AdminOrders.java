package com.jawla.ecom.Model;

public class AdminOrders
{
    private String name, city, address, phone, state, date, time, totalAmount;

    public AdminOrders() {
    }

    public AdminOrders(String name, String city, String address, String phone, String stat, String date, String time, String totalAmount) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.state = stat;
        this.date = date;
        this.time = time;
        this.totalAmount = totalAmount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStat() {
        return state;
    }

    public void setStat(String stat) {
        this.state = stat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
