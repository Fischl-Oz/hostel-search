<%@ page import="com.fischl.DAOs.CityDAO" %>
<%@ page import="com.fischl.models.City" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Search Start -->
<div id="search-bar" class="col-md-12 container-fluid bg-primary mb-5 wow fadeIn search-bar" data-wow-delay="0.1s" style="padding: 35px;">
	<div class="container">
		<form action="/posts" method="post">
			<div class="row g-2">
				<div class="col-md-10">
					<div class="row g-2">
						<div class="col-md-4">
							<input type="text" class="form-control border-0 py-3" name="search-bar-keywords" placeholder="Tìm nhanh">
						</div>
						<div class="col-md-4">
							<select class="form-select border-0 py-3" name="search-bar-city">
								<option value="-1" selected>Chọn Thành phố</option>
								<%
									CityDAO cityDAO = new CityDAO();
									ArrayList<City> list = cityDAO.getAll();
									for (City c: list) {
								%>
								<option value="<%= c.getCityId() %>"><%=c.getCityName()%></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="col-md-4">
							<select class="form-select border-0 py-3 " name="search-bar-prices">
								<option value="0" selected>Chọn giá thuê trọ</option>
								<option value="1">&lt; 800,000</option>
								<option value="2">800,000 - 1,000,000</option>
								<option value="3">&gt; 1,000,000</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<button class="btn btn-light border-0 w-100 py-3" type="submit" name="search-bar-btn" value="search">Tìm kiếm</button>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- Search End -->