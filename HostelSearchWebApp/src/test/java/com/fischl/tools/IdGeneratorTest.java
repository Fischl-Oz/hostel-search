/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.tools;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nguyen Khoi Minh
 */
public class IdGeneratorTest {
    
    public IdGeneratorTest() {
    }

    @Test
    public void IdGenerator_getNewUserId_UTCID01() {
        System.out.println("Execute IdGenerator_getNewUserId_UTCID01");
        IdGenerator instance = new IdGenerator();
        int expResult = 80000008;
        int result = instance.getNewUserId();
        assertEquals(expResult, result);
    }
    
    @Test
    public void IdGenerator_getNewUserId_UTCID02() {
        System.out.println("Execute IdGenerator_getNewUserId_UTCID02");
        Connection conn = null;
        IdGenerator instance = new IdGenerator(conn);
        Exception exc = assertThrows(NullPointerException.class, () -> {
            int res = instance.getNewUserId();
        });
        
        String expMssg = "\"this.conn\" is null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
    }
    
    @Test
    public void IdGenerator_getNewHostelId_UTCID01() {
        System.out.println("Execute IdGenerator_getNewHostelId_UTCID01");
        IdGenerator instance = new IdGenerator();
        int expResult = 70000004;
        int result = instance.getNewHostelId();
        assertEquals(expResult, result);
    }
    
    @Test
    public void IdGenerator_getNewHostelId_UTCID02() {
        System.out.println("Execute IdGenerator_getNewHostelId_UTCID02");
        IdGenerator instance = new IdGenerator(null);
        Exception exc = assertThrows(NullPointerException.class, () -> {
            instance.getNewHostelId();
        });
        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
    }
    
    @Test
    public void IdGenerator_getNewImgId_UTCID01() {
        System.out.println("Execute IdGenerator_getNewImgId_UTCID01");
        IdGenerator instance = new IdGenerator();
        int expResult = 10000001;
        int result = instance.getNewImgId();
        assertEquals(expResult, result);
    }
    
    @Test
    public void IdGenerator_getNewImgId_UTCID02() {
        System.out.println("Execute IdGenerator_getNewImgId_UTCID02");
        IdGenerator instance = new IdGenerator(null);
        Exception exc = assertThrows(NullPointerException.class, () -> {
            instance.getNewImgId();
        });
        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
    }

    @Test
    public void IdGenerator_getNewPostId_UTCID01() {
        System.out.println("Execute IdGenerator_getNewPostId_UTCID01");
        IdGenerator instance = new IdGenerator();
        int expResult = 60000001;
        int result = instance.getNewPostId();
        assertEquals(expResult, result);
    }
    
    @Test
    public void IdGenerator_getNewPostId_UTCID02() {
        System.out.println("Execute IdGenerator_getNewPostId_UTCID02");
        IdGenerator instance = new IdGenerator(null);
        Exception exc = assertThrows(NullPointerException.class, () -> {
            instance.getNewPostId();
        });
        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
    }
    
    @Test
    public void IdGenerator_getNewTagId_UTCID01() {
        System.out.println("Execute IdGenerator_getNewTagId_UTCID01");
        IdGenerator instance = new IdGenerator();
        String expResult = "TAG-004";
        String result = instance.getNewTagId();
        assertEquals(expResult, result);
    }
    
    @Test
    public void IdGenerator_getNewTagId_UTCID02() {
        System.out.println("Execute IdGenerator_getNewTagId_UTCID02");
        IdGenerator instance = new IdGenerator(null);
        Exception exc = assertThrows(NullPointerException.class, () -> {
            instance.getNewTagId();
        });
        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
    }
}
