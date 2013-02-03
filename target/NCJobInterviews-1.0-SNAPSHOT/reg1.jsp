<%-- 
    Document   : reg1
    Created on : 23-Apr-2012, 20:38:07
    Author     : k1x
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Successful!</title>
    </head>
  
 <script>  
 
<!--  
<%  
String clock = request.getParameter( "clock" );  
if( clock == null ) clock = "10";  
%>  
var timeout = <%=clock%>;  
function timer()  
{  
if( timeout-- > 0 )  
{  
document.forma.clock.value = timeout;  
window.setTimeout( "timer()", 1000 );  
}  
else  
document.location.href="login.perform";
 
}  
//-->  
</script>  

    <body>
       <img src="favtlogo.gif" />  
     <%! boolean auth; %>
        User <%= session.getAttribute("name") %> has been successfully added to database.
        His(her) password has strength <%= session.getAttribute("password") %>
        <br>
         You'll be automatically redirected after:
        <form action="<%=request.getRequestURL()%>" name="forma">         
        Seconds remaining: <input type="text" name="clock" value=" <%=clock%>" style="border:0px solid white">  
        </form> 
        <br>
        Or use <a href="login.perform">direct link</a>
        <script>  
            timer();  
        </script>  
    </body>
</html>


 


