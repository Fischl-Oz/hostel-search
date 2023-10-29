//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.fischl.controllers.User;

import com.fischl.DAOs.AccountDAO;
import com.fischl.models.Account;
import com.fischl.tools.MD5;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

public class ChangeInfoController extends HttpServlet {
    public ChangeInfoController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDAO udb = new AccountDAO();
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        if (cookies != null && request.getSession().getAttribute("username") == null && request.getSession().getAttribute("login") == null) {
            Cookie[] var16 = cookies;
            int var17 = cookies.length;

            for(int var8 = 0; var8 < var17; ++var8) {
                Cookie cookie = var16[var8];
                if (cookie.getName().equals("accountt")) {
                    String accountCookieValue = cookie.getValue();
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
                    } else {
                        response.sendRedirect(request.getContextPath() + "/home");
                    }
                    break;
                }
            }
        } else if (request.getSession().getAttribute("username") != null) {
            String username = (String)request.getSession().getAttribute("username");
            Account user = udb.getUserByUsername(username);
            request.setAttribute("data", user);
            session.setMaxInactiveInterval(Integer.MAX_VALUE);
            session.setAttribute("username", username);
            request.getRequestDispatcher("/changeInfo.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String phonenumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("usertype");
        AccountDAO accDAO = new AccountDAO();
        long millis = System.currentTimeMillis();
        Date date_signup = new Date(millis);

        try {
            if (accDAO.getUserByUsername(username) != null) {
                String oldUsername = (String)request.getSession().getAttribute("username");
                int id = accDAO.getUserByUsername(oldUsername).getUserId();
                if (!oldUsername.equals(username)) {
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        Cookie[] var16 = cookies;
                        int var17 = cookies.length;

                        for(int var18 = 0; var18 < var17; ++var18) {
                            Cookie cookie = var16[var18];
                            if (cookie.getName().equals("account")) {
                                cookie.setMaxAge(0);
                                cookie.setPath("/");
                                response.addCookie(cookie);
                                break;
                            }
                        }
                    }
                }

                if (null == userType) {
                    userType = "user";
                } else {
                    switch (userType) {
                        case "admin":
                            userType = "admin";
                            break;
                        case "user":
                            userType = "user";
                            break;
                        default:
                            userType = "user";
                    }
                }

                Account accNew = new Account(id, date_signup, fullname, username, password, phonenumber, email, userType);
                accDAO.update(accNew);
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("login", "true");
                response.sendRedirect(request.getContextPath() + "/admin");
            } else {
                System.out.println("Could not send user register");
                request.setAttribute("changeInfoStatus", "failure");
                request.getRequestDispatcher("/changeInfo.jsp").forward(request, response);
            }
        } catch (IOException var20) {
            System.out.println("Could not send user register");
            request.setAttribute("changeInfoStatus", "failure");
            request.getRequestDispatcher("/changeInfo.jsp").forward(request, response);
        }

    }
}