package com.rohitkashyap.HelpingHand.User;

import android.util.Log;

public class Details {

    public String name, city, poc, capacity, contact, cost, pincode, address, srnum;

    public Details() {
    }

    public Details(String name, String city, String poc, String capacity, String contact, String cost, String pincode, String address, String srnum) {
        this.name = name;
        this.city = city;
        this.poc = poc;
        this.capacity = capacity;
        this.contact = contact;
        this.cost = cost;
        this.pincode = pincode;
        this.address = address;
        this.srnum = srnum;

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

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSrnum() {
        return srnum;
    }

    public void setSrnum(String srnum) {
        this.srnum = srnum;
    }

    public void print(){
        Log.e("Details:::",name+" "+city+" "+poc+" "+capacity+" "+contact+" "+cost+" "+pincode+" "+address+" "+srnum);
    }
}
