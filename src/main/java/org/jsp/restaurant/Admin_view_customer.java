package org.jsp.restaurant;

import java.io.IOException;
import java.util.List;

import dao.mydao;
import dto.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewcustomer")

public class Admin_view_customer  extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		if(req.getSession().getAttribute("admin")==null)
		{
			resp.getWriter().print("<h1>Invalid Session</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else
		{
			
		mydao dao=new mydao();
		List<Customer> customers=dao.fetchAllCustomer();
		
		if(customers.isEmpty())
		{
			resp.getWriter().print("<h1 style='color:red'>No Customer Found</h1>");
			req.getRequestDispatcher("AdminHome.html").include(req, resp);
		}else {
		req.setAttribute("list",customers);
		req.getRequestDispatcher("view_customer.jsp").include(req, resp);
		}
		}
	}
		
	}


