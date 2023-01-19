package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.UserDTO;
import model.service.UserService;

import java.io.IOException;

public class MyinfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/myinfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String changePass = req.getParameter("changePass");
        String email = req.getParameter("email");

        HttpSession session = req.getSession();
        UserDTO data = (UserDTO)session.getAttribute("user");
        UserDTO updateData = new UserDTO();
        updateData.setPassword(changePass);
        updateData.setEmail(email);

        UserService service = new UserService();
        UserDTO result = service.update(data, updateData, password);
        if(result == null) {
            req.setAttribute("error", "현재 패스워드가 일치하지 않거나 저장에 문제가 발생하였습니다.");
            req.getRequestDispatcher("/WEB-INF/view/myinfo.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/logout");
        }
    }
}
