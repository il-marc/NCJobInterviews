package com.k1x.j2ee.webiface.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k1x.j2ee.webiface.app.Application;
import com.k1x.j2ee.webiface.app.MainServlet;
import com.k1x.j2ee.webiface.sessionutil.SessionData;

public abstract class Action implements ActionIface {

    private final String SESSIONATTR = "sessionData";

	private MainServlet servlet;
	private HttpSession session;
	private ServletContext context;
	private Application application;
	private SessionData sessionData;
	private boolean redirect;



	@Override
	public final String perform(HttpServletRequest request, HttpServletResponse response, MainServlet srvlet) {
		
			
		
			setServlet(srvlet);
			setSession(request.getSession(true));

			setContext(srvlet.getServletContext());

			setRedirect(true);


            session = request.getSession(false);
            if(session != null)
            {
                sessionData = (SessionData) session.getAttribute(SESSIONATTR);
                if(sessionData == null)
                {
                    sessionData = new SessionData();
                    sessionData.setSessionID(request.getRequestedSessionId());
                    updateSessionData();
                }
            }
            else
            {
                session = request.getSession(true);
                sessionData = new SessionData();
                sessionData.setSessionID(request.getRequestedSessionId());
                sessionData.setMode(SessionData.CALCULATIONS_LIST);
                updateSessionData();
            }

			return onPerform(request, response);
	}
	
	public abstract String onPerform(HttpServletRequest request, HttpServletResponse response);

	public MainServlet getServlet() {
		return servlet;
	}

	public void setServlet(MainServlet servlet) {
		this.servlet = servlet;
	}

    public void updateSessionData() {
        if(session!=null)
           session.setAttribute(SESSIONATTR, sessionData);
      }


    public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public SessionData getSessionData() {
		return sessionData;
	}

	public void setSessionData(SessionData sessionData) {
		this.sessionData = sessionData;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}





}
