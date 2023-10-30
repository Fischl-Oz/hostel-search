/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.DAOs;

import com.fischl.models.District;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Trung Thanh
 */
public class DistrictDAOTest {
    
    public DistrictDAOTest() {
    }
 

    /**
     * Test of add method, of class DistrictDAO.
     */
    @Test
    public void  District_add_UTCID01() {
        System.out.println("add");
        District dt = null;
        DistrictDAO instance = new DistrictDAO();
        boolean expResult = false;
        boolean result = instance.add(dt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
@Test
public void District_add_UTCID02() {
    System.out.println("addValidDistrict");
     String idDistrict = "DT-0001";
     String disName = "Ba Đình";
     String cityId = "CT-0001";
// Tạo đối tượng District hợp lệ
    District validDistrict = new District(idDistrict,disName,cityId);
    

    DistrictDAO instance = new DistrictDAO();
    boolean expResult = true; // Mong đợi việc thêm đối tượng thành công
    boolean result = instance.add(validDistrict);
    assertEquals(expResult, result);
}
@Test
public void District_add_UTCID03() {
    System.out.println("addDistrictWithEmptyName");
    District dt = new District();
    dt.setDistrictId("DT-0001");
    dt.setDistrictName(""); // district_name trống
    dt.setCityId("CT-0001");
    
    DistrictDAO instance = new DistrictDAO();
    boolean expResult = false;
    boolean result = instance.add(dt);
    assertEquals(expResult, result);
}
@Test
public void District_add_UTCID04() {
    System.out.println("addDistrictWithEmptyId");
    District dt = new District();
    dt.setDistrictId(""); // district_id trống
    dt.setDistrictName("Ba Đình");
    dt.setCityId("CT-0001");
    
    DistrictDAO instance = new DistrictDAO();
    boolean expResult = false;
    boolean result = instance.add(dt);
    assertEquals(expResult, result);
}
@Test
public void District_add_UTCID05() {
    System.out.println("addDistrictWithEmptyCityId");
    District dt = new District();
    dt.setDistrictId("DT-0001");
    dt.setDistrictName("Ba Đình");
    dt.setCityId(""); // city_id trống
    
    DistrictDAO instance = new DistrictDAO();
    boolean expResult = false;
    boolean result = instance.add(dt);
    assertEquals(expResult, result);
}
    /**
     * Test of update method, of class DistrictDAO.
     */
    @Test
    public void District_update_UTCID01() {
        System.out.println("update");
        District dt = null;
        DistrictDAO instance = new DistrictDAO();
        boolean expResult = false;
        boolean result = instance.update(dt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
@Test
public void District_update_UTCID02() {
    System.out.println("updateValidDistrict");
    District dt = new District();
      dt.setDistrictId("DT-0001"); // Thiết lập district_id của đối tượng cần cập nhật
    dt.setDistrictName("Ba Đình"); // Cập nhật district_name
      dt.setCityId("CT-0001"); // Cập nhật city_id
    
    DistrictDAO instance = new DistrictDAO();
    boolean expResult = true; // Mong đợi việc cập nhật thành công
    boolean result = instance.update(dt);
    assertEquals(expResult, result);
}
@Test
public void District_update_UTCID03() {
    System.out.println("updateInvalidDistrictId");
    District dt = new District();
    dt.setDistrictId("-1"); // district_id không hợp lệ
    dt.setDistrictName("Ba Đình");
    dt.setCityId("CT-0001");
    
    DistrictDAO instance = new DistrictDAO();
    boolean expResult = false; // Mong đợi việc cập nhật không thành công
    boolean result = instance.update(dt);
    assertEquals(expResult, result);
}
    @Test
public void District_update_UTCID04() {
    System.out.println("updateDistrictWithEmptyName");
    District dt = new District();
    dt.setDistrictId("DT-0001");
    dt.setDistrictName(""); // district_name trống
     dt.setCityId("CT-0001");
    
    DistrictDAO instance = new DistrictDAO();
    boolean expResult = false; // Mong đợi việc cập nhật không thành công
    boolean result = instance.update(dt);
    assertEquals(expResult, result);
}
    /**
     * Test of delete method, of class DistrictDAO.
     */
    @Test
    public void District_delete_UTCID01() {
        System.out.println("delete");
        String id = "";
        DistrictDAO instance = new DistrictDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

@Test
public void District_delete_UTCID02(){
    System.out.println("deleteValidId");
     
    String id = "DT-0001"; // ID hợp lệ của đối tượng cần xóa
    DistrictDAO instance = new DistrictDAO();
    boolean expResult = true; // Mong đợi việc xóa thành công
    boolean result = instance.delete(id);
    assertEquals(expResult, result);
}
@Test
public void District_delete_UTCID03() {
    System.out.println("deleteNonExistentId");
    String id = "-1"; // ID không tồn tại trong cơ sở dữ liệu
    DistrictDAO instance = new DistrictDAO();
    boolean expResult = false; // Mong đợi việc xóa không thành công
    boolean result = instance.delete(id);
    assertEquals(expResult, result);
}
@Test
public void District_delete_UTCID04(){
    System.out.println("deleteEmptyId");
    
    String id = ""; // ID trống
    DistrictDAO instance = new DistrictDAO();
    boolean expResult = false; // Mong đợi việc xóa không thành công
    boolean result = instance.delete(id);
    assertEquals(expResult, result);
}
    /**
     * Test of getAll method, of class DistrictDAO.
     */
    @Test
    public void District_getAll_UTCID01() {
        System.out.println("getAll");
        DistrictDAO instance = new DistrictDAO();
        ArrayList<District> expResult = null;
        ArrayList<District> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
@Test
public void District_getAll_UTCID02() {
    System.out.println("getAllNotEmptyList");
    DistrictDAO instance = new DistrictDAO();
    // Giả sử có ít nhất một quận trong cơ sở dữ liệu
    ArrayList<District> expResult = new ArrayList<>();
    District district1 = new District("DT-0001", "Bs Đình", "CT-0001");
    expResult.add(district1);
    ArrayList<District> result = instance.getAll();
    // Kiểm tra xem danh sách có trống không
    assertFalse(result.isEmpty());
    // Kiểm tra xem danh sách có chứa các đối tượng District mong đợi không
    assertTrue(result.contains(district1));
}
    /**
     * Test of getById method, of class DistrictDAO.
     */
    @Test
    public void District_getById_UTCID01() {
        System.out.println("getById");
        String id = "";
        DistrictDAO instance = new DistrictDAO();
        District expResult = null;
        District result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
public void District_getById_UTCID02() {
    System.out.println("getValidId");
    String id = "DT-0001"; // ID hợp lệ của đối tượng cần lấy
    DistrictDAO instance = new DistrictDAO();
    // Giả sử có một đối tượng District với ID là "1" trong cơ sở dữ liệu
    District expResult = new District("DT-0001", "Bs Đình", "CT-0001");
    District result = instance.getById(id);
    assertEquals(expResult, result);
}
@Test
public void District_getById_UTCID03() {
    System.out.println("getNonExistentId");
    String id = "1000"; // ID không tồn tại trong cơ sở dữ liệu
    DistrictDAO instance = new DistrictDAO();
    District expResult = null; // Mong đợi trả về null khi không tìm thấy đối tượng
    District result = instance.getById(id);
    assertEquals(expResult, result);
}
@Test
public void District_getById_UTCID04() {
    System.out.println("getNullId");
    String id = null; // ID là null
    DistrictDAO instance = new DistrictDAO();
    District expResult = null; // Mong đợi trả về null khi ID là null
    District result = instance.getById(id);
    assertEquals(expResult, result);
}
}
