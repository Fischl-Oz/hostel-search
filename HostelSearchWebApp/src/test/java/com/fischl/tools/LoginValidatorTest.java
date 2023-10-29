/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.tools;

import com.fischl.models.Account;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nguyen Khoi Minh
 */
public class LoginValidatorTest {
    
    public LoginValidatorTest() {
    }

    
    @Test
    public void LoginValidator_checkLogin_UTCID01() {
        System.out.println("Execute LoginValidator_checkLogin_UTCID01");
        String user_name = "MinhNK";
        String password = "123456";
        LoginValidator instance = new LoginValidator();
        String expResult = "Nguyen Khoi Minh";
        String result = instance.checkAccount(user_name, password).getFullName();
        assertTrue(expResult.equals(result));
    }
    
}
