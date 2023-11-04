<%@ page import="com.fischl.models.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fischl.DAOs.CityDAO" %>
<%@ page import="com.fischl.models.City" %>
<%@ page import="com.fischl.models.Tag" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	#filter {
        position: sticky;
        top: 4rem;
		left: 0;
        height: 100vh;
        background-color: #fff;
        padding: 20px;
	}
	#post {
		margin-bottom: 1rem;
	}
	#post-card {
		height: 100%;
	}
    #post-card .card-title,
	#post-card .card-text {
        overflow: hidden;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2; /* start showing ellipsis when 2rd line is reached */
        white-space: pre-wrap; /* let the text wrap preserving spaces */
		height: 3rem;
	}
</style>
<div class="container" style="margin-top: 50px">
	<div class="row">
		<jsp:include page="searchBar.jsp"></jsp:include>
	</div>
	<div class="row">
		<div class="col-md-3">
			<div id="filter">
				<h2>Bộ lọc</h2>

				<div class="form-group">
					<label for="search">Tìm kiếm</label>
					<input type="text" class="form-control" id="search">
				</div>

				<%
					List<Tag> tagList = (ArrayList<Tag>) request.getAttribute("tag-list");
				%>
				<div class="form-group">
					<label for="tag">Tag</label>
					<select class="form-control" id="tag">
						<option value="">Tất cả</option>
					<%
						for (Tag tag : tagList) {
					%>
						<option value="<%=tag.getTagId()%>"><%=tag.getTagTxt()%></option>
					<%
						}
					%>
					</select>
				</div>
			</div>

		</div>
		<div class="col-md-9">

			<div class="row">
				<%
					List<Post> posts = (ArrayList<Post>) request.getAttribute("post-list");
					for (Post post : posts) {
				%>
				<div class="col-md-4" id="post">
					<div class="card" id="post-card">
						<img src="https://via.placeholder.com/300x240" class="card-img-top" alt="<%=post.getPostTitle()%>">
						<div class="card-body">
							<h5 class="card-title"><%=post.getPostTitle()%></h5>
							<p class="card-text"><%=post.getPostContent()%>></p>
							<a href="about.html" class="btn btn-primary">Đọc thêm</a>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</div>