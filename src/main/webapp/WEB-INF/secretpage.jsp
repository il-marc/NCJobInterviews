<%-- 
    Document   : secretpage
    Created on : 24-Apr-2012, 17:41:34
    Author     : k1x
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
  	  <jsp:useBean id="sessionData" scope="session" class="com.k1x.j2ee.webiface.sessionutil.SessionData"/>
 
       <img src="favtlogo.gif" />  
         <h1>Hello World!</h1>
         Hello, <%= sessionData.getUser().getName() %>!
         <br>
        This page shouldn't be seen by unregistered users.
        <br>
        <img src="/WebConnector/getimage.perform" />  
    </body>
</html>
