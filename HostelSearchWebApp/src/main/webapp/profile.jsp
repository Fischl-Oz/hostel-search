<%-- Document : profile Created on : Oct 20, 2023, 4:48:52 PM Author : Nguyen Khoi Minh --%>
<%@page import="com.fischl.DAOs.AccountDAO"%>
<%@page import="com.fischl.models.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <title>JSP Page</title>

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Import font "Be Vietnam Pro" -->
        <link rel="stylesheet" href="assets/css/fontbevietnampro.css">
        <style>
            body {
                font-family: "Be Vietnam Pro", sans-serif !important;
            }

            input {
                font-weight: 400;
                color: rgba(0, 0, 0, .6);
                max-width: 600px;
                width: 100%;
            }

            .btn {
                margin-right: 30px;
            }
        </style>
    </head>

    <body>
        <%
            Account acc = (Account) session.getAttribute("currentAcc");
        %>
        <div class="container-xxl bg-white p-0">
            <!-- Navbar Start -->
            <jsp:include page="navbar.jsp" />
            <!-- Navbar End -->
            <div class="container profile-container">
                <div class="text-center mx-auto" style="margin-top: 50px;">
                    <h3 class="display-5" id="full-name-title"><%= acc.getFullName()%></h3>
                </div>
                <div class="col-12 col-sm-12" style="margin-top: 50px; margin-bottom: 50px;">

                    <form method="post" action="profile">
                        <div class="form-group row">
                            <div class="col-md-2"></div>
                            <label class="col-md-2 col-form-label">Tên người dùng:</label>
                            <div class="col-md-8">
                                <input type="text" name="user-name" placeholder="user name" value="<%= acc.getUserName()%>" disabled/>
                            </div>
                        </div>
                        <br>
                        <div class="form-group row">
                            <div class="col-md-2"></div>
                            <label class="col-md-2 col-form-label">Ngày đăng ký:</label>
                            <div class="col-md-8">
                                <input type="date" name="date-signup" value="<%= acc.getDateSignup().toString()%>" disabled/>
                            </div>
                        </div>
                        <br>
                        <div class="form-group row">
                            <div class="col-md-2"></div>
                            <label class="col-md-2 col-form-label">Email:</label>
                            <div class="col-md-8">
                                <input type="email" name="email" placeholder="email" value="<%= acc.getEmail()%>" disabled/>
                            </div>
                        </div>
                        <br>
                        <div class="form-group row">
                            <div class="col-md-2"></div>
                            <label class="col-md-2 col-form-label">Số điện thoại:</label>
                            <div class="col-md-8">
                                <input type="text" name="phone" placeholder="phone" value="<%= acc.getPhone()%>" disabled/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8"></div>
                            <div class="col-md-4">
                                <button onclick="removeDisabled()" type="button" class="btn btn-light">Chỉnh sửa</button>
                                <button onclick="" class="btn btn-success" name="btn-submit" value="submit">Lưu</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <jsp:include page="footer.jsp" />
        </div>
        <script>
            function removeDisabled() {
                const collection = document.getElementsByTagName("input");
                for (let i = 0; i < collection.length; i++) {
                    collection[i].removeAttribute("disabled");
                }
            }
            function save() {
                const collection = document.getElementsByTagName("input");
                for (let i = 0; i < collection.length; i++) {
                    collection[i].disabled = true;
                }
            }
        </script>
    </body>
</html>