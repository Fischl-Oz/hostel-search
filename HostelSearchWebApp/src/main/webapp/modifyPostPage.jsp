<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fischl.DAOs.TagDAO" %>
<%@ page import="com.fischl.models.Tag" %>
<%@ page import="com.fischl.models.Hostel" %>
<%@ page import="com.fischl.tools.DatabaseContext" %>
<%@ page import="com.fischl.models.Account" %>
<%@ page import="com.fischl.models.Post" %>
<%@ page import="com.fischl.DAOs.HostelDAO" %>
<%@ page import="com.fischl.DAOs.PostTagDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Include Bootstrap CSS and JavaScript -->
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">--%>
<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>--%>
<section>
	<style>
        #modifyPostModal {
            margin-top: 100px;
        }
        .modal-dialog {
            max-width: 80vw;
            min-width: 800px;
        }
	</style>
	<%
		Post post = (Post) request.getAttribute("post-to-modify");
	%>
	<form action="/modify-post" method="post" enctype="multipart/form-data">
		<div class="modal-header">
			<h5 class="modal-title" id="modifyPostModalLabel">Chỉnh Sửa Post</h5>
			<input type="hidden" value="<%= post.getPostId() %>" name="post-to-modify">
		</div>
		<div class="modal-body">
			<!-- Hostel (Dropdown Selection) -->
			<div class="form-group">
				<label for="hostelSelection">Nhà trọ</label>
				<select class="form-control" id="hostelSelection" name="selected-hostel">
					<%
						Hostel hostel = new HostelDAO().getById(post.getHostelId());
					%>
					<option value="<%= hostel.getHostelId() %>" selected><%= hostel.getHostelName() %></option>
					<%
						Account account = (Account) session.getAttribute("currentAcc");
						ArrayList<Hostel> hostels = new DatabaseContext().Hostels.Where(h -> h.getUserId() == account.getUserId() && h.getHostelId() != hostel.getHostelId());
						for (Hostel h : hostels) {
					%>
					<option value="<%= h.getHostelId() %>"><%= h.getHostelName() %></option>
					<%
						}
					%>
				</select>
			</div>

			<!-- Post Tag (Checkboxes) -->
			<div class="form-group">
				<label>Post Tags</label>
				<div class="row  ml-4 mr-4">
					<%
						ArrayList<String> postTagIds = new PostTagDAO().getAllTagIdByPostId(post.getPostId());
						ArrayList<Tag> tags = new TagDAO().getAll();
						for (Tag tag : tags) {
					%>
					<div class="col-md-4 form-check">
						<input type="checkbox" class="form-check-input" id="tag" name="checked-tags" value="<%= tag.getTagId() %>" <%= postTagIds.contains(tag.getTagId())? "checked" : "" %>>
						<label class="form-check-label" for="tag"><%= tag.getTagTxt() %></label>
					</div>
					<%
						}
					%>
				</div>
			</div>

			<!-- Post Title -->
			<div class="form-group">
				<label for="postTitle">Tiêu đề</label>
				<input type="text" class="form-control" id="postTitle" name="post-title" placeholder="Enter post title" value="<%= post.getPostTitle() %>">
			</div>

			<!-- Post Content -->
			<div class="form-group">
				<label for="postContent">Nội dung</label>
				<textarea class="form-control" id="postContent" rows="5" name="post-content" placeholder="Enter post content"><%= post.getPostContent() %></textarea>
			</div>

			<!-- Post Image Upload -->
			<div class="form-group">
				<label for="postImage">Hình ảnh</label>
				<input type="file" class="form-control-file" id="postImage" name="post-img">
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary" name="posting-btn" value="posting">Lưu thay đổi</button>
		</div>
	</form>

</section>