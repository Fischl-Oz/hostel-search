<%@ page import="com.fischl.models.District" %>
<%@ page import="com.fischl.DAOs.DistrictDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    #createHostelModal {
        margin-top: 100px;
        overflow-y: hidden;
    }

    .modal-dialog {
        max-width: 80vw;
        min-width: 800px;
    }

    .modal-body {
        max-height: 70vh;
        overflow-y: auto;
    }
</style>
<div class="modal fade" id="createHostelModal" tabindex="-1" role="dialog" aria-labelledby="createHostelModalLabel"
	 aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form action="/create-hostel" method="post" enctype="multipart/form-data">
				<div class="modal-header">
					<h5 class="modal-title" id="createHostelModalLabel">Tạo Hostel Mới</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Hostel Name -->
					<div class="form-group">
						<label for="hostelName">Tên Hostel</label>
						<input type="text" class="form-control" id="hostelName" name="hostel-name"
							   placeholder="Nhập tên hostel">
					</div>

					<!-- Address -->
					<div class="form-group">
						<label for="hostelAddress">Địa chỉ</label>
						<input type="text" class="form-control" id="hostelAddress" name="hostel-address"
							   placeholder="Nhập địa chỉ">
					</div>

					<!-- Description -->
					<div class="form-group">
						<label for="hostelDescription">Mô tả</label>
						<textarea class="form-control" id="hostelDescription" rows="3" name="hostel-description"
								  placeholder="Nhập mô tả"></textarea>
					</div>

					<!-- Price -->
					<div class="form-group">
						<label for="hostelPrice">Giá cả</label>
						<input type="text" class="form-control" id="hostelPrice" name="hostel-price"
							   placeholder="Nhập giá cả">
					</div>

					<!-- Area -->
					<div class="form-group">
						<label for="hostelArea">Diện tích</label>
						<input type="text" class="form-control" id="hostelArea" name="hostel-area"
							   placeholder="Nhập diện tích">
					</div>

					<!-- Total Rooms -->
					<div class="form-group">
						<label for="totalRooms">Tổng số phòng</label>
						<input type="text" class="form-control" id="totalRooms" name="total-rooms"
							   placeholder="Nhập tổng số phòng">
					</div>

					<!-- Available Rooms -->
					<div class="form-group">
						<label for="availableRooms">Số phòng hiện có sẵn</label>
						<input type="text" class="form-control" id="availableRooms" name="available-rooms"
							   placeholder="Nhập số phòng hiện có sẵn">
					</div>

					<!-- District/County -->
					<div class="form-group">
						<label for="hostelDistrict">Quận/Huyện</label>
						<select class="form-control" id="hostelDistrict" name="hostel-district">
							<%
								List<District> districtList = new DistrictDAO().getAll();
								for (District district : districtList) {
							%>
							<option value="<%= district.getDistrictId() %>"><%= district.getDistrictName() %>
							</option>
							<%
								}
							%>
						</select>
					</div>

					<!-- Hostel Image Upload -->
					<div class="form-group">
						<label for="hostelImage">Hình ảnh</label>
						<input type="file" class="form-control-file" id="hostelImage" name="hostel-img">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
					<button type="submit" class="btn btn-primary" name="create-hostel-btn" value="create-hostel">Tạo
						Hostel
					</button>
				</div>
			</form>
		</div>
	</div>
</div>
