package com.fischl.controllers.Page;

import com.fischl.DAOs.HostelDAO;
import com.fischl.DAOs.PostDAO;
import com.fischl.models.Hostel;
import com.fischl.models.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PostsInfoController", value = "/postsInfo")
public class PostsInfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postID = req.getParameter("postid");
        String hostelID = req.getParameter("hostelid");
        PostDAO postDAO = new PostDAO();
        Post post = postDAO.getById(Integer.parseInt(postID));
        req.setAttribute("post", post);
        HostelDAO hostelDAO = new HostelDAO();
        Hostel hostel = hostelDAO.getById(Integer.parseInt(hostelID));
        req.setAttribute("hostel", hostel);
        req.getRequestDispatcher("postInfo.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
