/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fischl.controllers.Page;

import com.fischl.DAOs.AccountDAO;
import com.fischl.DAOs.HostelDAO;
import com.fischl.DAOs.PostDAO;
import com.fischl.models.Account;
import com.fischl.models.Hostel;
import com.fischl.models.Post;
import com.fischl.tools.LoginValidator;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author User
 */
@WebServlet(name = "PostDetailServlet", urlPatterns = {"/postDetail"})
public class PostDetailServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostDetailServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO udb = new AccountDAO();
        HostelDAO hostelDAO = new HostelDAO();
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        String id_raw = request.getParameter("id");
        int id = Integer.parseInt("70000000");
        Hostel hostel = hostelDAO.getById(70000000);
//        Account user = udb.getUserById(post.getUserID());
//        ArrayList<Post> nearPost = new ArrayList<>();
//        nearPost = pdb.getListPostByCityAndPriceHaveLimit(post.getCityID(), "all", 5, post.getPostID());

//        session.setAttribute("nearPost", nearPost);
        request.setAttribute("hostel", hostel);
//        request.setAttribute("userOfPost", user);

        if (cookies != null && request.getSession().getAttribute("username") == null && request.getSession().getAttribute("login") == null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("accountt")) {
                    // Read the value of the "account" cookie
                    String accountCookieValue = cookie.getValue();

                    // Process the cookie value as needed
                    // For example, split the value into username and password
                    String[] accountInfo = accountCookieValue.split(":");
                    String username = accountInfo[0];
                    String password = accountInfo[1];
                    System.out.println("username: " + username);
                    System.out.println("password: " + password);
                    LoginValidator loginV = new LoginValidator();
                    Account login_acc = loginV.checkAccount(username, password);
                    if (login_acc != null) {

                        session.setMaxInactiveInterval(Integer.MAX_VALUE);
                        session.setAttribute("username", username);
                        session.setAttribute("usertype", login_acc.getUserType());
                        session.setAttribute("login", "true");
                        request.getRequestDispatcher("/postDetail.jsp").forward(request, response);
                        break;
                    } else {
                        request.getRequestDispatcher("/postDetailNormal.jsp").forward(request, response);
                    }
                    break; // Exit the loop since we found the desired cookie
                }
            }
        } else {
            if (request.getSession().getAttribute("username") != null) {

                String username = (String) request.getSession().getAttribute("username");
                Account acc = udb.getUserByUsername(username);
                session.setMaxInactiveInterval(Integer.MAX_VALUE);
                session.setAttribute("username", username);
                session.setAttribute("usertype", acc.getUserType());
                request.getRequestDispatcher("/postDetail.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/postDetailNormal.jsp").forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
