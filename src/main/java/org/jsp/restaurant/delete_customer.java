package org.jsp.restaurant;

import java.io.IOException;

import dao.mydao;
import dto.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletecustomer")
public class delete_customer extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Getting Id from the URL
		int id=Integer.parseInt(req.getParameter("id"));

		if(req.getSession().getAttribute("admin")==null)
		{
			resp.getWriter().print("<h1>Invalid Session</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else
		{
		mydao dao=new mydao();
		//Finding object because remove method accepts object
		Customer customer=dao.findcustomer(id);
		dao.delete(customer);
		resp.getWriter().print("<h1 style='color:green'>Customer Data Deleted Successfully</h1>");
		req.getRequestDispatcher("viewcustomer").include(req, resp);
	}}
	}

