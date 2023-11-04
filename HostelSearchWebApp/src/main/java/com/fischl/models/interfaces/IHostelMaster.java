package com.fischl.models.interfaces;

public interface IHostelMaster {
    int getUserId();
    void setUserId(int user_id);
    String getHostelMasterAddress();
    void setHostelMasterAddress(String hm_addr);
    String getCccdFront();
    void setCccdFront(String cccd_front);
    String getCccdBack();
    void setCccdBack(String cccd_back);
    String getHbc();
    void setHbc(String hbc);
    String getStatus();
    void setStatus(String status);
}
