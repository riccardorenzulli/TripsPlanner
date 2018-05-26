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
                            <div id ="user-personal-info" class="user-personal-info">
                                <h4>Personal Informations</h4>
                                <div class="user-info-body">
                                        <div class="col-md-6 col-sm-6">
                                            <label>Name</label>
                                                <input id="name" type="text" name="name" required="" value="<%=((User)session.getAttribute("user")).getName()%>" class="form-control">
                                        </div>
                                        <div class="col-md-6 col-sm-6">
                                            <label>Surname</label>
                                                <input id="surname" type="text" name="surname" required="" value="<%=((User)session.getAttribute("user")).getSurname()%>" class="form-control">
                                        </div>
                                        <div class="clearfix"></div>
                                        <div class="col-md-12">
                                            <label>Email</label>
                                            <input disabled type="email" name="email" required="" value="<%=((User)session.getAttribute("user")).getEmail()%>" class="form-control">
                                        </div>

                                        <%
                                            if (((User)session.getAttribute("user")).getAge() != null) {
                                        %>

                                        <div class="col-md-6 col-sm-6">
                                            <label>Age</label>
                                            <input id="age" type="text" name="age" required="" value="<%=((User)session.getAttribute("user")).getAge()%>" class="form-control">
                                        </div>

                                        <%
                                            } else {
                                        %>

                                        <div class="col-md-6 col-sm-6">
                                            <label>Age</label>
                                            <input id="age" type="text" name="age" required="" value="18" class="form-control">
                                        </div>

                                        <% } %>

                                        <%
                                            if (((User)session.getAttribute("user")).getSex() != null) {
                                        %>

                                        <div class="col-md-6 col-sm-6">
                                            <label>Sex</label>
                                            <select id="sex" class="form-control" name="sex">
                                                <%
                                                    if (((String)(((User)session.getAttribute("user")).getSex())).equalsIgnoreCase("Male")) {
                                                %>
                                                <option selected>Male</option>
                                                <% } else {
                                                %>
                                                <option>Male</option>
                                                <% } %>
                                                <%
                                                    if (((String)(((User)session.getAttribute("user")).getSex())).equalsIgnoreCase("Female")) {
                                                %>
                                                <option selected>Female</option>
                                                <% } else {
                                                %>
                                                <option>Female</option>
                                                <% } %>
                                                <%
                                                    if (((String)(((User)session.getAttribute("user")).getSex())).equalsIgnoreCase("Other")) {
                                                %>
                                                <option selected>Other</option>
                                                <% } else {
                                                %>
                                                <option>Other</option>
                                                <% } %>
                                            </select>
                                        </div>

                                        <%
                                            } else {
                                        %>

                                        <div class="col-md-6 col-sm-6">
                                            <label>Sex</label>
                                            <select id="sex" class="form-control" name="sex">
                                                <option>Male</option>
                                                <option selected>Female</option>
                                                <option>Other</option>
                                            </select>
                                        </div>
                                        <% } %>


                                        <div class="clearfix"></div>
                                        <div class="col-md-6 col-sm-6 col-xs-6">
                                            <input id="savechanges" class="savechanges-button btn transition-effect" value="SAVE CHANGES" type="submit" onclick="modifyUserInfo()">
                                        </div>
                                </div>
                                <div id="logchanges" class="alert alert-success">
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
        <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>

    </body>
</html>
