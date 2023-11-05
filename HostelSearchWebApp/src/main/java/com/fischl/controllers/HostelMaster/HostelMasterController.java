package com.fischl.controllers.HostelMaster;

import com.fischl.DAOs.AccountDAO;
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

            // Handle delete post
            String del = request.getParameter("del");
            if (del != null) {
                new PostDAO().delete(Integer.parseInt(del));
            }

            request.getRequestDispatcher(layout.getPageURI()).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}