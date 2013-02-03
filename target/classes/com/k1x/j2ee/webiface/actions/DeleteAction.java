package com.k1x.j2ee.webiface.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.k1x.j2ee.webiface.persistance.Calculations;
import com.k1x.j2ee.webiface.persistance.CalcThreadDbUtil;
import com.k1x.j2ee.webiface.persistance.DbUtil;
import com.k1x.j2ee.webiface.persistance.Users;

public class DeleteAction extends Action {

	@Override
	public String onPerform(HttpServletRequest request,
			HttpServletResponse response) {
		Users user = getSessionData().getUser();
		String[] values = request.getParameterValues("selected");
		if(values!=null&&user.isLoggedIn())
		{
		int[] valuesint = new int[values.length];
		for(int i = 0; i<values.length;i++)
		valuesint[i] = Integer.valueOf(values[i]).intValue();
		
		List<Calculations> calcs = DbUtil.GetCalculations(valuesint);
		
		DbUtil.DeleteCalculations(valuesint);
		}
		return "/calculationslist.perform";
	}

}
