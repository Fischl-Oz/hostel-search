<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    body {
        font-family: "Be Vietnam Pro", sans-serif;
    }
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
        <a href="" class="navbar-brand d-flex align-items-center text-center">
            <div class="icon p-2 me-2">
                <img class="img-fluid" src="./assets/images/logohss3.png" alt="Icon" style="width: 150px; height: 60px;">
            </div>
            <h1 class="m-0 text-primary"></h1>
        </a>

        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <%
            String user = null;
            HttpSession section = request.getSession(false);
            if (session != null) {
                user = (String) session.getAttribute("username");
            }
        %>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto">
                <a href="" class="nav-item nav-link active">trang chủ</a>
                <a href="about.html" class="nav-item nav-link">nhà/phòng trọ cho thuê</a>
                <a href="about.html" class="nav-item nav-link">tìm ở ghép</a>
                <a href="about.html" class="nav-item nav-link">hướng dẫn</a>
                <%
                    if (user == null) {
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
                if (user != null) {
            %>
            <div class="nav-item dropdown">
                <a href="" class="btn btn-primary px-3 d-none d-lg-flex nav-link dropdown-toggle " data-bs-toggle="dropdown" id="btn-signup"><%= user %></a>
                <div class="dropdown-menu rounded-0 m-0">
                    <a href="testimonial.html" class="dropdown-item">Profile</a>
                    <a href="404.html" class="dropdown-item">Post Manage</a>
                    <a href="index.jsp" class="dropdown-item">Logout</a>

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
