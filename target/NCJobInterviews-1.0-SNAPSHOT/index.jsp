<%-- 
    Document   : index
    Created on : 23-Apr-2012, 14:33:39
    Author     : k1x
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diana Web Connector</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        
    </head>
 
     <%@ page import="com.k1x.j2ee.webiface.sessionutil.SessionData" %>
  
     <jsp:useBean id="sessionData" scope="session" class="com.k1x.j2ee.webiface.sessionutil.SessionData"/>
    
    <body>
    
    
    <div id = "container">
    <div id = "header">
    <img src="favtlogo.gif" style = "float:left;" />
    <h1>Diana Web Connector</h1>
     </div>

    <div id="right_sidebar">	
	
	<%@include file="/WEB-INF/login.jspf"%>

    </div>
    <div id="content">     
	<%@include file="/WEB-INF/data.jspf"%>



	</div>	
	</div>
    
   
    </body>

</html>
