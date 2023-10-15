package com.fischl.models;


import java.sql.Date;

public class Account {
    private int user_id;
    private Date date_signup;
    private String full_name;
    private String user_name;
    private String password;
    private String phone;
    private String email;

    public Account() {}

    public Account(int user_id, Date date_signup, String full_name, String user_name, String password, String phone, String email) {
        this.user_id = user_id;
        this.date_signup = date_signup;
        this.full_name = full_name;
        this.user_name = user_name;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public Date getDateSignup() {
        return date_signup;
    }

    public void setDateSignup(Date date_signup) {
        this.date_signup = date_signup;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public boolean equals(Object o) {
        Account obj = (Account) o;
        return (obj.getUserId() == this.user_id);
    }
}
