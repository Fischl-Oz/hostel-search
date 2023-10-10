package com.fischl.models;

public class Admin {
    private int user_id;

    public Admin() {
    }

    public Admin(int user_id) {
        this.user_id = user_id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }
}
