package model.service;

import model.dao.BookmarkDAO;
import model.dto.BookmarkDTO;

import java.util.List;

public class BookmarkService {

    public List<BookmarkDTO> getAll() {
        BookmarkDAO dao = new BookmarkDAO();
        List<BookmarkDTO> data = dao.selectAll();
        dao.close();
        return data;
    }

    public boolean add(BookmarkDTO dto) {
        BookmarkDAO dao = new BookmarkDAO();
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
}
