<%@ page import="com.fischl.models.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section id="account-info">
	<style>
        .my-style {
            padding: 20px;
            margin-top: 50px;
            margin-bottom: 50px;
        }
	</style>
	<%
		Account acc = (Account) session.getAttribute("currentAcc");
	%>
	<div class="container my-style">
		<div class="row">
			<div class="col-md-12" style="margin-bottom: 30px">
				<h1 class="text-center">Profile</h1>
			</div>
		</div>
		<div class="row">
			<form method="post" action="profile" class="container">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-3">
						<img src="https://via.placeholder.com/250x250" alt="User Avatar" class="img-fluid">
					</div>
					<div class="col-md-6">
						<table class="table table-striped">
							<tbody>
								<tr>
									<th>Full Name</th>
									<td><input type="text" class="form-control" name="full-name" value="<%= acc.getFullName()%>" required></td>
								</tr>
								<tr>
									<th>User Name</th>
									<td><input type="text" class="form-control" name="user-name" value="<%= acc.getUserName()%>" readonly></td>
								</tr>
								<tr>
									<th>Email</th>
									<td><input type="email" class="form-control" name="email" value="<%= acc.getEmail()%>"></td>
								</tr>
								<tr>
									<th>Phone</th>
									<td><input type="text" class="form-control" name="phone" value="<%= acc.getPhone()%>" required></td>
								</tr>
								<tr>
									<th>Password</th>
									<td><input type="password" class="form-control" value="******" disabled></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-md-1"></div>
				</div>
				<div class="row">
					<div class="col-md-5"></div>
					<div class="col-md-1">
						<button type="submit" class="btn btn-primary btn-light" name="btn-submit" value="submit-profile" id="submitButton" disabled>Save</button>
					</div>
					<div class="col-md-5"></div>
				</div>
			</form>
		</div>
	</div>

	<script>
        document.body.addEventListener("change", function(event){
            saveAble();
        });
        function saveAble(){
            const saveButton = document.getElementById('submitButton');
            saveButton.disabled = false;
        }
	</script>
</section>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856g0fi0C1qJdwXplA7YCbuDGfG+j8p+otyi7R8wW4jAu7jJmoMoVkT3sm+9" crossorigin="anonymous"></script>