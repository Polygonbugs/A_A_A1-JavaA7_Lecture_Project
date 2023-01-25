package model.service;

import model.dao.BoardDAO;
import model.dto.BoardDTO;
import page.Paging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
    public Paging getPage(int pageNumber, int pageListLimit) {
        Map<String, Object> page = new HashMap<String, Object>();
        page.put("start", (pageNumber - 1) * pageListLimit + 1);
        page.put("end", pageNumber * pageListLimit);

        BoardDAO dao = new BoardDAO();
        List<BoardDTO> data = dao.selectPage(page);

        int totalRowCount = dao.selectTotalRowCount();
        int mod = totalRowCount % pageListLimit == 0 ? 0 : 1;
        int pageCount = (totalRowCount / pageListLimit) + mod;

        Paging paging = new Paging(data, pageNumber, pageCount, pageListLimit, 5);
        dao.close();

        return paging;
    }
}
