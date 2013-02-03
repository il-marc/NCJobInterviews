/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k1x.j2ee.webiface.persistance.Users;

/**
 *
 * @author k1x
 */
public class SecretpageAction extends Action {

    @Override
    public String onPerform(HttpServletRequest request, HttpServletResponse response) {
         
        if(!getSessionData().isUserLoggedIn())
        return "/WEB-INF/error.jsp";   
        else
        return "/WEB-INF/secretpage.jsp";     
            
    }
    
}
