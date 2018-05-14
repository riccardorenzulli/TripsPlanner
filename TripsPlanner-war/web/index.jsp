<%--
    Document   : index
    Created on : 11-mag-2018, 15.24.13
    Author     : giovannibonetta
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
		<link href="assets/css/animate.min.css" rel="stylesheet">
		<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">
		<link href="assets/css/owl.carousel.css" rel="stylesheet">
		<link href="assets/css/owl-carousel-theme.css" rel="stylesheet">
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="assets/css/flexslider.css" rel="stylesheet" media="screen">
		<link href="assets/css/style.css" rel="stylesheet" media="screen">
		<!-- LIGHT -->
		<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
		<!-- FONTS -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,800,700,600" rel="stylesheet" type="text/css">

    <!-- SCRIPTS -->
		<script src="scripts/login.js"></script>
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

<%@include file="searchBox.html" %>

<!-- BEGIN: HOW IT WORK -->
<section id="how-it-work">
		<div class="row work-row">
			<div class="container">
				<div class="section-title text-center">
					<h2>HOW IT WORKS?</h2>
					<h4>SEARCH - SELECT - BOOK</h4>
					<div class="space"></div>
					<p>
						Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.<br>
						Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
					</p>
				</div>
				<div class="work-step">
					<div class="col-md-4 col-sm-4 first-step text-center">
						<i class="fa fa-search"></i>
						<h5>SEARCH</h5>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
					</div>
					<div class="col-md-4 col-sm-4 second-step text-center">
						<i class="fa fa-heart-o"></i>
						<h5>SELECT</h5>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
					</div>
					<div class="col-md-4 col-sm-4 third-step text-center">
						<i class="fa fa-shopping-cart"></i>
						<h5>BOOK</h5>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
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
					<p>
						Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.<br>
						Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
					</p>
				</div>
				<div class="col-md-10 col-md-offset-1 on-top clear-padding">
					<div class="col-md-6 col-sm-6 td-product text-center clear-padding wow slideInUp" data-wow-delay="0.1s" style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
						<img src="assets/images/tour1.jpg" alt="cruise">
						<div class="overlay">
							<div class="wrapper">
								<h5>FRANCE</h5>
								<h3><span>ROMANTIC PARIS</span></h3>
								<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text.</p>
								<a href="#">KNOW MORE</a>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6 td-product text-center clear-padding wow slideInUp" data-wow-delay="0.2s" style="visibility: hidden; animation-delay: 0.2s; animation-name: none;">
						<img src="assets/images/tour1.jpg" alt="cruise">
						<div class="overlay">
							<div class="wrapper">
								<h5>BANGKOK</h5>
								<h3><span>DISENYLAND BANGKOK</span></h3>
								<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text.</p>
								<a href="#">KNOW MORE</a>
							</div>
						</div>
					</div>
					<div class="clearfix visible-md-block"></div>
					<div class="col-md-6 col-sm-6 td-product text-center clear-padding wow slideInUp" data-wow-delay="0.1s" style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
						<img src="assets/images/tour1.jpg" alt="cruise">
						<div class="overlay">
							<div class="wrapper">
								<h5>DUBAI</h5>
								<h3><span>SKY HIGH DUBAI</span></h3>
								<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text.</p>
								<a href="#">KNOW MORE</a>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6 td-product text-center clear-padding wow slideInUp" data-wow-delay="0.2s" style="visibility: hidden; animation-delay: 0.2s; animation-name: none;">
						<img src="assets/images/tour1.jpg" alt="cruise">
						<div class="overlay">
							<div class="wrapper">
								<h5>AUSTRIA</h5>
								<h3><span>HILLY VIEW</span></h3>
								<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text.</p>
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

<!-- BEGIN: RECENT BLOG POST -->
<section id="recent-blog">
	<div class="row top-offer hidden">
		<div class="container">
			<div class="section-title text-center">
				<h2>RECENT BLOG POSTS</h2>
				<h4>NEWS</h4>
			</div>
			<div class="owl-carousel owl-theme owl-loaded owl-responsive-1000 owl-hidden" id="post-list">






			<div class="owl-stage-outer"><div class="owl-stage" style="transform: translate3d(0px, 0px, 0px); transition: all 0s ease 0s; width: 65px;"><div class="owl-item active" style="width: 2.5px; margin-right: 30px;"><div class="owl-stage-outer"><div class="owl-stage" style="transform: translate3d(-1170px, 0px, 0px); transition: all 0s ease 0s; width: 4095px;"><div class="owl-item cloned" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: slideInUp;">
					<img src="assets/images/offer3.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item cloned" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.4s" style="visibility: visible; animation-delay: 0.4s; animation-name: slideInUp;">
					<img src="assets/images/offer4.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item cloned" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: slideInUp;">
					<img src="assets/images/offer3.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item cloned" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.6s" style="visibility: visible; animation-delay: 0.6s; animation-name: slideInUp;">
					<img src="assets/images/offer2.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item active" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: slideInUp;">
					<img src="assets/images/offer1.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item active" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.2s" style="visibility: visible; animation-delay: 0.2s; animation-name: slideInUp;">
					<img src="assets/images/offer2.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item active" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: slideInUp;">
					<img src="assets/images/offer3.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item active" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.4s" style="visibility: visible; animation-delay: 0.4s; animation-name: slideInUp;">
					<img src="assets/images/offer4.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: slideInUp;">
					<img src="assets/images/offer3.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.6s" style="visibility: visible; animation-delay: 0.6s; animation-name: slideInUp;">
					<img src="assets/images/offer2.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item cloned" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: slideInUp;">
					<img src="assets/images/offer1.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item cloned" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.2s" style="visibility: visible; animation-delay: 0.2s; animation-name: slideInUp;">
					<img src="assets/images/offer2.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item cloned" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: slideInUp;">
					<img src="assets/images/offer3.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div><div class="owl-item cloned" style="width: 262.5px; margin-right: 30px;"><div class="room-grid-view wow slideInUp animated" data-wow-delay="0.4s" style="visibility: visible; animation-delay: 0.4s; animation-name: slideInUp;">
					<img src="assets/images/offer4.jpg" alt="cruise">
					<div class="room-info">
						<div class="post-title">
							<h5>POST TITLE GOES HERE</h5>
							<p><i class="fa fa-calendar"></i> Jul 15, 2015</p>
						</div>
						<div class="post-desc">
							<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
						</div>
						<div class="room-book">
							<div class="col-md-8 col-sm-6 col-xs-6 clear-padding post-alt">
								<h5><i class="fa fa-comments"></i> 2 <i class="fa fa-share-alt"></i> 20 </h5>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6 clear-padding">
								<a href="#" class="text-center">MORE</a>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div></div></div></div></div><div class="owl-item active" style="width: 2.5px; margin-right: 30px;"><div class="owl-controls"><div class="owl-nav"><div class="owl-prev" style="display: none;">prev</div><div class="owl-next" style="display: none;">next</div></div><div style="" class="owl-dots"><div class="owl-dot active"><span></span></div><div class="owl-dot"><span></span></div></div></div></div></div></div><div class="owl-controls"><div class="owl-nav"><div class="owl-prev" style="display: none;">prev</div><div class="owl-next" style="display: none;">next</div></div><div style="" class="owl-dots"><div class="owl-dot active"><span></span></div></div></div></div>
		</div>
	</div>
</section>
<!-- END: RECENT BLOG POST -->

<!-- START: WHY CHOOSE US SECTION -->
<section id="why-choose-us">
	<div class="row choose-us-row">
		<div class="container clear-padding">
			<div class="light-section-title text-center">
				<h2>WHY CHOOSE US?</h2>
				<h4>REASONS TO TRUST US</h4>
				<div class="space"></div>
				<p>
					Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.<br>
					Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
				</p>
			</div>
			<div class="col-md-4 col-sm-4 wow slideInLeft" style="visibility: hidden; animation-name: none;">
				<div class="choose-us-item text-center">
					<div class="choose-icon"><i class="fa fa-suitcase"></i></div>
					<h4>Handpicked Tour</h4>
					<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
					<a href="#">KNOW MORE</a>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 wow slideInUp" style="visibility: hidden; animation-name: none;">
				<div class="choose-us-item text-center">
					<div class="choose-icon"><i class="fa fa-phone"></i></div>
					<h4>Dedicated Support</h4>
					<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
					<a href="#">KNOW MORE</a>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 wow slideInRight" style="visibility: hidden; animation-name: none;">
				<div class="choose-us-item text-center">
					<div class="choose-icon"><i class="fa fa-smile-o"></i></div>
					<h4>Lowest Price</h4>
					<p>Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
					<a href="#">KNOW MORE</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- END: WHY CHOOSE US SECTION -->

<!-- START: HOT  DEALS -->
<section>
	<div class="row hot-deals hidden">
		<div class="container clear-padding">
			<div class="section-title text-center">
				<h2>HOT DEALS</h2>
				<h4>SAVE MORE</h4>
			</div>
			<div role="tabpanel" class="text-center">
				<!-- BEGIN: CATEGORY TAB -->
				<ul class="nav nav-tabs" role="tablist" id="hotDeal">
					<li role="presentation" class="active text-center">
						<a href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">
							<i class="fa fa-bed"></i>
							<span>HOTELS</span>
						</a>
					</li>
					<li role="presentation" class="text-center">
						<a href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab">
							<i class="fa fa-suitcase"></i>
							<span>HOLIDAYS</span>
						</a>
					</li>
					<li role="presentation" class="text-center">
						<a href="#tab3" aria-controls="tab3" role="tab" data-toggle="tab">
							<i class="fa fa-plane"></i>
							<span>FLIGHTS</span>
						</a>
					</li>
					<li role="presentation" class="text-center">
						<a href="#tab4" aria-controls="tab4" role="tab" data-toggle="tab">
							<i class="fa fa-taxi"></i>
							<span>CARS</span>
						</a>
					</li>
					<li role="presentation" class="text-center">
						<a href="#tab5" aria-controls="tab5" role="tab" data-toggle="tab">
							<i class="fa fa-bed"></i>
							<span>HOTEL+FLIGHTS</span>
						</a>
					</li>
				</ul>
				<!-- END: CATEGORY TAB -->
				<div class="clearfix"></div>
				<!-- BEGIN: TAB PANELS -->
				<div class="tab-content">
					<!-- BEGIN: FLIGHT SEARCH -->
					<div role="tabpanel" class="tab-pane active fade in" id="tab1">
						<div class="col-md-6 hot-deal-list wow slideInLeft animated" style="visibility: visible; animation-name: slideInLeft;">
							<div class="item">
								<div class="col-xs-3">
									<img src="assets/images/offer1.jpg" alt="Cruise">
								</div>
								<div class="col-md-7 col-xs-6">
									<h5>Hotel Grand Lilly</h5>
									<p class="location"><i class="fa fa-map-marker"></i> New York, USA</p>
									<p class="text-sm">Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
								</div>
								<div class="col-md-2 col-xs-3">
									<h4>$499</h4>
									<h6>Per Night</h6>
									<a href="#">BOOK</a>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="item">
								<div class="col-xs-3">
									<img src="assets/images/offer2.jpg" alt="Cruise">
								</div>
								<div class="col-md-7 col-xs-6">
									<h5>Royal Resort</h5>
									<p class="location"><i class="fa fa-map-marker"></i> New York, USA</p>
									<p class="text-sm">Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
								</div>
								<div class="col-md-2 col-xs-3">
									<h4>$399</h4>
									<h6>Per Night</h6>
									<a href="#">BOOK</a>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="item">
								<div class="col-xs-3">
									<img src="assets/images/offer3.jpg" alt="Cruise">
								</div>
								<div class="col-md-7 col-xs-6">
									<h5>Hotel Grand Lilly</h5>
									<p class="location"><i class="fa fa-map-marker"></i> New York, USA</p>
									<p class="text-sm">Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
								</div>
								<div class="col-md-2 col-xs-3">
									<h4>$499</h4>
									<h6>Per Night</h6>
									<a href="#">BOOK</a>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-6 hot-deal-grid wow slideInRight animated" style="visibility: visible; animation-name: slideInRight;">
							<div class="col-sm-6 item">
								<div class="wrapper">
									<img src="assets/images/tour1.jpg" alt="Cruise">
									<h5>Paris Starting From $49/Night</h5>
									<a href="#">DETAILS</a>
								</div>
							</div>
							<div class="col-sm-6 item">
								<div class="wrapper">
									<img src="assets/images/tour1.jpg" alt="Cruise">
									<h5>Bangkok Starting From $69/Night</h5>
									<a href="#">DETAILS</a>
								</div>
							</div>
							<div class="col-sm-6 item">
								<div class="wrapper">
									<img src="assets/images/tour1.jpg" alt="Cruise">
									<h5>Dubai Starting From $99/Night</h5>
									<a href="#">DETAILS</a>
								</div>
							</div>
							<div class="col-sm-6 item">
								<div class="wrapper">
									<img src="assets/images/tour1.jpg" alt="Cruise">
									<h5>Italy Starting From $59/Night</h5>
									<a href="#">DETAILS</a>
								</div>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="tab2">
						<div class="col-md-6 hot-deal-list">
							<div class="item">
								<div class="col-xs-3">
									<img src="assets/images/offer3.jpg" alt="Cruise">
								</div>
								<div class="col-md-7 col-xs-6">
									<h5>Hotel Grand Lilly</h5>
									<p class="location"><i class="fa fa-map-marker"></i> New York, USA</p>
									<p class="text-sm">Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
								</div>
								<div class="col-md-2 col-xs-3">
									<h4>$499</h4>
									<h6>Per Night</h6>
									<a href="#">BOOK</a>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="item">
								<div class="col-xs-3">
									<img src="assets/images/offer2.jpg" alt="Cruise">
								</div>
								<div class="col-md-7 col-xs-6">
									<h5>Royal Resort</h5>
									<p class="location"><i class="fa fa-map-marker"></i> New York, USA</p>
									<p class="text-sm">Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
								</div>
								<div class="col-md-2 col-xs-3">
									<h4>$399</h4>
									<h6>Per Night</h6>
									<a href="#">BOOK</a>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="item">
								<div class="col-xs-3">
									<img src="assets/images/offer1.jpg" alt="Cruise">
								</div>
								<div class="col-md-7 col-xs-6">
									<h5>Hotel Grand Lilly</h5>
									<p class="location"><i class="fa fa-map-marker"></i> New York, USA</p>
									<p class="text-sm">Lorem Ipsum is simply dummy text. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
								</div>
								<div class="col-md-2 col-xs-3">
									<h4>$499</h4>
									<h6>Per Night</h6>
									<a href="#">BOOK</a>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-6 hot-deal-grid">
							<div class="col-sm-6 item">
								<div class="wrapper">
									<img src="assets/images/tour1.jpg" alt="Cruise">
									<h5>Paris Starting From $49/Night</h5>
									<a href="#">DETAILS</a>
								</div>
							</div>
							<div class="col-sm-6 item">
								<div class="wrapper">
									<img src="assets/images/tour1.jpg" alt="Cruise">
									<h5>Bangkok Starting From $69/Night</h5>
									<a href="#">DETAILS</a>
								</div>
							</div>
							<div class="col-sm-6 item">
								<div class="wrapper">
									<img src="assets/images/tour1.jpg" alt="Cruise">
									<h5>Dubai Starting From $99/Night</h5>
									<a href="#">DETAILS</a>
								</div>
							</div>
							<div class="col-sm-6 item">
								<div class="wrapper">
									<img src="assets/images/tour1.jpg" alt="Cruise">
									<h5>Italy Starting From $59/Night</h5>
									<a href="#">DETAILS</a>
								</div>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="tab3">
						Lorem Lpsum 3
					</div>
					<div role="tabpanel" class="tab-pane" id="tab4">
						Lorem Lpsum 4
					</div>
					<div role="tabpanel" class="tab-pane" id="tab5">
						Lorem Lpsum 5
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- END: HOT DEALS -->

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
