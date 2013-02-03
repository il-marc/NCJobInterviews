   <%@ page import="com.k1x.j2ee.webiface.sessionutil.SessionData" %>
   <%@ page import="com.k1x.j2ee.webiface.persistance.Users" %>


	<%
      if(auth)
     {
    	 
		switch(sessionData.getMode())
		{
		case SessionData.ADD_CALCULATION:
		{
	%>
	<%@ include file = "/WEB-INF/add_calculation.jsp" %>    
	<%
			break;
		}
		case SessionData.CALCULATIONS_LIST:
		{
	%>
	<%@ include file = "/WEB-INF/calculations.jsp" %>    
	
	<%
			break;
		}
		case SessionData.REGISTER:
		{
	%>
	<%
			break;
		}
		
		}
    %>
    

    <%
     }
    %>