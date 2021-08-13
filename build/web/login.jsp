<%-- 
    Document   : login.jsp
    Created on : Jul 9, 2021, 5:58:00 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="boostrap.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='https://www.google.com/recaptcha/api.js'></script>
        <title>Login Page</title>
    </head>
    <body>
        <div class="container" style="margin-top: 10px;">
            <div class="row"
                 style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
                <div class="col-sm-12">
                    <form action="LoginController" method="POST">
                        <div class="form-group">
                            <label>User ID</label>
                            <input type="text" value=""
                                   class="form-control" name="txtUserID" placeholder="Enter userID">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" value=""
                                   class="form-control" name="txtPassword" placeholder="Enter password">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Login"/>
                        <input type="reset" class="btn btn-primary" value="Reset"/>
                        <c:if test="${requestScope.ERROR_LOGIN !=null}">
                            <script>alert("${requestScope.ERROR_LOGIN}")</script>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
