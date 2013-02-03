package com.k1x.j2ee.webiface.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.k1x.j2ee.webiface.persistance.Calculations;
import com.k1x.j2ee.webiface.persistance.CalcThreadDbUtil;
import com.k1x.j2ee.webiface.persistance.DbUtil;
import com.k1x.j2ee.webiface.sessionutil.SessionData;

public class ViewCalculationAction extends Action 
{

	@Override
	public String onPerform(HttpServletRequest request,
			HttpServletResponse response) {

		String idStr = request.getParameter("id");
		String uidStr = request.getParameter("uid");
		int id;
		int uid;
		try
		{
		id = Integer.parseInt(idStr);
		uid = Integer.parseInt(uidStr);


		Calculations calculation = DbUtil.GetCalculation(id);
		getSessionData().setMode(SessionData.VIEW_CALCULATION);		
		getSession().setAttribute("calculation", calculation);
		updateSessionData();
					
		return "/index.jsp";
		}
		catch (Exception E)
		{
			E.printStackTrace();
			getSessionData().setMode(SessionData.CALCULATIONS_LIST);
            updateSessionData();
			return "/index.jsp";
		}
		

	}

}
