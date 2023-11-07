package com.fischl.models;


public class Hostel {
    private int hostel_id;
    private String hostel_name;
    private String hostel_addr;
    private String hostel_desc;
    private double price;
    private double area;
    private byte total_room;
    private byte available_room;
    private String district_id;
    private int user_id;

    public Hostel() {
    }

    public Hostel(int hostel_id, String hostel_name, String hostel_addr, String hostel_desc, int price, double area, byte total_room, byte available_room, String district_id, int user_id) {
        this.hostel_id = hostel_id;
        this.hostel_name = hostel_name;
        this.hostel_addr = hostel_addr;
        this.hostel_desc = hostel_desc;
        this.price = price;
        this.area = area;
        this.total_room = total_room;
        this.available_room = available_room;
        this.district_id = district_id;
        this.user_id = user_id;
    }

    public int getHostelId() {
        return hostel_id;
    }

    public void setHostelId(int hostel_id) {
        this.hostel_id = hostel_id;
    }

    public String getHostelName() {
        return hostel_name;
    }

    public void setHostelName(String hostel_name) {
        this.hostel_name = hostel_name;
    }

    public String getHostelAddr() {
        return hostel_addr;
    }

    public void setHostelAddr(String hostel_addr) {
        this.hostel_addr = hostel_addr;
    }

    public String getHostelDesc() {
        return hostel_desc;
    }

    public void setHostelDesc(String hostel_desc) {
        this.hostel_desc = hostel_desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public byte getTotalRoom() {
        return total_room;
    }

    public void setTotalRoom(byte total_room) {
        this.total_room = total_room;
    }

    public byte getAvailableRoom() {
        return available_room;
    }

    public void setAvailableRoom(byte available_room) {
        this.available_room = available_room;
    }

    public String getDistrictId() {
        return district_id;
    }

    public void setDistrictId(String district_id) {
        this.district_id = district_id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }
}
