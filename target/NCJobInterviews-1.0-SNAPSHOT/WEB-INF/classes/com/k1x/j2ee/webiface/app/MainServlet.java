package com.k1x.j2ee.webiface.app;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.k1x.j2ee.webiface.actions.ActionIface;
import com.k1x.j2ee.webiface.persistance.CalcThreadDbUtil;
import com.k1x.j2ee.webiface.sessionutil.SessionData;

import javax.servlet.ServletConfig;


public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected ActionFactory factory = new ActionFactory();
	
	private Application application;
	
    	protected String getActionName(HttpServletRequest request) 
    	{
    		String path = request.getServletPath();
    		return path.substring(1, path.lastIndexOf("."));
    	}
    	
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
         


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException         
    {
        ActionIface action = factory.create(getActionName(request));
        String url = action.perform(request, response, this);
        if (url != null)
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }


	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        	processRequest(request, response);
	}

	@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
