<%--
			* Authors: Giovanni Bonetta, Riccardo Renzulli, Gabriele Sartor<br>
			* Università degli Studi di Torino<br>
			* Department of Computer Science<br>
			* Sviluppo Software per Componenti e Servizi Web<br>
			* Date: May 2018<br><br>
			* <p/>
			* giovanni.bonetta@edu.unito.it<br>
			* riccardo.renzulli@edu.unito.it<br>
			* gabriele.sartor@edu.unito.it<br><br>
--%>


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
		<meta name="google-signin-client_id" content="682887231528-qe2dfr4gba9fn1dmef7q97bq7l6o6m98.apps.googleusercontent.com">

		<title>TripsPlanner - Create fantastic trips</title>

    <!-- STYLES -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
		<link href="assets/css/animate.min.css" rel="stylesheet">
		<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">
		<link href="assets/css/owl.carousel.css" rel="stylesheet">
		<link href="assets/css/owl-carousel-theme.css" rel="stylesheet">
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="assets/css/flexslider.css" rel="stylesheet" media="screen">
		<link href="assets/css/style.css" rel="stylesheet" media="screen">

                <!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
		<!-- LIGHT -->
		<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
		<!-- FONTS -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,800,700,600" rel="stylesheet" type="text/css">

    <!-- SCRIPTS -->
		<script src="assets/js/login.js"></script>
		<script src="https://apis.google.com/js/platform.js" async defer></script>
	</head>

	<body class="load-full-screen">
		<div id="supersized" class="quality" style="display: block;">
			<a target="_blank" style="display: block; opacity: 1;" class="prevslide">
				<img src="assets/images/slide.jpg" style="width: 1841px; height: 1233.47px; left: 0px; top: -355.5px;">
			</a>
			<a target="_blank" style="display: block; opacity: 1;" class="activeslide">
				<img src="assets/images/slide.jpg" style="width: 1841px; height: 1233.47px; left: 0px; top: -355.5px;">
			</a>
			<a target="_blank">
				<img src="assets/images/road.jpg" style="width: 1841px; height: 1233.47px; left: 0px; top: -355.5px;">
			</a>
		</div>
		<div id="supersized" class="quality" style="display: block;">
			<a target="_blank" style="display: block; opacity: 1;" class="">
				<img src="assets/images/slide.jpg" style="width: 1841px; height: 1233.47px; left: 0px; top: -355.5px;"></a>
				<a target="_blank" style="display: block; opacity: 1;" class="activeslide">
					<img src="assets/images/road.jpg" style="width: 1841px; height: 1233.47px; left: 0px; top: -355.5px;"></a>
					<a target="_blank">
						<img src="assets/images/slide.jpg" style="width: 1841px; height: 1233.47px; left: 0px; top: -355.5px;"></a>
		</div>

<!-- BEGIN: PRELOADER -->
<div id="loader" class="load-full-screen" style="display: none;">
	<div class="loading-animation">
		<span><i class="fa fa-plane"></i></span>
		<span><i class="fa fa-bed"></i></span>
		<span><i class="fa fa-ship"></i></span>
		<span><i class="fa fa-suitcase"></i></span>
	</div>
</div>
<!-- END: PRELOADER -->
<!-- BEGIN: SITE-WRAPPER -->
<div class="site-wrapper">
<!-- BEGIN: NAV SECTION -->
<jsp:include page="header.jsp" />
<jsp:include page="nav.html"/>
<div class="clearfix"></div>
<!-- END: NAV SECTION -->

<!-- hidden input to pass the amadeus key to javascript for the autocomplete service -->
<input id='amadeus_autocomplete' type='hidden' value='${applicationScope['amadeus_autocomplete']}'/>

<%@include file="searchBox.html" %>

<!-- BEGIN: HOW IT WORK -->
<section id="how-it-work">
		<div class="row work-row">
			<div class="container">
				<div class="section-title text-center">
					<h2>HOW IT WORKS?</h2>
					<h4>SEARCH - SAVE - SHARE</h4>
					<div class="space"></div>

					<p>
					Create a fully customized itinerary for free, save it and share it with your friends.
					</p>
				</div>
				<div class="work-step">
					<div class="col-md-4 col-sm-4 first-step text-center">
						<i class="fa fa-search"></i>
						<h5>SEARCH</h5>
						<p>Search for your favorite cities.</p>
					</div>
					<div class="col-md-4 col-sm-4 second-step text-center">
						<i class="fa fa-heart-o"></i>
						<h5>SAVE</h5>
						<p>Save your trips so they will be always with you.</p>
					</div>
					<div class="col-md-4 col-sm-4 third-step text-center">
						<i class="fa fa-share-alt"></i>
						<h5>SHARE</h5>
						<p>Share your trips and start exploring the world.</p>
					</div>
				</div>
			</div>
		</div>
</section>
<!--END: HOW IT WORK -->

<!-- BEGIN: TOP DESTINATION SECTION -->
<section id="home-top-destination">
	<div class="row image-background">
		<div class="td-overlay">
			<div class="container">
				<div class="light-section-title text-center">
					<h2>TOP DESTINATION</h2>
					<h4>EXPLORE</h4>
					<div class="space"></div>
				</div>
				<div class="col-md-10 col-md-offset-1 on-top clear-padding">
					<div class="col-md-6 col-sm-6 td-product text-center clear-padding wow slideInUp" data-wow-delay="0.1s" style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
						<img src="assets/images/paris.jpg" alt="cruise">
						<div class="overlay">
							<div class="wrapper">
								<h5>FRANCE</h5>
								<h3><span>ROMANTIC PARIS</span></h3>
								<a href="#">KNOW MORE</a>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6 td-product text-center clear-padding wow slideInUp" data-wow-delay="0.2s" style="visibility: hidden; animation-delay: 0.2s; animation-name: none;">
						<img src="assets/images/london.jpg" alt="cruise">
						<div class="overlay">
							<div class="wrapper">
								<h5>UNITED KINGDOM</h5>
								<h3><span>WONDERFUL LONDON</span></h3>
								<a href="#">KNOW MORE</a>
							</div>
						</div>
					</div>
					<div class="clearfix visible-md-block"></div>
					<div class="col-md-6 col-sm-6 td-product text-center clear-padding wow slideInUp" data-wow-delay="0.1s" style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
						<img src="assets/images/rome.jpg" alt="cruise">
						<div class="overlay">
							<div class="wrapper">
								<h5>ITALY</h5>
								<h3><span>MAGNIFICENT ROME</span></h3>
								<a href="#">KNOW MORE</a>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6 td-product text-center clear-padding wow slideInUp" data-wow-delay="0.2s" style="visibility: hidden; animation-delay: 0.2s; animation-name: none;">
						<img src="assets/images/newyork.jpg" alt="cruise">
						<div class="overlay">
							<div class="wrapper">
								<h5>USA</h5>
								<h3><span>WILD NEW YORK</span></h3>
								<a href="#">KNOW MORE</a>
							</div>
						</div>
					</div>
					<div class="clearfix visible-md-block"></div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- END: TOP DESTINATION SECTION -->

<!-- START: WHY CHOOSE US SECTION -->
<section id="why-choose-us">
	<div class="row choose-us-row">
		<div class="container clear-padding">
			<div class="light-section-title text-center">
				<h2>WHY CHOOSE US?</h2>
				<h4>REASONS TO TRUST US</h4>
				<div class="space"></div>
				<p>
					TripsPlanner works for you and saves you time.<br>
					It helps you organize your travels and share them with your friends.<br>
					Always take it with you through the android app.<br>
					It's free!<br>
				</p>
			</div>
			<div class="col-md-4 col-sm-4 wow slideInLeft" style="visibility: hidden; animation-name: none;">
				<div class="choose-us-item text-center">
					<div class="choose-icon"><i class="fa fa-desktop"></i></div>
					<h4>Best technology</h4>
					<p>Planning engine that helps you create trips, save them and share them with your friends.</p>
					<a href="#">KNOW MORE</a>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 wow slideInUp" style="visibility: hidden; animation-name: none;">
				<div class="choose-us-item text-center">
					<div class="choose-icon"><i class="fa fa-phone"></i></div>
					<h4>Dedicated Support</h4>
					<p>We consider support as important as our technology and delivery process. If you need help, just send us an email. </p>
					<a href="#">KNOW MORE</a>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 wow slideInRight" style="visibility: hidden; animation-name: none;">
				<div class="choose-us-item text-center">
					<div class="choose-icon"><i class="fa fa-smile-o"></i></div>
					<h4>Lowest Price</h4>
					<p>TripsPlanner is completely free. It also offers you the cheapest hotels and flights.</p>
					<a href="#">KNOW MORE</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- END: WHY CHOOSE US SECTION -->

<!-- START: FOOTER -->
<jsp:include page="footer.html" />

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
<script type="text/javascript" src="assets/plugins/supersized.3.1.3.min.js"></script>
<script src="assets/js/js.js"></script>
<script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
<!-- <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAnhWd3kTxtx-49mP3x8SiNIvH3XZKL-Wo&libraries=places&language=en"></script> -->
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="assets/js/AmadeusAutocomplete.js"></script>
<script type="text/javascript">
			jQuery(function($){
				"use strict";
				$.supersized({

					//Functionality
					slideshow               :   1,		//Slideshow on/off
					autoplay				:	1,		//Slideshow starts playing automatically
					start_slide             :   1,		//Start slide (0 is random)
					random					: 	0,		//Randomize slide order (Ignores start slide)
					slide_interval          :   10000,	//Length between transitions
					transition              :   1, 		//0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
					transition_speed		:	500,	//Speed of transition
					new_window				:	1,		//Image links open in new window/tab
					pause_hover             :   0,		//Pause slideshow on hover
					keyboard_nav            :   0,		//Keyboard navigation on/off
					performance				:	1,		//0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)
					image_protect			:	1,		//Disables image dragging and right click with Javascript

					//Size & Position
					min_width		        :   0,		//Min width allowed (in pixels)
					min_height		        :   0,		//Min height allowed (in pixels)
					vertical_center         :   1,		//Vertically center background
					horizontal_center       :   1,		//Horizontally center background
					fit_portrait         	:   1,		//Portrait images will not exceed browser height
					fit_landscape			:   0,		//Landscape images will not exceed browser width

					//Components
					navigation              :   1,		//Slideshow controls on/off
					thumbnail_navigation    :   1,		//Thumbnail navigation
					slide_counter           :   1,		//Display slide numbers
					slide_captions          :   1,		//Slide caption (Pull from "title" in slides array)
					slides 					:  	[		//Slideshow Images
														{image : 'assets/images/road.jpg', title : 'Slide 1'},
														{image : 'assets/images/road.jpg', title : 'Slide 2'},
														{image : 'assets/images/road.jpg', title : 'Slide 3'}
												]

				});
		    });

</script>
</body>
</html>
