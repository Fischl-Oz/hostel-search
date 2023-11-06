<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.text.DecimalFormat, java.text.NumberFormat, java.util.Locale" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Base64" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.fischl.models.Hostel" %>
<%@ page import="com.fischl.models.Post" %>

<%@ page import ="com.fischl.models.Account" %>
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
<style>
    .container-fluid.background-light {

        background-image: url("https://images.unsplash.com/photo-1615873968403-89e068629265?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1032&q=80 1032w");

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



</style>
<div class="container-fluid background-light" style="margin-top: 70px; margin-bottom: 40px; background-color: #fff; padding: 20px;">
	<td>
		<!-- Add action buttons for managing posts (e.g., update, delete) -->


	</td>
	<ul class="nav nav-tabs mt-5">
		<li class="nav-item">
			<a class="nav-link active" data-bs-toggle="tab" href="#posts">Post</a>
		</li>
		<li class="nav-item">
			<a class="nav-link " data-bs-toggle="tab" href="#hostel">Hostel</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" data-bs-toggle="tab" href="#users">Accounts</a>
		</li>
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
								<span class="truncated-description"></span>
								<span class="full-description" style="display: none;"></span>
								<a href="#" class="read-more-link">Read More</a>
								<a href="#" class="collapse-link" style="display: none;">Show less</a> <!-- Add the collapse-link with the initial display set to none -->
							</div>
							<%
								} else {
									out.println(description);
								}
							%>
						</td>
						<td><%= pList.getPostDate()%></td>
						<td><%= pList.getPostStatus()%></td>
						<td>
							<!-- Add action buttons for managing posts (e.g., update, delete) -->
							<button class="btn btn-primary" >Accepted</button>
							<button class="btn btn-danger" >Rejected</button>
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
				<tbody id="postsTableBody">
					<!-- Search Bar -->
					<div class="search-bar">
						<input type="text" id="userSearchQuery" placeholder="Tìm kiếm theo ID hoặc Tên chủ nhà trọ">
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
									out.println(description);
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
						<button class="btn btn-primary" onclick="addUser()">Add User</button>
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
							<button class="btn btn-primary"  onclick="updateUser(<%= u.getUserId() %>)">Update</button>
							<button class="btn btn-danger"  onclick="deleteUser(<%= u.getUserId() %>)">Delete</button>
						</td>


					</tr>
					<% }
					}
					%>
				</tbody>
			</table>

		</div>
		<%--     END TAB ACCOUNT      --%>

	</div>


</div>
<script>
    $(document).ready(function () {
        $('.dropdown').on('focusin mouseenter', function () {
            $(this).addClass('show').find('.dropdown-menu').addClass('show');
        }).on('focusout mouseleave', function () {
            $(this).removeClass('show').find('.dropdown-menu').removeClass('show');
        });

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
</script>