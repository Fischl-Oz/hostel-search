package com.fischl.models;

public class HostelMaster {
    private int user_id;
    private String hm_addr;
    private  boolean authenticated;

    public HostelMaster() {
    }

    public HostelMaster(int user_id, String hm_addr, boolean authenticated) {
        this.user_id = user_id;
        this.hm_addr = hm_addr;
        this.authenticated = authenticated;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getHmAddr() {
        return hm_addr;
    }

    public void setHmAddr(String hm_addr) {
        this.hm_addr = hm_addr;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
