/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.actions;

/**
 *
 * @author k1x
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.k1x.j2ee.webiface.app.MainServlet;

public interface ActionIface {
	
	String ID = "id";
	String USERNAME = "username";
	String PASSWORD = "password";
    String LOGIN_ERR = "Invalid username or password!";
        
	public String perform(HttpServletRequest request, HttpServletResponse response, MainServlet srvlet);
}