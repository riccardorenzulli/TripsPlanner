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

<!-- START: USER PROFILE -->
<div class="row user-profile">
	<div class="container">

		<div class="col-md-12 col-sm-10">
					<div id="user-personal" class="col-md-6">
						<div class="user-personal-info">
							<h4>Personal Information</h4>
							<div class="user-info-body">
								<form>
									<div class="col-md-6 col-sm-6">
										<label>First Name</label>
										<input type="text" name="fname" required="" placeholder="First Name" class="form-control">
									</div>
									<div class="col-md-6 col-sm-6">
										<label>First Name</label>
										<input type="text" name="lname" required="" placeholder="Last Name" class="form-control">
									</div>
									<div class="clearfix"></div>
									<div class="col-md-12">
										<label>Email-ID</label>
										<input type="email" name="email" required="" placeholder="lenore@example.com" class="form-control">
									</div>
									<div class="col-md-12">
										<label>Contact Number</label>
										<input type="text" name="contact" required="" class="form-control">
									</div>
									<div class="col-md-12">
										<label>Date Of Birth</label>
										<div class="clearfix"></div>
										<div class="col-md-4 col-sm-4 col-xs-4 clear-padding">
											<select class="form-control" name="day">
												<option>Day</option>
												<option>01</option>
												<option>02</option>
												<option>03</option>
												<option>04</option>
												<option>05</option>
											</select>
										</div>
										<div class="col-md-4 col-sm-4 col-xs-4">
											<select class="form-control" name="month">
												<option>Month</option>
												<option>01</option>
												<option>02</option>
												<option>03</option>
												<option>04</option>
												<option>05</option>
											</select>
										</div>
										<div class="col-md-4 col-sm-4 col-xs-4 clear-padding">
											<select class="form-control" name="year">
												<option>Year</option>
												<option>1990</option>
												<option>1991</option>
												<option>1992</option>
												<option>1993</option>
												<option>1994</option>
											</select>
										</div>
									</div>
									<div class="col-md-12">
										<label>Current Address</label>
										<textarea placeholder="Your Current Address" id="current-address" class="form-control" rows="5"></textarea>
										<div class="col-md-6 col-sm-6 col-xs-6 clear-padding">
											<input type="text" name="zip-code" class="form-control" placeholder="Zip Code">
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<input type="text" name="zip-code" class="form-control" placeholder="City">
										</div>
										<div class="col-md-6 col-sm-6 clear-padding">
											<select class="form-control" name="country">
												<option>Country</option>
												<option>Australia</option>
												<option>India</option>
												<option>USA</option>
												<option>UK</option>
											</select>
										</div>
										<div class="col-md-6 col-sm-6">
											<select class="form-control" name="state">
												<option>State</option>
												<option>CA</option>
												<option>GA</option>
												<option>NY</option>
												<option>SA</option>
												<option>WA</option>
											</select>
										</div>
									</div>
									<div class="col-md-12">
										<label>Upload Avatar</label>
										<input type="file" name="profile-pic" class="upload-pic">
									</div>
									<div class="clearfix"></div>
									<div class="col-md-6 col-sm-6 col-xs-6 text-center">
										 <button type="submit">SAVE CHANGES</button>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-6 text-center">
										<a href="#">CANCEL</a>
									</div>
								</form>
							</div>
						</div>
					</div>
		</div>
	</div>
</div>
<!-- END: USER PROFILE -->
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

</body>
</html>
