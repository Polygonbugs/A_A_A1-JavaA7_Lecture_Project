package controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.service.BoardService;
import page.Paging;

import java.io.IOException;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p = req.getParameter("p");
        int pageNumber = 1;
        if(p != null) {
            if(!p.isEmpty()) {
                pageNumber = Integer.parseInt(p);
            }
        }

        // cnt 쿠키를 찾아서 cookie에 저장
        Cookie cookie = null;
        Cookie[] cookies = req.getCookies();
        for(Cookie c:cookies) {
            if(c.getName().equals("cnt")) {
                cookie = c;
            }
        }

        // cnt 파라미터를 찾아서 pageListLimit에 저장
        String cnt = req.getParameter("cnt");
        int pageListLimit = 10;
        if(cnt != null) {
            if(!cnt.isEmpty()) {
                pageListLimit = Integer.parseInt(cnt);
                // 사용자 요청에 의해 cnt가 변경된 경우 새로운 쿠키를 만들어서 사용자에게 제공
                cookie = new Cookie("cnt", cnt);
                cookie.setMaxAge(60 * 60 * 24 * 5);
                resp.addCookie(cookie);
            }
        } else {
            // cnt 파라미터가 없으면 cookie에 저장된 cnt 쿠키를 pageListLimit에 저장
            if(cookie != null) {
                pageListLimit = Integer.parseInt(cookie.getValue());
            }
        }

        BoardService service = new BoardService();
        Paging paging = service.getPage(pageNumber, pageListLimit);

        req.setAttribute("paging", paging);
        req.getRequestDispatcher("/WEB-INF/view/board/index.jsp").forward(req, resp);
    }
}
