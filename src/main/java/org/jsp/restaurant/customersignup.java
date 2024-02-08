package org.jsp.restaurant;

	import java.io.IOException;
	import java.time.LocalDate;
	import java.time.Period;

import dao.mydao;
import dto.Customer;
import jakarta.persistence.Column;
import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.MultipartConfig;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.http.Part;

	//This is to Map the action URL to this class(Should be Same as action - Case sensitive)
	@WebServlet("/signup")
	//To receive image we need to use this-enctype
	@MultipartConfig
	//This is to make Class as Servlet Class
	public class customersignup extends HttpServlet {
		@Override
		// When there is form and we want data to be secured so doPost
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// Logic to Receive Values from Front End
			String fullName = req.getParameter("name");
			String password = req.getParameter("pass");
			long mobile = Long.parseLong(req.getParameter("num"));
			String email = req.getParameter("email");
			LocalDate dob = LocalDate.parse(req.getParameter("date"));
			int age = Period.between(dob, LocalDate.now()).getYears();

			//Logic to Receive image and convert to byte[]
			Part pic = req.getPart("pic");
			byte[] picture=null;
			picture=new byte[pic.getInputStream().available()];
			pic.getInputStream().read(picture);
			
			 mydao m=new mydao();
			//logic to verify email and mobile number is not repeated
			if(m.fetchemail(email)==null && m.fetchmobile(mobile)==null)
			{
			
			Customer c=new Customer();
			 c.setName(fullName);
			 c.setAge(age);
			 c.setEmail(email);
			 c.setDob(dob);
			 c.setPassword(password);
			 c.setPicture(picture);
			 m.save(c);
			 resp.getWriter().print("<h1 style='color:red'>Account created successfully</h1>");
			 req.getRequestDispatcher("Login.html").include(req,resp);
			}
			 else
			 {
				 resp.getWriter().print("<h1 style='color:red'>Email and mobile already exist in the database</h1>");
				 req.getRequestDispatcher("sigin.html").include(req,resp);
			 }
			 
			
			 
			 
			 
			 
			 
		}
	}

