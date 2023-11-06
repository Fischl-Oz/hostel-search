<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fischl.DAOs.CityDAO" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.fischl.DAOs.TagDAO" %>
<%@ page import="com.fischl.models.*" %>
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
		<%
			String keywords = (String) request.getAttribute("keywords");
			String[] tags = (String[]) request.getAttribute("tags");
            ArrayList<String> checkedTags;
			if (tags == null || tags.length == 0) {
				checkedTags = new ArrayList<>();
			}
            else {
				checkedTags = new ArrayList<>(Arrays.asList(tags));
			}
		%>
		<div class="col-md-3">
			<div id="filter">
				<h2>Bộ lọc</h2>

				<form action="${pageContext.request.contextPath}/posts" method="post">
					<div class="row">
						<div class="form-group">
							<label for="search">Tìm kiếm</label>
							<input type="text" class="form-control" id="search" name="keywords">
						</div>

						<%
							ArrayList<Tag> tagList = (ArrayList<Tag>) request.getAttribute("tag-list");
						%>
						<div class="form-group">
							<%
								if (tagList != null) {
									for (Tag tag : tagList) {
                                        boolean isChecked = checkedTags.contains(tag.getTagId());
							%>
							<input type="checkbox" id="tag<%=tag.getTagId()%>" name="tags" value="<%=tag.getTagId()%>" <%= isChecked ? "checked" : "" %> >
							<label for="tag<%=tag.getTagId()%>"><%=tag.getTagTxt()%></label><br>
							<%
									}
                                }
							%>
						</div>
					</div>
					<div class="row">
						<button class="btn btn-secondary w-50" type="submit" name="search-btn" value="search">Tìm kiếm</button>
					</div>
				</form>
			</div>

		</div>
		<div class="col-md-9">
			<% if (request.getAttribute("status").equals("search")) { %>
				<div class="row">
					<% if (keywords != null && !keywords.isEmpty()) { %>
						<h3>Kết quả tìm kiếm cho "<%=keywords%>"</h3>
					<% } %>
				</div>
			<% } %>
			<div class="row">
				<%
					List<Post> posts = (ArrayList<Post>) request.getAttribute("post-list");
				%>
				<% if (posts.size() == 0) { %>
				  <h3>Không tìm thấy kết quả nào!</h3>
				<% } %>
				<%
					for (Post post : posts ) {
				%>
				<div class="col-md-4" id="post">
					<div class="card" id="post-card">
						<img src="https://via.placeholder.com/300x240" class="card-img-top" alt="<%=post.getPostTitle()%>">
						<div class="card-body">
							<h5 class="card-title"><%=post.getPostTitle()%></h5>
							<p class="card-text"><%=post.getPostContent()%></p>
							<form method="get" action="${pageContext.request.contextPath}/postsInfo">
								<input type="hidden" name="postid" value="<%=post.getPostId()%>">
								<input type="hidden" name="hostelid" value="<%=post.getHostelId()%>">
								<input type="submit" class="btn btn-primary" value="Đọc thêm"/>
							</form>

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