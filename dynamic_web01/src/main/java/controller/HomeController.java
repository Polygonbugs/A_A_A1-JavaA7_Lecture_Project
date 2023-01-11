package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String color = req.getParameter("color");
		if(color == null) {
			color = "black";
		}
		req.setAttribute("color", color);
		req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);
	}
	
}
