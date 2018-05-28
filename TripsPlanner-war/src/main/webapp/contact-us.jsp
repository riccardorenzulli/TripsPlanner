<%@page contentType="text/html" pageEncoding="UTF-8" import="com.tripsplanner.model.entity.*"%>
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
		<script src="assets/js/sweetalert2.all.js" type="text/javascript"></script>
		<script src="assets/js/login.js"></script>
		<script src="https://apis.google.com/js/platform.js" async defer></script>
		<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

	</head>
	<body class="load-full-screen">

		<!-- BEGIN: PRELOADER -->
		<div id="loader" class="load-full-screen">
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

			<!-- BEGIN: NAVIGATION -->
			<jsp:include page="header.jsp" />
		    <jsp:include page="nav.html"/>
			<!-- END: NAVIGATION -->
			<!-- START: PAGE TITLE -->
			<div class="row page-title">
				<div class="container clear-padding text-center flight-title">
					<h3>CONTACT US</h3>
					<h4 class="thank">Let's Get Connected</h4>
				</div>
			</div>
			<!-- END: PAGE TITLE -->

			<!-- START: CONTACT-US -->
			<div class="row contact-address">
				<div class="container clear-padding">
					<div class="text-center">
						<h2>GET IN TOUCH</h2>
						<h5>Thank you for using and supporting our website. If you need help just send us an email. We'll answers as soon as we can.</h5>
						<div class="space"></div>
						<div class="col-md-4 col-sm-4">
							<i class="fa fa-map-marker"></i>
							<p>Via Pessinetto 12, Turin, IT</p>
						</div>
						<div class="col-md-4 col-sm-4">
							<i class="fa fa-envelope-o"></i>
							<p><a href="mailto:tripsplanner@gmail.com">tripsplanner@gmail.com</a></p>
						</div>
						<div class="col-md-4 col-sm-4">
							<i class="fa fa-phone"></i>
							<p>+91 1234567890</p>
						</div>
					</div>
				</div>
			</div>
			<!-- END: CONTACT-US -->
			<!-- START: MAP & CONTACT FORM -->
			<div class="row">
				<div id="contact-container" class="container clear-padding">
					<div class="col-md-6 col-sm-6">
						<iframe class="contact-map" src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJ73xxq7JtiEcRntjYqj2OWkA&amp;key=AIzaSyB6hgZM-ruUqTPVUjXGUR-vv7WRqc4MXjY"></iframe>
					</div>
					<div class="col-md-6 col-sm-6 contact-form">
						<div class="col-md-12">
							<h2>DROP A MESSAGE</h2>
							<h5>Drop Us a Message</h5>
						</div>
						<form >
							<div class="col-md-6 col-sm-6">
								<input type="text" name="name" required class="form-control" placeholder="Your Name">
							</div>
							<div class="col-md-6 col-sm-6">
								<input type="email" name="email" required class="form-control" placeholder="Your Email">
							</div>
							<div class="clearfix"></div>
							<div class="col-md-12">
								<input type="text" name="message-title" required class="form-control" placeholder="Message Title">
							</div>
							<div class="clearfix"></div>
							<div class="col-md-12">
								<textarea class="form-control" rows="5" id="comment" placeholder="Your Message"></textarea>
							</div>
							<div class="clearfix"></div>
							<div class="text-center">
								<button type="submit" class="btn btn-default submit-review">SEND YOUR MESSAGE</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- END: MAP & CONTACT FORM -->

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
	<script src="assets/js/js.js"></script>
	<script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>

	</body>
</html>
