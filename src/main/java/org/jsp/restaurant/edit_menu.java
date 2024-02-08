package org.jsp.restaurant;

import java.io.IOException;

import dao.mydao;
import dto.food_item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class edit_menu extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if(req.getSession().getAttribute("admin")==null)
		{
			resp.getWriter().print("<h1>Invalid Session</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else
		{
	    int id=Integer.parseInt(req.getParameter("id"));
	    mydao dao=new mydao();
	    food_item item=dao.find(id);
	    
	    req.setAttribute("item", item);
	    req.getRequestDispatcher("edit.jsp").forward(req, resp);
	
}}
}
