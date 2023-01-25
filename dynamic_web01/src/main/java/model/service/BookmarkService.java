package model.service;

import model.dao.BookmarkDAO;
import model.dto.BookmarkDTO;
import page.Paging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookmarkService {

    public List<BookmarkDTO> getAll(BookmarkDTO dto) {
        BookmarkDAO dao = new BookmarkDAO();
        List<BookmarkDTO> data = dao.selectAll(dto);
        dao.close();
        return data;
    }

    public Paging getPage(BookmarkDTO dto, int pNum, int cnt) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", (pNum - 1) * cnt + 1);
        map.put("end", pNum * cnt);
        map.put("userId", dto.getUserId());
        BookmarkDAO dao = new BookmarkDAO();

        int totalRowCount = dao.selectTotalRowCount(dto);
        int mod = totalRowCount % cnt == 0? 0 : 1;
        int pageCount = (totalRowCount / cnt) + mod;

        List<BookmarkDTO> data = dao.selectPage(map);
        Paging paging = new Paging(data, pNum, pageCount, cnt, 5);

        dao.close();
        return paging;
    }

    public boolean add(BookmarkDTO dto) {
        BookmarkDAO dao = new BookmarkDAO();
        int id = dao.getId();
        dto.setId(id);

        int rowCount = dao.insert(dto);
        if(rowCount == 1) {
            dao.commit();
            dao.close();
            return true;
        }
        dao.rollback();
        dao.close();
        return false;
    }

    public BookmarkDTO get(BookmarkDTO dto) {
        BookmarkDAO dao = new BookmarkDAO();
        BookmarkDTO data = dao.selectId(dto);
        return data;
    }

    public boolean update(BookmarkDTO dto) {
        BookmarkDAO dao = new BookmarkDAO();
        int count = dao.update(dto);
        if(count == 1) {
            dao.commit();
            dao.close();
            return true;
        }
        dao.rollback(); dao.close();
        return false;
    }

    public boolean remove(BookmarkDTO dto) {
        BookmarkDAO dao = new BookmarkDAO();
        int count = dao.delete(dto);

        if(count == 1) {
            dao.commit(); dao.close();
            return true;
        }
        dao.rollback(); dao.close();
        return false;

    }
}
