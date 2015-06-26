package com.clickzilla.ee;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "this is a project to understand Servlet Context", urlPatterns = { "/ContextServlet" })
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			if(name != "" && name != null){
				
				//get the servlet context from the request object
				ServletContext context = request.getServletContext();
				
				//set the value to the servlet context
				context.setAttribute("name", name);
				response.sendRedirect("account.jsp");
			}else{
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
