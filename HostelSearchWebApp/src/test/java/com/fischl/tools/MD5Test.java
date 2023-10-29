/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.tools;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nguyen Khoi Minh
 */
public class MD5Test {
    
    public MD5Test() {
    }

    @Test
    public void MD5_getMd5_UTCID01() {
        System.out.println("Execute MD5_getMd5_UTCID01");
        String input = "123456";
        String expResult = "e10adc3949ba59abbe56e057f20f883e";
        String result = MD5.getMd5(input);
        assertEquals(expResult, result);   
    }
    
    @Test
    public void MD5_getMd5_UTCID02() {
        System.out.println("Execute MD5_getMd5_UTCID02");
        String input = null;
        Exception exc = assertThrows(NullPointerException.class, () -> {
            MD5.getMd5(input);
        });
        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
    }
    
    @Test
    public void MD5_getMd5_UTCID03() {
        System.out.println("Execute MD5_getMd5_UTCID03");
        String input = "!@#$%^";
        String expResult = "c92b51b2f4d93d4e1081670bd9273402";
        String result = MD5.getMd5(input);
        assertEquals(expResult, result);
    }
}
