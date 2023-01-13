package model.dao;

import database.connect.OracleConnection;
import model.dto.BookmarkDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookmarkDAO {

    private SqlSession session = OracleConnection.getSqlSession();

    public List<BookmarkDTO> selectAll() {
        List<BookmarkDTO> data = session.selectList("bookmarkMapper.selectAll");
        return data;
    }

    public int insert(BookmarkDTO dto) {
        int count = session.insert("bookmarkMapper.insert", dto);
        return count;
    }

    public void commit() {
        session.commit();
    }

    public void rollback() {
        session.rollback();
    }

    public void close() {
        session.close();
    }

    public BookmarkDTO selectId(int id) {
        BookmarkDTO data = session.selectOne("bookmarkMapper.selectId", id);
        return data;
    }

    public int update(BookmarkDTO dto) {
        int count = session.update("bookmarkMapper.update", dto);
        return count;
    }

    public int delete(BookmarkDTO dto) {
        int count = session.delete("bookmarkMapper.delete", dto);
        return count;
    }
}
