/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.DAOs;

import com.fischl.models.PostTag;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC1
 */
public class PostTagDAOTest {
    
    public PostTagDAOTest() {
    }

    /**
     * Test of add method, of class PostTagDAO.
     * Pass a null post tag
     */
    @Test
    public void PostTagDAOTest_add_UTCID01() {
        System.out.println("Executing PostTagDAOTest_add_UTCID01");
        PostTag ptag = null;
        PostTagDAO instance = new PostTagDAO();
        boolean expResult = false;
        boolean result = instance.add(ptag);
        //Vertif the result
        assertEquals(expResult, result);
        System.out.println("The test PostTagDAOTest_add_UTCID01 has passed");
    }

    /**
     * Test of update method, of class PostTagDAO.
     * Pass a null post tag
     */
    @Test
    public void PostTagDAOTest_update_UTCID01() {
        System.out.println("Executing PostTagDAOTest_update_UTCID01");
        PostTag ptag = null;
        PostTagDAO instance = new PostTagDAO();
        boolean expResult = false;
        boolean result = instance.update(ptag);
        //Vertify the result
        assertEquals(expResult, result);
        System.out.println("The test PostTagDAOTest_update_UTCID01 has passed");
    }

    /**
     * Test of delete method, of class PostTagDAO.
     * Pass null tadId + id integer of 0
     */
    @Test
    public void PostTagDAOTest_delete_UTCID01() {
        System.out.println("Executing PostTagDAOTest_delete_UTCID01");
        String tag_id = "";
        int post_id = 0;
        PostTagDAO instance = new PostTagDAO();
        boolean expResult = false;
        boolean result = instance.delete(tag_id, post_id);
        //Vertify the result
        assertEquals(expResult, result);
        System.out.println("The test PostTagDAOTest_delete_UTCID01 has passed");
    }

    /**
     * Test of delete method, of class PostTagDAO.
     * Pass postId integer of 0
     */
    @Test
    public void PostTagDAOTest_delete_UTCID02() {
        System.out.println("Executing PostTagDAOTest_delete_UTCID02");
        int post_id = 0;
        PostTagDAO instance = new PostTagDAO();
        boolean expResult = false;
        boolean result = instance.delete(post_id);
        //Verity the result
        assertEquals(expResult, result);
        System.out.println("The test PostTagDAOTest_delete_UTCID02 has passed");
    }

    /**
     * Test of delete method, of class PostTagDAO.
     * Pass a null String 
     */
    @Test
    public void PostTagDAOTest_delete_UTCID03() {
        System.out.println("Executing PostTagDAOTest_delete_UTCID03");
        String tag_id = "";
        PostTagDAO instance = new PostTagDAO();
        boolean expResult = false;
        boolean result = instance.delete(tag_id);
        //Verity the reult
        assertEquals(expResult, result);
        System.out.println("The test PostTagDAOTest_delete_UTCID03 has passed");
    }

    /**
     * Test of getAllTagIdByPostId method, of class PostTagDAO
     * pass an post id integer of 0 + null Potts List
     */
    @Test
    public void PostTagDAOTest_getAllTag_UTCID01() {
        System.out.println("Executing PostTagDAOTest_getAllTag_UTCID01");
        int post_id = 0;
        PostTagDAO instance = new PostTagDAO();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAllTagIdByPostId(post_id);
        //Vertofy the result
        assertEquals(expResult, result);
        System.out.println("The test PostTagDAOTest_getAllTag_UTCID01 has passed");
    }

    /**
     * Test of getAllPostIdByTagId method, of class PostTagDAO.
     * pass a null tagId + empty Post lit
     */
    @Test
    public void PostTagDAOTest_getAllostByIdByTag_UTCID01() {
        System.out.println("Executing PostTagDAOTest_getAllostByIdByTag_UTCID01");
        String tag_id = "";
        PostTagDAO instance = new PostTagDAO();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getAllPostIdByTagId(tag_id);
        //Vertify the result
        assertEquals(expResult, result);
        System.out.println("The test PostTagDAOTest_getAllostByIdByTag_UTCID01 has passed");
    }
    
}
