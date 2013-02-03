         
	<%@ page import="com.k1x.j2ee.webiface.persistance.Users" %>
 	
	<%
	Users user = sessionData.getUser();
	boolean auth= user!=null; %>
          
            
     <% 
     String errorMessage=(String)session.getAttribute("errorMessage"); 
     if(errorMessage!=null) out.println(errorMessage);
     if(auth) { %>
     Hello, <%= user.getName() %>!
     <p><a href="logout.perform">LogOut</a></p>
     <p><a href="add_calculation.perform">Add Calculation</a></p>
     <p><a href="calculationslist.perform">Calculations List</a></p>
     <p><a href="secretpage.perform">Secret Page</a></p>
     <% } 
     else
        { 
     %>
   
    <form name="form1" method="post" action="login.perform">
       <input type="hidden" name="loginform" value="loginform">
       <p>
	login<br>
        <input name="login" type="text" id="login">
      </p>
      <p>
        password<br>
      </p>
      <p>
        <input name="password" type="password" id="password">
      </p>
      <p>
        
      </p><label>
          <input type="submit" name="submitButton" id="submit" value="Submit">
        </label>
    </form>
    <p><a href="register.jsp">Register</a></p>
    
    <% }
     session.setAttribute("errorMessage","");
     %>
    