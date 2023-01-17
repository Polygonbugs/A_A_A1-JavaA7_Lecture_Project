package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

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

		HttpSession session = req.getSession();
		System.out.println("로그인 상태: " + session.getAttribute("login"));
		System.out.println("계정 정보 : " + session.getAttribute("user"));
		/*Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			System.out.println(c.getName() + "|" + c.getValue());
		}*/

		req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
		
		// resp.setContentType("text/html; charset=utf-8");
		// resp.setCharacterEncoding("UTF-8");
		
		// resp.getWriter().print("<h1>GET 요청을 받았습니다.</h1>");
		// resp.getWriter().flush();
	}

}
