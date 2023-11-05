<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fischl.DAOs.TagDAO" %>
<%@ page import="com.fischl.models.Tag" %>
<%@ page import="com.fischl.models.Hostel" %>
<%@ page import="com.fischl.tools.DatabaseContext" %>
<%@ page import="com.fischl.models.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Include Bootstrap CSS and JavaScript -->
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">--%>
<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>--%>
<style>
	#createPostModal {
		margin-top: 100px;
	}
	.modal-dialog {
        max-width: 80vw;
		min-width: 800px;
    }
</style>
<!-- Modal for creating a post -->
<div class="modal fade" id="createPostModal" tabindex="-1" role="dialog" aria-labelledby="createPostModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form action="/create-post" method="post" enctype="multipart/form-data">
				<div class="modal-header">
					<h5 class="modal-title" id="createPostModalLabel">Tạo Post Mới</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Hostel (Dropdown Selection) -->
					<div class="form-group">
						<label for="hostelSelection">Nhà trọ</label>
						<select class="form-control" id="hostelSelection" name="selected-hostel">
							<%
								Account account = (Account) session.getAttribute("currentAcc");
								ArrayList<Hostel> hostels = new DatabaseContext().Hostels.Where(h -> h.getUserId() == account.getUserId());
								for (Hostel hostel : hostels) {
							%>
							<option value="<%= hostel.getHostelId() %>"><%= hostel.getHostelName() %></option>
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
								ArrayList<Tag> tags = new TagDAO().getAll();
								for (Tag tag : tags) {
							%>
							<div class="col-md-4 form-check">
								<input type="checkbox" class="form-check-input" id="tag" name="checked-tags" value="<%= tag.getTagId() %>">
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
						<input type="text" class="form-control" id="postTitle" name="post-title" placeholder="Enter post title">
					</div>

					<!-- Post Content -->
					<div class="form-group">
						<label for="postContent">Nội dung</label>
						<textarea class="form-control" id="postContent" rows="5" name="post-content" placeholder="Enter post content"></textarea>
					</div>

					<!-- Post Image Upload -->
					<div class="form-group">
						<label for="postImage">Hình ảnh</label>
						<input type="file" class="form-control-file" id="postImage" name="post-img">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
					<button type="submit" class="btn btn-primary" name="posting-btn" value="posting">Đăng Post</button>
				</div>
			</form>
		</div>
	</div>
</div>