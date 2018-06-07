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

            /*      .room-info-wrapper:hover {
                    border: 1px solid #F19C4F;
                    box-shadow: 0px 0px 5px #F19C4F;}*/

            /*#fixed{ 
                position:fixed; 
                width:30%;}*/

            #fixed {
                position: -webkit-sticky;
                position: sticky;
                top: 0;
                padding: 5px;
            }

        </style>

        <title>TripsPlanner - Create fantastic trips</title>

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
        <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <!-- FONTS -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,800,700,600' rel='stylesheet' type='text/css'>

    </head>
    <body class="load-full-screen">

<div id="load_cont" class="coming-soon-wrapper full-screen">
            <div class="coming-soon full-screen">
                <div class="centered-box text-center">
                    <div class="logo">
                        <h2>TRIPSPLANNER</h2>
                    </div>
                    <div class="loading-animation">
                        <span><i class="fa fa-plane"></i></span>
                        <span><i class="fa fa-bed"></i></span>
                        <span><i class="fa fa-ship"></i></span>
                        <span><i class="fa fa-suitcase"></i></span>
                    </div>
                    <div class="search-title">
                        <p>We Are On It! Looking For The Best Trip For You. This Will Take Few Seconds.</p>
                    </div>
                    <p class="copyright">&copy; 2018 TripsPlanner</p>
                </div>
            </div>
        </div>
<div id="main_cont">
        <!-- BEGIN: SITE-WRAPPER -->
        <div class="site-wrapper">
            <jsp:include page="header.jsp" />
            <jsp:include page="nav.html"/>
            <div class="clearfix"></div>


            <!-- START: PAGE TITLE -->

            <!-- END: PAGE TITLE -->

            <!-- START: ROOM GALLERY -->

            <div class="row product-complete-info" style="background-color: #fafafa">
                <div id="wrap" class="container">
                    <div class="col-md-8 main-content">
                        <div class="room-complete-detail custom-tabs">

                            <div class="">

                                <div id="room-info" class="tab-pane fade in active">
                                    <h4 class="tab-heading">Hotels</h4>

                                    <%
                                        List<Hotel> hotels = (List<Hotel>) request.getSession().getAttribute("hotels");
                                        if (hotels != null) {
                                            for (Hotel hotel : hotels) {
                                    %>

                                    <div id="hotel_entry" class="room-info-wrapper" onclick="setPricesAndMarker(this)">
                                        <div class="col-md-4 col-sm-6 clear-padding">
                                            <img src="https://www.hotel-city47.com/wp-content/blogs.dir/864/files/deslizantehome/Hotel_city_habitacion_matrimonio_03.jpg" alt="cruise">
                                        </div>
                                        <div class="col-md-5 col-sm-6 room-desc">
                                            <h4> <%= hotel.getName()%> </h4>
                                            <h5> <%= hotel.getAddress()%> </h5>
                                            <p> <%= hotel.getRoomDescription()%> </p>
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
                                                <h3><%= hotel.getTotal()%>/<%= hotel.getCurrency()%> </h3>
                                            </div>
                                            <% if (hotel.isAvailable()) {%>
                                            <div class="book">
                                                <form action="ControllerServlet?action=tripHotel" method="post" onsubmit="loadingPage();">
                                                    <input id="list_id_choosed" name="list_id_choosed" type='hidden' value=<%=hotel.getList_id()%> />
                                                    <button type="submit" class="search-button btn transition-effect" name="act" value="choose">Choose</button>
                                                </form>
                                            </div>
                                            <% } else { %>
                                            <div class="" style="color:#f9676b">
                                                <h4>not available</h4>
                                            </div> 
                                            <% }%>
                                            <input id='lat' type='hidden' value='<%= hotel.getLatitude()%>'/>
                                            <input id='lon' type='hidden' value='<%= hotel.getLongitude()%>'/>
                                            <input id='total_price' type='hidden' value='<%= hotel.getTotal()%>'/>
                                            <input id='day_price' type='hidden' value='<%= hotel.getDayPrice()%>'/>
                                            <input id='adult_number' type='hidden' value='<%= hotel.getGuests()%>'/>
                                            <input id='list_id' type='hidden' value='<%= hotel.getList_id()%>'/>
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
                    <div id="fixed" class="col-md-4 hotel-detail-sidebar">

                        <div >

                            <div class="col-md-12 clear-padding">
                                <!--					<div class="map sidebar-item">
                                                                                <h5><i class="fa fa-map-marker"></i> Mall Road, Shimla, Himachal Pradesh, 176077</h5>
                                                                                <iframe class="hotel-map" src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJG1usnet4BTkRzQqb_Ys-JOg&amp;key=AIzaSyB6hgZM-ruUqTPVUjXGUR-vv7WRqc4MXjY" ></iframe>
                                                                        </div>-->
                                <div class="map sidebar-item">
                                    <div class="hotel-map">
                                        <div id="map"></div>
                                    </div>
                                </div>
                                <div class="sidebar-item">
                                    <h4><i class="fa fa-bookmark"></i>Price Details</h4>
                                    <div class="sidebar-body">
                                        <table class="table">
                                            <tbody><tr>
                                                    <td> Adult number</td>
                                                    <td id="adult_number_field">---</td>
                                                </tr>
                                                <tr>
                                                    <td>Base Amount</td>
                                                    <td id="base_amount_field">---</td>
                                                </tr>
                                                <tr>
                                                    <td>You Pay</td>
                                                    <td id="total_cost_field" style="font-weight: bold;">---</td>
                                                </tr>

                                            </tbody></table>
                                    </div>                                                   
                                </div>

                                <div>
                                    <form action="ControllerServlet?action=tripHotel" method="post" onsubmit="loadingPage();">
                                        <button type="submit" class="search-button btn transition-effect" name="act" value="skip" >Skip hotel</button>
                                    </form>
                                </div>
                                <div class="clearfix"></div>
                            </div>

                        </div>   

                    </div>
                </div>
            </div>
            <!-- END: ROOM GALLERY -->

            <!-- START: FOOTER -->
            <jsp:include page="footer.html" />
            <!-- END: FOOTER -->

        </div>
        <!-- END: SITE-WRAPPER -->
</div>
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
        <script src="assets/js/googleMapHotel.js"></script>
        <script src="assets/js/loadingPage.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDj1R8HigvjL4UgHft-PPsfme65pvj846U&callback=initMap&libraries=drawing"
        async defer></script>
        <script>
                                        $(window).load(function () {
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

