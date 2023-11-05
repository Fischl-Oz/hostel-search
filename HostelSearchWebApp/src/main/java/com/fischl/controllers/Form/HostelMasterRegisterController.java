package com.fischl.controllers.Form;

import com.fischl.DAOs.AccountDAO;
import com.fischl.DAOs.HostelMasterDAO;
import com.fischl.models.Account;
import com.fischl.models.HostelMaster;
import com.fischl.tools.FileUploader;
import com.fischl.tools.Layout;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "HostelMasterRegisterController", value = "/hm-register")
public class HostelMasterRegisterController extends HttpServlet {
    public static final String SAVE_DIRECTORY = "uploadImages";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.endsWith("/hm-register") && request.getSession().getAttribute("login").equals("true")) {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            AccountDAO accDao = new AccountDAO();
            Account acc = accDao.getUserByUsername(username);
            session.setAttribute("currentAcc", acc);
            Layout layout = new Layout(request);
            layout.applyTo("hostelMasterRegistration.jsp");
            request.getRequestDispatcher(layout.getPageURI()).forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("dangky-btn") != null && request.getParameter("dangky-btn").equals("dang-ky")) {

            // Get data from form
            String full_name = request.getParameter("full_name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Handle file uploads
            Part frontIdCardPart = request.getPart("front_id_card_image");
            Part backIdCardPart = request.getPart("back_id_card_image");
            Part businessCertificatePart = request.getPart("business_certificate_image");

            // Store the uploaded files in the specified folder
            FileUploader fileUploader = new FileUploader(request);
            fileUploader.setUploadDirectory(SAVE_DIRECTORY);
            fileUploader.appendToFileName(username);
            fileUploader.setFileName("front_id_card_image");
            String frontIdCardPath = fileUploader.saveFile(frontIdCardPart);
            fileUploader.setFileName("back_id_card_image");
            String backIdCardPath = fileUploader.saveFile(backIdCardPart);
            fileUploader.setFileName("business_certificate_image");
            String businessCertificatePath = fileUploader.saveFile(businessCertificatePart);

            // Get origin account in db, then update data
            Account acc = new AccountDAO().getUserByUsername(username);
            acc.setFullName(full_name);
            acc.setEmail(email);
            acc.setPhone(phone);
            acc.setPassword(password);
            acc.setUserType("hostelmaster");

            // Create new HostelMaster
            HostelMaster hm = new HostelMaster(acc.getUserId(), address, frontIdCardPath, backIdCardPath, businessCertificatePath, "pending");

            try {
                // Update account to db
                new AccountDAO().update(acc);
                // Add hostel master to db
                new HostelMasterDAO().add(hm);

                // Reset current account on request
                request.setAttribute("currentAcc", acc);

                // Forward to current page with success message
                response.sendRedirect(request.getContextPath() + "/");
            } catch (Exception e) {
                e.printStackTrace();
                // Apply layout
                Layout layout = new Layout(request);
                layout.applyTo("hostelMasterRegistration.jsp");
                layout.hasPopup(Layout.Theme.fail,"Đăng ký thất bại, vui lòng thử lại");
                // Forward to current page with error message
                request.getRequestDispatcher(layout.getPageURI()).forward(request,response);
            }

            //print out data to console
            System.out.println("HostelMasterRegisterController.doPost");
            System.out.println("full_name: " + full_name);
            System.out.println("email: " + email);
            System.out.println("phone: " + phone);
            System.out.println("address: " + address);
            System.out.println("username: " + username);
            System.out.println("password: " + password);
        }
    }


}