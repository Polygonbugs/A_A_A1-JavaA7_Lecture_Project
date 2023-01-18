package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.service.BookmarkService;

import java.io.IOException;

public class BookmarkDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("login") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        UserDTO userData = (UserDTO)session.getAttribute("user");

        String id = req.getParameter("id");

        BookmarkDTO dto = new BookmarkDTO();
        dto.setId(Integer.parseInt(id));
        dto.setUserId(userData.getUserId());

        BookmarkService service = new BookmarkService();
        boolean result = service.remove(dto);

        if(result) {
            resp.sendRedirect("../bookmark");
        } else {
            resp.sendRedirect("../fail");
        }
    }
}
