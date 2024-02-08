package org.jsp.restaurant;

import java.io.IOException;

import dao.mydao;
import dto.Customer;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/loginbutton")	
public class customerlogin extends HttpServlet {
     
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		String email=req.getParameter("mail");
		String password=req.getParameter("pass");
		mydao dao=new mydao();
		if(email.equals("admin@jsp.com") && password.equals("admin"))
		{
			
			
			resp.getWriter().print("<h1>login success</h1>");
			//getting and setting the attribute of the session
			HttpSession session=req.getSession();
			session.setAttribute("admin","admin");
			//this is logic to send to next page
			req.getRequestDispatcher("Adminhome.html").include(req,resp);
		}else {
		Customer customer=dao.fetchemail(email);
	
		if(customer==null)
		{
			resp.getWriter().print("<h1>Inavlid Email</h1>");
			req.getRequestDispatcher("Login.html").include(req,resp);
		}
		else
		{
			if(password.equals(customer.getPassword()))
			{
				resp.getWriter().print("<h1>login success</h1>");
				req.getRequestDispatcher("customer.html").include(req,resp);
			}
			else
			{
				resp.getWriter().print("<h1>Invalid password</h1>");
				req.getRequestDispatcher("Login.html").include(req,resp);
				
			}
		}
		}
	}
 }

