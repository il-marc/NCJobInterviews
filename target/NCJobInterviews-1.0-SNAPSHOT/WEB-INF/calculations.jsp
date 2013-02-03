<%-- 
    Document   : index
    Created on : 23-Apr-2012, 14:33:39
    Author     : k1x
--%>

<%@ taglib prefix="ex" uri="/WEB-INF/custom.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.k1x.j2ee.webiface.persistance.Calculations" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment</title>
    </head>
    <body>
	
	<% 
	if(calculationsList.isInitialized())
	{
	
	List<Calculations> calculations = calculationsList.getCalculationsList();
	%>
	<form name="form2" method="post" action="delete.perform">
	<table>
	
	<tr>
	<td>Id</td> 
	<td>Name</td> 
	<td> Uid </td> 
	<td> Data</td>
	<td> Complete</td>
	</tr>		
	
	</table>
	<input type="submit" name="submitButton" id="submitButton" value="Delete Selected">
	</form>
	<%
	}
	%>
	<ex:CalculationsTable/>        
   
    </body>

</html>
