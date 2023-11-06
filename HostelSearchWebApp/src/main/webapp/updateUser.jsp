<%-- 
    Document   : updateUser
    Created on : Oct 20, 2023, 1:56:20 PM
    Author     : Trung Thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="com.fischl.models.Account" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Change Information</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!-- Additional CSS Files -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
              <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
        <!-- TEMPLATE -->
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
        <style>
            body {
                background-image: url("https://images.unsplash.com/photo-1615873968403-89e068629265?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1032&q=80 1032w");
                width: 100%;
                background-repeat: no-repeat;
                background-size: cover;
                background-position: center;
            }
            .btn-primary {
                color: #000;
                background-color: #ff9a00;
                border-color: #ff9a00;
            }
            @media screen and (min-width: 1920px) {
                .footer {
                    position: fixed;
                    left: 0;
                    bottom: 0;
                    width: 100%;
                    background-color: #f8f8f8;
                }
            }

            @media screen and (max-width: 16in) {
                .footer {
                    margin-top: 70px;
                }
            }
        </style>

    </head>

    <body>


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
            <!-- Navbar Start -->
            <jsp:include page="navbar.jsp" />
            <!-- Navbar End -->
        </header>
        <!-- ***** Header Area End ***** -->


        <div class="container-fluid vh-40" style="margin-top:150px">
            <div id="toast" style="z-index: 1;"></div>
            <div class="">
                <div class="rounded d-flex justify-content-center" style="margin-bottom: 70px;">
                    <div class="col-lg-4 col-md-6 col-sm-12 shadow-lg p-5 background-light" style="background-color: rgb(233 218 182 / 76%); border-radius: 25px; backdrop-filter: blur(3px); ">

                        <% Account u = (Account) request.getAttribute("data");%>
                        <div class="text-center">
                            <h3 class="text-primary">Cập Nhật Tài Khoản ID: <%= u.getUserId()%></h3>
                        </div>
                        <!-- FORM NEEEEE -->
                        <form id="updateUser" method="POST" action="updateUser">
                            <div class="p-4">


                                <!--<!-- FULL NAME -->
                              
                                    <input name="id" type="hidden" class="form-control" placeholder="ID" value="<%= u.getUserId()%>">
                           
                                <!--<!-- FULL NAME -->
                                <div class="row input-group mb-3">
                                    <span class="input-group-text bg-primary" style="width: 36px;"><i class="bi bi-person-plus-fill text-white"></i></span>
                                    <input name="fullname" type="text" class="form-control" placeholder="Full Name" value="<%= u.getFullName()%>">
                                </div>
                                <!--<!-- USER NAME -->
                                <div class="row input-group mb-3">
                                    <span class="col-1 input-group-text bg-primary" style="width: 36px;"><i class="bi bi-person-plus-fill text-white"></i></span>
                                    <input name="username" type="text" class="form-control" placeholder="User Name" value="<%= u.getUserName()%>">
                                </div>
                                <div class="row input-group mb-3">
                                    <span class="input-group-text bg-primary" style="width: 36px;"><i class="bi bi-key-fill text-white"></i></span>
                                    <input name="password" type="password" class="form-control" placeholder="password" value="<%= u.getPassword()%>">
                                </div>
                                <!--<!-- PHONE NAME -->
                                <div class="row input-group mb-3">
                                    <span class="input-group-text bg-primary" style="width: 36px;"><i class="bi bi-phone text-white"></i></span>
                                    <input name="phoneNumber" type="text" class="form-control" placeholder="Phone Number" value="<%= u.getPhone()%>">
                                </div>
                                <!--<!-- EMAIL NAME -->
                                <div class="row input-group mb-3">
                                    <span class="col-1 input-group-text bg-primary" style="width: 36px;"><i class="bi bi-envelope text-white"></i></span>
                                    <input name="email" type="email" class="form-control" placeholder="Email" value="<%= u.getEmail()%>">
                                </div>
                                <!-- User Type -->
                                <div class="row input-group mb-3">
                                    <span class="input-group-text bg-primary" style="width: 120px;"><i
                                            class="bi bi-discord text-white"> Quyền hạn</i></span>

                                    <!--                                     Assume u là đối tượng User được chuyển đến từ servlet hoặc controller -->
                                    <select class="form-control" name="userType">
                                        <c:choose>
                                            <c:when test="${u.getUserType() eq 'admin'}">
                                                <option value="admin" selected>admin</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="normal" selected>normal</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </div>

                            </div>


                            <button class="w-50 mx-auto btn btn-primary text-center mt-2" style="display: flex; justify-content: center;" type="submit">
                                Cập Nhật
                            </button>
                        </form>

                    </div>
                </div>
            </div>
        </div>


        <div class="footer">
            <!-- Footer Start -->
            <jsp:include page="footer.jsp"/>
            <!-- Footer End -->
        </div>




        <!-- Scripts -->
        <!-- Bootstrap core JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

        <script src="./assets/js/isotope.js"></script>
        <script src="./assets/js/owl-carousel.js"></script>
        <script src="./assets/js/tabs.js"></script>
        <script src="./assets/js/popup.js"></script>
        <script src="./assets/js/custom.js"></script>
        <script src="./assets/js/toast.js"></script>

        <script>
            if ("${requestScope.registrationStatus}" === "failure") {
                showErrorRegister();
            <%
                request.setAttribute("registrationStatus", null);
            %>
            }
        </script>
    </body>

</html>


