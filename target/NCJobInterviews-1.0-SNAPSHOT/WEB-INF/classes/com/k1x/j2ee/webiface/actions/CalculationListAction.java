package com.k1x.j2ee.webiface.actions;


import com.k1x.j2ee.webiface.sessionutil.SessionData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculationListAction extends Action {

	@Override
	public String onPerform(HttpServletRequest request,
			HttpServletResponse response) {

		getSessionData().setMode(SessionData.CALCULATIONS_LIST);
        updateSessionData();
		return "/index.jsp";
	}

}
