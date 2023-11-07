package com.fischl.controllers.HostelMaster;

import com.fischl.DAOs.AccountDAO;
import com.fischl.DAOs.HostelDAO;
import com.fischl.DAOs.PostDAO;
import com.fischl.tools.Layout;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HostelMasterController", value = "/hm")
public class HostelMasterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.startsWith("/hm")) {
            // Handle modify hostel
            String hostelId = request.getParameter("modify-hostel");
            if (hostelId != null) {
                request.setAttribute("hostel-to-modify", new HostelDAO().getById(Integer.parseInt(hostelId)));
                request.getRequestDispatcher("/modify-hostel").forward(request, response);
                return;
            }

            // Handle modify post
            String postId = request.getParameter("modify-post");
            if (postId != null) {
                request.setAttribute("post-to-modify", new PostDAO().getById(Integer.parseInt(postId)));
                request.getRequestDispatcher("/modify-post").forward(request, response);
                return;
            }
            Layout layout = new Layout(request);
            layout.applyTo("HostelMasterMainPage.jsp");

            // Pick active tab
            String activeTab = request.getParameter("active-tab");
            if (activeTab != null) {
                request.getSession().setAttribute("active-tab", activeTab);
            } else {
                request.getSession().setAttribute("active-tab", "");
            }

            // Handle delete hostel
            String delH = request.getParameter("delH");
            if (delH != null) {
                // delete all posts of hostel
                new PostDAO().deleteByHostelId(Integer.parseInt(delH));

                // delete hostel
                new HostelDAO().delete(Integer.parseInt(delH));
            }

            // Handle delete post
            String delP = request.getParameter("delP");
            if (delP != null) {
                new PostDAO().delete(Integer.parseInt(delP));
            }

            request.getRequestDispatcher(layout.getPageURI()).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}