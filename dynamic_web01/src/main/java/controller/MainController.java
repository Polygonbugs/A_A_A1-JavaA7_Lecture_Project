package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String cnt = req.getParameter("count");
		Integer iCnt = 0;
		if(cnt != null) {
			iCnt = Integer.parseInt(cnt);
		}
		req.setAttribute("iCnt", iCnt);
		
		req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
		
		// resp.setContentType("text/html; charset=utf-8");
		// resp.setCharacterEncoding("UTF-8");
		
		// resp.getWriter().print("<h1>GET 요청을 받았습니다.</h1>");
		// resp.getWriter().flush();
	}

}
