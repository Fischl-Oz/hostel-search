/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fischl.controllers.Form;

import com.fischl.DAOs.AccountDAO;
import com.fischl.models.Account;
import com.fischl.tools.IdGenerator;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.*;
import com.fischl.tools.MD5;

/**
 *
 * @author User
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/signup"})

public class RegisterController extends HttpServlet {

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
            out.println("<title>Servlet RegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        request.getRequestDispatcher("/register.jsp").forward(request, response);
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

//        if (request.getParameter("signinSubmit") != null && request.getParameter("signinSubmit").equals("Submit")) {
            String fullname = request.getParameter("fullname");
            String username = request.getParameter("username");
            String phonenumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String usertype = "normal";
            AccountDAO accDAO = new AccountDAO();
            long millis = System.currentTimeMillis();
            java.sql.Date date_signup = new java.sql.Date(millis);
            try {
                if (accDAO.getUserByUsername(username) == null) {
                    Account accNew = new Account(new IdGenerator().getNewUserId(), date_signup, fullname, username, MD5.getMd5(password), phonenumber, email, usertype);
                    accDAO.add(accNew);
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("login", "true");
                    response.sendRedirect(request.getContextPath() +"/home" );
                } else {
                    System.out.println("Could not send user register");
                    request.setAttribute("registrationStatus", "success");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
            } catch (IOException e) {
                System.out.println("Could not send user register");
                request.setAttribute("registrationStatus", "failure");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
//        }

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
