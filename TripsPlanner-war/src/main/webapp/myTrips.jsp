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
        <script src="scripts/login.js"></script>
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
                    <div class="section-title text-center">
                        <h2>MY TRIPS</h2>
                    </div>
                    <!-- START: INDIVIDUAL LISTING AREA -->
                    <div class="col-md-12 holidays-listing">
                        <%
                            int count = 0;
                            List<Trip> trips = (List<Trip>) request.getAttribute("trips");
                            if (trips != null) {
                                for (Trip trip : trips) {
                        %>
                        <!-- START: HOLIDAYS GRID VIEW -->
                        <div class="col-md-3 col-sm-6">
                            <div class="holiday-grid-view">
                                <div class="holiday-header-wrapper">
                                    <div class="holiday-header">
                                        <div class="holiday-img">
                                            <img src="<%= trip.getDayPlaces(0).get(1).getPhotosUrl()%>" alt="cruise">
                                        </div>
                                        <div class="holiday-price">
                                            <h4><%= (int)trip.getHotel().getDayPrice()*trip.getItineraries().size()%>&euro;</h4>
                                            <h5><%= trip.getItineraries().size()%> Days</h5>
                                        </div>
                                        <div class="holiday-title">
                                            <h3><%= trip.getSearch().getDestinationCity()%></h3>
                                            <h5></h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="holiday-details">
                                    <div class="col-md-4 col-sm-4 col-xs-4">
                                        <h5>Date</h5>
                                    </div>
                                    <div class="col-md-8 col-sm-8 col-xs-8">
                                        <p>From <%= trip.getSearch().getDepartureDate().toString()%> to <%=trip.getSearch().getReturnDate().toString() %></p>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="col-md-4 col-sm-4 col-xs-4">
                                        <h5>Inclusion</h5>
                                    </div>
                                    <div class="col-md-8 col-sm-8 col-xs-8">
                                        <p>
                                            <i class="fa fa-plane" title="Flight"></i>
                                            <i class="fa fa-bed" title="Hotel"></i>
                                            <i class="fa fa-cutlery" title="Meal"></i>
                                            <i class="fa fa-taxi" title="Transport"></i>
                                            <i class="fa fa-eye" title="Sightseeing"></i></p>
                                    </div>
                                    <div class="col-md-4 col-sm-4 col-xs-4">
                                        <h5>Highlight</h5>
                                    </div>
                                    <div class="col-md-8 col-sm-8 col-xs-8">
                                        <p class="sm-text">Lorem Ipsum is simply dummy text of the printing industry.</p>
                                    </div>
                                </div>
                                <div class="holiday-footer text-center">
                                    <div class="col-md-8 col-sm-8 col-xs-8 view-detail">
                                        <a href="#">VIEW DETAILS</a>
                                    </div>
                                    <div class="col-md-4 col-sm-4 col-xs-4 social">
                                        <a href="ControllerServlet?action=delete-trip&id=<%=trip.getId()%>"><i class="fa fa-trash-o"></i></a>
                                        <i class="fa fa-share-alt"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                            count++;
                            if (count % 4 == 0) {
                        %>
                        <div class="clearfix-sm clearfix"></div>
                        <%
                            }
                        %>

                        <!-- END: HOTEL GRID VIEW -->
                        <%
                                }
                            }
                        %>

                        <!-- START: PAGINATION -->
                        <div class="clearfix-sm clearfix"></div>
                        <div class="bottom-pagination">

                        </div>
                        <!-- END: PAGINATION -->
                    </div>
                    <!-- END: INDIVIDUAL LISTING AREA -->
                </div>
            </div>
            <!-- END: LISTING AREA -->

            <!-- START: FOOTER -->
            <section id="footer">
                <footer>
                    <div class="row main-footer-sub">
                        <div class="container clear-padding">
                            <div class="col-md-7 col-sm-7">
                                <form >
                                    <label>SUBSCRIBE TO OUR NEWSLETTER</label>
                                    <div class="clearfix"></div>
                                    <div class="col-md-9 col-sm-8 col-xs-6 clear-padding">
                                        <input class="form-control" type="email" required placeholder="Enter Your Email" name="email">
                                    </div>
                                    <div class="col-md-3 col-sm-4 col-xs-6 clear-padding">
                                        <button type="submit"><i class="fa fa-paper-plane"></i>SUBSCRIBE</button>
                                    </div>
                                </form>
                            </div>
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
                                    <li><a href="#">Wonderful London</a></li>
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