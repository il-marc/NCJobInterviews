package com.k1x.j2ee.webiface.app;

public class Application {

	
	private MainServlet servlet;

	public Application(MainServlet servlet)
	{
		this.setServlet(servlet);
	}

	public MainServlet getServlet() {
		return servlet;
	}

	public void setServlet(MainServlet servlet) {
		this.servlet = servlet;
	}
}
