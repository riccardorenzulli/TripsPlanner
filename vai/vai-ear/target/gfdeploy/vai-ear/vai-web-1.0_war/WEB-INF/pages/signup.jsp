<%-- 
    Document   : signup
    Created on : 31-mar-2018, 17.36.12
    Author     : giovannibonetta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST" action="signup" modelAttribute="user">
             <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="surname">Surname</form:label></td>
                    <td><form:input path="surname"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td><form:label path="repeatpassword">Repeat Password</form:label></td>
                    <td><form:input path="repeatpassword"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
                <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
        </form:form>
    </body>
</html>
