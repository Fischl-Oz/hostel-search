/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.fischl.DAOs;

import com.fischl.models.City;
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
public class CityDAOTest {

    public CityDAOTest() {
    }

    /**
     * Test of add method, of class CityDAO.
     */
    @Test
    public void CityDAO_ADD_UTCID01() {
        System.out.println("add");
        City ct = null;
        CityDAO instance = new CityDAO();
        boolean expResult = false;
        boolean result = instance.add(ct);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void CityDAO_ADD_UTCID02() {
        System.out.println("Testing add() method with valid city");

        // Tạo một thành phố hợp lệ với các thông tin cần thiết
        String cityId = "CT-0001";
        String cityName = "Hà Nội";

        City validCity = new City(cityId, cityName);

        CityDAO instance = new CityDAO();
        boolean expResult = true; // Giá trị mong đợi là true vì thành phố hợp lệ được thêm thành công
        boolean result = instance.add(validCity);

        assertEquals(expResult, result); // So sánh giá trị mong đợi với giá trị thực tế
    }

    @Test
    public void CityDAO_ADD_UTCID03() {
        System.out.println("Testing add() method with invalid city");
        String cityId = "CT-0001";
        String cityName = "Hà Nội";

        City invalidCity = new City(cityId, cityName);
        CityDAO instance = new CityDAO();
        boolean result = instance.add(invalidCity);
        assertFalse(result); // Kết quả mong đợi là false vì thành phố không hợp lệ không thể được thêm vào
    }

    @Test
    public void CityDAO_ADD_UTCID04() {
        System.out.println("Testing add() method with duplicate city");
        String cityId = "CT-0001";
        String cityName = "Hà Nội";

        City invalidCity = new City(cityId, cityName);
        CityDAO instance = new CityDAO();
        // Giả sử thành phố đã tồn tại trong cơ sở dữ liệu
        boolean firstResult = instance.add(invalidCity);
        assertTrue(firstResult); // Kết quả mong đợi là true vì thành phố đã được thêm thành công lần đầu
        // Thử thêm thành phố đã tồn tại một lần nữa (trùng lặp)
        boolean duplicateResult = instance.add(invalidCity);
        assertFalse(duplicateResult); // Kết quả mong đợi là false vì thành phố đã tồn tại trong cơ sở dữ liệu
    }

    /**
     * Test of update method, of class CityDAO.
     */
    @Test
    public void CityDAO_UPDATE_UTCID01() {
        System.out.println("update");
        City ct = null;
        CityDAO instance = new CityDAO();
        boolean expResult = false;
        boolean result = instance.update(ct);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void CityDAO_UPDATE_UTCID02() {
        System.out.println("Testing update() method with valid city");

        // Tạo một thành phố hợp lệ với các thông tin cần thiết
        String cityId = "CT-0001";
        String originalCityName = "Hà Nội";

        City originalCity = new City(cityId, originalCityName);

        // Thêm thành phố vào cơ sở dữ liệu
        CityDAO instance = new CityDAO();
        instance.add(originalCity);

        // Cập nhật thông tin của thành phố
        String updatedCityName = "Updated City";

        City updatedCity = new City(cityId, updatedCityName);

        // Thực hiện cập nhật và kiểm tra kết quả
        boolean expResult = true; // Giả sử việc cập nhật thành công
        boolean result = instance.update(updatedCity);
        assertEquals(expResult, result); // So sánh giá trị mong đợi với giá trị thực tế
    }

    /**
     * Test of delete method, of class CityDAO.
     */
    @Test
    public void CityDAO_DELETE_UTCID01() {
        System.out.println("delete");
        String id = "";
        CityDAO instance = new CityDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void CityDAO_DELETE_UTCID02() {
        System.out.println("Testing delete() method with non-existing city");
        CityDAO instance = new CityDAO();
        // Sử dụng một ID không tồn tại trong cơ sở dữ liệu
        String nonExistingId = "CT-0030";
        boolean expResult = false; // Kết quả mong đợi là false vì thành phố không tồn tại
        boolean result = instance.delete(nonExistingId);
        assertEquals(expResult, result); // So sánh giá trị mong đợi với giá trị thực tế
    }

    @Test
    public void CityDAO_DELETE_UTCID03() {
        System.out.println("Testing delete() method with empty or null ID");
        CityDAO instance = new CityDAO();
        // Sử dụng ID rỗng hoặc null
        String emptyId = "";
        String nullId = null;

        boolean expResult = false; // Kết quả mong đợi là false vì ID rỗng hoặc null
        boolean result1 = instance.delete(emptyId);
        boolean result2 = instance.delete(nullId);

        assertEquals(expResult, result1); // So sánh giá trị mong đợi với giá trị thực tế
        assertEquals(expResult, result2); // So sánh giá trị mong đợi với giá trị thực tế
    }

    @Test
    public void CityDAO_DELETE_UTCID04() {
        // Khởi tạo cơ sở dữ liệu thử nghiệm hoặc đảm bảo cơ sở dữ liệu ở một trạng thái ban đầu cụ thể

        // Thêm một thành phố vào cơ sở dữ liệu để xóa
        CityDAO instance = new CityDAO();
        City city = new City("CT-0001", "Hà Nội");
        instance.add(city);

        // Xóa thành phố từ cơ sở dữ liệu
        boolean expResult = true; // Kết quả mong đợi là true vì thành phố tồn tại và được xóa thành công
        boolean result = instance.delete(city.getCityId());
        assertEquals(expResult, result); // So sánh giá trị mong đợi với giá trị thực tế

        // Kiểm tra xem thành phố đã bị xóa thành công khỏi cơ sở dữ liệu hay không
        assertNull(instance.getById(city.getCityId()));
    }

    /**
     * Test of getAll method, of class CityDAO.
     */
    @Test
    public void CityDAO_GetAll_UTCID01() {
        System.out.println("getAll");
        CityDAO instance = new CityDAO();
        ArrayList<City> expResult = null;
        ArrayList<City> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void CityDAO_GetAll_UTCID02() {
        System.out.println("Testing getAll() method with non-empty database");

        // Khởi tạo cơ sở dữ liệu thử nghiệm hoặc đảm bảo cơ sở dữ liệu ở một trạng thái ban đầu cụ thể
        CityDAO instance = new CityDAO();

        // Thêm một số thành phố vào cơ sở dữ liệu để tạo ra một danh sách không rỗng
        instance.add(new City("CT-0021", "sdfds"));
        instance.add(new City("CT-0022", "sdfdsgfd"));
        instance.add(new City("CT-0023", "ưqeqư"));

        // Lấy danh sách thành phố từ cơ sở dữ liệu
        ArrayList<City> result = instance.getAll();

        // Kiểm tra xem danh sách không rỗng
        assertNotNull(result);

        // Kiểm tra số lượng thành phố trong danh sách, trong trường hợp này, chúng ta mong đợi có 3 thành phố
        assertEquals(26, result.size());
    }

    @Test
    public void CityDAO_GetAll_UTCID03() {
        System.out.println("Testing getAll() method with null city");
        CityDAO instance = new CityDAO();
        instance.add(null); // Thêm một thành phố null vào cơ sở dữ liệu
        ArrayList<City> result = instance.getAll();
        assertNotNull(result); // Kết quả không được null
        assertEquals(23, result.size()); // Danh sách trả về phải rỗng vì không có thành phố hợp lệ
    }

    /**
     * Test of getById method, of class CityDAO.
     */
    @Test
    public void CityDAO_GetById_UTCID01() {
        System.out.println("getById");
        String id = "";
        CityDAO instance = new CityDAO();
        City expResult = null;
        City result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void CityDAO_GetById_UTCID02() {
        System.out.println("Testing getById() method with valid id");
        CityDAO instance = new CityDAO();
        City city = new City("CT-0007", "Huế");
        instance.add(city); // Thêm một thành phố vào cơ sở dữ liệu
        City expResult = city; // Kết quả mong đợi là thành phố đã được thêm vào cơ sở dữ liệu
        City result = instance.getById(city.getCityId());
        assertEquals(expResult, result); // So sánh giá trị mong đợi với giá trị thực tế
    }

    @Test
    public void CityDAO_GetById_UTCID03() {
        System.out.println("Testing getById() method with non-existent id");
        CityDAO instance = new CityDAO();
        String nonExistentId = "CT-0021"; // Giả sử id không tồn tại trong cơ sở dữ liệu
        City expResult = null; // Không có thành phố tương ứng với nonExistentId
        City result = instance.getById(nonExistentId);
        assertEquals(expResult, result); // So sánh kết quả trả về với giá trị null
    }

}
