package com.fischl.controllers.Page;

import com.fischl.DAOs.PostDAO;
import com.fischl.DAOs.TagDAO;
import com.fischl.models.Post;
import com.fischl.models.Tag;
import com.fischl.tools.Layout;
import com.fischl.tools.SearchEngine;
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
            forwardWithAllPosts(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("search-btn") != null && request.getParameter("search-btn").equals("search")) {
            // Get keywords
            String keywords = request.getParameter("keywords");

            // Get tags
            String[] tags = request.getParameterValues("tags");

            // If both keywords and tags are empty, return all posts
            if (tags == null && keywords.isEmpty()) {
                forwardWithAllPosts(request,response);
                return;
            }

            // Search
            SearchEngine searchEngine = new SearchEngine();
            searchEngine.setKeyword(keywords);
            searchEngine.setTags(tags);
            searchEngine.search();
            ArrayList<Post> results = searchEngine.getResults();

            // Set attributes
            request.setAttribute("post-list", results);
            TagDAO tagDAO = new TagDAO();
            List<Tag> tagList = tagDAO.getAll();
            request.setAttribute("tag-list", tagList);
            request.setAttribute("status", "search");
            request.setAttribute("keywords", keywords);
            request.setAttribute("tags", tags);
            Layout layout = new Layout(request);
            layout.applyTo("postsGrid.jsp");
            request.getRequestDispatcher(layout.getPageURI()).forward(request,response);
        }
    }
    private void forwardWithAllPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDAO postDAO = new PostDAO();
        List<Post> postList = postDAO.getAll();
        request.setAttribute("post-list", postList);
        TagDAO tagDAO = new TagDAO();
        List<Tag> tagList = tagDAO.getAll();
        request.setAttribute("tag-list", tagList);
        request.setAttribute("status", "all");
        Layout layout = new Layout(request);
        layout.applyTo("postsGrid.jsp");
        request.getRequestDispatcher(layout.getPageURI()).forward(request,response);
    }
}