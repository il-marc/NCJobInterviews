package com.k1x.j2ee.webiface.customtags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import com.k1x.j2ee.webiface.persistance.Calculations;
import com.k1x.j2ee.webiface.persistance.DbUtil;

import java.io.*;
import java.util.List;

public class TableTag extends SimpleTagSupport {


	
	public void doTag() throws JspException, IOException {

		PageContext pageContext = (PageContext) getJspContext();
		
	    JspWriter out = getJspContext().getOut();
	    out.println("Hello, Custom Tag!");
	    
		List<Calculations> calculations =  DbUtil.GetCalculations();
				
		try {
			for(Calculations calcItem: calculations)
			{
				out.println("<tr>");
				out.println("<td>" + calcItem.getId() +"</td>");
				out.println("<td>" + calcItem.getName() +"</td>");
				out.println("<td>" + calcItem.getUid() +"</td>");
				out.println("<td>" + calcItem.getN() +"</td>");
				out.println("<td>" + calcItem.getK() +"</td>");
				
				if(calcItem.getComplete()==1) 
				out.println("<td><a href=\"view_calculation.perform?id=" + calcItem.getId() + "&uid=" + calcItem.getUid() + "\">View Data</a></td>");
				else
				out.println("<td>" + calcItem.getData() + "</td>");
				
				out.println("<td>" + calcItem.getComplete() +"</td>");		
				out.println("<td><input type=\"checkbox\" name=\"selected\" value=\""+calcItem.getId()+"\"/></td></tr>");		
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }
	}
