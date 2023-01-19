package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.service.BookmarkService;

import java.io.IOException;
import java.util.List;

@WebServlet("/bookmark")    // web.xml에 있는 <servlet-mapping>과 같은 태그와 같은 역할을 한다.
                            // web.xml이 먼저 로드되고, 그 다음 annotation(@)이 로드된다.
                            // 주의사항 : 동일한 URL mapping 정보가 있으면 안된다. (톰캣 서버 구동중 충돌이 발생된다)
public class BookmarkController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        UserDTO userData = (UserDTO)session.getAttribute("user");
        BookmarkDTO dto = new BookmarkDTO();
        dto.setUserId(userData.getUserId());

        BookmarkService service = new BookmarkService();
        List<BookmarkDTO> data = service.getAll(dto);      // Object로 Upcasting이 이루어진다.
        req.setAttribute("data", data);
        req.getRequestDispatcher("/WEB-INF/view/bookmark.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        UserDTO userData = (UserDTO)session.getAttribute("user");

        BookmarkDTO dto = new BookmarkDTO();
        dto.setUserId(userData.getUserId());
        dto.setUrl(req.getParameter("url"));
        dto.setName(req.getParameter("name"));

        BookmarkService service = new BookmarkService();
        boolean result = service.add(dto);

        if(result) {
            resp.sendRedirect("./bookmark");
        } else {
            resp.sendRedirect("./fail");
        }
    }
}
