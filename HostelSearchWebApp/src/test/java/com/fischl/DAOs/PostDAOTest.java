/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.DAOs;

import com.fischl.models.Post;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC1
 */
public class PostDAOTest {

    public PostDAOTest() {
    }

    /**
     * Test of add method, of class PostDAO. add a null post to class
     */
    @Test
    public void PostDAOTest_add_UTCID01() {
        System.out.println("Executing PostDAOTest_add_UTCID01");
        Post p = null;
        PostDAO instance = new PostDAO();
        Exception exc = assertThrows(NullPointerException.class, () -> {
            boolean res = instance.add(p);
        });

        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
        System.out.println("The test PostDAOTest_add_UTCID01 has passed");
    }

    /**
     * Test of add method, of class PostDAO. add a new post to class 
     */
    @Test


    public void PostDAOTest_add_UTCID02() {
        System.out.println("Executing PostDAOTest_add_UTCID02");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Post p = new Post(1, "Test", timestamp, "This is Post context..", "Open", 5, "DT-4444");
        PostDAO instance = new PostDAO();
        boolean expResult = true;
        boolean result = instance.add(p);
        //Vertify the result
        assertEquals(expResult, result);
        System.out.println("The test PostDAOTest_add_UTCID02 has passed");
    }

    /**
     * Test of add method, of class PostDAO. add an invalid post to class
     */
    @Test
    public void PostDAOTest_add_UTCID03() {
        System.out.println("Executing PostDAOTest_add_UTCID03");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Post p = new Post(4, "Test", timestamp, "This is Post context..", "Open", 5, null);
        PostDAO instance = new PostDAO();
        boolean expResult = false;
        boolean result = instance.add(p);
        //Vertify the result
        assertEquals(expResult, result);
        System.out.println("The test PostDAOTest_add_UTCID03 has passed");
    }

    /**
     * Test of add method, of class PostDAO. null connection to mysql
     */
    @Test
    public void PostDAOTest_add_UTCID04() {
        System.out.println("Executing PostDAOTest_add_UTCID04");
        Connection connection = null;
        PostDAO instance = new PostDAO();
        Post p = null;
        Exception exc = assertThrows(NullPointerException.class, () -> {
            boolean res = instance.add(p);
        });

        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
        System.out.println("The test PostDAOTest_add_UTCID04 has passed");
    }

    //--------------------------------------------------------------------------
    /**
     * Test of update method, of class PostDAO. update with a null Post
     */
    @Test
    public void PostDAOTest_update_UTCID01() {
        System.out.println("Executing PostDAOTest_update_UTCID01");
        Post p = null;
        PostDAO instance = new PostDAO();
        Exception exc = assertThrows(NullPointerException.class, () -> {
            boolean res = instance.update(p);
        });

        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
        System.out.println("The test PostDAOTest_update_UTCID01 has passed");
    }

    /**
     * Test of update method, of class PostDAO. update with existed post Unable
     * to test
     */
    @Test
    public void PostDAOTest_update_UTCID02() {
        System.out.println("Executing PostDAOTest_update_UTCID02");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Post p = new Post(1, "Test", timestamp, "This is Post context..", "Open", 5, "DT-5214");
        PostDAO instance = new PostDAO();
        boolean expResult = true;
        boolean result = instance.update(p);
        //Vertify the result
        assertEquals(expResult, result);
        System.out.println("The test PostDAOTest_update_UTCID02 has passed");
    }

    /**
     * Test of update method, of class PostDAO. update with an invalid post
     */
    @Test
    public void PostDAOTest_update_UTCID03() {
        System.out.println("Executing PostDAOTest_update_UTCID03");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Post p = new Post(4, "Test", timestamp, "This is Post context..", "Open", 5, null);
        PostDAO instance = new PostDAO();
        boolean expResult = false;
        boolean result = instance.update(p);
        //Vertify the result
        assertEquals(expResult, result);
        System.out.println("The test PostDAOTest_update_UTCID03 has passed");
    }

    /**
     * Test of update method, of class PostDAO. null sql connection
     */
    @Test
    public void PostDAOTest_update_UTCID04() {
        System.out.println("Executing PostDAOTest_update_UTCID04");
        Connection connection = null;
        PostDAO instance = new PostDAO();
        Post p = null;
        Exception exc = assertThrows(NullPointerException.class, () -> {
            boolean res = instance.update(p);
        });

        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
        System.out.println("The test PostDAOTest_update_UTCID04 has passed");
    }
    //--------------------------------------------------------------------------

    /**
     * Test of delete method, of class PostDAO. delete with a null post Id
     */
    @Test
    public void PostDAOTest_delete_UTCID01() {
        System.out.println("Executing PostDAOTest_delete_UTCID01");
        Integer id = null;
        PostDAO instance = new PostDAO();
        Exception exc = assertThrows(NullPointerException.class, () -> {
            boolean res = instance.delete(id);
        });

        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
        System.out.println("The test PostDAOTest_delete_UTCID01 has passed");
    }

    /**
     * Test of delete method, of class PostDAO. delete with existed post id
     * Unable to test
     */
    @Test
    public void PostDAOTest_delete_UTCID02() {
        System.out.println("Executing PostDAOTest_delete_UTCID02");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Post p = new Post(1, "Test", timestamp, "This is Post context..", "Open", 5, "DT-5214");
        PostDAO instance = new PostDAO();
        boolean expResult = true;
        boolean result = instance.delete(p.getPostId());
        assertEquals(expResult, result);
        System.out.println("The test PostDAOTest_delete_UTCID02 has passed");
    }

    /**
     * Test of delete method, of class PostDAO. delete with an invalid post id
     */
    @Test
    public void PostDAOTest_delete_UTCID03() {
        System.out.println("Executing PostDAOTest_delete_UTCID03");
        Integer id = 10000000;
        PostDAO instance = new PostDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        System.out.println("The test PostDAOTest_delete_UTCID03 has passed");
    }

    /**
     * Test of delete method, of class PostDAO. null sql connection
     */
    @Test
    public void PostDAOTest_delete_UTCID04() {
        System.out.println("Executing PostDAOTest_delete_UTCID04");
        Connection connection = null;
        PostDAO instance = new PostDAO();
        Exception exc = assertThrows(NullPointerException.class, () -> {
            boolean res = instance.delete(null);
        });

        String expMssg = "null";
        String actMssg = exc.getMessage();
        assertTrue(actMssg.contains(expMssg));
        System.out.println("The test PostDAOTest_delete_UTCID04 has passed");
    }

    //--------------------------------------------------------------------------
    /**
     * Test of getAll method, of class PostDAO. Get a null Post List
     */
    @Test
    public void PostDAOTest_getAll_UTCID01() {
        System.out.println("Executing PostDAOTest_getAll_UTCID01");
        PostDAO instance = new PostDAO();
        ArrayList<Post> expResult = null;
        ArrayList<Post> result = instance.getAll();
        //Vertify the result
        assertEquals(expResult, result);
        System.out.println("The test PostDAOTest_getAll_UTCID01 has passed");
    }

    /**
     * Test of getById method, of class PostDAO. Call a new instance and pass an
     * integer of null
     */
    @Test
    public void PostDAOTest_getNyId_UTCID01() {
        System.out.println("Executing PostDAOTest_getNyId_UTCID01");
        Integer id = null;
        PostDAO instance = new PostDAO();
        Post expResult = null;
        Post result = instance.getById(id);
        //Vertify the result
        assertEquals(expResult, result);
        System.out.println("The test PostDAOTest_getNyId_UTCID01 has passed");
    }

}
