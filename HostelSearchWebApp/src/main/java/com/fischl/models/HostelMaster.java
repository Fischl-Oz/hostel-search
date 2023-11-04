package com.fischl.models;

import com.fischl.models.interfaces.IHostelMaster;

public class HostelMaster implements IHostelMaster {
    private int user_id;
    private String hm_addr;
    private String cccd_front;
    private String cccd_back;
    private String hbc; // Hostel Business Certificate
    private String status;

    public HostelMaster() {
    }

    public HostelMaster(int user_id, String hm_addr, String cccd_front, String cccd_back, String hbc, String status) {
        this.user_id = user_id;
        this.hm_addr = hm_addr;
        this.cccd_front = cccd_front;
        this.cccd_back = cccd_back;
        this.hbc = hbc;
        this.status = status;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getHostelMasterAddress() {
        return hm_addr;
    }

    public void setHostelMasterAddress(String hm_addr) {
        this.hm_addr = hm_addr;
    }

    public String getCccdFront() {
        return cccd_front;
    }

    public void setCccdFront(String cccd_front) {
        this.cccd_front = cccd_front;
    }

    public String getCccdBack() {
        return cccd_back;
    }

    public void setCccdBack(String cccd_back) {
        this.cccd_back = cccd_back;
    }

    public String getHbc() {
        return hbc;
    }

    public void setHbc(String hbc) {
        this.hbc = hbc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void clone(HostelMaster hostelMaster) {
        setUserId(hostelMaster.getUserId());
        setHostelMasterAddress(hostelMaster.getHostelMasterAddress());
        setCccdFront(hostelMaster.getCccdFront());
        setCccdBack(hostelMaster.getCccdBack());
        setHbc(hostelMaster.getHbc());
        setStatus(hostelMaster.getStatus());
    }
}
