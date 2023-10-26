<%-- 
    Document   : postDetail
    Created on : Jul 16, 2023, 7:36:09 PM
    Author     : Quoc Anh
--%>

<%@page import="com.fischl.tools.IdGenerator"%>
<%@page import="com.fischl.models.Hostel"%>
<%@page import="com.fischl.models.Account"%>
<%@page import="com.fischl.models.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.text.DecimalFormat, java.text.NumberFormat, java.util.Locale" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Base64" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
            rel="stylesheet">
        <title>Information</title>
        <!-- Bootstrap core CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">


        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

        <style>
            .modal {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.7);
                display: flex;
                justify-content: center;
                align-items: center;
                z-index: 9999;
            }

            .modal-image {
                max-width: 90%;
                max-height: 90%;
            }
        </style>


    </head>

    <body >

        <%!
            public String inputStreamToBase64(InputStream inputStream) throws IOException {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                return Base64.getEncoder().encodeToString(imageBytes);
            }

            public String formatCurrency(double price) {
                NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
                DecimalFormat decimalFormat = (DecimalFormat) formatter;
                decimalFormat.applyPattern("#,### VNĐ");
                return decimalFormat.format(price);
            }
        %>

        <!-- ***** Preloader Start ***** -->
        <div id="js-preloader" class="js-preloader">
            <div class="preloader-inner">
                <span class="dot"></span>
                <div class="dots">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </div>
        </div>
        <!-- ***** Preloader End ***** -->

        <!-- ***** Header Area Start ***** -->
        <header class="header-area">
            <nav class="container main-nav">
                <!-- ***** Logo Start ***** -->
                <a href="./home" class="logo">
                    <!--<img src="../src/java/imgs/logo2.jpg" alt="">-->
                    <img style="object-fit: contain;" src="./assets/images/logo3.png" alt="">
                </a>
                <!-- ***** Logo End ***** -->

                <%
                    String user = null;
                    HttpSession section = request.getSession(false);
                    if (session != null) {
                        user = (String) session.getAttribute("username");
                    }
                %>

                <!-- ***** Menu Start ***** -->
                <ul class="nav" style="align-items: center;">
                    <li class="effect"><a href="./home" class="active">Home</a></li>
                    <li class="effect"><a href="./rental">Rental</a></li>
                    <li class="effect"><a href="./instruction">Instruction</a></li>
                    <li class="effect"><a href="./register">Register</a></li>
                    <li class="effect"><a href="./login">Login</a></li>
                </ul>

                <a class='menu-trigger'>
                    <span>Menu</span>
                </a>
                <!-- ***** Menu End ***** -->
            </nav>
        </header>
        <!-- ***** Header Area End ***** -->
        <%
            Hostel hostePost = new Hostel(70000026, "hostelName1", "hostelAddr01", "hostelDesc01", 1000000, 12.5, (byte) 2, (byte) 1, "DT-0001", 80000000);
//                    (Hostel) request.getAttribute("hostel"); 
            long millis = System.currentTimeMillis();
            java.sql.Date date_signup = new java.sql.Date(millis);
            Account userOfPost = new Account(new IdGenerator().getNewUserId(), date_signup, "dat", "nguyendat", "1511", "0793989857", "nguyendat1511@gmail.com", "User");
//                    (Account) request.getAttribute("userOfPost"); 
        %>
        <!-- ***** BODY Area Start ***** -->
        <div class="container" style="background-color: #eee; padding: 20px; margin-top: 70px;">
            <div class="row">
                <div class="col-lg-12">
                    <img style="height: 70vh; object-fit: cover; border-radius: 10px; cursor: pointer;" src="<%= hostePost.getDistrictId()%>" alt="Post Image" class="img-fluid" onclick="showFullImage(this)">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-lg-12"> 
                    <h2 class="text-primary"><%= hostePost.getHostelName()%></h2>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-lg-12">
                    <p><%= hostePost.getHostelDesc()%></p>
                </div>
            </div>

            <%
                if ("admin".equals(session.getAttribute("usertype"))) {

            %>
            <div class="row button-group">
                <button class="btn btn-primary" onclick="updatePost(<%= hostePost.getHostelId()%>)">Update</button>
                <button class="btn btn-danger" onclick="deletePost(<%= hostePost.getHostelId()%>)">Delete</button>
            </div>
            <%
                }
            %>
            <div class="row mt-3">
                <div class="col-lg-6">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th scope="row">Address</th>
                                <td><%= hostePost.getHostelAddr()%></td>
                            </tr>
                            <tr>
                                <th scope="row">Price</th>
                                <td><%= hostePost.getPrice()%> /1 Tháng</td>
                            </tr>
                            <tr>
                                <th scope="row">Area</th>
                                <td><%= hostePost.getArea()%></td>
                            </tr>
                            <tr>
                                <th scope="row">Number of Rooms</th>
                                <td><%= hostePost.getTotalRoom()%></td>
                            </tr>
                            <tr>
                                <th scope="row">Available Rooms</th>
                                <td><%= hostePost.getAvailableRoom()%></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-6">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th scope="row">Name</th>
                                <td><%= userOfPost.getFullName()%></td>
                            </tr>
                            <tr>
                                <th scope="row">Phone Number</th>
                                <td><%= userOfPost.getPhone()%></td>
                            </tr>
                            <tr>
                                <th scope="row">Email</th>
                                <td><%= userOfPost.getEmail()%></td>
                            </tr>
                            <tr>
                                <th scope="row">Date</th>
                                <td><%= hostePost.getPrice()%></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-lg-12">
                    <h4 class="text-primary mb-4">Contact the Host</h4>
                    <ul class="list-unstyled contact-options" style="display: flex; justify-content: space-around;">
                        <li>
                            <i class="bi bi-envelope"></i>
                            <a href="mailto:<%= userOfPost.getEmail()%>" class="contact-link">Contact via Email</a>
                        </li>
                        <li>
                            <i class="bi bi-telephone"></i>
                            <a href="tel:<%= userOfPost.getPhone()%>" class="contact-link">Contact via Phone</a>
                        </li>
                    </ul>
                </div>
            </div>


        </div>

        <!-- ***** BODY Area End ***** -->
        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-4 right-logo">
                                <a href="index.html"><img style="object-fit: contain;" src="assets/images/logo3.png"
                                                          alt="" class="footer-logo" /></a>
                            </div>

                            <div class="col-lg-4 center-info">
                                <h2>Kết nối với chúng tôi</h2>
                                <ul>
                                    <li>Hotline: <a href="tel:0987654321">098.765.4321</a></li>

                                    <li>Email: <a href="mailto:group1@gmail.com"
                                                  target="_blank">group1@gmail.com</a></li>
                                    <li class="social">
                                        <a href="https://www.facebook.com/" target="_blank">
                                            <i class="bi bi-facebook" style="color: #ffffff; font-size: 20px;"></i>
                                        </a>
                                        <a href="https://www.youtube.com/" target="_blank">
                                            <i class="bi bi-youtube" style="color: #ffffff; font-size: 20px;"></i>
                                        </a>
                                        <a href="https://www.instagram.com" target="_blank">
                                            <i class="bi bi-instagram" style="color: #ffffff; font-size: 20px;"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>

                            <div class="col-lg-4 left-contact">
                                <p>Copyright © 2023 <a href="#">Group 1</a> Company. <br>All rights reserved.</p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>


        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAVUwRXJYeKMiRdG6zZ1GQFiSGuWGOgU"></script>

        <!-- Scripts -->
        <!-- Bootstrap core JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>



        <script src="assets/js/isotope.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/tabs.js"></script>
        <script src="assets/js/popup.js"></script>
        <script src="assets/js/custom.js"></script>

        <script>
                    function updatePost(postId) {
                        // Perform the necessary logic to update the post
                        // For example, you can redirect to an update page with the post ID
                        window.location.href = "updatePost?id=" + postId;
                    }

                    function deletePost(postId) {
                        // Perform the necessary logic to update the post
                        // For example, you can redirect to an update page with the post ID
                        window.location.href = "deletePost?id=" + postId;
                    }
        </script>
        <script>
            function showFullImage(imageElement) {
                var imageUrl = imageElement.getAttribute('src');

                // Create a modal/lightbox element
                var modal = document.createElement('div');
                modal.classList.add('modal');

                // Create an image element inside the modal
                var modalImage = document.createElement('img');
                modalImage.classList.add('modal-image');
                modalImage.setAttribute('src', imageUrl);

                // Append the modal image to the modal
                modal.appendChild(modalImage);

                // Append the modal to the document body
                document.body.appendChild(modal);

                // Add a click event listener to the modal to close it when clicked
                modal.addEventListener('click', function () {
                    modal.remove();
                });
            }
        </script>
    </body>
</html>
