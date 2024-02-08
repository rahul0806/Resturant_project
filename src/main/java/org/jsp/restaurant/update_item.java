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
import jakarta.servlet.http.Part;

@WebServlet("/update")
@MultipartConfig
public class update_item extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int ID= Integer.parseInt( req.getParameter("ID"));
    String item_name= req.getParameter("name");
    double item_price= Double.parseDouble(req.getParameter("price"));
    int quantity=Integer.parseInt(req.getParameter("quantity"));
    String type=req.getParameter("type");
    Part part=req.getPart("img");
    byte[] image=null;
    mydao dao=new mydao();
    food_item item1=dao.find(ID);
    if(part==null)
    {
    	image=item1.getPicture();
    }
    else {
    image=new byte[req.getPart("img").getInputStream().available()];
    req.getPart("img").getInputStream().read(image);
    }
    food_item item=new food_item();
    item.setId(ID);
    item.setName(item_name);
    item.setPicture(image);
    item.setPrice(item_price);
    item.setStock(quantity);
    item.setType(type);
    
    mydao dao1=new mydao();
    dao1.update(item);
    resp.getWriter().print("<h1 sstyle='color:green'>Item Updated successfully</h1>");
    req.getRequestDispatcher("viewmenu").include(req,resp);
    
}
}
