package model.dao;

import database.connect.OracleConnection;
import model.dto.BookmarkDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BookmarkDAO {

    private SqlSession session = OracleConnection.getSqlSession();

    /**
     * 데이터베이스에 저장할 데이터의 식별값을 생성하기 위한 메서드
     * @return id
     */
    public int getId() {
        int id = session.selectOne("bookmarkMapper.getId");
        return id;
    }

    public BookmarkDTO selectId(BookmarkDTO dto) {
        BookmarkDTO data = session.selectOne("bookmarkMapper.selectId", dto);
        return data;
    }


    public List<BookmarkDTO> selectAll(BookmarkDTO dto) {
        List<BookmarkDTO> data = session.selectList("bookmarkMapper.selectAll", dto);
        return data;
    }

    public List<BookmarkDTO> selectPage(Map<String, Object> map) {
        List<BookmarkDTO> data = session.selectList("bookmarkMapper.selectPage", map);
        return data;
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

    public int insert(BookmarkDTO dto) {
        int count = session.insert("bookmarkMapper.insert", dto);
        return count;
    }

    public int update(BookmarkDTO dto) {
        int count = session.update("bookmarkMapper.update", dto);
        return count;
    }

    public int delete(BookmarkDTO dto) {
        int count = session.delete("bookmarkMapper.delete", dto);
        return count;
    }

    public int selectTotalRowCount(BookmarkDTO dto) {
        int count = session.selectOne("bookmarkMapper.selectTotalRowCount", dto);
        return count;
    }
}
