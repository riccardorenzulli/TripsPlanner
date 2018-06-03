<%-- 
    Document   : dayContent
    Created on : May 24, 2018, 2:48:14 PM
    Author     : the-silent-fox
--%>

<%@page import="java.util.List"%>
<%@page import="com.tripsplanner.model.entity.User"%>
<%@page import="com.tripsplanner.model.entity.Route"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tripsplanner.model.entity.Place"%>
<%@page import="com.tripsplanner.model.entity.Trip"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- START: INDIVIDUAL LISTING AREA -->
<div class="col-md-9 hotel-listing">

    <%
        Trip trip = (Trip) request.getSession().getAttribute("trip");
        int tripDays = trip.getItineraries().size();
        for (int k = 0; k < tripDays; k++) {
    %>
    <div id="<%= "page" + k%>" class="switchable col-md-12 clear-padding" <%= k == 0 ? "style='display:block;'" : "style='display:none;'"%>>
        <div class="text-center col-md-12">
            <h2>Day <%= k + 1%></h2>
        </div>
        <%

            List<Place> places = (List<Place>) trip.getDayPlaces(k);
            List<Route> legs = (List<Route>) trip.getItineraries().get(k).getLegs();

            for (int i = 0; i < places.size() - 1; i++) {
        %>

        <div class="hotel-list-view">
            <div class="wrapper">
                <div class="col-md-4 col-sm-6 switch-img clear-padding">
                    <img src="<%=places.get(i).getPhotosUrl()%>" alt="cruise">
                </div>
                <div class="col-md-5 col-sm-6 hotel-info">
                    <div>
                        <div class="hotel-header">
                            <h5>
                                <%= places.get(i).getName()%> #<%= i + 1%>
                            </h5>
                            <a href=javascript:void(0) onclick="setMarker(this,<%= k%>,<%= i%>)">
                                <p><i class="fa fa-map-marker"></i>
                                    <%= places.get(i).getAddress()%>
                                </p>
                                <input class='lat' type='hidden' value='<%= places.get(i).getLat()%>'/>
                                <input class='lon' type='hidden' value='<%= places.get(i).getLng()%>'/>
                            </a>
                        </div>

                        <div class="hotel-desc">
                            <p><%= places.get(i).getDescription()%></p>
                        </div>
                    </div>
                </div>
                <div class="clearfix visible-sm-block"></div>
                <div class="col-md-3 rating-price-box text-center clear-padding">
                    <input class="search-button btn transition-effect add_memory" type="button" value="Add Memory" onclick="openMemoryUpload(<%= k%>, <%= i%>)">
                    <input class="search-button btn transition-effect view_memory" type="button" value="View Memories" onclick="viewMemories(<%= k%>, <%= i%>)">
                </div>
            </div>
        </div>

        <div class="hotel-list-view directions">
            <div class="wrapper">
                <div class="col-md-1 col-sm-1"></div>
                <div class="col-md-5 col-sm-5 directions-border-left">
                    <p><%= legs.get(i).getInfo()%> <a href="<%= legs.get(i).getMapsDirections()%>" target="_blank">Get directions</a></p> 
                </div>
                <div class="col-md-6 col-sm-6"></div>
            </div>                                  
        </div>
        <%
            }
            int lastIndex = places.size() - 1;
        %>
        <div  class="hotel-list-view">    <!-- style="margin-bottom: 60px;"-->
            <div class="wrapper">
                <div class="col-md-4 col-sm-6 switch-img clear-padding">
                    <%
                        String urlPhoto = places.get(lastIndex).getPhotosUrl();
                        if (urlPhoto == null) {
                            urlPhoto = "http://newenglishtravel.com/wp-content/uploads/2015/11/the-best-travel-websites-in-the-world-1200x800.jpg";
                        }
                    %>

                    <img src="<%=urlPhoto%>" alt="place">
                </div>
                <div class="col-md-5 col-sm-6 hotel-info">
                    <div>
                        <div class="hotel-header">
                            <h5>
                                <%= places.get(lastIndex).getName()%> #<%= lastIndex + 1%>
                            </h5>
                            <a href=javascript:void(0) onclick="setMarker(this,<%= k%>,<%= lastIndex%>)">
                                <p><i class="fa fa-map-marker"></i>
                                    <%= places.get(lastIndex).getAddress()%>
                                </p>
                                <input class='lat' type='hidden' value='<%= places.get(lastIndex).getLat()%>'/>
                                <input class='lon' type='hidden' value='<%= places.get(lastIndex).getLng()%>'/>
                            </a>
                        </div>

                        <div class="hotel-desc">
                            <p><%= places.get(lastIndex).getDescription()%></p>
                        </div>
                    </div>
                </div>
                <div class="clearfix visible-sm-block"></div>
                <div class="col-md-3 rating-price-box text-center clear-padding">
                    <input class="search-button btn transition-effect add_memory" type="button" value="Add Memory" onclick="openMemoryUpload(<%= k%>, <%= lastIndex%>)">
                    <input class="search-button btn transition-effect view_memory" type="button" value="View Memories" onclick="viewMemories(<%= k%>, <%= lastIndex%>)">
                </div>
            </div>
            <input class='lat' type='hidden' value='<%= places.get(lastIndex).getLat()%>'/>
            <input class='lon' type='hidden' value='<%= places.get(lastIndex).getLng()%>'/>
        </div>
    </div>
    <%
        }
    %>                            
</div>
<div id="add_memory_div">
    <form action="" method="post" enctype="multipart/form-data" id="add_memory_form" class="box">
        <input type="text" id="description" name="description" placeholder="Write your description"/>
        <div id="upload-wrap">
            <div class="image-upload-wrap">
                <input class="file-upload-input" name="memoryIMG" type='file' onchange="readURL(this);" accept="image/*" />
                <div class="drag-text">
                    <h3>Drag and drop a file or select add Image</h3>
                </div>
            </div>
            <div class="file-upload-content">
                <img class="file-upload-image" src="#" alt="your image" />
                <div class="image-title-wrap">
                    <button type="button" onclick="removeUpload()" class="remove-image">Remove <span class="image-title">Uploaded Image</span></button>
                </div>
            </div>
            <button class="file-upload-btn" type="button" onclick="$('.file-upload-input').trigger('click')">Add Image</button>
        </div>
        <input class="search-button btn transition-effect" type="submit" value="Upload"/>
    </form>
</div>
<!-- END TRIP DIV -->

<div id="fixed" class="col-md-3 hotel-detail-sidebar">
    <div >
        <div class="col-md-12 clear-padding">
            <div class="map sidebar-item">
                <div class="hotel-map">
                    <div id="map"></div>
                </div>
            </div>
        </div>
    </div>   
</div>

