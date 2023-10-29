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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Trung Thanh
 */
public class AdminPageController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * 

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
        HostelDAO hosteldb = new HostelDAO();
        AccountDAO udb = new AccountDAO();
        PostDAO pdl = new PostDAO();
        
        ArrayList<Hostel> hostelsList = new ArrayList<>();
        ArrayList<Post> postsList = new ArrayList<>();
        ArrayList<Account> usersList = new ArrayList<>();
        
        hostelsList = hosteldb.getAll();
        postsList = pdl.getAll();
        usersList = udb.getAll();
        
        session.setAttribute("hostelsList", hostelsList);
        session.setAttribute("postsList",postsList);
        session.setAttribute("accList", usersList);
        
        
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null && request.getSession().getAttribute("username") == null && request.getSession().getAttribute("login") == null ) {
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
                    System.out.println("password: "+ password);
                  
                      Account u = udb.getByUsernamePassword(username, password);

                    if (u != null) {
                        session.setAttribute("username", username);
                        session.setAttribute("usertype", u.getUserType());
                        session.setAttribute("login", "true");
                        response.sendRedirect(request.getContextPath() + "/admin");
                        break;
                    } else {
                        if (request.getSession().getAttribute("username") != null) {
                            
                        session.setAttribute("username", request.getSession().getAttribute("username"));
                        request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
                        } else {
                            response.sendRedirect(request.getContextPath() + "/home");
                        }
                    }
                    break; // Exit the loop since we found the desired cookie
                }
            }
        } else {
            if (request.getSession().getAttribute("username") != null) {
               Account u = udb.getUserByUsername((String) request.getSession().getAttribute("username"));
            session.setMaxInactiveInterval(Integer.MAX_VALUE);
            session.setAttribute("username", request.getSession().getAttribute("username"));
            session.setAttribute("usertype", u.getUserType());
            request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
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
        
    }



}
