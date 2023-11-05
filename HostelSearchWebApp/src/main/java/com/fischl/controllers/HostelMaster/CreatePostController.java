package com.fischl.controllers.HostelMaster;

import com.fischl.DAOs.PostDAO;
import com.fischl.models.Post;
import com.fischl.tools.FileUploader;
import com.fischl.tools.IdGenerator;
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
@WebServlet(name = "CreatePostController", value = "/create-post")
public class CreatePostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            Post post = new Post();
            post.setPostId(new IdGenerator().getNewPostId());
            Date date = new Date(System.currentTimeMillis());
            post.setPostDate(new Timestamp(date.getTime()));
            post.setPostTitle(title);
            post.setPostContent(content);
            post.setPostStatus("pending");
            post.setHostelId(hostel_id);

            // Add to database
            try {
                new PostDAO().add(post);
                response.sendRedirect("/hm?active-tab=post");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}