<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.fischl.DAOs.PostDAO" %>
<%@ page import="com.fischl.models.Post" %>
<%@ page import="com.fischl.models.HostelMaster" %>
<%@ page import="com.fischl.DAOs.HostelMasterDAO" %>
<%@ page import="com.fischl.DAOs.HostelDAO" %>
<%@ page import="com.fischl.tools.DatabaseContext" %>
<%@ page import="com.fischl.models.Hostel" %>
<%@ page import="com.fischl.models.Account" %>

<%
	DatabaseContext dbContext = new DatabaseContext();
    Post[] postArr = new Post[6];
	Hostel[] hostelArr = new Hostel[6];
    Account[] accArr = new Account[6];
	for (int i = 0; i < 6; i++) {
		postArr[i] = dbContext.Posts.toList().get(i);
        int index = i;
        hostelArr[i] = dbContext.Hostels.SingleOrDefault(h -> h.getHostelId() == postArr[index].getHostelId());
        accArr[i] = dbContext.Accounts.SingleOrDefault(acc -> acc.getUserId() == hostelArr[index].getUserId());
	}
%>

<style>
	.property-item {
		height: 100%;
	}
</style>
<div class="container">
	<div class="row g-0 gx-5 align-items-end">
		<div class="col-lg-6">
			<div class="text-start mx-auto mb-5 wow slideInLeft" data-wow-delay="0.1s">
				<h1 class="mb-3">Bài Đăng Mới</h1>
				<p>Xem qua bài đăng của các chủ trọ. Cập nhật 24/7.</p>
			</div>
		</div>
		<div class="col-lg-6 text-start text-lg-end wow slideInRight" data-wow-delay="0.1s">
			<ul class="nav nav-pills d-inline-flex justify-content-end mb-5">
				<li class="nav-item me-2">
					<a class="btn btn-outline-primary active" data-bs-toggle="pill" href="#tab-1">Mới nhất</a>
				</li>
				<li class="nav-item me-2">
					<a class="btn btn-outline-primary" data-bs-toggle="pill" href="#tab-2">Được yêu thích nhất</a>
				</li>
				<li class="nav-item me-0">
					<a class="btn btn-outline-primary" data-bs-toggle="pill" href="#tab-3">Nhiều người tìm kiếm nhất</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="tab-content">
		<%
			for (int p = 0; p < 3; p++) {
				%>
				<div id="tab-<%= p + 1%>" class="tab-pane fade show p-0 <%= p==0? "active" : ""%>">
					<div class="row g-4">
					<%
						for (int i = 0; i < 6; i++) {
					%>
						<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.<%= ((i+1)%2 == 1? (i+1)==6? 1 : (i+1) : (i+2)==6? 1 : (i+2))%6%>s">
							<div class="property-item rounded overflow-hidden">
								<div class="position-relative overflow-hidden">
									<a href=""><img class="img-fluid" src="img/property-<%= i + 1%>.jpg" alt=""></a>
									<div class="bg-primary rounded text-white position-absolute start-0 top-0 m-4 py-1 px-3">For Rent</div>
									<div class="bg-white rounded-top text-primary position-absolute start-0 bottom-0 mx-4 pt-1 px-3"><%= accArr[i].getUserName()%></div>
								</div>
								<div class="p-4 pb-0">
									<h5 class="text-primary mb-3">$<%= hostelArr[i].getPrice()%></h5>
									<a class="d-block h5 mb-2" href=""><%= postArr[i].getPostTitle()%></a>
									<p><i class="fa fa-map-marker-alt text-primary me-2"></i><%= hostelArr[i].getHostelAddr()%></p>
								</div>
								<div class="d-flex border-top">
									<small class="flex-fill text-center border-end py-2"><i class="fa fa-ruler-combined text-primary me-2"></i><%= hostelArr[i].getArea()%>msq</small>
									<small class="flex-fill text-center border-end py-2"><i class="fa fa-bed text-primary me-2"></i><%= hostelArr[i].getTotalRoom()%></small>
									<small class="flex-fill text-center py-2"><i class="fa fa-bath text-primary me-2"></i><%= hostelArr[i].getAvailableRoom()%></small>
								</div>
							</div>
						</div>
					<%
						}
					%>
						<div class="col-12 text-center wow fadeInUp" data-wow-delay="0.1s">
							<a class="btn btn-primary py-3 px-5" href="${pageContext.request.contextPath}/posts">Xem thêm nhiều bài đăng khác</a>
						</div>
					</div>
				</div>
				<%
			}
		%>
	</div>
</div>