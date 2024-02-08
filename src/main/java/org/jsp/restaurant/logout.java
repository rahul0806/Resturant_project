package org.jsp.restaurant;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class logout extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getSession().invalidate();
	resp.getWriter().print("<h1 style='color:red'>LOGOUT SUCCESSFULLY </h1>");
	req.getRequestDispatcher("home.html").include(req, resp);
}
}
