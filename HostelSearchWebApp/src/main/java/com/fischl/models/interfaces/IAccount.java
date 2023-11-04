package com.fischl.models.interfaces;

public interface IAccount {
    int getUserId();
    void setUserId(int user_id);
    String getFullName();
    void setFullName(String full_name);
    String getUserName();
    void setUserName(String user_name);
    String getPassword();
    void setPassword(String password);
    String getPhone();
    void setPhone(String phone);
    String getEmail();
    void setEmail(String email);
    String getUserType();
    void setUserType(String user_type);
}