<%-- 
    Document   : register
    Created on : 23-Apr-2012, 16:55:55
    Author     : k1x
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
       <img src="favtlogo.gif" />  
        <h1>Registration</h1>
    <% 
     String errorMessage=(String)session.getAttribute("errorMessage");; 
     if(errorMessage!=null) out.println(errorMessage);
     %>
        <form name="form1" method="post" action="register.perform">
            <input type="hidden" name="registerform" value="registerform">

                             Login:<br>
            <input type="text" name="login" id="login">
 			<br>Password:<br>
            <input type="password" name="password" id="password">
 			<br>Re-enter password:<br>
            <input type="password" name="repsw" id="repsw">
			<br>Full name:<br>
            <input type="text" name="fullname" id="fullname">
            <br>
            <input type="submit" name="submitButton" id="submitButton" value="Submit">
            
        </form>
        <% session.setAttribute("errorMessage",""); %>
    </body>
</html>
