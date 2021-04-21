package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.AdminDao;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Register() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		
		AdminDao d = new AdminDao();
		d.updateadmin(username, password);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("login.html");
		rd.include(request,response);
		out.println("<h2>new username and password updated sucessfully<h2>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
