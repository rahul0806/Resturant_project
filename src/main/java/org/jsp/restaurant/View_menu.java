package org.jsp.restaurant;

import java.io.IOException;
import java.util.List;

import dao.mydao;
import dto.food_item;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewmenu")
public class View_menu  extends HttpServlet{

	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
	    

		if(req.getSession().getAttribute("admin")==null)
		{
			resp.getWriter().print("<h1>Invalid Session</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else
		{
		mydao dao=new mydao();
		List<food_item> items=dao.fetchAllfooditem();

		if(items.isEmpty())
		{
			resp.getWriter().print("<h1 style='color:red'> no item found</h1>)");
			req.getRequestDispatcher("Adminhome.html").include(req,resp);
		}
		else {
			req.setAttribute("list", items);
			req.getRequestDispatcher("ViewMenu.jsp").include(req,resp);
		}
	}}
     
	}


