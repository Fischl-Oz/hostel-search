/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.database;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class DBConnectionTest {
    
    /**
     * Test of getConnection method, of class DBConnection.
     */
    @Test
    public void testGetConnection() {
        System.out.println("Connecting to database...");
        
        Connection result = DBConnection.getConnection();
        
        assertNotNull(result);
    }
    
}
