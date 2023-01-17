package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.dto.UserDTO;
import model.service.UserService;

import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("login") != null) {
            if((boolean)session.getAttribute("login")) {
                resp.sendRedirect(req.getContextPath() + "/");
                return;
            }
        }
        Cookie[] cookies = req.getCookies();
        for(Cookie c: cookies) {
            if(c.getName().equals("remember")) {
                req.setAttribute("rememberId", c.getValue());
            }
        }
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Cookie cookie = new Cookie("name", "value"); // 1. 쿠키 생성
        //cookie.setMaxAge(60*60*24);                               // 2. 쿠키 유효(life)시간 설정, 60 -> 60초
        //resp.addCookie(cookie);                                   // 3. 응답 객체에 설정

        //HttpSession session = req.getSession(false);    // 세션정보가 없으면 null
        //session.getAttribute("속성명");                    // 세션 객체에 저장된 속성값을 속성명으로 찾아서 반환
        //session.setAttribute("속성명", 속성값);              // 세션 객체에 속성명, 속성값 저장
        //session.removeAttribute("속성명");                 // 세션 객체에 저장된 속성을 삭제
        //session.invalidate();                                  // 세션 객체를 삭제
        //session.setMaxInactiveInterval(0);                     // 세션 유지 시간

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        UserDTO dto = new UserDTO();
        dto.setUserId(userId);
        dto.setPassword(password);

        UserService service = new UserService();
        UserDTO data = service.login(dto);

        if(data == null) {
            req.setAttribute("error", "아이디 또는 패스워드가 잘못되었습니다.");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        } else {
            session.setAttribute("login", true);    // 로그인 상태를 기록하기 위한 속성
            session.setAttribute("user", data);            // 로그인 계정 정보를 기록하기 위한 속성
            Cookie cookie = new Cookie("remember", userId);
            if(remember != null) {
                cookie.setMaxAge(60 * 60 * 24);
            } else {
                cookie.setMaxAge(0);   // 유휴시간을 0으로 설정해서 클라이언트에서 삭제하도록 만드는 역할
            }
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}
