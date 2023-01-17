package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.UserDTO;
import model.service.UserService;

import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        Cookie cookie = new Cookie("remember", userId);
        cookie.setMaxAge(60 * 60 * 24);

        UserDTO dto = new UserDTO();
        dto.setUserId(userId);
        dto.setPassword(password);

        UserService service = new UserService();
        UserDTO data = service.login(dto);

        if(data == null) {
            req.setAttribute("error", "아이디 또는 패스워드가 잘못되었습니다.");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        } else {
            if(remember != null) {
                resp.addCookie(cookie);
            }
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}
