<%@ page import="com.fischl.models.Hostel" %>
<%@ page import="com.fischl.models.District" %>
<%@ page import="com.fischl.DAOs.DistrictDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    	// Get hostel object from request attribute
	Hostel hostel = (Hostel) request.getAttribute("hostel-to-modify");
%>
<form action="/modify-hostel" method="post" enctype="multipart/form-data">
	<div class="modal-header">
		<h5 class="modal-title" id="modifyHostelModalLabel">Chỉnh Sửa Hostel</h5>
		<input type="hidden" value="<%= hostel.getHostelId() %>" name="hostel-to-modify">
	</div>
	<div class="modal-body">
		<!-- Hostel Name -->
		<div class="form-group">
			<label for="hostelName">Tên Hostel</label>
			<input type="text" class="form-control" id="hostelName" name="hostel-name" placeholder="Nhập tên hostel" value="<%= hostel.getHostelName() %>">
		</div>

		<!-- Hostel Address -->
		<div class="form-group">
			<label for="hostelAddress">Địa chỉ</label>
			<input type="text" class="form-control" id="hostelAddress" name="hostel-address" placeholder="Nhập địa chỉ" value="<%= hostel.getHostelAddr() %>">
		</div>

		<!-- Hostel Description -->
		<div class="form-group">
			<label for="hostelDescription">Mô tả</label>
			<textarea class="form-control" id="hostelDescription" rows="5" name="hostel-description" placeholder="Nhập mô tả"><%= hostel.getHostelDesc() %></textarea>
		</div>

		<!-- Hostel Price -->
		<div class="form-group">
			<label for="hostelPrice">Giá</label>
			<input type="text" class="form-control" id="hostelPrice" name="hostel-price" placeholder="Nhập giá" value="<%= hostel.getPrice() %>">
		</div>

		<!-- Hostel Area -->
		<div class="form-group">
			<label for="hostelArea">Diện tích</label>
			<input type="text" class="form-control" id="hostelArea" name="hostel-area" placeholder="Nhập diện tích" value="<%= hostel.getArea() %>">
		</div>

		<!-- Total Rooms -->
		<div class="form-group">
			<label for="totalRooms">Tổng số phòng</label>
			<input type="text" class="form-control" id="totalRooms" name="total-rooms" placeholder="Nhập tổng số phòng" value="<%= hostel.getTotalRoom() %>">
		</div>

		<!-- Available Rooms -->
		<div class="form-group">
			<label for="availableRooms">Số phòng sẵn có</label>
			<input type="text" class="form-control" id="availableRooms" name="available-rooms" placeholder="Nhập số phòng sẵn có" value="<%= hostel.getAvailableRoom() %>">
		</div>

		<!-- District (Dropdown Selection) -->
		<%
		    List<District> districts = new DistrictDAO().getAll();
		%>
		<div class="form-group">
			<label for="districtSelection">Quận/Huyện</label>
			<select class="form-control" id="districtSelection" name="selected-district">
				<%
				    for (District district : districts) {
				%>
				<option value="<%= district.getDistrictId() %>"><%= district.getDistrictName() %></option>
				<%
					}
				%>
			</select>
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary" name="modify-hostel-btn" value="modify-hostel">Lưu thay đổi</button>
	</div>
</form>
