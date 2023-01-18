package model.service;

import model.dao.BookmarkDAO;
import model.dto.BookmarkDTO;

import java.util.List;

public class BookmarkService {

    public List<BookmarkDTO> getAll(BookmarkDTO dto) {
        BookmarkDAO dao = new BookmarkDAO();
        List<BookmarkDTO> data = dao.selectAll(dto);
        dao.close();
        return data;
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
