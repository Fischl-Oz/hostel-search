<%@ page import="com.fischl.models.Account" %>
<%@ page import="com.fischl.models.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	Account acc = (Account) session.getAttribute("currentAcc");
	User user = new User(acc);
	if (user.isHostelMaster())
		if (user.toHostelMaster().getStatus().equals("pending")) {
%>
<section id="hm-reg-on-pending" style="padding-top: 50px">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center" style="color: greenyellow">Register On Pending</h1>
			</div>
		</div>
		<div class="row d-flex justify-content-center">
			<div class="col-md-10">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<th>Họ và tên</th>
							<td><%= user.getFullName() %></td>
						</tr>
						<tr>
							<th>Email</th>
							<td><%= user.getEmail() %></td>
						</tr>
						<tr>
							<th>Phone</th>
							<td><%= user.getPhone() %></td>
						</tr>
						<tr>
							<th>Địa chỉ</th>
							<td><%= user.getHostelMasterAddress() %></td>
						</tr>
						<tr>
							<th>Tên đăng nhập</th>
							<td><%= user.getUserName() %></td>
						</tr>
						<tr>
							<th>Ảnh CCCD mặt trước</th>
							<td><img src="https://via.placeholder.com/250x150" alt="CCCD-front"></td>
						</tr>
						<tr>
							<th>Ảnh CCCD mặt sau</th>
							<td><img src="https://via.placeholder.com/250x150" alt="CCCD-back"></td>
						</tr>
						<tr>
							<th>Trạng thái đăng ký</th>
							<td><%= user.getStatus() %></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</section>
<%
		}
    if (!user.isHostelMaster()) {
%>
<section id="hm-reg-form">

	<div class="container" style="padding-top: 50px">
		<div class="row" style="text-align: center">
			<h2>Đăng ký tài khoản chủ nhà trọ</h2>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<form id="registrationForm" class="col-md-8" action="hm-register" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="full_name">Họ và tên:</label>
					<input type="text" class="form-control" id="full_name" name="full_name" value="<%= acc.getFullName()%>" required>
				</div>

				<div class="form-group">
					<label for="email">Email:</label>
					<input type="email" class="form-control" id="email" name="email" value="<%= acc.getEmail()==null? "" : acc.getEmail()%>" required>
				</div>

				<div class="form-group">
					<label for="phone">Số điện thoại:</label>
					<input type="tel" class="form-control" id="phone" name="phone" value="<%= acc.getPhone()==null? "" : acc.getPhone()%>" required>
				</div>

				<div class="form-group">
					<label for="address">Địa chỉ:</label>
					<input type="text" class="form-control" id="address" name="address" placeholder="Ví dụ: 123 Đường ABC, Huyện XYZ, ..." required>
				</div>

				<div class="form-group">
					<label for="username">Tên đăng nhập:</label>
					<input type="text" class="form-control" id="username" name="username" value="<%= acc.getUserName()%>" required>
				</div>

				<div class="form-group">
					<label for="password">Mật khẩu:</label>
					<input type="password" class="form-control" id="password" name="password" value="<%= acc.getPassword()%>" required>
				</div>

				<div class="form-group">
					<label for="confirm_password">Xác nhận mật khẩu:</label>
					<input type="password" class="form-control" id="confirm_password" name="confirm_password" value="<%= acc.getPassword()%>" required>
				</div>

				<div class="form-group">
					<label for="front_id_card_image">Ảnh CMND mặt trước:</label>
					<input type="file" class="form-control-file" id="front_id_card_image" name="front_id_card_image" accept=".png, .jpg, image/png, image/jpeg" required>
				</div>

				<div class="form-group">
					<label for="back_id_card_image">Ảnh CMND mặt sau:</label>
					<input type="file" class="form-control-file" id="back_id_card_image" name="back_id_card_image" accept=".png, .jpg, image/png, image/jpeg" required>
				</div>

				<div class="form-group">
					<label for="business_certificate_image">Ảnh chứng nhận kinh doanh nhà trọ:</label>
					<input type="file" class="form-control-file" id="business_certificate_image" name="business_certificate_image" accept=".png, .jpg, image/png, image/jpeg" required>
				</div>

				<div style="float: right">
					<button type="submit" class="btn btn-primary" value="dang-ky" name="dangky-btn">Đăng ký</button>
				</div>
			</form>
			<div class="col-md-2"></div>
		</div>
	</div>
	<script>
		// Get input field
		const fullName = document.getElementById("full_name");
		const email = document.getElementById("email");
		const phone = document.getElementById("phone");
		const username = document.getElementById("username");
		const password = document.getElementById("password");
		const confirmPassword = document.getElementById("confirm_password");
		const address = document.getElementById("address");

		// Function to validate the form
		function validateForm() {

			// Regular expressions for email and phone validation
			const emailRegex = /^\S+@\S+\.\S+$/;
			const phoneRegex = /^((0)[3|5|7|8|9][0-9]{8,9})$/;
			// Regular expression for username validation (letters, numbers, underscores)
			const usernameRegex = /^[a-zA-Z0-9_]+$/;

			// Validate full name (not empty)
			if (fullName.value.trim() === "") {
				alert("Họ và tên không được để trống");
				fullName.focus();
				return false;
			}

			// Validate email (must be a valid email address)
			if (!email.value.match(emailRegex)) {
				alert("Email không hợp lệ");
				email.focus();
				return false;
			}

			// Validate phone (must be numeric)
			if (!phone.value.match(phoneRegex)) {
				alert("Số điện thoại không hợp lệ");
				phone.focus();
				return false;
			}

			// Validate address (not empty)
			if (address.value.trim() === "") {
				alert("Địa chỉ không được để trống");
				address.focus()
				return false;
			}

			// Validate username (not empty)
			if (username.value.trim() === "") {
				alert("Tên đăng nhập không được để trống");
				username.focus()
				return false;
			} else if (!username.value.match(usernameRegex)) {
				alert("Tên đăng nhập chỉ được chứa chữ cái, số và dấu gạch dưới.");
				username.focus()
				return false;
			}

			// Validate password (must be at least 6 characters)
			if (password.value.length < 6) {
				alert("Mật khẩu phải có ít nhất 6 ký tự");
				password.focus()
				return false;
			}

			// Validate password confirmation (must match password)
			if (password.value !== confirmPassword.value) {
				alert("Xác nhận mật khẩu không khớp");
				confirmPassword.focus()
				return false;
			}

			return true;
		}

		// Add an event listener to the password field
		password.addEventListener("input", function() {
			// Reset the value of the confirm_password field
			confirmPassword.value = "";
		});

		// Attach the validateForm function to the form's submit event
		document.getElementById("registrationForm").addEventListener("submit", function (event) {
			if (!validateForm()) {
				event.preventDefault();
			}
		});
	</script>
</section>
<%
		}
%>
