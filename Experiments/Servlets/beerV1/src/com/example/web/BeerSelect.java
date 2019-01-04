package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.model.*;

public class BeerSelect extends HttpServlet {
	
		public void doPost(HttpServletRequest request,
						HttpServletResponse response)
						throws IOException, ServletException {
		
			
			//response.setContentType("text/html");
			//PrintWriter out = response.getWriter();
			//out.println("Beer Selection Advice<br>");
			/*List advice = BeerExpert.getBrands(request.getParameter("color"));
			out.println("<br>Beer advice: ");
			for(int i = 0; i < advice.size(); i++)
				out.println("<br>" + advice.get(i));*/
			List advice = BeerExpert.getBrands(request.getParameter("color"));
			request.setAttribute("styles", advice);
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}
}