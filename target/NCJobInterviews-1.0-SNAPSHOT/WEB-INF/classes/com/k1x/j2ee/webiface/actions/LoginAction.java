/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.actions;

import com.k1x.j2ee.webiface.sessionutil.SessionData;
import com.k1x.j2ee.webiface.util.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k1x.j2ee.webiface.persistance.Calculations;
import com.k1x.j2ee.webiface.persistance.DbUtil;
import com.k1x.j2ee.webiface.persistance.Users;
import java.util.List;


/**
 *
 * @author k1x
 */
public class LoginAction extends Action {
  
	private Users iUser; 
	
	@Override
    public String onPerform(HttpServletRequest request, HttpServletResponse response) 
    {
        
		
		HttpSession session = request.getSession();
		
         String login = request.getParameter("login");
         String password = request.getParameter("password");
        
         boolean match = false;
         if(request.getParameter("submitButton")!=null)
         {
        	 
             List<Users> list= DbUtil.GetUsers(login);
             int i=0;
             for(Users user:(List<Users>)list)
             {
            	 iUser = user;
                 i++;
             }

             if(i==1)
             {
                 if(MD5.getHash(password).equals(iUser.getPassword())) match = true;
                 else session.setAttribute("errorMessage", LOGIN_ERR);
             }
             else if(i>1)             
             session.setAttribute("errorMessage", "This user has more than 1 record!");
             else 
             session.setAttribute("errorMessage", LOGIN_ERR);
         }

        
        if(match)
        {
        	iUser.setLoggedIn(true);

        	getSessionData().setUser(iUser);
        	
        	getSessionData().setMode(SessionData.CALCULATIONS_LIST);

            updateSessionData();

    		List<Calculations> calculations =  DbUtil.GetCalculations();

        }
        return "/index.jsp";
    }

	
    
    
}
