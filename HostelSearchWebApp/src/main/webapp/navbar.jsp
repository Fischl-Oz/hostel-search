<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="com.fischl.models.Account" %>
<%@ page import="com.fischl.DAOs.AccountDAO" %>
<%@ page import="com.fischl.models.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap" rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/template_style.css" rel="stylesheet">

<!-- Our custom Stylesheet -->
<style>
    .nav-item {
        font-weight: bold !important;
    }
    #btn-signup {
        font-weight: bold !important;
        text-transform: uppercase;
    }
</style>

<!-- Navbar Start -->
<div class="container-fluid nav-bar bg-transparent">
    <nav class="navbar navbar-expand-lg bg-white navbar-light py-0 px-4">
        <!-- logo icon nbar -->
        <a href="/" class="navbar-brand d-flex align-items-center text-center">
            <div class="icon p-2 me-2">
                <img class="img-fluid" src="./assets/images/logohss3.png" alt="Icon" style="width: 150px; height: 60px;">
            </div>
            <h1 class="m-0 text-primary"></h1>
        </a>

        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <%
            Account acc = null;
            HttpSession section = request.getSession(false);
            if (session != null) {
                acc = new AccountDAO().getUserByUsername((String) session.getAttribute("username"));
            }
        %>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto">
                <a href="/" class="nav-item nav-link active">trang chủ</a>
                <a href="about.html" class="nav-item nav-link">nhà/phòng trọ cho thuê</a>
                <%
                    User user = new User(acc);
                    if (acc != null)
                        if (user.isHostelMaster() && !user.isHostelMasterApproved()
                            || !user.isHostelMaster()) {
                %>
                <a href="/hm-register" class="nav-item nav-link">đăng ký chủ trọ</a>
                <% } %>
                <a href="about.html" class="nav-item nav-link">hướng dẫn</a>
                <%
                    if (acc == null) {
                %>
                <a href="/login" class="nav-item nav-link">đăng nhập</a>
                <%
                    }
                %>
                <%
                    if ("admin".equals(session.getAttribute("usertype"))) {
                %>
                <a href="/admin" class="nav-item nav-link">Admin</a>
                <%
                    }
                %>
            </div>
            <%
                if (acc != null) {
            %>
            <div class="nav-item dropdown">
                <a href="" class="btn btn-primary px-3 d-none d-lg-flex nav-link dropdown-toggle " data-bs-toggle="dropdown"><%= acc.getUserName()%></a>
                <div class="dropdown-menu rounded-0 m-0">
                    <a href="/profile" class="dropdown-item">Profile</a>
                    <a href="about.html" class="dropdown-item">Post Manage</a>
                    <a href="/logout" class="dropdown-item">Logout</a>

                </div>
            </div>
            <%
            } else {
            %>
            <a href="signup" class="btn btn-primary px-3 d-none d-lg-flex nav-link" id="btn-signup">đăng ký</a>
            <%
                }
            %>
        </div>
    </nav>
</div>
<!-- Navbar End -->

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>