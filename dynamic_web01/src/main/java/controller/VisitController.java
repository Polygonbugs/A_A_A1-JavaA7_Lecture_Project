package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		VisitService service = new VisitService();
		List<VisitDTO> visitList = service.getList();
		req.setAttribute("dataList", visitList);
		req.getRequestDispatcher("/WEB-INF/view/visit.jsp").forward(req, resp);
	}
	
	/**
	 * 방명록 작성 후 저장 요청이 있을 경우 사용하는 메서드
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VisitDTO dto = new VisitDTO();
		String nickname = req.getParameter("nickname");
		String context = req.getParameter("context");
		dto.setNickName(nickname);
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
