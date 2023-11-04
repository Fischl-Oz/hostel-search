<%@ page import="com.fischl.tools.Layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Layout layout = (Layout) request.getAttribute("layout");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Hostel Searching</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Boostrap Stylesheet -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/template_style.css" rel="stylesheet">

    <!-- Import font "Be Vietnam Pro" -->
    <link rel="stylesheet" href="assets/css/fontbevietnampro.css">
    <style>
      body {
        font-family: "Be Vietnam Pro", sans-serif !important;
      }
      .btn-primary:hover {
        color: #fb7000 !important;
      }
    </style>
  </head>

  <body>
    <div class="container-xxl bg-white p-0">
      <!-- Spinner Start -->
      <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
          <span class="sr-only">Loading...</span>
        </div>
      </div>
      <!-- Spinner End -->


      <!-- Navbar Start -->
      <jsp:include page="navbar.jsp" />
      <!-- Navbar End -->

      <!-- Popup Start -->
      <%
        if (layout.popup != null) {
      %>
        <!-- Modal -->
        <div class="modal fade" id="popup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Thông báo:</h5>
                <button type="button" class="close" onclick="closePopup()" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body popup-content">
                <h1><%= new String(layout.popup.popupMessage)%></h1>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="closePopup()">Close</button>
              </div>
            </div>
          </div>
        </div>

        <style>
          #popup {
            z-index: 10000;
          }
          .popup-content {
            padding: 20px;
            text-align: center;
          }
          .popup-content h1 {
            color: <%= layout.popup.getColor()%>;
          }
        </style>

        <script type="text/javascript">
          function closePopup() {
            $("#popup").modal('hide');
          }

          $(document).ready(function(){
            $("#popup").modal('show');
          });

          // Add an event listener to the document body
          document.body.addEventListener("click", function(event) {
            // Get the element that was clicked
            var clickedElement = event.target;

            // Check if the clicked element is outside the popup
            if (!clickedElement.closest("#popup")) {
              closePopup()
            }
          });

          // Prevent resubmit form when refresh page
            if ( window.history.replaceState ) {
            window.history.replaceState( null, null, window.location.href );
          }
        </script>
      <%
          request.removeAttribute("layout");
        }
      %>
      <!-- Popup End -->

      <!-- Main Content Start -->
      <%
        String body_content = (String) request.getAttribute("body-content");
      %>
      <main>
        <jsp:include page='<%= body_content%>'></jsp:include>
      </main>
      <!-- Main Content End -->

      <!-- Footer Start -->
      <jsp:include page="footer.jsp"/>
      <!-- Footer End -->


      <!-- Back to Top -->
      <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- JS CDN -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
  </body>

</html>