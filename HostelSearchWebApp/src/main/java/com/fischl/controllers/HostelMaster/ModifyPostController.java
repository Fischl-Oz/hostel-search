package com.fischl.controllers.HostelMaster;

import com.fischl.DAOs.PostDAO;
import com.fischl.models.Post;
import com.fischl.tools.FileUploader;
import com.fischl.tools.IdGenerator;
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
@WebServlet(name = "ModifyPostController", value = "/modify-post")
public class ModifyPostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.startsWith("/modify-post")) {
            Layout layout = new Layout(request);
            layout.applyTo("modifyPostPage.jsp");

            // Get post to modify
            Post post = (Post) request.getAttribute("post-to-modify");
            if (post == null) {
                response.sendRedirect("/hm?active-tab=post");
                return;
            }
            request.getRequestDispatcher(layout.getPageURI()).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("posting-btn") != null && request.getParameter("posting-btn").equals("posting")) {
            // Get user
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            // Get data from form
            int hostel_id = Integer.parseInt(request.getParameter("selected-hostel"));
            String[] tag_ids = request.getParameterValues("checked-tags"); // Nullable
            String title = request.getParameter("post-title");
            String content = request.getParameter("post-content");
            Part postImagePart = request.getPart("post-img");

            // Print data to console
            System.out.println("hostel_id: " + hostel_id);
            System.out.print("tag_ids: ");
            Arrays.stream(tag_ids).forEach(System.out::print);
            System.out.println("title: " + title);
            System.out.println("content: " + content);
            FileUploader fileUploader = new FileUploader(request);
            System.out.println(fileUploader.getFileName(postImagePart));

            // Create post object
            String postId = request.getParameter("post-to-modify");
            Post post = new PostDAO().getById(Integer.parseInt(postId));
            Date date = new Date(System.currentTimeMillis());
            post.setPostDate(new Timestamp(date.getTime()));
            post.setPostTitle(title);
            post.setPostContent(content);
            post.setPostStatus("pending");
            post.setHostelId(hostel_id);

            // Update to database
            try {
                new PostDAO().update(post);
                response.sendRedirect("/hm?active-tab=post");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}