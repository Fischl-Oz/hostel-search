package com.fischl.tools;

import com.fischl.DAOs.AccountDAO;
public class LoginValidator {

    public int checkAccount(String user_name, String password) {

        return new AccountDAO().getByUsernamePassword(user_name,password).getUserId();
    }
}
