package org.jsp.restaurant;
import java.io.IOException;

import dao.mydao;
import dto.food_item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/add_product")
@MultipartConfig
public class add_item  extends HttpServlet{
      protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
      {
    	    String item_name= req.getParameter("name");
    	    double item_price= Double.parseDouble(req.getParameter("price"));
    	    int quantity=Integer.parseInt(req.getParameter("quantity"));
    	    String type=req.getParameter("type");
    	    byte[] image=new byte[req.getPart("img").getInputStream().available()];
    	    req.getPart("img").getInputStream().read(image);
    	    food_item item=new food_item();
    	    item.setName(item_name);
    	    item.setPicture(image);
    	    item.setPrice(item_price);
    	    item.setQuantity(quantity);
    	    item.setType(type);
    	    
    	  
    	    mydao dao=new mydao();
    	    dao.save(item);
    	    
    	    resp.getWriter().print("<h1 sstyle='color:green'>Item added successfully</h1>");
    	    req.getRequestDispatcher("Adminhome.html").include(req, resp);
    	    
      }
}
