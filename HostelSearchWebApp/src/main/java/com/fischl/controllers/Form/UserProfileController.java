/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fischl.controllers.Form;

import com.fischl.DAOs.AccountDAO;
import com.fischl.models.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import com.fischl.tools.Layout;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static java.lang.System.out;

/**
 *
 * @author Nguyen Khoi Minh
 */
@WebServlet(name = "UserProfileController", urlPatterns = {"/profile"})
public class UserProfileController extends HttpServlet {

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
        String path = request.getRequestURI();
        if (path.endsWith("/profile")) {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            AccountDAO accDao = new AccountDAO();
            Account acc = accDao.getUserByUsername(username);
            session.setAttribute("currentAcc", acc);
            Layout layout = new Layout(request);
            layout.applyTo("userProfile.jsp");
            request.getRequestDispatcher(layout.getPageURI()).forward(request, response);
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
        if (request.getParameter("btn-submit") != null && request.getParameter("btn-submit").equals("submit-profile")) {
            Account currentAcc = (Account) request.getSession().getAttribute("currentAcc");
            String full_name = request.getParameter("full-name");
            String user_name = request.getParameter("user-name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            currentAcc.setFullName(full_name);
            currentAcc.setUserName(user_name);
            currentAcc.setEmail(email);
            currentAcc.setPhone(phone);
            AccountDAO accDao = new AccountDAO();
            Layout layout = new Layout(request);
            layout.applyTo("userProfile.jsp");
            if (accDao.update(currentAcc)) {
                layout.hasPopup(Layout.Theme.success, "Cập nhật thành công!");
                request.getRequestDispatcher(layout.getPageURI()).forward(request,response);
            } else {
                layout.hasPopup(Layout.Theme.fail, "Cập nhật thất bại!");
                request.getRequestDispatcher(layout.getPageURI()).forward(request,response);
            }
        }
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
