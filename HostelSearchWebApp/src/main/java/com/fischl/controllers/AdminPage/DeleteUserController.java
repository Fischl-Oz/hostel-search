/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fischl.controllers.AdminPage;

import com.fischl.DAOs.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
    
/**
 *
 * @author Trung Thanh
 * XONG ROI NHA
 */
public class DeleteUserController extends HttpServlet {

 

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
         String id_raw = request.getParameter("id");
       int id;
        AccountDAO udb = new AccountDAO();
        try {
               id = Integer.parseInt(id_raw);
        if (udb.delete(id)){
            request.setAttribute("deleteStatus", "success");
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            request.setAttribute("deleteStatus", "failure");
            response.sendRedirect(request.getContextPath() + "/admin");
        } 
        } catch (Exception e) {
            
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
