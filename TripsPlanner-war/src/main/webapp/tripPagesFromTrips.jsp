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

        <style>

            #fixed {
                position: -webkit-sticky;
                position: sticky;
                top: 0;
                padding: 5px;
            }

        </style>
        
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
        <!-- margin to the map -->
        <link href="assets/css/addmargintomap.css" rel="stylesheet">

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
        <script src="assets/js/googleMapTrip.js"></script>
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
            <div class="row" style="background-color: #fafafa">
                <div class="container">	
                    <jsp:include page="dayContentFromTrips.jsp" /> 

                </div>
<!-- START: PAGINATION -->
                <div class="bottom-pagination">
                    
                    <nav class="pull-right">
                        <ul class="pagination pagination-lg">
                            <li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                                <%
                                    Trip trip = (Trip) request.getSession().getAttribute("trip");
                                    for (int i = 0; i < trip.getItineraries().size(); i++) {
                                        if (i == 0) {
                                %>
                            <li id="<%= "button" + i%>" class="active"><a href="#" onclick="showPage(<%= i%>,<%= trip.getItineraries().size()%>)"><%= i + 1%><span class="sr-only">(current)</span></a></li>
                                <%
                                } else {
                                %>
                            <li id="<%= "button" + i%>"><a href="#" onclick="showPage(<%= i%>,<%= trip.getItineraries().size()%>)"><%= i + 1%> <span class="sr-only">(current)</span></a></li>
                                <%
                                        }
                                    }
                                %>
                            <li><a href="#" aria-label="Previous"><span aria-hidden="true">&#187;</span></a></li>
                        </ul>
                    </nav>
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
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDj1R8HigvjL4UgHft-PPsfme65pvj846U&callback=initMap&libraries=drawing"
        async defer></script>
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