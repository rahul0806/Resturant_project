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

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
	   
		mydao dao=new mydao();
		List<food_item> items=dao.fetchAllfooditem();
//		resp.getWriter().print("<html><body><h1>Menu</h1><body><html>");
//		resp.getWriter().print("<table border ='1'");
//		resp.getWriter().print
//		("<tr><th>Name</th><th>type</th><th>Price</th><Quantity</th><th>edit</th><th>delete</th><th>edit</th></tr>");
//		for (food_item item : items) {
//			resp.getWriter().print(
//					"<tr><th>"+item.getName()+"</th><th>"+item.getType()+"</th><th>"+item.getPrice()+"</th><th>"+item.getQuantity()+"</th><th><button>Edit</button></th><th><button>Delete</button></th></tr>");
//		}
//		resp.getWriter().print("</table></body></html>");
		if(items.isEmpty())
		{
			resp.getWriter().print("<h1 style='color:red'> no item found</h1>)");
			req.getRequestDispatcher("Adminhome.html").include(req,resp);
		}
		else {
			req.setAttribute("list", items);
			req.getRequestDispatcher("ViewMenu.jsp").include(req,resp);
		}
	}
     
	}


