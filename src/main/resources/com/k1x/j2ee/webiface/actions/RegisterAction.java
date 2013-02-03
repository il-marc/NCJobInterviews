/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.k1x.j2ee.webiface.persistance.CalcThreadDbUtil;
import com.k1x.j2ee.webiface.persistance.DbUtil;
import com.k1x.j2ee.webiface.util.MD5;
import com.k1x.j2ee.webiface.util.Password;


/**
 *
 * @author k1x
 */
public class RegisterAction extends Action {


    @Override
    public String onPerform(HttpServletRequest request, HttpServletResponse response) 
    {
         HttpSession session = request.getSession();     

         String login=request.getParameter("login");
         String password=request.getParameter("password");
         String repsw=request.getParameter("repsw");
         String fullname=request.getParameter("fullname");
         String submitBtn=request.getParameter("submitButton");


         if(submitBtn!=null)          
         { 
     
         int strength=Password.strength(password);

         if(login.length()<4)
         {
             session.setAttribute("errorMessage", "Username is too short. It must contain at least 4 characters!");
             return "/register.jsp";
         }
         else if(DbUtil.CheckLogin(login)!=0)
         {
             session.setAttribute("errorMessage", "Username already exists!");
             return "/register.jsp";
         }
         else if(!password.equals(repsw))
         {
             session.setAttribute("errorMessage", "Passwords mismatch!");
             return "/register.jsp";
         }

         else if(strength<1)
         {
             session.setAttribute("errorMessage", "Your password has strength "+strength+". It must be at least 50.");
             return "/register.jsp";
         } 

         else 
         {
        	 DbUtil.addMember(login, MD5.getHash(password), fullname);
         
         session.setAttribute("name", login);
         session.setAttribute("password", String.valueOf(Password.strength(password)));
         return "/reg1.jsp"; 
         }
         }
         else return "/register.jsp";

    }
     
    }
  
 

       
 
    

