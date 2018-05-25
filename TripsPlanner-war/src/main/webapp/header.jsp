<%@page contentType="text/html" pageEncoding="UTF-8" import="com.tripsplanner.model.entity.*"%>

<div class="site-wrapper">
    <div class="row transparent-menu-top">
        <div id="header" class="container clear-padding">
            <div class="navbar-contact">
                <div class="col-md-7 col-sm-6 clear-padding"></div>
                <div class="col-md-5 col-sm-6 clear-padding search-box">
                    <div id="user-detnav" class="col-md-6 col-xs-7 clear-padding user-logged" style="float: right;">
                        <%
                           if((User)session.getAttribute("user") != null) {
                        %>
                        <a href="ControllerServlet?action=user-info" class="transition-effect">
                            <img id="profile-pic" src="<%=((User)session.getAttribute("user")).getImgURL()%>" alt="profile pic">
                            Hi, <%=((User)session.getAttribute("user")).getName()%>!
                        </a>
                        <a href="#" onclick="genericLogout('<%=(String)session.getAttribute("typeLogin")%>')" class="transition-effect">
                            <i class="fa fa-sign-out"></i>
                            Logout
                        </a>
                        <% } else {
                        %>
                        <a href="ControllerServlet?action=login" class="transition-effect">
                            <i class="fa fa-sign-out"></i>
                            Login
                        </a>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
