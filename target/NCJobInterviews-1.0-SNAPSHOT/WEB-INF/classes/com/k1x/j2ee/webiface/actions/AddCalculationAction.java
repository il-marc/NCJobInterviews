package com.k1x.j2ee.webiface.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.k1x.j2ee.webiface.persistance.CalcThreadDbUtil;
import com.k1x.j2ee.webiface.persistance.DbUtil;
import com.k1x.j2ee.webiface.persistance.Users;
import com.k1x.j2ee.webiface.sessionutil.SessionData;

public class AddCalculationAction extends Action 
{

	@Override
	public String onPerform(HttpServletRequest request,	HttpServletResponse response) {
			
			getSessionData().setMode(SessionData.ADD_CALCULATION);
		
			String name=request.getParameter("name");
			String n=request.getParameter("value_n");
			String k=request.getParameter("value_k");
			
			String submitBtn=request.getParameter("submitButton");
			
			Users user = getSessionData().getUser();
			
			if(user!=null && submitBtn!=null && user.isLoggedIn())
			{
				DbUtil.addCalculation(user, name, n,k);
				return "/calculationslist.perform";			
			}			
		
			return "/index.jsp";
	}

}
