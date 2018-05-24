<%-- 
    Document   : hotelList
    Created on : 23-mag-2018, 14.54.35
    Author     : giovannibonetta
--%>

<%@page import="java.util.List"%>
<%@page import="com.tripsplanner.model.entity.Hotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html class="load-full-screen">
<head>
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="LimpidThemes">
        <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      
/*      .room-info-wrapper:hover {
	border: 1px solid #F19C4F;
	box-shadow: 0px 0px 5px #F19C4F;}*/
        
        #fixed{ 
    position:fixed; 
    width:30%;}


    </style>
	
	<title>Cruise - Responsive Travel Agency Template</title>
	
    <!-- STYLES -->
	<link href="assets/css/animate.min.css" rel="stylesheet">
	<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">
	<link href="assets/css/owl.carousel.css" rel="stylesheet">
	<link href="assets/css/owl-carousel-theme.css" rel="stylesheet">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="assets/css/flexslider.css" rel="stylesheet" media="screen">
	<link href="assets/css/style.css" rel="stylesheet" media="screen">
        
        <!-- margin to the map -->
        <link href="assets/css/addmargintomap.css" rel="stylesheet">
	<!-- LIGHT -->
	<link rel="stylesheet" type="text/css" href="assets/css/dummy.css" id="select-style">
	<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	
	<!-- FONTS -->
	
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,800,700,600' rel='stylesheet' type='text/css'>

</head>
<body class="load-full-screen">

<!-- BEGIN: PRELOADER -->
<!-- END: PRELOADER -->

<!-- BEGIN: COLOR SWITCHER -->
<!-- END: COLOR SWITCHER -->

<!-- BEGIN: SITE-WRAPPER -->
<div class="site-wrapper">
    <jsp:include page="header.jsp" />
    <jsp:include page="nav.html"/>
    <div class="clearfix"></div>
	

	<!-- START: PAGE TITLE -->
	
	<!-- END: PAGE TITLE -->
	
	<!-- START: ROOM GALLERY -->
	
	<div class="row product-complete-info">
		<div id="wrap" class="container">
			<div class="col-md-8 main-content">
				<div class="room-complete-detail custom-tabs">
					
					<div class="">
						
						<div id="room-info" class="tab-pane fade in active">
							<h4 class="tab-heading">Hotels</h4>
                                                        
                                                        <%
                                                            List<Hotel> hotels = (List<Hotel>) request.getAttribute("hotels");
                                                            if (hotels != null) {
                                                                for (Hotel hotel : hotels) {
                                                        %>
                                                        
							<div class="room-info-wrapper">
								<div class="col-md-4 col-sm-6 clear-padding">
									<img src="assets/images/offer1.jpg" alt="cruise">
								</div>
								<div class="col-md-5 col-sm-6 room-desc">
                                                                    <h4> <%= hotel.getName() %> </h4>
									<h5> <%= hotel.getAddress() %> </h5>
									<p> <%= hotel.getRoomDescription() %> </p>
									<p>
										<i class="fa fa-wifi"></i>
										<i class="fa fa-taxi"></i>
										<i class="fa fa-cutlery"></i>
										<i class="fa fa-beer"></i>
										<i class="fa fa-coffee"></i>
										<i class="fa fa-desktop"></i>
									</p>
								</div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-md-3 text-center booking-box">
									<div class="price">
										<h3><%= hotel.getTotal() %>/<%= hotel.getCurrency() %> </h3>
									</div>
                                                                                <% if(hotel.getAvaiable() == true){ %>
									<div class="book">
										<a href="#">CHOOSE</a>
									</div>
                                                                                 <% }else{ %>
                                                                        <div class="" style="color:#f9676b">
										<h4>not available</h4>
									</div> 
                                                                        <% } %>
                                                                        <input id='lat' type='hidden' value='<%= hotel.getLatitude() %>'/>
                                                                        <input id='lon' type='hidden' value='<%= hotel.getLongitude() %>'/>
								</div>
							</div>
                                                        
                                                        <%
                                                            }
                                                        }
                                                        %>
                                                        
						</div>
						
						
						
					</div>
				</div>
			</div>
			<div class="col-md-4 hotel-detail-sidebar">
                            <div id="fixed">
                            <div class="col-md-12 clear-padding">
                                <!--					<div class="map sidebar-item">
                                                                                <h5><i class="fa fa-map-marker"></i> Mall Road, Shimla, Himachal Pradesh, 176077</h5>
                                                                                <iframe class="hotel-map" src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJG1usnet4BTkRzQqb_Ys-JOg&amp;key=AIzaSyB6hgZM-ruUqTPVUjXGUR-vv7WRqc4MXjY" ></iframe>
                                                                        </div>-->
                                <div id="fixed" class="map sidebar-item">
                                    <div class="hotel-map">
                                        <div id="map"></div>
                                    </div>
                                </div>

                            </div>
                            </div>    
			</div>
		</div>
	</div>
<!-- END: ROOM GALLERY -->

<!-- START: FOOTER -->
<section id="footer">
	<footer>
		<div class="row main-footer-sub">
			<div class="container clear-padding">
				<div class="col-md-5 col-sm-5">
					<div class="social-media pull-right">
						<ul>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							<li><a href="#"><i class="fa fa-youtube"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="main-footer row">
			<div class="container clear-padding">
				<div class="col-md-3 col-sm-6 about-box">
					<h3>CRUISE</h3>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
					<a href="#">READ MORE</a>
				</div>
				<div class="col-md-3 col-sm-6 links">
					<h4>Popular Tours</h4>
					<ul>
						<li><a href="#">Romantic France</a></li>
						<li><a href="#">Wonderful Lodnon</a></li>
						<li><a href="#">Awesome Amsterdam</a></li>
						<li><a href="#">Wild Africa</a></li>
						<li><a href="#">Beach Goa</a></li>
						<li><a href="#">Casino Los Vages</a></li>
						<li><a href="#">Romantic France</a></li>
					</ul>
				</div>
				<div class="clearfix visible-sm-block"></div>
				<div class="col-md-3 col-sm-6 links">
					<h4>Our Services</h4>
					<ul>
						<li><a href="#">Domestic Flights</a></li>
						<li><a href="#">International Flights</a></li>
						<li><a href="#">Tours & Holidays</a></li>
						<li><a href="#">Domestic Hotels</a></li>
						<li><a href="#">International Hotels</a></li>
						<li><a href="#">Cruise Holidays</a></li>
						<li><a href="#">Car Rental</a></li>
					</ul>
				</div>
				<div class="col-md-3 col-sm-6 contact-box">
					<h4>Contact Us</h4>
					<p><i class="fa fa-home"></i> Street #156 Burbank, Studio City Hollywood, California USA</p>
					<p><i class="fa fa-phone"></i> +91 1234567890</p>
					<p><i class="fa fa-envelope-o"></i> support@domain.com</p>
				</div>
				<div class="clearfix"></div>
				<div class="col-md-12 text-center we-accept">
					<h4>We Accept</h4>
					<ul>
						<li><img src="assets/images/card/card.jpg" alt="cruise"></li>
						<li><img src="assets/images/card/card.jpg" alt="cruise"></li>
						<li><img src="assets/images/card/card.jpg" alt="cruise"></li>
						<li><img src="assets/images/card/card.jpg" alt="cruise"></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="main-footer-nav row">
			<div class="container clear-padding">
				<div class="col-md-6 col-sm-6">
					<p>Copyright &copy; 2015 LimpidThemes. All Rights Reserved.</p>
				</div>
				<div class="col-md-6 col-sm-6">
					<ul>
						<li><a href="#">FLIGHTS</a></li>
						<li><a href="#">TOURS</a></li>
						<li><a href="#">CARS</a></li>
						<li><a href="#">HOTELS</a></li>
						<li><a href="#">BLOG</a></li>
					</ul>
				</div>
				<div class="go-up">
					<a href="#"><i class="fa fa-arrow-up"></i></a>
				</div>
			</div>
		</div>
	</footer>
</section>
<!-- END: FOOTER -->

</div>
<!-- END: SITE-WRAPPER -->

<!-- Load Scripts -->
<script src="assets/js/respond.js"></script>
<script src="assets/js/jquery.js"></script>
<script src="assets/plugins/owl.carousel.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery-ui.min.js"></script>
<script src="assets/js/bootstrap-select.min.js"></script>
<script src="assets/plugins/wow.min.js"></script>
<script src="assets/plugins/jquery.flexslider-min.js"></script>
<script src="assets/js/js.js"></script>
<script src="assets/js/googleMap.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAnhWd3kTxtx-49mP3x8SiNIvH3XZKL-Wo&callback=initMap&libraries=drawing"
    async defer></script>
<script>
$(window).load(function() {
	"use strict";
  // The slider being synced must be initialized first
  $('#carousel').flexslider({
    animation: "slide",
    controlNav: false,
    animationLoop: false,
    slideshow: false,
    itemWidth: 150,
    itemMargin: 5,
    asNavFor: '#slider'
  });
 
  $('#slider').flexslider({
		animation: "slide",
		controlNav: false,
		animationLoop: false,
		slideshow: false,
		sync: "#carousel"
	  });
	});
  $('#map-google').css("margin-top:60px");
</script>
</body>
</html>

