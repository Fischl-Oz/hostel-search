/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.DAOs;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import com.fischl.tools.IdGenerator;
import com.fischl.models.Hostel;
import java.sql.SQLException;

/**
 *
 * @author hoang
 */
public class HostelDAOTest {

    public HostelDAOTest() {
    }

    /**
     * Test of add method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_add_UTCID01() {
        System.out.println("add");
        Hostel hostel = null;
        HostelDAO instance = new HostelDAO();
        Exception assertThrows = assertThrows(NullPointerException.class, () -> {
            instance.add(hostel);
        });
        String expectedMessage = "null";
        String actualMessage = assertThrows.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    /**
     * Test of add method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_add_UTCID02() {
        System.out.println("add");
        Hostel hostel = new Hostel(-1, "hostelName01", "hostelAddr01", "hostelDesc01", 1000000, 12.5, (byte) 2, (byte) 1, "DT-0000", 80000000);
        HostelDAO instance = new HostelDAO();
        boolean expResult = false;
        boolean result = instance.add(hostel);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_add_UTCID03() {
        System.out.println("add");
        Hostel hostel = new Hostel((new IdGenerator()).getNewHostelId(), null, "hostelAddr01", "hostelDesc01", 1000000, 12.5, (byte) 2, (byte) 1, "DT-0000", 80000000);
        HostelDAO instance = new HostelDAO();
        boolean expResult = false;
        boolean result = instance.add(hostel);
        assertEquals(expResult, result);

    }

    @Test
    public void HostelDAO_add_UTCID04() {
        System.out.println("add");
        Hostel hostel = new Hostel(70000001, "hostelName1", "hostelAddr01", "hostelDesc01", 1000000, 12.5, (byte) 2, (byte) 1, "DT-0001", 80000000);
        HostelDAO instance = new HostelDAO();
        boolean expResult = false;
        boolean result = instance.add(hostel);
        assertEquals(expResult, result);

    }

    @Test
    public void HostelDAO_add_UTCID05() {
        System.out.println("add");
        Hostel hostel = new Hostel((new IdGenerator()).getNewHostelId(), "hostelName1", "hostelAddr01", "hostelDesc01", 1000000, 12.5, (byte) 2, (byte) 1, "DT-0001", 80000000);
        HostelDAO instance = new HostelDAO();
        boolean expResult = true;
        boolean result = instance.add(hostel);
        assertEquals(expResult, result);

    }

    @Test
    public void HostelDAO_add_UTCID06() {
        System.out.println("add");
        Hostel hostel = new Hostel((new IdGenerator()).getNewHostelId(), "hostelName1", "hostelAddr01", "hostelDesc01", 1000000, 12.5, (byte) 0, (byte) 1, "DT-0001", 80000000);
        HostelDAO instance = new HostelDAO();
        boolean expResult = false;
        boolean result = instance.add(hostel);
        assertEquals(expResult, result);

    }

    /**
     * Test of delete method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_delete_UTCID01() {
        System.out.println("delete");
        Integer id = null;
        HostelDAO instance = new HostelDAO();
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
    public void HostelDAO_delete_UTCID02() {
        System.out.println("delete");
        Integer id = -1;
        HostelDAO instance = new HostelDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of delete method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_delete_UTCID03() {
        System.out.println("delete");
        Integer id = (new IdGenerator()).getNewHostelId();
        HostelDAO instance = new HostelDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of delete method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_delete_UTCID04() {
        System.out.println("delete");
        Integer id = 70000001;
        HostelDAO instance = new HostelDAO();
        boolean expResult = true;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of update method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_update_UTCID01() {
        System.out.println("update");
        Hostel hostel = null;
        HostelDAO instance = new HostelDAO();
        Exception assertThrows = assertThrows(NullPointerException.class, () -> {
            instance.update(hostel);
        });
        String expectedMessage = "null";
        String actualMessage = assertThrows.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
    
    /**
     * Test of update method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_update_UTCID02() {
        System.out.println("update");
        HostelDAO instance = new HostelDAO();
        Hostel hostel = new Hostel();
        hostel.setHostelId(70000001);
        hostel.setHostelName("Hostel C");
        hostel.setHostelAddr("abcs");
        hostel.setHostelDesc("test update");
        hostel.setPrice(100000);
        hostel.setArea(10);
        hostel.setTotalRoom(((byte)5));
        hostel.setAvailableRoom((byte)2);
        hostel.setDistrictId("DT-0001");
        hostel.setUserId(80000001);
        boolean expResult = true;
        boolean result = instance.update(hostel);
        assertEquals(expResult, result);

    }
    /**
     * Test of update method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_update_UTCID03() {
        System.out.println("update");
        HostelDAO instance = new HostelDAO();
        Hostel hostel = new Hostel();
        hostel.setHostelId(69999999);
        hostel.setHostelName("Hostel Name Test");
        boolean expResult = false;
        boolean result = instance.update(hostel);
        assertEquals(expResult, result);

    }
    /**
     * Test of getAll method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_getAll_UTCID01() {
        System.out.println("getAll");
        HostelDAO instance = new HostelDAO();
        boolean expResult = true;
        ArrayList<Hostel> list = instance.getAll();
        assertEquals(expResult, !list.isEmpty());

    }
    /**
     * Test of getAll method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_getAll_UTCID02() {
        System.out.println("getAll");
        HostelDAO instance = new HostelDAO();
        Exception assertThrows = assertThrows(NullPointerException.class, () -> {
            instance.getAll();
        });
        String expectedMessage = "null";
        String actualMessage = assertThrows.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
    
    

    /**
     * Test of getById method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_getById_UTCID01() {
        System.out.println("getById");
        Integer id = null;
        HostelDAO instance = new HostelDAO();
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
    public void HostelDAO_getById_UTCID02() {
        System.out.println("getById");
        int id = 70000001;
        String hostelname = "Hostel B";
        HostelDAO instance = new HostelDAO();
        boolean expResult = true;
        String result = instance.getById(id).getHostelName();
        assertEquals(expResult, result.equals(hostelname));

    }
    /**
     * Test of getById method, of class HostelDAO.
     */
    @Test
    public void HostelDAO_getById_UTCID03() {
        System.out.println("getById");
        Integer id = -1;
        HostelDAO instance = new HostelDAO();
        String expResult = null;
        String result = instance.getById(id).getHostelName();
        assertEquals(expResult, result);

    }

}
