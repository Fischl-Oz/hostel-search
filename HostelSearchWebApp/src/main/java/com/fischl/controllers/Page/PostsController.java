package com.fischl.controllers.Page;

import com.fischl.DAOs.PostDAO;
import com.fischl.DAOs.TagDAO;
import com.fischl.models.Post;
import com.fischl.models.Tag;
import com.fischl.tools.Layout;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PostsController", value = "/posts")
public class PostsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.endsWith("/posts")) {
            PostDAO postDAO = new PostDAO();
            List<Post> postList = postDAO.getAll();
            request.setAttribute("post-list", postList);
            TagDAO tagDAO = new TagDAO();
            List<Tag> tagList = tagDAO.getAll();
            request.setAttribute("tag-list", tagList);
            Layout layout = new Layout(request);
            layout.applyTo("postsGrid.jsp");
            request.getRequestDispatcher(layout.getPageURI()).forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}