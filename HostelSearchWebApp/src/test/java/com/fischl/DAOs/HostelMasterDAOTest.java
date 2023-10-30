/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.DAOs;

import com.fischl.models.HostelMaster;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class HostelMasterDAOTest {
    
    public HostelMasterDAOTest() {
    }

    /**
     * Test of add method, of class HostelMasterDAO.
     */
    @Test
    public void HostelMasterDAO_add_UTCID01() {
        System.out.println("add");
        HostelMaster hostelMaster = null;
        HostelMasterDAO instance = new HostelMasterDAO();
        Exception assertThrows = assertThrows(NullPointerException.class, () -> {
            instance.add(hostelMaster);
        });
        String expectedMessage = "null";
        String actualMessage = assertThrows.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        
    }
    /**
     * Test of add method, of class HostelDAO.
     */
    @Test
    public void HostelMasterDAO_add_UTCID02() {
        System.out.println("add");
        HostelMaster hostelMaster = new HostelMaster(-1, "hostelAddr01", true);
        HostelMasterDAO instance = new HostelMasterDAO();
        boolean expResult = false;
        boolean result = instance.add(hostelMaster);
        assertEquals(expResult, result);

    }
    // fail do ten relation sai: hostel_master ko ton tai
    @Test
    public void HostelMasterDAO_add_UTCID03() {
        System.out.println("add");
        HostelMaster hostelMaster = new HostelMaster(80000007, "hostelAddr01", true);
        HostelMasterDAO instance = new HostelMasterDAO();
        boolean expResult = true;
        boolean result = instance.add(hostelMaster);
        assertEquals(expResult, result);

    }@Test
    public void HostelMasterDAO_add_UTCID04() {
        System.out.println("add");
        HostelMaster hostelMaster = new HostelMaster(80000001, "hostelAddr01", true);
        HostelMasterDAO instance = new HostelMasterDAO();
        boolean expResult = false;
        boolean result = instance.add(hostelMaster);
        assertEquals(expResult, result);

    }
    

    /**
     * Test of delete method, of class HostelMasterDAO.
     */
    @Test
    public void HostelMasterDAO_delete_UTCID01() {
        System.out.println("delete");
        Integer id = null;
        HostelMasterDAO instance = new HostelMasterDAO();
        Exception assertThrows = assertThrows(NullPointerException.class, () -> {
            instance.delete(id);
        });
        String expectedMessage = "null";
        String actualMessage = assertThrows.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        
    }
    /**
     * Test of delete method, of class HostelDAO.
     */
    @Test
    public void HostelMasterDAO_delete_UTCID02() {
        System.out.println("delete");
        Integer id = -1;
        HostelMasterDAO instance = new HostelMasterDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);

    }
    /**
     * Test of delete method, of class HostelDAO.
     * fail do ten relation sai: hostel_master ko ton tai
     */
    @Test
    public void HostelMasterDAO_delete_UTCID03() {
        System.out.println("delete");
        Integer id = 80000000;
        HostelMasterDAO instance = new HostelMasterDAO();
        boolean expResult = true;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of update method, of class HostelMasterDAO.
     */
    @Test
    public void HostelMasterDAO_update_UTCID01() {
        System.out.println("update");
        HostelMaster hm = null;
        HostelMasterDAO instance = new HostelMasterDAO();
        Exception assertThrows = assertThrows(NullPointerException.class, () -> {
            instance.update(hm);
        });
        String expectedMessage = "null";
        String actualMessage = assertThrows.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    /**
     * Test of delete method, of class HostelDAO.
     * fail do ten relation sai: hostel_master ko ton tai
     */
    @Test
    public void HostelMasterDAO_update_UTCID02() {
        System.out.println("update");
        HostelMasterDAO instance = new HostelMasterDAO();
        HostelMaster hm = new HostelMaster();
        hm.setUserId(80000005);
        hm.setHmAddr("HostelAddress 1");
        hm.setAuthenticated(true);
        boolean expResult = false;
        boolean result = instance.update(hm);
        assertEquals(expResult, result);

    }
/**
     * Test of delete method, of class HostelDAO.
     */
    @Test
    public void HostelMasterDAO_update_UTCID03() {
        System.out.println("update");
        HostelMasterDAO instance = new HostelMasterDAO();
        HostelMaster hm = new HostelMaster();
        hm.setUserId(80000001);
        hm.setHmAddr("HostelAddress 1");
        hm.setAuthenticated(true);
        boolean expResult = true;
        boolean result = instance.update(hm);
        assertEquals(expResult, result);

    }
    /**
     * Test of getAll method, of class HostelMasterDAO.
     */
    @Test
    public void HostelMasterDAO_getAll_UTCID01() {
        System.out.println("getAll");
        HostelMasterDAO instance = new HostelMasterDAO();
        boolean expResult = true;
        ArrayList<HostelMaster> list = instance.getAll();
        assertEquals(expResult, !list.isEmpty());
        
    }

    /**
     * Test of getAll method, of class HostelDAO.
     */
    @Test
    public void HostelMasterDAO_getAll_UTCID02() {
        System.out.println("getAll");
        HostelMasterDAO instance = new HostelMasterDAO();
        Exception assertThrows = assertThrows(NullPointerException.class, () -> {
            instance.getAll();
        });
        String expectedMessage = "null";
        String actualMessage = assertThrows.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
    /**
     * Test of getById method, of class HostelMasterDAO.
     */
    @Test
    public void HostelMasterDAO_getById_UTCID01() {
        System.out.println("getById");
        Integer id = null;
        HostelMasterDAO instance = new HostelMasterDAO();
        Exception assertThrows = assertThrows(NullPointerException.class, () -> {
            instance.getById(id);
        });
        String expectedMessage = "null";
        String actualMessage = assertThrows.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        
    }
    
    /**
     * Test of getById method, of class HostelDAO.
     */
    @Test
    public void HostelMasterDAO_getById_UTCID02() {
        System.out.println("getById");
        int id = 80000001;
        String hmAddress = "456 Main St";
        HostelMasterDAO instance = new HostelMasterDAO();
        boolean expResult = true;
        String result = instance.getById(id).getHmAddr();
        assertEquals(expResult, result.equals(hmAddress));

    }
    /**
     * Test of getById method, of class HostelDAO.
     */
    @Test
    public void HostelMasterDAO_getById_UTCID03() {
        System.out.println("getById");
        Integer id = -1;
        HostelMasterDAO instance = new HostelMasterDAO();
        String expResult = null;
        String result = instance.getById(id).getHmAddr();
        assertEquals(expResult, result);

    }
    
}
