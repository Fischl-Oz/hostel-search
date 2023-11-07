package com.fischl.controllers.HostelMaster;

import com.fischl.DAOs.HostelDAO;
import com.fischl.models.Account;
import com.fischl.models.Hostel;
import com.fischl.tools.IdGenerator;
import com.fischl.tools.Layout;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "CreateHostelController", value = "/create-hostel")
public class CreateHostelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("create-hostel-btn") != null && request.getParameter("create-hostel-btn").equals("create-hostel")) {
            // Get data from the form
            String hostelName = request.getParameter("hostel-name");
            String hostelAddress = request.getParameter("hostel-address");
            String hostelDescription = request.getParameter("hostel-description");
            int hostelPrice = Integer.parseInt(request.getParameter("hostel-price"));
            double hostelArea = Double.parseDouble(request.getParameter("hostel-area"));
            byte totalRooms = Byte.parseByte(request.getParameter("total-rooms"));
            byte availableRooms = Byte.parseByte(request.getParameter("available-rooms"));
            String hostelDistrictId = request.getParameter("hostel-district");
            Part hostelImagePart = request.getPart("hostel-img");

            // You can process the image upload using your FileUploader here

            // Print data to console
            System.out.println("hostelName: " + hostelName);
            System.out.println("hostelAddress: " + hostelAddress);
            System.out.println("hostelDescription: " + hostelDescription);
            System.out.println("hostelPrice: " + hostelPrice);
            System.out.println("hostelArea: " + hostelArea);
            System.out.println("totalRooms: " + totalRooms);
            System.out.println("availableRooms: " + availableRooms);
            System.out.println("hostelDistrictId: " + hostelDistrictId);

            // Create a Hostel object
            Hostel hostel = new Hostel();
            hostel.setHostelId(new IdGenerator().getNewHostelId());
            hostel.setHostelName(hostelName);
            hostel.setHostelAddr(hostelAddress);
            hostel.setHostelDesc(hostelDescription);
            hostel.setPrice(hostelPrice);
            hostel.setArea(hostelArea);
            hostel.setTotalRoom(totalRooms);
            hostel.setAvailableRoom(availableRooms);
            hostel.setDistrictId(hostelDistrictId);
             // Get user
            Account user = (Account) request.getSession().getAttribute("currentAcc");
            hostel.setUserId(user.getUserId());

            // Add to the database
            try {
                new HostelDAO().add(hostel);
                response.sendRedirect("/hm"); // Redirect to a success page
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}