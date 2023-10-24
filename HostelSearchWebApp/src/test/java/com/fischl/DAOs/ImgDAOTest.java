/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.DAOs;

import com.fischl.models.Img;
import com.fischl.tools.IdGenerator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ImgDAOTest {

    public ImgDAOTest() {
    }

    /**
     * Test of add method, of class ImgDAO.
     */
    @Test
    public void ImgDAO_add_UTCID01() {
        System.out.println("add");
        Img img = null;
        ImgDAO instance = new ImgDAO();
        boolean expResult = false;
        boolean result = instance.add(img);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class ImgDAO.
     */
    @Test
    public void ImgDAO_add_UTCID02() {
        System.out.println("add");
        IdGenerator idGenerator = new IdGenerator();
        Img img = new Img(idGenerator.getNewImgId(), "datdeptrai", "nguyendat", "good", 80000000, 70000000);
        ImgDAO instance = new ImgDAO();
        boolean expResult = true;
        boolean result = instance.add(img);
        assertEquals(expResult, result);
    }

    @Test
    public void ImgDAO_add_UTCID03() {
        System.out.println("add");
        Img img = null;
        ImgDAO instance = new ImgDAO();
        boolean expResult = false;
        boolean result = instance.add(img);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class ImgDAO.
     */
    @Test
    public void ImgDAO_update_UTCID01() {
        System.out.println("update");
        Img img = null;
        ImgDAO instance = new ImgDAO();
        boolean expResult = false;
        boolean result = instance.update(img);
        assertEquals(expResult, result);
    }

    @Test
    public void ImgDAO_update_UTCID02() {
        System.out.println("update");
        IdGenerator idGenerator = new IdGenerator();
        Img img = new Img(idGenerator.getNewImgId(), "datdeptrai", "nguyendat", "good", 80000000, 70000000);
        ImgDAO instance = new ImgDAO();
        boolean expResult = false;
        boolean result = instance.update(img);
        assertEquals(expResult, result);
    }

    @Test
    public void ImgDAO_update_UTCID04() {
        System.out.println("update");
        IdGenerator idGenerator = new IdGenerator();
        Img img = new Img(idGenerator.getNewImgId(), "datdeptrai", "nguyendat", "good", 80000000, 70000000);
        ImgDAO instance = new ImgDAO();
        boolean expResult = true;
        boolean result = instance.update(img);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class ImgDAO.
     */
    @Test
    public void ImgDAO_delete_UTCID01() {
        System.out.println("delete");
        Integer id = null;
        ImgDAO instance = new ImgDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    @Test
    public void ImgDAO_delete_UTCID02() {
        System.out.println("delete");
        Integer id = 10000000;
        ImgDAO instance = new ImgDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    @Test
    public void ImgDAO_delete_UTCID03() {
        System.out.println("delete");
        Integer id = 10000000;
        ImgDAO instance = new ImgDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class ImgDAO.
     */
    @Test
    public void ImgDAO_getAll_UTCID01() {
        ImgDAO instance = new ImgDAO();
        ArrayList<Img> expResult = new ArrayList<Img>();
        ArrayList<Img> result = instance.getAll();
        assertEquals(expResult, result);
    }

    @Test
    public void ImgDAO_getAll_UTCID02() {
        ImgDAO instance = new ImgDAO();
        ArrayList<Img> expResult = null;
        ArrayList<Img> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class ImgDAO.
     */
    @Test
    public void ImgDAO_getById_UTCID01() {
        Integer img_id = 10000000;
        ImgDAO instance = new ImgDAO();
        String expResult = "dat";
        String result = instance.getById(img_id).getImgName();
        assertEquals(expResult, result);
    }

    @Test
    public void ImgDAO_getById_UTCID02() {
        Integer img_id = null;
        ImgDAO instance = new ImgDAO();
        String expResult = "dat";
        String result = instance.getById(img_id).getImgName();
        assertEquals(expResult, result);
    }

}
