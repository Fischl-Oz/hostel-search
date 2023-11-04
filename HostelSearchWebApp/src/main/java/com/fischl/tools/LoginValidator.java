package com.fischl.tools;

import com.fischl.DAOs.AccountDAO;
import com.fischl.models.Account;

public class LoginValidator {

    public Account checkAccount(String user_name, String password) {
        Account acc = null;

        acc = new AccountDAO().getByUsernamePassword(user_name,password);

        return acc;
    }
}
