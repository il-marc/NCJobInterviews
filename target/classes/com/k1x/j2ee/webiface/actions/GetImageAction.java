/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.actions;


import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;
import javax.servlet.*;

/**
 *
 * @author k1x
 */
public class GetImageAction extends Action {
    private ServletOutputStream out;
    private FileInputStream in;
	private ServletContext context;
    @Override
    public String onPerform(HttpServletRequest request, HttpServletResponse response) {
                 //your image servlet code here
  	
        response.setContentType("image/jpeg");

        File file = new File(getContext().getRealPath("/") + "/WEB-INF/img/napoleon.jpg");
        response.setContentLength((int)file.length());

        // Open the file and output streams
        try {
            in = new FileInputStream(file);
            out = response.getOutputStream();
          // Copy the contents of the file to the output stream
          byte[] buf = new byte[1024];
           int count = 0;
            while ((count = in.read(buf)) >= 0) 
            out.write(buf, 0, count);
            in.close();
            out.close();
         } catch (IOException ex) 
        {
            Logger.getLogger(GetImageAction.class.getName()).log(Level.SEVERE, null, ex);
        }
           return "/";
    } 
             
    
}
