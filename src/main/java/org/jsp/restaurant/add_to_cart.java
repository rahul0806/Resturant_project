package org.jsp.restaurant;

import java.io.IOException;

import dao.mydao;
import dto.Customer;
import dto.Cart;
import dto.food_item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addtocart")
public class add_to_cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Customer customer=(Customer)req.getSession().getAttribute("Customer");
    	if(customer==null)
 		{
 			resp.getWriter().print("<h1>Invalid Session</h1>");
 			req.getRequestDispatcher("Login.html").include(req, resp);
 		}
 		else
 		{
 			int id=Integer.parseInt(req.getParameter("id"));
 			mydao dao=new mydao();
 			food_item fooditem=dao.find(id);
 		    Cart cart= customer
    }
}
