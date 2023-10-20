/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fischl.controllers.AdminPage;

import com.fischl.DAOs.AccountDAO;
import com.fischl.models.Account;
import com.fischl.tools.IdGenerator;
import com.fischl.tools.MD5;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Trung Thanh
 */
public class UpdateUserServlet extends HttpServlet {

  

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
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

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
                    Account u = udb.getByUsernamePassword(username, MD5.getMd5(password));
                    if (u != null) {

                        session.setMaxInactiveInterval(Integer.MAX_VALUE);
                        session.setAttribute("username", username);
                        session.setAttribute("login", "true");
                        Account user = udb.getUserByUsername(username);
                        request.setAttribute("data", user);
                        response.sendRedirect(request.getContextPath() + "/changeInfo");
                        break;
                    } else {
                        response.sendRedirect(request.getContextPath() + "/home");
                    }
                    break; // Exit the loop since we found the desired cookie
                }
            }

        } else { 
            if (request.getSession().getAttribute("username") != null) {
                String username = (String) request.getSession().getAttribute("username");
                String id_raw = request.getParameter("id");
               int id;
                AccountDAO accDao = new AccountDAO();
               
                        id = Integer.parseInt(id_raw);
                        Account acc  = accDao.getById(id);
                        request.setAttribute("data", acc);

                    session.setMaxInactiveInterval(Integer.MAX_VALUE);
                    session.setAttribute("username", username);
                    request.getRequestDispatcher("/updateUser.jsp").forward(request, response);

               
            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
        String id_raw = request.getParameter("id");
          String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String phonenumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String usertype = request.getParameter("userType");
         int id;
         
        AccountDAO accDAO = new AccountDAO();
        long millis = System.currentTimeMillis();
        java.sql.Date date_signup = new java.sql.Date(millis);
        try {
            
        
     if (request.getSession().getAttribute("username") != null) {
            AccountDAO udb = new AccountDAO();
            HttpSession session = request.getSession();
                Account u = udb.getUserByUsername((String) request.getSession().getAttribute("username"));
                System.out.println("u == null ?  " + (u == null));
                session.setMaxInactiveInterval(Integer.MAX_VALUE);
                session.setAttribute("username", request.getSession().getAttribute("username"));
                session.setAttribute("usertype", u.getUserType());
// Thêm người dùng vào cơ sở dữ liệu (sử dụng accDAO hoặc lớp xử lý tương ứng)
     }
               id = Integer.parseInt(id_raw);
             Account accNew = new Account(id, date_signup, fullname, username, MD5.getMd5(password), phonenumber, email, usertype);
            accDAO.update(accNew);
            // Chuyển hướng người dùng đến trang quản trị
            response.sendRedirect(request.getContextPath() + "/admin");
        } catch (IOException e) {
            System.out.println("Could not send user register");
            request.setAttribute("registrationStatus", "failure");
            request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
        }

    }

}
