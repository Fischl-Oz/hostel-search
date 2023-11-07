
<%-- 
    Document   : admin
    Created on : Jul 8, 2023, 2:53:29 AM
    Author     : Trung Thanh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.text.DecimalFormat, java.text.NumberFormat, java.util.Locale" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Base64" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.fischl.models.Hostel" %>
<%@ page import="com.fischl.models.Post" %>

<%@ page import ="com.fischl.models.Account" %>
<%@ page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">
        <title>Admin</title>
        <!-- Bootstrap core CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <!-- Additional CSS Files -->
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
<%--        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>--%>
        <style>
            /*            .container-fluid.background-light {
            
                            background-image: url("https://images.unsplash.com/photo-1615873968403-89e068629265?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1032&q=80 1032w");
            
                            background-repeat: no-repeat;
                            background-size: cover;
                            background-position: center;
                        }*/


            @media screen and (max-width: 16in) {
                .footer {
                    margin-top: 70px;
                }
                height: 100vh;
            }
            .tab-content .nav-link {
                color: #ff0000; /* Thay #ff0000 bằng mã màu hoặc tên màu bạn muốn sử dụng */
            }

            /* Đổi màu khi hover vào tab */
            .tab-content .nav-link:hover {
                color: #00ff00; /* Thay #00ff00 bằng mã màu hoặc tên màu bạn muốn sử dụng khi hover vào tab */
            }
            /* Đổi màu nền của bảng */
            .tab-content table {
                background-color: rgba(245, 247, 201, 0.94); /* Đặt màu trong suốt với alpha = 0.5 */
            }
            .text-center.text-primary{
                background-color:rgba(245, 247, 201, 0.94);
                color: #eda536!important;
            }
            .nav-link {
                color: #eda536!important;
            }
            .nav-link.dropdown-toggle{
                color: #ffffff!important;
            }
            .nav.nav-tabs.mt-5{
                background-color:rgba(242, 242, 242, 0.94);
            }


            /* Đổi màu chữ của các ô bảng */
            .tab-content table th{
                color: #eda536!important;
            }
            .tab-content table td {
                color: #333; /* Thay #333 bằng mã màu hoặc tên màu bạn muốn sử dụng cho chữ trong ô bảng */
            }

            /* CSS */
            .pagination a.page-link {
                color: #007bff; /* Màu chữ cho các liên kết */
                text-decoration: none; /* Loại bỏ gạch chân */
                transition: color 0.3s ease; /* Hiệu ứng màu chữ thay đổi trong 0.3 giây */
            }

            .pagination a.page-link:hover {
                color: #0056b3; /* Màu chữ khi di chuột qua liên kết */
            }

            .pagination a.page-link.active {
                font-weight: bold; /* In đậm chữ khi liên kết được chọn */
                color: black; /* Màu chữ khi liên kết được chọn */
                background-color: #f0eec0; /* Màu nền khi liên kết được chọn */
            }

        </style>
    </head>

    <body>

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

            <!-- Navbar Start -->
            <jsp:include page="navbar.jsp" />
            <!-- Navbar End -->


        </header>
        <!-- ***** Header Area End ***** -->


        <div class="container-fluid background-light" style="margin-top: 70px; margin-bottom: 40px; background-color: #fff; padding: 20px;">

            <ul class="nav nav-tabs mt-5">
                <li class="nav-item">
                    <a class="nav-link" data-bs-toggle="tab" href="#posts">Bài đăng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " data-bs-toggle="tab" href="#hostel">Chủ trọ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " data-bs-toggle="tab" href="#users">Tài khoản</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link " data-bs-toggle="tab" href="#chartjs">Biểu đồ</a>--%>
<%--                </li>--%>
            </ul>
            <%--        TAB POST      --%>
            <div class="tab-content mt-3">
                <div class="tab-pane fade show active" id="posts">
                    <h2 class="text-center text-primary">Post Detail</h2>
                    <!-- Table for displaying list of posts -->

                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Post ID</th>
                                <th>Post Title</th>
                                <th>Post Content</th>
                                <th>Post Date</th>
                                <th>Post Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody id="postsTableBody">
                            <!-- Search Bar -->
                        <div class="search-bar">
                            <input type="text" id="postSearchQuery" placeholder="Tìm kiếm theo ID hoặc Tiêu đề">
                            <button type="button" onclick="searchHostel()"><i class="bi bi-search"></i></button>
                        </div>

                        <%-- Iterate over the list of posts and display the information --%>
                        <% 
                          ArrayList<Post> postsList = (ArrayList<Post>) session.getAttribute("postsList");
                          if (postsList != null) {
                               for (Post pList : postsList) { 
                        %>
                        <tr>
                            <td><%= pList.getPostId()%></td>
                            <td><%= pList.getPostTitle()%></td>
                            <td>
                                <% 
                                    String description = pList.getPostContent();
                                    int maxLength = 50; // Maximum length of the description

                                    if (description.length() > maxLength) {
                                        String truncatedDescription = description.substring(0, maxLength) + "...";
                                        String fullDescription = description;
                                %>
                                <div class="item-description"> <!-- Add the item-description class here -->
                                    <span class="truncated-description"><%= truncatedDescription %></span>
                                    <span class="full-description" style="display: none;"><%= fullDescription %></span>
                                    <a href="#" class="read-more-link">Read More</a>
                                    <a href="#" class="collapse-link" style="display: none;">Show less</a> <!-- Add the collapse-link with the initial display set to none -->
                                </div>
                                <%
                                            } else {
                                                System.out.println(description);
                                            }
                                %>
                            </td>
                            <td><%= pList.getPostDate()%></td>
                            <td style="<%= pList.getPostStatus().equals("accepted")? "Color: green" : "" %>"><%= pList.getPostStatus()%></td>
                            <td>
                                <!-- Add action buttons for managing posts (e.g., update, delete) -->
                                <button class="btn btn-primary" <%= (pList.getPostStatus().equals("accepted") || pList.getPostStatus().equals("rejected")? "disabled" : "") %>>Accepted</button>
                                <button class="btn btn-danger" <%= (pList.getPostStatus().equals("accepted") || pList.getPostStatus().equals("rejected")? "disabled" : "") %>>Rejected</button>
                            </td>
                        </tr>
                        <% }
                            } %>
                        </tbody>
                    </table>
                    <%--      END  TAB POST      --%>
                    <%--        TAB HOSTEL      --%>
                </div>
                <div class="tab-pane fade " id="hostel">
                    <h2 class="text-center text-primary">Hostel Detail</h2>
                    <!-- Table for displaying list of posts -->
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Hostel ID</th>
                                <th>Hostel Name</th>
                                <th>Description</th>
                                <th>Address</th>
                                <th>Price</th>
                                <th>Area</th>
                                <th>Total Room</th>
                                <th>A-Room</th>
                                <!--                                <button class="btn btn-danger" onclick="addHostel()">Add Hostel</button>
                                                                <th>Actions</th>-->
                            </tr>

                        </thead>
                        <tbody id="hostelTableBody">
                            <!-- Search Bar -->
                        <div class="search-bar">
                            <input type="text" id="hostelSearchQuery" placeholder="Tìm kiếm theo ID hoặc Tên chủ nhà trọ">
                            <button type="button" onclick="searchHostel()"><i class="bi bi-search"></i></button>
                        </div>

                        <%-- Iterate over the list of posts and display the information --%>
                        <% 
                           ArrayList<Hostel> hostelsList = (ArrayList<Hostel>) session.getAttribute("hostelsList");
                           if (hostelsList != null) {
                                for (Hostel hostel : hostelsList) { 
                        %>
                        <tr>
                            <td><%= hostel.getHostelId()%></td>
                            <td><%= hostel.getHostelName()%></td>
                            <td>
                                <% 
                                    String description = hostel.getHostelDesc();
                                    int maxLength = 50; // Maximum length of the description

                                    if (description.length() > maxLength) {
                                        String truncatedDescription = description.substring(0, maxLength) + "...";
                                        String fullDescription = description;
                                %>
                                <div class="item-description"> <!-- Add the item-description class here -->
                                    <span class="truncated-description"><%= truncatedDescription %></span>
                                    <span class="full-description" style="display: none;"><%= fullDescription %></span>
                                    <a href="#" class="read-more-link">Read More</a>
                                    <a href="#" class="collapse-link" style="display: none;">Show less</a> <!-- Add the collapse-link with the initial display set to none -->
                                </div>
                                <%
                                       } else {
                                           System.out.println(description);
                                       }
                                %>
                            </td>
                            <td><%= hostel.getHostelAddr()%></td>

                            <td><%= hostel.getPrice()%></td>
                            <td><%= hostel.getArea()%></td>
                            <td><%= hostel.getTotalRoom()%></td>
                            <td><%= hostel.getAvailableRoom()%></td>

                            <!-- 
                              <td>
                                  
                                   <button class="btn btn-primary" onclick="updateHostel(<%= hostel.getHostelId() %>)">Update</button>
                                   <button class="btn btn-danger" onclick="deleteHostel()(<%= hostel.getHostelId() %>)">Delete</button>
                              </td> 
                            -->
                        </tr>
                        <% }
                            } %>
                        </tbody>
                    </table>
                    <%--       END TAB HOSTEL      --%>
                    <%--        TAB ACCOUNT      --%>

                </div>
                <div class="tab-pane fade" id="users">
                    <h2 class="text-center text-primary">Accounts</h2>
                    <!-- Table for displaying list of users -->
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>User ID</th>
                                <th>Sign Up Date</th>
                                <th>Full name</th>
                                <th>Username</th>
                                <th>Email</th>
                                <th>Phone Number</th>
                                <th>User Type</th>
                        <button class="btn btn-primary" onclick="addUser()" ><i class="fas fa-plus"></i></button>
                        <th>Action</th>
                        </tr>
                        </thead>
                        <tbody id="usersTableBody">
                        <div class="search-bar">
                            <input type="text" id="userSearchQuery" placeholder="Tìm kiếm theo ID hoặc Tên người dùng">
                            <button type="button" onclick="searchUsers()"><i class="bi bi-search"></i></button>
                        </div>
                        <%-- Iterate over the list of users and display the information --%>
                        <% ArrayList<Account> accList = (ArrayList<Account>) session.getAttribute("accList");
                           if (accList != null) {
                                for (Account u : accList) { 
                        %> 
                        <tr>
                            <td><%= u.getUserId()%></td>
                            <td><%= u.getDateSignup()%></td>
                            <td><%= u.getFullName()%></td>
                            <td><%= u.getUserName()%></td>
                            <td><%= u.getEmail()%></td>
                            <td><%= u.getPhone()%></td>
                            <td><%= u.getUserType()%></td>

                            <td>
                                <!-- Add action buttons for managing posts (e.g., update, delete) -->
                                <button class="btn btn-primary"  onclick="updateUser(<%= u.getUserId() %>)"> <i class="fas fa-edit"></i></button>
                                <button class="btn btn-danger"  onclick="deleteUser(<%= u.getUserId() %>)"><i class="fas fa-trash-alt"></i></button>
                            </td>


                        </tr>
                        <% }
                                 }
                        %>
                        </tbody>
                    </table>



                    <!-- Cách sử dụng giá trị endPage trong trang JSP -->
                    <div class="pagination">
                        <% 
                            int endPage = (int)request.getAttribute("endPage");
                            int tag = (int)request.getAttribute("tag");
                            // Lấy giá trị của endPage từ attribute
                            for (int i = 1; i <= endPage; i++) { 
                        %>
                        <a class="page-link <%= i == tag ? "active" : "" %>" href="admin?index=<%= i %>"><%= i %></a>
                        <% } %>
                    </div>

                </div>
                <%--     END TAB ACCOUNT      --%>
<%--                <div class="tab-pane fade" id="chartjs">--%>
<%--                    <h2 class="text-center text-primary">Số lượng bài đăng hàng tháng</h2>--%>
<%--                    <!-- Table for displaying list of users -->--%>
<%--                    <canvas id="myChart" class="charrt" width="100" height="100"></canvas>--%>


<%--                </div>--%>
            </div>


        </div>   





        <!-- Scripts -->
        <!-- Bootstrap core JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>;
        <script src="assets/js/isotope.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/tabs.js"></script>
        <script src="assets/js/popup.js"></script>
        <script src="assets/js/custom.js"></script>
        <script src="assets/js/admin.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
        <script>
                                    $(document).ready(function () {
                                        // $('.dropdown').on('focusin mouseenter', function () {
                                        //     $(this).addClass('show').find('.dropdown-menu').addClass('show');
                                        // }).on('focusout mouseleave', function () {
                                        //     $(this).removeClass('show').find('.dropdown-menu').removeClass('show');
                                        // });

                                        $(document).on("click", ".read-more-link", function (e) {
                                            e.preventDefault();
                                            var container = $(this).closest('.item-description');
                                            container.find(".truncated-description").hide();
                                            container.find(".full-description").show();
                                            $(this).hide(); // Hide the "Read More" link
                                            container.find(".collapse-link").show(); // Show the "Tóm gọn" link
                                        });

                                        $(document).on("click", ".collapse-link", function (e) {
                                            e.preventDefault();
                                            var container = $(this).closest('.item-description');
                                            container.find(".full-description").hide();
                                            container.find(".truncated-description").show();
                                            $(this).hide(); // Hide the "Tóm gọn" link
                                            container.find(".read-more-link").show(); // Show the "Read More" link
                                        });
                                    });

                                    // var tabs = document.querySelectorAll('.nav-link');
                                    // tabs.forEach(function (tab) {
                                    //     tab.addEventListener('click', function (event) {
                                    //         var tabId = event.target.getAttribute('href').substring(1);
                                    //         localStorage.setItem('activeTab', tabId);
                                    //     });
                                    // });

                                    var tabs = document.querySelectorAll('.nav-link');

                                    tabs.forEach(function (tab) {
                                        tab.addEventListener('click', function (event) {
                                            // Lấy ID của tab được click
                                            var tabId = event.target.getAttribute('href').substring(1);

                                            // Lưu tab hiện tại vào localStorage
                                            localStorage.setItem('activeTab', tabId);

                                            // Xóa lớp 'active' khỏi tất cả các tab
                                            tabs.forEach(function (t) {
                                                t.classList.remove('active');
                                            });

                                            // Thêm lớp 'active' cho tab được click
                                            event.target.classList.add('active');
                                        });
                                    });


                                    // Đặt tab active dựa trên giá trị trong localStorage
                                    var activeTabId = localStorage.getItem('activeTab');
                                    if (activeTabId) {
                                        var activeTab = document.querySelector('.nav-link[href="#' + activeTabId + '"]');
                                        if (activeTab) {
                                            activeTab.classList.add('active');
                                        }
                                    }


                                    // // JavaScript
                                    // document.addEventListener('DOMContentLoaded', function () {
                                    //     var activeTabId = localStorage.getItem('activeTab');
                                    //     if (activeTabId) {
                                    //         // Nếu có trạng thái tab được lưu, hiển thị tab đó khi trang được tải lại
                                    //         var activeTab = document.querySelector('.nav-link[href="#' + activeTabId + '"]');
                                    //         if (activeTab) {
                                    //             activeTab.click(); // Kích hoạt sự kiện click trên tab được lưu
                                    //         }
                                    //     }
                                    // });

                                    function deleteUser(userId) {
                                        Swal.fire({
                                            title: 'Bạn có chắc chắn muốn xóa người dùng này không?',
                                            icon: 'warning',
                                            showCancelButton: true,
                                            confirmButtonColor: '#d33',
                                            cancelButtonColor: '#3085d6',
                                            confirmButtonText: 'Xóa',
                                            cancelButtonText: 'Hủy bỏ'
                                        }).then((result) => {
                                            if (result.isConfirmed) {
                                                window.location.href = 'deleteUser?id=' + userId;
                                            }
                                        });
                                    }
//CHART
                                    // Lấy thẻ canvas bằng ID
//                                     var ctx = document.getElementById('myChart').getContext('2d');
//
// // Dữ liệu cho biểu đồ (ví dụ: số liệu của biểu đồ đường)
//                                     var data = {
//                                         labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
//                                         datasets: [{
//                                                 label: 'Bài đăng hàng tháng',
//                                                 data: [12, 19, 3, 5, 2, 5, 2, 6, 7, 4, 8, 3, 7, 11, 15], // Dữ liệu số liệu của bạn ở đây
//                                                 backgroundColor: 'rgba(75, 192, 192, 0.2)', // Màu nền của biểu đồ
//                                                 borderColor: 'rgba(75, 192, 192, 1)', // Màu đường viền của biểu đồ
//                                                 borderWidth: 1 // Độ đậm của đường viền
//                                             }]
//                                     };
//
// // Tạo một biểu đồ đường
//                                     var myChart = new Chart(ctx, {
//                                         type: 'bar', // Loại biểu đồ (ở đây là biểu đồ đường)
//                                         data: data, // Dữ liệu cho biểu đồ
//                                         options: {
//                                             scales: {
//                                                 y: {
//                                                     beginAtZero: true // Hiển thị trục y bắt đầu từ giá trị 0
//                                                 }
//                                             }
//                                         }
//                                     });
        </script>

    </body>

</html>
