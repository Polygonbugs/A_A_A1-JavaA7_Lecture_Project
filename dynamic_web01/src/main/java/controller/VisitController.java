package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.dto.UserDTO;
import model.dto.VisitDTO;
import model.service.VisitService;

/**
 * 방명록을 위한 컨트롤러
 * @author user1
 */
public class VisitController extends HttpServlet {

	/**
	 * 방명록 페이지 요청이 있을 경우 사용하는 메서드
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNumber = req.getParameter("p");
		int pNum;
		if(pageNumber == null || pageNumber.isEmpty()) {
			pNum = 1;
		} else {
			pNum = Integer.parseInt(pageNumber);
		}

		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("cnt")){
				cookie = c;
			}
		}

		String cnt = req.getParameter("cnt");
		if(cnt != null) {
			if(cnt.isEmpty()) {
				if(cookie != null) {
					cnt = cookie.getValue();
				} else {
					cnt = "10";	// 초기값
				}
			}
		} else {
			if(cookie != null) {
				cnt = cookie.getValue();
			} else {
				cnt = "10";
			}
		}

		cookie = new Cookie("cnt", cnt);
		cookie.setMaxAge(60 * 60 * 24 * 5);
		resp.addCookie(cookie);

		VisitService service = new VisitService();
		List<VisitDTO> visitList = service.getPage(pNum, Integer.parseInt(cnt));
		List<Integer> pageList = service.getPageList(Integer.parseInt(cnt));
		int lastPageNumber = service.getLastPageNumber(Integer.parseInt(cnt));

		req.setAttribute("dataList", visitList);
		req.setAttribute("pageList", pageList);
		req.setAttribute("lastPageNumber", lastPageNumber);
		req.setAttribute("cnt", cnt);
		req.getRequestDispatcher("/WEB-INF/view/visit.jsp").forward(req, resp);
	}
	
	/**
	 * 방명록 작성 후 저장 요청이 있을 경우 사용하는 메서드
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if(session.getAttribute("login") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		UserDTO userData = (UserDTO)session.getAttribute("user");

		VisitDTO dto = new VisitDTO();
		String nickname = req.getParameter("nickname");
		String context = req.getParameter("context");
		dto.setUserId(userData.getUserId());
		dto.setContext(context);
		
		VisitService service = new VisitService();
		boolean result = service.add(dto);
		
		if(result) {
			resp.sendRedirect("./visit");
		} else {
			//req.getRequestDispatcher("/WEB-INF/view/fail.jsp").forward(req, resp);
			resp.sendRedirect("./fail");
		}
	}
}
