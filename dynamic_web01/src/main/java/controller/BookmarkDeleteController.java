package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.BookmarkDTO;
import model.service.BookmarkService;

import java.io.IOException;

public class BookmarkDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        BookmarkDTO dto = new BookmarkDTO();
        dto.setId(Integer.parseInt(id));

        BookmarkService service = new BookmarkService();
        boolean result = service.remove(dto);

        if(result) {
            resp.sendRedirect("../bookmark");
        } else {
            resp.sendRedirect("../fail");
        }
    }
}
