package com.fischl.controllers.HostelMaster;

import com.fischl.DAOs.HostelDAO;
import com.fischl.DAOs.PostDAO;
import com.fischl.models.Hostel;
import com.fischl.models.Post;
import com.fischl.tools.FileUploader;
import com.fischl.tools.Layout;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "ModifyHostelController", value = "/modify-hostel")
public class ModifyHostelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.startsWith("/modify-hostel")) {
            Layout layout = new Layout(request);
            layout.applyTo("modifyHostelPage.jsp");

            // Get hostel to modify
            Hostel hostel = (Hostel) request.getAttribute("hostel-to-modify");
            if (hostel == null) {
                response.sendRedirect("/hm");
                return;
            }
            request.getRequestDispatcher(layout.getPageURI()).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("modify-hostel-btn") != null && request.getParameter("modify-hostel-btn").equals("modify-hostel")) {
            // Get user
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            // Retrieve form data
            String hostelName = request.getParameter("hostel-name");
            String hostelAddress = request.getParameter("hostel-address");
            String hostelDescription = request.getParameter("hostel-description");
            String hostelPrice = request.getParameter("hostel-price");
            String hostelArea = request.getParameter("hostel-area");
            String totalRooms = request.getParameter("total-rooms");
            String availableRooms = request.getParameter("available-rooms");
            String selectedDistrict = request.getParameter("selected-district");


            // Create post object
            String hostelId = request.getParameter("hostel-to-modify");
            Hostel hostel = new HostelDAO().getById(Integer.parseInt(hostelId));
            hostel.setHostelName(hostelName);
            hostel.setHostelAddr(hostelAddress);
            hostel.setHostelDesc(hostelDescription);
            hostel.setPrice(Double.parseDouble(hostelPrice));
            hostel.setArea(Double.parseDouble(hostelArea));
            hostel.setTotalRoom(Byte.parseByte(totalRooms));
            hostel.setAvailableRoom(Byte.parseByte(availableRooms));
            hostel.setDistrictId(selectedDistrict);
;
            // Update to database
            try {
                new HostelDAO().update(hostel);
                response.sendRedirect("/hm");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}