<%@ page import="com.fischl.tools.DatabaseContext" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fischl.models.Hostel" %>
<%@ page import="com.fischl.models.Account" %>
<%@ page import="com.fischl.models.Post" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	#hostel-master-main {
		padding-top: 50px;
		min-height: 800px;
	}
	#main-title {
		display: flex;
		color: #fff;
		text-transform: uppercase;
		align-items: center;
		height: 100%;
	}
	.card-details * {
        overflow: hidden;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2; /* start showing ellipsis when 2rd line is reached */
        white-space: pre-wrap; /* let the text wrap preserving spaces */
        max-height: 3rem;
		margin: 0;
	}
	.card-details span {
		font-weight: bold;
		width: fit-content;
	}
    .card-details h5 {
		margin-bottom: 1em;
	}
	.card-btns {
		margin: 0;
		padding: 5px;
	}
	.card-btns a {
		width: 100%;
	}
</style>
<%
	DatabaseContext db = new DatabaseContext();
	Account acc = (Account) session.getAttribute("currentAcc");
    String activeTab = (String) request.getSession().getAttribute("active-tab");
%>
<section id="hostel-master-main">

	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<a class="navbar-brand mx-auto" id="main-title" href="#">Dashboard Chủ Trọ</a>
	</nav>

	<!-- Tabs -->
	<%
	    if (activeTab == null)
			activeTab = "";
	%>
	<ul class="nav nav-tabs" id="myTabs" role="tablist">
		<li class="nav-item">
			<a class="nav-link <%= (!activeTab.equals("")? "" : "active") %>" id="manageHostels-tab" data-toggle="tab" href="#manageHostels" role="tab" aria-controls="manageHostels" aria-selected="<%= (!activeTab.equals("")? "false" : "true") %>">Quản lý trọ</a>
		</li>
		<li class="nav-item">
			<a class="nav-link <%= (activeTab.equals("post"))? "active" : "" %>" id="managePosts-tab" data-toggle="tab" href="#managePosts" role="tab" aria-controls="managePosts" aria-selected="<%= (activeTab.equals("post"))? "true" : "false" %>">Quản lý post</a>
		</li>
		<li class="nav-item">
			<a class="nav-link <%= (activeTab.equals("reg"))? "active" : "" %>" id="manageRegistrations-tab" data-toggle="tab" href="#manageRegistrations" role="tab" aria-controls="manageRegistrations" aria-selected="<%= (activeTab.equals("reg"))? "true" : "false" %>">Quản lý đăng ký</a>
		</li>
	</ul>

	<!-- Tab Content -->
	<div class="tab-content" id="myTabContent">
		<!-- Quản lý trọ -->
		<%
			ArrayList<Hostel> hostels = db.Hostels.Where(h -> h.getUserId() == acc.getUserId());
		%>
		<div class="tab-pane fade show active" id="manageHostels" role="tabpanel" aria-labelledby="manageHostels-tab">
			<div class="row">
				<div class="col-md-8"></div>
				<div class="col-md-4" style="text-align: right;"><a href="#" class="btn btn-success" style="padding: 10px; margin-right: 30px; margin-top: 20px; margin-bottom: 10px;"><i class="fas fa-plus"></i> Thêm Trọ Mới</a></div>
			</div>
			<div class="container mt-4">
				<!-- Add hostel cards and CRUD buttons here -->
				<div class="row">
					<%
						if (!hostels.isEmpty())
							for (Hostel hostel : hostels) {
					%>
					<div class="col-md-4" style="margin-bottom: 20px; height: fit-content;">
						<div class="card mb-4">
							<div class="row card-body">
								<!-- Hostel details -->
								<div class="col-md-8 card-details" style="height: 200px;">
									<h5 class="card-title"><%= hostel.getHostelName() %></h5>
									<p class="card-text"><span>Địa chỉ:</span> <%= hostel.getHostelAddr() %></p>
									<p class="card-text"><span>Mô tả:</span> <%= hostel.getHostelDesc() %></p>
									<p class="card-text"><span>Giá cả:</span> <%= hostel.getPrice() %> VNĐ/Tháng</p>
								</div>
								<div class="col-md-4 mt-2">
									<img src="https://via.placeholder.com/300" alt="Hostel Image" class="card-img" style="max-width: 100%; max-height: 100%;">
								</div>
							</div>
							<!-- CRUD buttons -->
							<div class="row card-btns">
								<div class="col-md-4">
									<a href="#" class="btn btn-primary">Sửa</a>
								</div>
								<div class="col-md-4">
									<a href="#" class="btn btn-danger">Xóa</a>
								</div>
								<div class="col-md-4">
									<a href="" class="btn btn-primary btn-success">Chi tiết</a>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>


		<!-- Quản lý post -->
		<%
		    ArrayList<Post> posts = db.Posts.Where(p -> db.Hostels.FirstOrDefault(h -> h.getHostelId() == p.getHostelId()).getUserId() == acc.getUserId());
		%>
		<div class="tab-pane fade" id="managePosts" role="tabpanel" aria-labelledby="managePosts-tab">
			<div class="row">
				<div class="col-md-8"></div>
				<!-- Button to trigger the modal -->
				<div class="col-md-4" style="text-align: right;">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createPostModal" style="padding: 10px; margin-right: 30px; margin-top: 20px; margin-bottom: 10px;">
						<i class="fas fa-plus"></i> Tạo Post Mới
					</button>
				</div>
				<jsp:include page="createPostModal.jsp"></jsp:include>
			</div>
			<div class="container mt-4">
				<!-- Add post cards and CRUD buttons here -->
				<div class="row">
					<%
						if (!posts.isEmpty())
							for (Post post : posts) {
					%>
					<div class="col-md-4" style="margin-bottom: 20px;">
						<div class="card mb-4" style="height: 100%; margin: 0;">
							<div class="card-body">
								<!-- Post details -->
								<div class="card-details">
									<h5 class="card-title"><%= post.getPostTitle() %></h5>
									<p class="card-text" style="font-style: italic; padding-bottom: 10px;"><%= new SimpleDateFormat("dd/MM/yyyy - hh:mm").format(post.getPostDate()) %></p>
									<p class="card-text"><%= post.getPostContent() %></p>
								</div>
							</div>
							<div class="row card-btns">
								<!-- CRUD buttons -->
								<div class="col-md-6">
									<a href="#" class="btn btn-primary">Sửa</a>
								</div>
								<div class="col-md-6">
									<a href="/hm?del=<%= post.getPostId() %>" class="btn btn-danger del-post-btn">Xóa</a>
								</div>
							</div>
						</div>
					</div>
					<%
							}
					%>
				</div>
			</div>
		</div>
		<script>
            let deleteButtons = document.querySelectorAll(".del-post-btn");
            deleteButtons.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    if (confirm("Bạn có chắc chắn muốn xóa post này?")) {
                        // go to the link specify in button's href attribute
                        window.location.href = btn.getAttribute("href");
                    } else {
                        // do nothing
                    }
                })
            });
		</script>

		<!-- Quản lý đăng ký -->
		<div class="tab-pane fade" id="manageRegistrations" role="tabpanel" aria-labelledby="manageRegistrations-tab">
			<h2>Chả có j ở đây do chưa làm xong :D</h2>
			<!-- You can add content for managing registrations here (if needed) -->
		</div>
	</div>
</section>

<!-- Add links to Bootstrap and jQuery scripts at the end of the body -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
