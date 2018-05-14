<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
	<link rel="stylesheet" type="text/css" href="assets/css/dummy.css" id="select-style">
	<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">

	<!-- FONTS -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,800,700,600' rel='stylesheet' type='text/css'>
</head>

<body class="load-full-screen">

<!-- BEGIN: SITE-WRAPPER -->
<jsp:include page="header.jsp" />


	<div class="clearfix"></div>
	<!-- START: PAGE TITLE -->

	<div id="login-container" class="container-fluid">
		<div id="login-card">
			<div class="row page-title">
				<div id="login-header" class="container clear-padding text-center flight-title">
					<h3>LOGIN/REGISTER</h3>
					<h4 class="thank">Manage Your Account</h4>
				</div>
			</div>
			<hr>
			<!-- END: PAGE TITLE -->

			<!-- START: LOGIN/REGISTER -->
			<div class="row login-row">
				<div id="login-body" class="container clear-padding">
					<div class="col-sm-4 col-sm-offset-4 login-form">
						<div id="fb-g-login">

							<div id="googlelogin" class="g-signin2" data-longtitle="true" data-onsuccess="doLoginGoogle" data-theme="light" style="margin-bottom: 5%"></div>

							<div id="facebookLogin">
								<a class="btn btn-block btn-social btn-facebook" style="background-color: #3b5998; color:white !important;" onclick="doLoginFB()">
										<div class="abcRioButtonIcon" style="float:left">
											<div style="width:18px;height:18px;" class="abcRioButtonSvgImageWithFallback abcRioButtonIconImage abcRioButtonIconImage18">
									    	<span class="fa fa-facebook" style=""></span>
											</div>
										</div>
									  <span id ="fb-signin">Sign in with Facebook</span>
								</a>
							</div>

						</div>


						<form id="hidden-form-g" action="LoginServlet?action=login-g" method="post">
						        <input type="hidden" id="idtoken" name="idtoken">
						        <input type="hidden" id="action" name="action">
						        <input type="hidden" id="id" name="id">
						        <input type="hidden" id="name" name="name">
						        <input type="hidden" id="surname" name="surname">
						        <input type="hidden" id="email" name="email">
						        <input type="hidden" id="imgURL" name="imgURL">

						 </form>

						<form id="hidden-form-f" action="LoginServlet?action=login-f" method="post">
						        <input type="hidden" id="idtoken" name="idtoken">
						        <input type="hidden" id="action" name="action">

						 </form>

					 </div>
				</div>
			</div>
		</div>
</div>
	<!-- END: LOGIN/REGISTER -->
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
<script src="assets/plugins/jquery.magnific-popup.min.js"></script>
<script src="assets/js/js.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="scripts/login.js"></script>

</body>

</html>
