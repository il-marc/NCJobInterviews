package com.k1x.j2ee.web;

/**
 * Created with IntelliJ IDEA.
 * User: k1x
 * Date: 29/11/12
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MyServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //      resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        String S = "Hello world from servlet";

        session.setAttribute("str", S);

    /*    out.println("Hello Servlet!");
        out.flush();
      */
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

   }

    @Override
    public void init() throws ServletException {
        super.init();    //To change body of overridden methods use File | Settings | File Templates.
    }



}
