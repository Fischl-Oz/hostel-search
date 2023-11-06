<%-- 
    Document   : addUser
    Created on : Oct 19, 2023, 11:33:45 PM
    Author     : Trung Thanh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thêm Tài Khoản</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
              integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!-- Additional CSS Files -->
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
            <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
        <!--<!-- fdsfds -->

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

            @media screen and (min-width: 1920px) {
                .footer {
                    position: fixed;
                    left: 0;
                    bottom: 0;
                    width: 100%;
                }
            }

            @media screen and (max-width: 16in) {
                .footer {
                    margin-top: 70px;
                }
            }

            .text-primary {
                color: #aa5e2e !important;
            }

            .bg-primary {
                background-color: #aa5e2e !important;
            }

            .btn-primary {
                color: #fff;
                background-color: #aa5e2e;
                border-color: #0d6efd;
            }


            element.style {
                background-color: rgb(233 218 182 / 76%);
                border-radius: 25px;
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

        <!-- Navbar Start -->
        <jsp:include page="navbar.jsp" />
        <!-- Navbar End -->

             <div class="container-fluid vh-40" style="margin-top:70px; padding: 40px;">
                    <div id="toast" style="z-index: 1;"></div>
                    <div class="">
                        <div class="rounded d-flex justify-content-center">
                            <div class="col-lg-4 col-md-6 col-sm-12 background-light"
                                 style="background-color: rgb(233 218 182 / 76%); border-radius: 25px; backdrop-filter: blur(3px); ">
                                <div class="text-center" style="margin-top: 20px;">
                                    <h3 style="margin-top:30px; color: #aa5e2e; padding: 20px; padding-bottom: 20px;">
                                        Thêm Tài Khoản</h3>
                                </div>
                                <form id="adduserform" method="post" action="addUser">
                                    <div style="padding: 20px 70px;">
                                        <div class="row input-group mb-3">
                                            <div id="username-error" class="text-danger"></div>
                                            <span class="input-group-text bg-primary" style="width: 35px;"><i
                                                    class="bi bi-person-plus-fill text-white"></i></span>
                                            <input id="fullname" name="fullname" type="text" class="form-control"
                                                   placeholder="Nhập tên đầy đủ">
                                        </div>
                                        <div class="row input-group mb-3">
                                            <span class="col-1 input-group-text bg-primary" style="width: 35px;"><i
                                                    class="bi bi-person-plus-fill text-white"></i></span>
                                            <input id="username" name="username" type="text" class="form-control"
                                                   placeholder="Nhập tên tài khoản">
                                        </div>
                                        <div class="row input-group mb-3">
                                            <span class="input-group-text bg-primary" style="width: 35px;"><i
                                                    class="bi bi-phone text-white"></i></span>
                                            <input id="phoneNumber" name="phoneNumber" type="text" class="form-control"
                                                   placeholder="Nhập số điện thoại">
                                        </div>
                                        <div class="row input-group mb-3">
                                            <span class="col-1 input-group-text bg-primary" style="width: 35px;"><i
                                                    class="bi bi-envelope text-white"></i></span>
                                            <input id="email" name="email" type="email" class="form-control"
                                                   placeholder="Nhập Email">
                                        </div>
                                        <div class="row input-group mb-3">
                                            <span class="input-group-text bg-primary" style="width: 35px;"><i
                                                    class="bi bi-key-fill text-white"></i></span>
                                            <input id="password" name="password" type="password" class="form-control"
                                                   placeholder="Nhập mật khẩu">
                                        </div>
        
                                        <div class="row input-group mb-3">
                                            <label for="userType" class="form-label" style="color:black">Quyền Hạn Truy Cập</label>
                                            <div class="input-group" id="usertype-error">
                                                <span class="input-group-text bg-primary text-white"><i class="bi bi-discord"></i></span>
                                                <select class="form-select" id="userType" name="userType">
                                                    <option value="none" selected>none</option>  Giá trị mặc định là "none" và được chọn sẵn 
                                                    <option value="admin">admin</option>
                                                    <option value="normal">normal</option>
                                                </select>
                                            </div>
                                        </div>
        
        
                                        <div class="d-flex justify-content-between">
                                            <a href="/admin" class=" text-center mt-2 float-left mr-2"
                                               style="text-decoration: none; color: black;">
                                                Quay Lại
                                            </a>
                                            <button class="w-50 btn btn-primary text-center mt-2 float-right"
                                                    type="submit" value="Submit" name="btnSubmit">
                                                Thêm Tài Khoản
                                            </button>
                                        </div>
        
        
                                    </div>                       
                                </form>
        
                            </div>
                        </div>
                    </div>
                </div>
        <!-- Footer Start -->
        <jsp:include page="footer.jsp"/>
        <!-- Footer End -->


        <!-- Scripts -->
        <!-- Bootstrap core JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <!--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>-->
        <!--<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>-->

        <script src="./vendor/jquery/jquery.min.js"></script>
        <script src="./vendor/jquery/jquery.validate.min.js"></script>

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

            $(document).ready(function () {
                $('#adduserform').validate({
                    rules: {
                        // Define validation rules for your form fields
                        fullname: {
                            required: true, // Field is required
                            minlength: 5, // Minimum length of 5 characters
                            maxlength: 100 // Minimum length of 5 characters
                        },
                        username: {
                            required: true, // Field is required
                            minlength: 5, // Minimum length of 5 characters
                            maxlength: 50
                        },
                        phoneNumber: {
                            required: true, // Field is required
                            number: true,
                            maxlength: 10
                        },
                        email: {
                            required: true, // Field is required
                            email: true,
                            maxlength: 100
                        },
                        password: {
                            required: true, // Field is required
                            minlength: 6, // Minimum length of 5 characters
                            maxlength: 50
                        },
                        cfpassword: {
                            required: true, // Field is required
                            equalTo: "#password"
                        },
                        userType: {
                            required: true,
                            customUserRole: true
                        }
                        // Add more fields and rules as needed
                    },
                    messages: {
                        // Define error messages for your form fields
                        fullname: {
                            required: 'Please enter a value for this field',
                            minlength: 'Minimum length is 6 characters',
                            maxlength: 'Maximum length is 100 characters'
                        },
                        username: {
                            required: 'Please enter a value for this field',
                            minlength: 'Minimum length is 6 characters',
                            maxlength: 'Maximum length is 50 characters'
                        },
                        phoneNumber: {
                            required: 'Please enter a value for this field',
                            number: 'Please enter a valid number',
                            maxlength: 'Maximum length is 10 characters'
                        },
                        email: {
                            required: 'Please enter a value for this field',
                            email: 'Please enter a valid email',
                            maxlength: 'Maximum length is 100 characters'
                        },
                        password: {
                            required: 'Please enter a value for this field',
                            minlength: 'Minimum length is 6 characters',
                            maxlength: 'Maximum length is 50 characters'
                        },
                        cfpassword: {
                            required: 'Please enter a value for this field',
                            equalTo: 'Must equal to password'
                        },
                        userType: {
                            required: 'Please select a user type',
                            customUserRole: 'Please select either "admin" or "normal"'
                        }
                        // Add more fields and messages as needed
                    }
                });
                $.validator.addMethod("customUserRole", function (value, element) {
                    return this.optional(element) || /^(admin|normal)$/i.test(value);
                }, "Please select either 'admin' or 'normal'");
            });
            // Sử dụng jQuery để chờ đến khi trang đã tải hoàn toàn
            $(document).ready(function () {
                // Lắng nghe sự kiện khi người dùng nhập `username`
                $('#username').on('input', function () {
                    // Lấy giá trị `username` từ trường nhập liệu
                    var username = $(this).val();
                    // Kiểm tra `username` chỉ khi nó có ít nhất 3 ký tự
                    if (username.length >= 3) {
                        // Gửi yêu cầu Ajax đến máy chủ để kiểm tra `username`
                        $.ajax({
                            type: 'POST',
                            url: 'AddUserServlet', // Đường dẫn đến servlet hoặc API kiểm tra `username`
                            data: {username: username},
                            success: function (response) {
                                // Xử lý phản hồi từ máy chủ
                                if (response === 'true') {
                                    // `username` đã tồn tại trong cơ sở dữ liệu
                                    $('#username-error').text('Tài khoản đã tồn tại trong hệ thống!.');
                                } else {
                                    // `username` là duy nhất
                                    $('#username-error').text('');
                                }
                            }
                        });
                    } else {
                        // Nếu `username` có ít hơn 3 ký tự, không kiểm tra
                        $('#username-error').text('');
                    }
                });

            });
      </script>
    </body>

</html>
