package com.fischl.DAOs;

import com.fischl.models.Account;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class AccountDAOTest {

    @Test
    void add() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
        // arrange
        AccountDAO accDao = new AccountDAO();
        int user_id = 80000000;
        String expected_full_name = "Nguyen Khoi Minh";
        String actual;
        
        // act
        actual = accDao.getById(user_id).getFullName();
        
        // assert
        assertEquals(expected_full_name, actual);
    }
}