package org.jsp.restaurant;

import java.io.IOException;

import dao.mydao;
import dto.food_item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class delete_menu  extends HttpServlet{
     protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
    	int id=Integer.parseInt( req.getParameter("id"));
    	mydao dao=new mydao();
    	food_item item=dao.find(id);
    	dao.delete(item);
    	res.getWriter().print("<h1 style='color:green'>Data deleted successfully</h1>");
    	req.getRequestDispatcher("viewmenu").include(req, res);
     }
}
