/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.DAOs;

import com.fischl.models.Account;
import com.fischl.tools.MD5;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Trung Thanh
 */
public class AccountDAOTest {

    public AccountDAOTest() {

    }

    /**
     * Test of add method, of class AccountDAO.
     */
    @Test
    public void AccountDAO_add_UTCID01() {
        System.out.println("Execute AccountDAO_add_UTCID01");
        Account account = null;
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.add(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void AccountDAO_add_UTCID02() {
        // Mục tiêu của test case này là kiểm tra việc thêm một tài khoản hợp lệ vào cơ sở dữ liệu.

        // Hiển thị thông báo để biết test case đang được chạy
        System.out.println("Execute AccountDAO_add_UTCID02");

        // Tạo một đối tượng Account hợp lệ
           int user_id = 80000003;
        Date date_signup = Date.valueOf("2023-10-15");
        String full_name = "Nguyen Tran Trung Thanh";
        String user_name = "ThanhNTT";
        String password = "123456";
        String phone = "0939289910";
        String email = "thanhnttce170901@fpt.edu.vnn";
        String user_type = "admin";

        // Tạo một thể hiện của AccountDAO
        AccountDAO instance = new AccountDAO();

        // Thực hiện thêm tài khoản và lưu kết quả vào biến result
        boolean result = instance.add(new Account(user_id, date_signup, full_name, user_name, password, phone, email, user_type));

        // Kết quả mong đợi: việc thêm tài khoản hợp lệ sẽ trả về true
        boolean expResult = true;

        // So sánh kết quả thực tế với kết quả mong đợi
        assertEquals("Failed to add a valid account to the database", expResult, result);
    }

    @Test
    public void AccountDAO_add_UTCID03() {
        System.out.println("Execute AccountDAO_add_UTCID03");
        // Tạo một đối tượng Account không hợp lệ
          int user_id = 80000009;
        Date date_signup = Date.valueOf("2023-10-20");
        String full_name = "Trung Thanh";
        String user_name = "admin3";
        String password = "123445";
        String phone = "0987654345";
        String email = "pjkay210203@gmail.com";
        String user_type = "normal";

        Account invalidAccount = new Account(user_id, date_signup, full_name, user_name, password, phone, email, user_type);

        // Tạo một thể hiện của AccountDAO
        AccountDAO instance = new AccountDAO();

        // Thực hiện thêm tài khoản và lưu kết quả vào biến result
        boolean result = instance.add(invalidAccount);

        // Kết quả mong đợi: việc thêm tài khoản không hợp lệ sẽ trả về false
        boolean expResult = false;

        // So sánh kết quả thực tế với kết quả mong đợi
        assertEquals("Successfully added an invalid account to the database", expResult, result);
    }
    @Test
    public void AccountDAO_add_UTCID04() {
        System.out.println("Execute AccountDAO_add_UTCID04");
        // Tạo một đối tượng Account hợp lệ
        int user_id = 80000003;
        Date date_signup = Date.valueOf("2023-10-15");
        String full_name = "Nguyen Tran Trung Thanh";
        String user_name = "ThanhNTT";
        String password = "123456";
        String phone = "0939289910";
        String email = "thanhnttce170901@fpt.edu.vnn";
        String user_type = "admin";
        Account validAccount = new Account(user_id, date_signup, full_name, user_name, password, phone, email, user_type);

        // Tạo một thể hiện của AccountDAO
        AccountDAO instance = new AccountDAO();

        // Thêm tài khoản hợp lệ lần đầu
        boolean firstResult = instance.add(validAccount);

        // Kết quả mong đợi: việc thêm tài khoản hợp lệ lần đầu sẽ trả về true
        boolean expResultForFirstAddition = true;

        // So sánh kết quả thực tế với kết quả mong đợi cho lần thêm đầu tiên
        assertEquals("Failed to add a valid account for the first time", expResultForFirstAddition, firstResult);

        // Thêm tài khoản hợp lệ một lần nữa (trùng lặp)
        boolean duplicateResult = instance.add(validAccount);

        // Kết quả mong đợi: việc thêm tài khoản trùng lặp sẽ trả về false
        boolean expResultForDuplicateAddition = false;

        // So sánh kết quả thực tế với kết quả mong đợi cho lần thêm trùng lặp
        assertEquals("Successfully added a duplicate account to the database", expResultForDuplicateAddition, duplicateResult);
    }

    /**
     * Test of delete method, of class AccountDAO.
     */
    @Test
    public void AccountDAO_delete_UTCID01() {
        System.out.println("Execute AccountDAO_delete_UTCID01");
        Integer id = null;
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //ail("The test case is a prototype.");
    }

    @Test
    public void AccountDAO_delete_UTCID02() {
        System.out.println("Execute AccountDAO_delete_UTCID02");
        Integer id = 80000001; // ID của một tài khoản tồn tại trong cơ sở dữ liệu
        AccountDAO instance = new AccountDAO();
        boolean expResult = true; // Kết quả mong đợi: việc xóa tài khoản tồn tại thành công
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    @Test
    public void AccountDAO_delete_UTCID03() {
        System.out.println("Execute AccountDAO_delete_UTCID03");
        Integer id = 9999; // ID của một tài khoản không tồn tại trong cơ sở dữ liệu
        AccountDAO instance = new AccountDAO();
        boolean expResult = false; // Kết quả mong đợi: việc xóa tài khoản không tồn tại sẽ thất bại
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    @Test
    public void AccountDAO_delete_UTCID04() {
        System.out.println("Execute AccountDAO_delete_UTCID04");
        Integer id = -1; // ID âm
        AccountDAO instance = new AccountDAO();
        boolean expResult = false; // Kết quả mong đợi: việc xóa tài khoản với ID âm sẽ thất bại
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class AccountDAO.
     */
    @Test
    public void AccountDAO_update_UTCID01() {
        System.out.println("Execute AccountDAO_update_UTCID04");
        Account account = null;
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.update(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void AccountDAO_update_UTCID02() {
        System.out.println("Execute AccountDAO_update_UTCID02");
        // Tạo một đối tượng Account hợp lệ
        int user_id = 80000003;
        Date date_signup = Date.valueOf("2023-10-15");
        String full_name = "Nguyen Tran Trung Thanh";
        String user_name = "ThanhNTT";
        String password = "123456";
        String phone = "0939289910";
        String email = "thanhnttce170901@fpt.edu.vnn";
        String user_type = "admin";

        Account validAccount = new Account(user_id, date_signup, full_name, user_name, MD5.getMd5(password), phone, email, user_type);

        // Tạo một thể hiện của AccountDAO
        AccountDAO instance = new AccountDAO();

        // Thực hiện cập nhật tài khoản và kiểm tra kết quả
        boolean result = instance.update(validAccount);

        assertTrue(result); // Kết quả mong đợi là true vì tài khoản hợp lệ đã được cập nhật thành công
    }

    @Test
    public void AccountDAO_update_UTCID03() {
        System.out.println("Execute AccountDAO_update_UTCID03");
        // Tạo một đối tượng Account không tồn tại trong cơ sở dữ liệu
        int nonExistentUserId = 99999999; // Giả sử user_id này không tồn tại trong cơ sở dữ liệu
        Date nonExistentDateSignup = Date.valueOf("2023-10-20");
        String nonExistentFullName = "Non Existent User";
        String nonExistentUserName = "nonexistentuser";
        String nonExistentPassword = "password123";
        String nonExistentPhone = "1234567890";
        String nonExistentEmail = "nonexistentuser@example.com";
        String nonExistentUserType = "normal";

        Account nonExistentAccount = new Account(nonExistentUserId, nonExistentDateSignup, nonExistentFullName, nonExistentUserName, nonExistentPassword, nonExistentPhone, nonExistentEmail, nonExistentUserType);

        // Tạo một thể hiện của AccountDAO
        AccountDAO instance = new AccountDAO();

        // Thực hiện cập nhật tài khoản không tồn tại và kiểm tra kết quả
        boolean result = instance.update(nonExistentAccount);

        assertFalse(result); // Kết quả mong đợi là false vì tài khoản không tồn tại không thể được cập nhật
    }

    /**
     * Test of getAll method, of class AccountDAO.
     */
    @Test
    public void AccountDAO_getAll_UTCID01() {
        System.out.println("Execute AccountDAO_getAll_UTCID0");
        AccountDAO instance = new AccountDAO();
        ArrayList<Account> expResult = null;
        ArrayList<Account> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         fail("The test case is a prototype.");
    }

    @Test
    public void AccountDAO_getAll_UTCID02() {
        System.out.println("Execute AccountDAO_getAll_UTCID02");

        // Tạo một đối tượng Account với thông tin được cung cấp
        int user_id = 80000003;
        Date date_signup = Date.valueOf("2023-10-15");
        String full_name = "Nguyen Tran Trung Thanh";
        String user_name = "ThanhNTT";
        String password = "123456";
        String phone = "0939289910";
        String email = "thanhnttce170901@fpt.edu.vn";
        String user_type = "admin";

        Account expResult = new Account(user_id, date_signup, full_name, user_name, password, phone, email, user_type);

        // Tạo một đối tượng AccountDAO và thêm tài khoản vào cơ sở dữ liệu giả định
        AccountDAO instance = new AccountDAO();
        instance.add(expResult);

        // Gọi phương thức getAll() để lấy danh sách tài khoản từ cơ sở dữ liệu
        ArrayList<Account> result = instance.getAll();

        // Kiểm tra xem danh sách tài khoản có chứa tài khoản được tạo hay không
        assertTrue(result.contains(expResult));
    }

    @Test
    public void AccountDAO_getAll_UTCID03() {
        //testGetAllMultipleAccounts
        System.out.println("Execute AccountDAO_getAll_UTCID03");
        AccountDAO instance = new AccountDAO();
        // Tạo danh sách tài khoản để làm dữ liệu giả định
        ArrayList<Account> expResult = new ArrayList<>();

        // Tạo và thêm các tài khoản vào danh sách
        expResult.add(new Account(80000001, Date.valueOf("2023-10-01"), "John Doe", "johndoe", "password123", "123456789", "johndoe@example.com", "user"));
        expResult.add(new Account(80000002, Date.valueOf("2023-10-02"), "Alice Johnson", "alicej", "securepassword", "987654321", "alicejohnson@example.com", "user"));
        expResult.add(new Account(80000003, Date.valueOf("2023-10-03"), "Bob Smith", "bobsmith", "letmein", "111111111", "bobsmith@example.com", "admin"));

        // Thêm các tài khoản vào cơ sở dữ liệu giả định (chỉ dùng cho mục đích kiểm tra)
        instance.add(expResult.get(0));
        instance.add(expResult.get(1));
        instance.add(expResult.get(2));

        ArrayList<Account> result = instance.getAll();
        assertEquals(expResult, result); // So sánh danh sách trả về với danh sách tài khoản giả định
    }

    /**
     * Test of getById method, of class AccountDAO.
     */
    @Test
    public void AccountDAO_GgetById_UTCID01() {
        System.out.println("Execute AccountDAO_getAll_UTCID01");
        Integer id = null;
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void AccountDAO_getById_UTCID02() {
        System.out.println("Execute AccountDAO_getById_UTCID02");
        int validId = 80000003; // Giả sử id hợp lệ
        AccountDAO instance = new AccountDAO();
        int user_id = 80000003;
        Date date_signup = Date.valueOf("2023-10-15");
        String full_name = "Nguyen Tran Trung Thanh";
        String user_name = "ThanhNTT";
        String password = "123456";
        String phone = "0939289910";
        String email = "thanhnttce170901@fpt.edu.vn";
        String user_type = "admin";

        Account expResult = new Account(user_id, date_signup, full_name, user_name, password, phone, email, user_type);

        instance.add(expResult); // Thêm tài khoản vào cơ sở dữ liệu giả định
        Account result = instance.getById(validId);
        assertEquals(expResult, result); // So sánh kết quả trả về với tài khoản giả định
    }

    @Test
    public void AccountDAO_getById_UTCID03() {
        System.out.println("Execute AccountDAO_getById_UTCID03");
        int nonExistentId = 99999999; // Giả sử id không tồn tại trong cơ sở dữ liệu
        AccountDAO instance = new AccountDAO();
        Account expResult = null; // Không có tài khoản tương ứng với nonExistentId
        Account result = instance.getById(nonExistentId);
        assertEquals(expResult, result); // So sánh kết quả trả về với giá trị null
    }

    /**
     * Test of getByUsernamePassword method, of class AccountDAO.
     */
    @Test
    public void AccountDAO_getByUsernamePassword_UTCID01() {
        System.out.println("Execute AccountDAO_getByUsernamePassword_UTCID01");
        String user_name = "";
        String password = "";
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.getByUsernamePassword(user_name, MD5.getMd5(password));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void AccountDAO_getByUsernamePassword_UTCID02() {
        System.out.println("Execute AccountDAO_getByUsernamePassword_UTCID02");
        String existingUsername = "ThanhNTT";
        String existingpassword = "123456";
        AccountDAO instance = new AccountDAO();
        int user_id = 80000003;
        Date date_signup = Date.valueOf("2023-10-15");
        String full_name = "Nguyen Tran Trung Thanh";
        String user_name = "ThanhNTT";
        String password = "123456";
        String phone = "0939289910";
        String email = "thanhnttce170901@fpt.edu.vn";
        String user_type = "admin";

        Account expResult = new Account(user_id, date_signup, full_name, user_name, password, phone, email, user_type);
        // Giả sử có một tài khoản tương ứng với existingUsername và password trong cơ sở dữ liệu

        Account result = instance.getByUsernamePassword(existingUsername, MD5.getMd5(existingpassword));
        assertEquals(expResult, result); // So sánh kết quả trả về với tài khoản mong đợi
    }

    @Test
    public void AccountDAO_getByUsernamePassword_UTCID03() {
        System.out.println("Execute AccountDAO_getByUsernamePassword_UTCID03");
        String correctUsername = "ThanhNTT";
        String correctPassword = "123456";
        String incorrectPassword = "12345677";
        AccountDAO instance = new AccountDAO();
        // Giả sử có một tài khoản tương ứng với correctUsername và correctPassword trong cơ sở dữ liệu
        Account expResult = null; // Mật khẩu không chính xác
        Account result = instance.getByUsernamePassword(correctUsername, incorrectPassword);
        assertEquals(expResult, result); // So sánh kết quả trả về với giá trị null
    }

    /**
     * Test of getUserByUsername method, of class AccountDAO.
     */
    @Test
    public void AccountDAO_getUserByUsername_UTCID01() {
        System.out.println("Execute AccountDAO_getByUsername_UTCID01");
        String username = "";
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.getUserByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void AccountDAO_getByUsername_UTCID02() {
        System.out.println("Execute AccountDAO_getByUsername_UTCID02");
        String existingUsername = "ThanhNTT";
        AccountDAO instance = new AccountDAO();
        // Giả sử có một tài khoản tương ứng với existingUsername trong cơ sở dữ liệu
          int user_id = 80000003;
        Date date_signup = Date.valueOf("2023-10-15");
        String full_name = "Nguyen Tran Trung Thanh";
        String user_name = "ThanhNTT";
        String password = "123456";
        String phone = "0939289910";
        String email = "thanhnttce170901@fpt.edu.vn";
        String user_type = "admin";

        Account expResult = new Account(user_id, date_signup, full_name, user_name, password, phone, email, user_type);
        Account result = instance.getUserByUsername(existingUsername);
        assertEquals(expResult, result); // So sánh kết quả trả về với tài khoản mong đợi
    }

    @Test
    public void AccountDAO_getByUsername_UTCID03() {
        System.out.println("Execute AccountDAO_getByUsername_UTCID03");
        String specialCharactersUsername = "!@#$%^";
        AccountDAO instance = new AccountDAO();
        Account expResult = null; // Không nên có tài khoản với username chứa ký tự đặc biệt
        Account result = instance.getUserByUsername(specialCharactersUsername);
        assertEquals(expResult, result); // So sánh kết quả trả về với giá trị null
    }

}
