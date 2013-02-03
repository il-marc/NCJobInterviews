/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.k1x.j2ee.webiface.persistance.Users;

/**
 *
 * @author k1x
 */
public class LogoutAction extends Action {

	Users iUser;
	
    @Override
    public String onPerform(HttpServletRequest request, HttpServletResponse response) 
    {
    	getSession().invalidate();

        return "/index.jsp";
    }
    
}
