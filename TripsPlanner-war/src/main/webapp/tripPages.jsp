<%@page import="com.tripsplanner.model.entity.Route"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tripsplanner.model.entity.Trip"%>
<%@page import="com.tripsplanner.model.entity.Place"%>
<%@page import="java.util.List"%>
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
        <script src="assets/js/sweetalert2.all.js" type="text/javascript"></script>
        <script src="assets/js/login.js"></script>
        <script src="assets/js/tripPage.js"></script>
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
            <!-- START: LISTING AREA-->
            <div class="row">
                <div class="container">	
                    <jsp:include page="dayContent.jsp" /> 
                </div>
            </div>
            <!-- END: LISTING AREA -->

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
        <script>

            /* Price Range Slider */

            $(function () {
                "use strict";
                $("#price-range").slider({
                    range: true,
                    min: 0,
                    max: 100,
                    values: [3, 50],
                    slide: function (event, ui) {
                        $("#amount").val("$ " + ui.values[ 0 ] + " - $ " + ui.values[ 1 ]);
                    }
                });
                $("#amount").val("$ " + $("#price-range").slider("values", 0) +
                        " - $ " + $("#price-range").slider("values", 1));
            });
        </script>
    </body>
</html>