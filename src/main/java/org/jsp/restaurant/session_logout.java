package org.jsp.restaurant;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sessionlogout")
public class session_logout  extends HttpServlet{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   if(req.getSession().getAttribute("admin")==null)
		{
			resp.getWriter().print("<h1>Invalid Session</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else
		{
			req.getRequestDispatcher("add_item.html").include(req, resp);
		}
}
}
