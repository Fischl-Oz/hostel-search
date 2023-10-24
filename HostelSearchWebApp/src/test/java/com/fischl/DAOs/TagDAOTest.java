/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.DAOs;

import com.fischl.models.Tag;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TagDAOTest {

    public TagDAOTest() {
    }

    /**
     * Test of add method, of class TagDAO.
     */
    @Test
    public void TagDAO_add_UTCID01() {
        System.out.println("add");
        Tag t = null;
        TagDAO instance = new TagDAO();
        boolean expResult = false;
        boolean result = instance.add(t);
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_add_UTCID02() {
        System.out.println("add");
        Tag t = new Tag("TAG-003", "JAVA");
        TagDAO instance = new TagDAO();
        boolean expResult = false;
        boolean result = instance.add(t);
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_add_UTCID03() {
        System.out.println("add");
        Tag t = new Tag("TAG-003", "JAVA");
        TagDAO instance = new TagDAO();
        boolean expResult = true;
        boolean result = instance.add(t);
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_add_UTCID04() {
        System.out.println("add");
        Tag t = null;
        TagDAO instance = new TagDAO();
        boolean expResult = false;
        boolean result = instance.add(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class TagDAO.
     */
    @Test
    public void TagDAO_update_UTCID01() {
        System.out.println("update");
        Tag t = new Tag("TAG-001", "JAVA");
        TagDAO instance = new TagDAO();
        boolean expResult = true;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_update_UTCID02() {
        System.out.println("update");
        Tag t = null;
        TagDAO instance = new TagDAO();
        boolean expResult = false;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_update_UTCID03() {
        System.out.println("update");
        Tag t = new Tag("TAG-001", "JAVA");
        TagDAO instance = new TagDAO();
        boolean expResult = false;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_update_UTCID04() {
        System.out.println("update");
        Tag t = null;
        TagDAO instance = new TagDAO();
        boolean expResult = false;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class TagDAO.
     */
    @Test
    public void TagDAO_delete_UTCID01() {
        System.out.println("delete");
        String id = "TAG-001";
        TagDAO instance = new TagDAO();
        boolean expResult = true;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_delete_UTCID02() {
        System.out.println("delete");
        String id = null;
        TagDAO instance = new TagDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_delete_UTCID03() {
        System.out.println("delete");
        String id = "TAG-001";
        TagDAO instance = new TagDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_delete_UTCID04() {
        System.out.println("delete");
        String id = null;
        TagDAO instance = new TagDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class TagDAO.
     */
    @Test
    public void TagDAO_getAll_UTCID01() {
        TagDAO instance = new TagDAO();
        ArrayList<Tag> expResult = new ArrayList<Tag>();
        ArrayList<Tag> result = instance.getAll();
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_getAll_UTCID02() {
        TagDAO instance = new TagDAO();
        ArrayList<Tag> expResult = null;
        ArrayList<Tag> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class TagDAO.
     */
    @Test
    public void TagDAO_getByID_UCTID01() {
        System.out.println("getById");
        String id = "TAG-002";
        TagDAO instance = new TagDAO();
        String expResult = "TAG-002";
        String result = instance.getById(id).getTagId();
        assertEquals(expResult, result);
    }

    @Test
    public void TagDAO_getByID_UCTID02() {
        System.out.println("getById");
        String id = "";
        TagDAO instance = new TagDAO();
        String expResult = "";
        String result = instance.getById(id).getTagId();
        assertEquals(expResult, result);
    }
}
